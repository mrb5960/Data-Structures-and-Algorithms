package com.ctci.arrays;

import java.util.ArrayList;

public class Leaders {
	
	ArrayList<Integer> getLeaders(int[] arr){
		ArrayList<Integer> leaders = new ArrayList<>();
		int maxValue = 0;
		
		for(int i = arr.length - 1; i > 0; i--){
			if(arr[i] > maxValue){
				maxValue = arr[i];
				leaders.add(arr[i]);
			}
		}
		
		return leaders;
	}

	public static void main(String[] args) {
		Leaders l = new Leaders();
		int arr[] = {16, 17, 4, 3, 5, 2};
		ArrayList<Integer> result = l.getLeaders(arr);
		for(int num : result)
			System.out.println(num);
	}

}
