package com.ctci.strings;

public class StringRotation {
	
	boolean isRotation(String str1, String str2) {
		if(str1.length() == str2.length()) {
			String temp = str1 + str1;
			return temp.contains(str2);
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "terroches";
		String s2 = "rochester";
		StringRotation sr = new StringRotation();
		System.out.println(sr.isRotation(s1, s2));
	}

}
