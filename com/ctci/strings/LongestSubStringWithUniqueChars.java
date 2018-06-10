package com.ctci.strings;

import java.util.HashSet;

public class LongestSubStringWithUniqueChars {

	public void getLongestSubstring(String str){
		int len = str.length();
		int i = 0, j = 0, max_length = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		while(i < len && j < len){
			char ch = str.charAt(j);
			if(set.contains(ch)){
				set.remove(ch);
				i++;
			}
			else{
				set.add(ch);
				j++;
				max_length = Math.max(max_length, j - i);
			}
		}
		
		System.out.println(max_length);
	}
	
	public static void main(String[] args) {
		String str = "abcabcdeab";
		LongestSubStringWithUniqueChars lswuc = new LongestSubStringWithUniqueChars();
		lswuc.getLongestSubstring(str);
	}

}
