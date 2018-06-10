package com.ctci.arrays;

import java.util.HashMap;

public class HashMapDemo {
	
	/*
	 * getMap() returns a HashMap with characters from the list as keys
	 * and count of characters as the values
	 */
	HashMap<Character, Integer> getMap(char[] list){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < list.length; i++){
			if(map.containsKey(list[i])){
				map.put(list[i], map.get(list[i]) + 1);
			}
			else{
				map.put(list[i], 1);
			}
		}
		
		return map;
	}

	public static void main(String[] args) {
		char[] list = {'a', 'a', 'b', 'a', 'c'};
		HashMap<Character, Integer> map = new HashMapDemo().getMap(list);
		System.out.println(map);
	}

}
