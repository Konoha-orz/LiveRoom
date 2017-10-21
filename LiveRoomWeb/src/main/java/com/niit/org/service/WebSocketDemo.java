package com.niit.org.service;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint("/webSocket")
public class WebSocketDemo {
  // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
  private  static final AtomicInteger onlineCount = new AtomicInteger(0);
  // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
  private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet = new CopyOnWriteArraySet<WebSocketDemo>();
  //定义一个记录客户端的聊天昵称
  private final String nickname;
  // 与某个客户端的连接会话，需要通过它来给客户端发送数据
  private Session session;

  public  WebSocketDemo() {
      nickname = "访客"+onlineCount.getAndIncrement(); 
  }
  /*
   *使用@Onopen注解的表示当客户端链接成功后的回掉。参数Session是可选参数
   这个Session是WebSocket规范中的会话，表示一次会话。并非HttpSession
   */
  @OnOpen
  public void onOpen(Session session) {
      this.session = session;
      webSocketSet.add(this);
      String message = String.format("[%s,%s]",nickname,"加入聊天室");
      broadcast(message);
      System.out.println("onOpen");
  }
/*
   *使用@OnMessage注解的表示当客户端发送消息后的回掉，第一个参数表示用户发送的数据。参数Session是可选参数，与OnOpen方法中的session是一致的
   */
  @OnMessage
  public void onMessage(String message,Session session){
  //这里当然会打印true
      System.out.println(this.session==session);
      broadcast(String.format("%s:%s",nickname,filter(message)));
  }
/*
*用户断开链接后的回调，注意这个方法必须是客户端调用了断开链接方法后才会回调
*/
  @OnClose
  public void onClose() {
      webSocketSet.remove(this);
      String message = String.format("[%s,%s]",nickname,"离开了聊天室链接");
      broadcast(message);
  }
  //完成群发
  private void broadcast(String info){
      for(WebSocketDemo w:webSocketSet){
          try {
              synchronized (WebSocketDemo.class) {
            	  
                  w.session.getBasicRemote().sendText(info);
              }
          } catch (IOException e) {
              System.out.println("向客户端"+w.nickname+"发送消息失败");
              webSocketSet.remove(w);
              try {
                  w.session.close();
              } catch (IOException e1) {}
              String message = String.format("[%s,%s]",w.nickname,"已经断开链接");
              broadcast(message);
          }

      }
  }
  //对用户的消息可以做一些过滤请求，如屏蔽关键字等等。。。
  public static String filter(String message){
      if(message==null){
          return null;
      }
      return message;
  }
}