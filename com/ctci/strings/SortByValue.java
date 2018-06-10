package com.ctci.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortByValue {
	
	public void display(String str){
		TreeMap<Integer, Character> sortedmap = new TreeMap<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch)){
				int temp_count = map.get(ch);
				map.put(ch, temp_count+1);
			}
			else{
				map.put(ch, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			sortedmap.put(entry.getValue(), entry.getKey());
		}
		
		System.out.println(sortedmap);
	}
	
	class AlphaCount implements Comparable<AlphaCount>{
		int count;
		char alpha;
		
		public AlphaCount(int count, char alpha) {
			this.count = count;
			this.alpha = alpha;
		}

		@Override
		public int compareTo(AlphaCount ac){
			if(this.count > ac.count)
				return -1;
			else if(this.count < ac.count)
				return 1;
			else
				return 0;
		}
	}
	
	
	/*
	 * Time complexity
	 * Let L be the length of the string
	 * Let U be the unique characters in the string
	 * Time taken to build the map is O(L)
	 * Time taken to build the list is O(U)
	 * Time taken to sort the list is O(U log U)
	 * Time taken to print the list is O(U)
	 * Total time is O(L + U log U)
	 * 
	 * Space complexity 
	 * Map, list takes O(U) space
	 */
	public void display2(String str){
		ArrayList<AlphaCount> list = new ArrayList<>();
		HashMap<Character, AlphaCount> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch)){
				AlphaCount temp = map.get(ch);
				temp.count +=1;
				map.put(ch, temp);
			}
			else{
				map.put(ch, new AlphaCount(1, ch));
			}
		}
		
		for(Map.Entry<Character, AlphaCount> entry : map.entrySet()){
			list.add(entry.getValue());
		}
		
		Collections.sort(list);
		for(AlphaCount ac : list)
			System.out.println(ac.alpha + " " + ac.count);
	}

	public static void main(String[] args) {
		String str = "aabbbccccddddd";
		SortByValue sbv = new SortByValue();
		sbv.display2(str);
	}

}
