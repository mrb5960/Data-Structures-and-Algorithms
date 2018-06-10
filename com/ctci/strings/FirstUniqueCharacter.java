package com.ctci.strings;

import java.util.LinkedHashMap;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String str = "leetcode";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch))
				map.put(ch, -1);
			else
				map.put(ch, i);
		}
		
		int min_index = str.length() - 1, flag = 0;
		
		for(int i : map.values()){
			if(i >= 0){
				flag = 1;
				if(i < min_index) 
					min_index = i;
			}
		}
		
		System.out.println(flag == 0 ? -1 : min_index);
	}
}
