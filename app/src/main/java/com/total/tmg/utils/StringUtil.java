package com.total.tmg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String addMask(String src){
		String pre = src.substring(0, 3);
		String end = src.substring(7,11);
		return pre+"****"+end;
	}
	
	public static String addMask(String src, int start, int end){
		return "";
	}
	
	public static String getChildLocationInfo(String name, String sex,
			String grade, String addr, String lastTime) {
		return "姓名:" + name + "\n性别:" + sex + "\n年级:" + grade + "\n地址:" + addr
				+ "\n最后定位时间:" + lastTime;
	}

	public static String getClassFromStr(String str) {
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

	/**
	 * if str is null or space return true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}

		return false;
	}


}
