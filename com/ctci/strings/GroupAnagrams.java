package com.ctci.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);

            if(!map.containsKey(temp)){
            	ArrayList<String> newList = new ArrayList<>();
            	newList.add(strs[i]);
                map.put(temp, newList);
            }
            else{
                map.get(temp).add(strs[i]);
            }
        }
        
        return new ArrayList<List<String>>(map.values());
    }

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> output = ga.groupAnagrams(strs);
		//for(List l : output)
			System.out.println(output);
	}

}
