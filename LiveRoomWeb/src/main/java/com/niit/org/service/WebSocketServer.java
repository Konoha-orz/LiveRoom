package com.niit.org.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.org.bean.Msg;
import com.niit.org.configurator.GetHttpSessionConfigurator;

//TODO 分一下系统消息和用户消息
//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@Component
@ServerEndpoint(value = "/webSocket/{roomId}", configurator=GetHttpSessionConfigurator.class)
public class WebSocketServer {
 // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
 private  static final AtomicInteger onlineCount = new AtomicInteger(0);
 // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
 private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
 private static Map<String, Set<WebSocketServer>> map = new ConcurrentHashMap<String, Set<WebSocketServer>>();
 private Set<WebSocketServer> serverSet = new HashSet<WebSocketServer>() ;
 //定义一个记录客户端的聊天昵称
 private String username;
 // 与某个客户端的连接会话，需要通过它来给客户端发送数据
 private Session session;
 //房间ID
 private String roomId;

 public WebSocketServer() {
     username = "访客"+onlineCount.getAndIncrement();
 }
 /*
  *使用@Onopen注解的表示当客户端链接成功后的回掉。参数Session是可选参数
  这个Session是WebSocket规范中的会话，表示一次会话。并非HttpSession
  */
 @OnOpen
 public void onOpen(@PathParam("roomId") String roomId,
                    Session session,
                    EndpointConfig config) throws JsonProcessingException {
     HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
     this.session = session;
     this.roomId=roomId;
     // 由于websocket是建立在http基础之上的，有js发起连接的所以一旦刷新页面链接就会被重置。
     if (Integer.parseInt(roomId)==0 && httpSession.getAttribute("roomId") != null ){
         this.roomId=roomId=httpSession.getAttribute("roomId").toString();
     }
     webSocketSet.add(this);
     // 一个数据结构可以用来区分多个房间
     //是否有roomId ,有则添加进对应的房间，没有就新建一个房间
     // 是否是第一个加入房间的
     if (map.containsKey(roomId) && map.get(roomId) != null){
         map.get(roomId).add(this);
     } else {
         serverSet.add(this);
         map.put(roomId,serverSet);
     }
     // 有可能建立连接还没有username
     Object username= httpSession.getAttribute("username");
     // 登录的话，提示用户名，未登录的话仅仅提示连接到聊天室
     Msg msg = new Msg();
     if (username != null){
         this.username =  username.toString();
         msg.setCreator("系统消息");
         msg.setMsgBody(this.username+"加入聊天室");
     } else {
         this.username =  "guest";
         msg.setCreator("系统消息");
         msg.setMsgBody(this.username+"已经连接到聊天室");
         msg.setRoomId(roomId);
     }
     msg.setsTime(Calendar.getInstance());
     String serialized = new ObjectMapper().writeValueAsString(msg);
     broadcast(roomId, serialized);
     System.out.println("onOpen"+serialized);
 }
   /*
    *使用@OnMessage注解的表示当客户端发送消息后的回掉，第一个参数表示用户发送的数据。参数Session是可选参数，与OnOpen方法中的session是一致的
    */
 @OnMessage
 public void onMessage(@PathParam("roomId") String roomId,
                       String message,
                       Session session) throws JsonProcessingException {
     Msg msg = new Msg();
     msg.setCreator(this.username);
     msg.setMsgBody(message);
     msg.setsTime(Calendar.getInstance());
     msg.setRoomId(roomId);
     String serialized = new ObjectMapper().writeValueAsString(msg);
     System.out.println("OnMessage:"+serialized);
     broadcast(roomId, filter(serialized));
 }
 /*
 *用户断开链接后的回调，注意这个方法必须是客户端调用了断开链接方法后才会回调
 */
 @OnClose
 public void onClose() throws JsonProcessingException {
     webSocketSet.remove(this);
     Set<WebSocketServer> tempSet= map.get(roomId);
     tempSet.remove(this);
     Msg msg = new Msg();
     msg.setCreator("系统消息");
     msg.setMsgBody(this.username+"离开了聊天室链接");
     msg.setsTime(Calendar.getInstance());
     String serialized = new ObjectMapper().writeValueAsString(msg);
     String roomId=this.session.getPathParameters().get("roomId");
     msg.setRoomId(roomId);
     broadcast(roomId,serialized);
 }
 //完成群发,按照房间发送消息
 private void broadcast(String roomId, String info){
     Set<WebSocketServer> tempSet= map.get(roomId);
     for(WebSocketServer w:tempSet){
         try {
             synchronized (WebSocketServer.class) {
                 w.session.getBasicRemote().sendText(info);
             }
         } catch (IOException e) {
             System.out.println("向客户端"+w.username+"发送消息失败");
             webSocketSet.remove(w);
             tempSet.remove(w);
             try {
                 w.session.close();
             } catch (IOException e1) {}
             String message = String.format("[%s,%s]",w.username,"已经断开链接");
             broadcast(roomId, message);
         }
     }
 }
 //对用户的消息可以做一些过滤请求，如屏蔽关键字等等。
 public static String filter(String message){
     if(message==null){
         return null;
     }
     return message;
 }
}
