package com.wind.utils;

import java.util.Random;

public class FileUtil {
	private static byte[] base = { 
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
		'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
		'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
		'Y', 'Z' 
	};
	
	private static String encodeBase62(double num ) {
		if(num == 0) return null;
		if(num > (Math.pow(2, 54))) return null;
		
		StringBuffer result = new StringBuffer();
		while (num>0) {
	        int index = (int) (num%62);
	        result.append((char) base[index]);
	        num = Math.floor(num/62);
		}
		return result.reverse().toString();
	}
	
	/**
	 * 生成文件名
	 * 
	 * @author qianchun  @date 2016年7月5日 下午6:42:21
	 * @param userId
	 * @return
	 */
	public static String generateFileName(long userId) {
		int location = new Random().nextInt(8999) + 1000;
		
		String seed_part = encodeBase62(userId);
		
		long now = System.currentTimeMillis()/1000;//mfloor(ngx.now())
		String time_part = encodeBase62(now);
		
		String random_part = encodeBase62(new Random().nextInt(99999) + 10000);
		
		System.out.println("location:" + location + ", random_part:" + random_part + 
				", seed_part:" + seed_part + ", time_part:"+time_part);
		
		return (location + random_part + seed_part + time_part + random_part.length()
				+ (new Random().nextInt(8) + 1) + seed_part.length() 
				+ (new Random().nextInt(8) + 1) + time_part.length() + "app");
	}
	public static void main(String[] args) {
		System.out.println(generateFileName(207));
	}
}
