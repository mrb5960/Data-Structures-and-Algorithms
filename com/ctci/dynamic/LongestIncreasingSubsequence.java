package com.ctci.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	int findLIS(int[] arr){
		int[] temp = new int[arr.length];
		Arrays.fill(temp, 1);
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					temp[i] = Math.max(temp[i], temp[j]+1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < temp.length; i++){
			if(temp[i] > max){
				max = temp[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		
		int out = lis.findLIS(arr);
		System.out.println(out);
	}
}