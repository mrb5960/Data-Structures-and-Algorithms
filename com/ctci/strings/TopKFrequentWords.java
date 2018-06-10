package com.ctci.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		HashMap<String, Integer> map = new HashMap<>();
		for(String word : words){
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(map.get(s1) > map.get(s2))
					return -1;
				else if(map.get(s2) > map.get(s1))
					return 1;
				else
					return s1.compareTo(s2);
			}
		});
		
		// returns a list from startIndex to stopIndex
		list.subList(0, 2);
		
		for(int i = 0; i < 2; i++)
			System.out.println(list.get(i));
	}

}
