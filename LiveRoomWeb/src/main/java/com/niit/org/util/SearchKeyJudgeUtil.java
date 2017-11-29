package com.niit.org.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchKeyJudgeUtil {

	public static boolean isRoom(String key) {
		 Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(key);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}

	
	
}
