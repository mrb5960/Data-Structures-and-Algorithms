package com.ctci.strings;

public class OneAway {
	
	boolean isOneAway(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1)
			return false;
				
		if(s1.length() == s2.length()) {
			return isOneReplace(s1, s2);
		}
		else if(s1.length() <= s2.length()) {
			return isOneInsert(s1, s2);
		}
		else {
			return isOneInsert(s2,s1);
		}
		
	}
	
	boolean isOneInsert(String s1, String s2) {
		boolean oneinsert = true;
		int count = 0;
		int i = 0, j = 0;
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) != s2.charAt(j)) {
				count++;
				j++;
				if(count == 2) {
					return false;
				}
			}
			i++;
			j++;
		}
		return oneinsert;
	}
	
	boolean isOneReplace(String s1, String s2) {
		boolean onereplace = false;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(onereplace)
					return false;
				onereplace = true;
			}
		}
		return onereplace;
	}
	
	public static void main(String args[]) {
		OneAway oa = new OneAway();
		System.out.println(oa.isOneAway("pale", "male"));
		System.out.println(oa.isOneAway("pales", "pale"));
	}

}
