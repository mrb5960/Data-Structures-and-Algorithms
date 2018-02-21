package com.ctci.strings;

public class StringCompression {
	
	String getCompressedString(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		if(sb.length() > str.length())
			return str;
		else
			return sb.toString();
	}

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		System.out.println(sc.getCompressedString("aaabbbbccccaaaadde"));
	}

}
