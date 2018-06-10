package com.ctci.dynamic;

import java.util.Arrays;

public class LongestCommonSubstring {
	
	public String getlcs(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] memo = new int[len1+1][len2+1];
		
		Arrays.fill(memo[0], 0);
		
		for(int row = 0; row <= len1; row++){
			memo[row][0] = 0;
		}
		
		int max = 0;
		int max_row = 0;
		for(int row = 1; row <= len1; row++){
			for(int col = 1; col <= len2; col++){
				if(s1.charAt(row-1) == s2.charAt(col-1)){
					memo[row][col] = memo[row-1][col-1] + 1;
					if(memo[row][col] > max){
						max = memo[row][col];
						max_row = row;
					}
				}
				else{
					memo[row][col] = 0;
				}
			}
		}
		
		int startIndex = max_row - max;
		return s1.substring(startIndex, max_row);
	}

	public static void main(String[] args) {
		String s1 = "abcababcde";
		String s2 = "abcdeababc";
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.getlcs(s1, s2));
	}

}
