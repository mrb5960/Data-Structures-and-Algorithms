package com.ctci.strings;

public class CheckPermutation {
	
	boolean isPermuatation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		// making an assumption on the number of characters
		int[] characters = new int[128];
		
		char[] s1_array = s1.toCharArray();
		
		for(char c : s1_array) {
			characters[c]++;
		}
		
		char[] s2_array = s2.toCharArray();
		
		for(char c : s2_array) {
			characters[c]--;
			if(characters[c] < 0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		CheckPermutation cp = new CheckPermutation();
		System.out.println(cp.isPermuatation("abcd", "dcbe"));
	}

}
