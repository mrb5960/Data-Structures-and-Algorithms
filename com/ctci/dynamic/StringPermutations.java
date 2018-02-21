package com.ctci.dynamic;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	void getPermutations(String str){
		List<String> permutations = getPermutationsHelper(str);
		System.out.println("Number of permutations: " + permutations.size());
		for(String temp : permutations)
			System.out.println(temp);
	}
	
	List<String> getPermutationsHelper(String str){
		if(str.length() == 1){
			List<String> newlist = new ArrayList<String>();
			newlist.add(str);
			return newlist;
		}
		
		int index = 0;
		char prefix = str.charAt(index);
		String suffix = str.substring(++index, str.length());
		
		List<String> down = getPermutationsHelper(suffix);
		List<String> top = new ArrayList<>();
		
		for(String temp : down){
			for(int i = 0; i <= temp.length(); i++){
				StringBuilder sb = new StringBuilder(temp);
				top.add(sb.insert(i, prefix).toString());
			}
		}
		
		return top;
	}

	public static void main(String[] args) {
		StringPermutations sp = new StringPermutations();
		sp.getPermutations("abcd");
	}
}
