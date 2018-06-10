package com.ctci.strings;

import java.util.HashSet;

public class MinStringWithMaxUniqueChars {
	
	public void getMax(String str){
		int i = 0, j = 0;
		int len = str.length();
		
		int max_window_length = 0;
		HashSet<Character> set = new HashSet<>();
		int max_unique = set.size();
		while(i < len && j < len){
			char ch = str.charAt(j);
			if(set.contains(ch)){
				
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
