package com.laozhao.loginServer.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class DateUtil {

	public static String getStringOfNow()
	{
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime  now=LocalDateTime.now();
		return df.format(now);
	}
	
	public static Long getIntervalToNow(String formTime) {
		String pattern=getDatetimeFormat(formTime);
		if(pattern==null)
			return -1L;
		DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
		return getInterval(LocalDateTime.parse(formTime, df),LocalDateTime.now());
	}
	
	
	public static Long getInterval(LocalDateTime from,LocalDateTime to)
	{
		Duration interval=Duration.between(from, to);
		return interval.toMinutes();
	}
	
	 public static String getDatetimeFormat(String date){  
	        date=date.trim();  
	        String a1 = "[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}";//yyyyMMddHHmmss  
	        String a2 = "[0-9]{4}[0-9]{2}[0-9]{2}";//yyyyMMdd  
	        String a3 = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";//yyyy-MM-dd HH:mm:ss  
	        String a4 = "[0-9]{4}-[0-9]{2}-[0-9]{2}";//yyyy-MM-dd  
	        String a5= "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}";//yyyy-MM-dd  HH:mm  
	        boolean datea1 = Pattern.compile(a1).matcher(date).matches();  
	        if(datea1){  
	            return "yyyyMMddHHmmss";  
	        }  
	        boolean datea2 = Pattern.compile(a2).matcher(date).matches();  
	        if(datea2){  
	            return "yyyyMMdd";  
	        }  
	        boolean datea3 = Pattern.compile(a3).matcher(date).matches();  
	        if(datea3){  
	            return "yyyy-MM-dd HH:mm:ss";  
	        }  
	        boolean datea4 = Pattern.compile(a4).matcher(date).matches();  
	        if(datea4){  
	            return "yyyy-MM-dd";  
	        }  
	        boolean datea5 = Pattern.compile(a5).matcher(date).matches();  
	        if(datea5){  
	            return "yyyy-MM-dd HH:mm";  
	        }  
	        return null;  
	    }  
}
