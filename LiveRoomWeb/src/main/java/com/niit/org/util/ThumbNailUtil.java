package com.niit.org.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ������Ƶ��Ӧ������ͼ
public class ThumbNailUtil {

    public static String toolPath = "D:\\Plugins\\ffmpeg-20171120-8f4702a-win64-static\\bin\\ffmpeg.exe";
    public static String sourcePath = ""; // Դ�ļ���·��
    public static String beginTime = "1";// ��λ��s //100s���ڶ������ڼ�������� ����ʱ���ٶ��Ǵ����1��10
    public static String targetPath = "";//����ļ��е�λ��
    
    public ThumbNailUtil(String toolPath,String sourcePath,String targetPath) {
    	this.toolPath = toolPath;
    	this.sourcePath = sourcePath;
    	this.targetPath = targetPath;
    }
    // ���·���Ƿ����
    private static boolean checkfile(String path) {  
        File file = new File(path);  
        if (!file.isFile()) {  
            return false;  
        }  
        return true;  
    }  
    // ����ffmpeg��ʵ������ͼ�Ĳü�
    public static boolean makeThumbNail(String sourcePath, String beginTime, String targetPath) {
    	System.out.println("targetPath:"+targetPath); 
    	List<String> commend = new ArrayList<String>(); 
    	if (!checkfile(sourcePath)) {  
            System.out.println(sourcePath + " is not file");  
            return false;  
        }
        try {  
            commend.add(toolPath);
            commend.add("-i");  
            commend.add(sourcePath);
            commend.add("-y");
            commend.add("-f");
            commend.add("image2");
            commend.add("-ss");
            commend.add(beginTime);
            commend.add("-t");
            commend.add("1");
            commend.add("-s");
            commend.add("276x155");
            commend.add(targetPath);
            //�����߳��������ת��
            ProcessBuilder builder = new ProcessBuilder(commend);                 
            builder.command(commend);  
            builder.start();  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        } 
    }
    //���Ʊ����ļ���
    public static void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("�ļ����ǿյ�!");
                return;
            } else {
                for (File file2 : files) {
                	String fileName = file2.getName();
            		if (fileName.endsWith(".ts")) {
                		// ���������ͼ�ļ���
                		String fullSourcePath = file2.getAbsolutePath();
                		String fullTargetPath = targetPath+"\\"+generateName(fileName);
                		// ������Ƶ����ͼ�Ľ�ȡ
                		makeThumbNail(fullSourcePath,beginTime,fullTargetPath);
            		}
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
    }
    // ��������ͼ������(�����)
    public static String generateName(String sourceName) {
    	String reg = "\\d{1,}-\\d{1,}";
        Pattern r = Pattern.compile(reg);
        Matcher m = r.matcher(sourceName);
        String name = "0.jpg";
    	if (m.find()) {
    		name = sourceName.split("-")[0] +".jpg";
    	}
    	return name;
    }
    // ָ��ĳ�������ts���н�ͼ
    public static Map<String,ArrayList<Integer>> maxNumber(File[] files) {
    	Map<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
    	String fileName = "",id="";
    	ArrayList<Integer> ts = new ArrayList<Integer>();
    	
    	if (files.length == 0) {
    		//�ļ���Ϊ��
    	} else {
    		for (File file : files) {
    			if (fileName.endsWith(".ts")) {
	    			fileName = file.getName();
	    			id = fileName.split("-")[0];
	    			if(map.containsKey(id)) {
	    				ts = map.get(id);
	    				ts.add(Integer.valueOf(fileName.split("-")[1]));
	    			} else {
	    				ts = new ArrayList<Integer>();
	    				ts.add(Integer.valueOf(fileName.split("-")[1]));
	    				map.put(id, ts);
	    			}
    			}
    		}
    	}
    	for (String str : map.keySet()) {
    		ts = map.get(str);
			Collections.sort(ts, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
		    });
	       System.out.println("key= "+ str + " and value= " + map.get(str));
        }
    	return map; 
    }
}
/**
 *     使用方法
 *   	String toolPath = "D:\\\\Plugins\\\\ffmpeg-20171120-8f4702a-win64-static\\\\bin\\\\ffmpeg.exe";
//    	String sourcePath = "C:\\Users\\17701\\Desktop\\test\\";
//    	String targetPath = request.getServletContext().getRealPath("\\WEB-INF\\thumb\\");
//    	System.out.println(targetPath);
//    	ThumbNailUtil tnu = new ThumbNailUtil(toolPath,sourcePath,targetPath);
//    	tnu.traverseFolder(sourcePath);
 * 
 * */
 */