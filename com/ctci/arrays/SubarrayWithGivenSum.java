package com.ctci.arrays;

import java.util.HashMap;

public class SubarrayWithGivenSum {
	
	// O(n^2) solution
	boolean isPresent(int[] arr, int sum){
		
		for(int i = 0; i < arr.length; i++){
			int tempSum = 0;
			for(int j = i; j < arr.length; j++){
				tempSum += arr[j];
				if(tempSum == sum)
					return true;
			}
		}
		return false;
	}

	int subarrayWithGivenSum(int[] arr, int k){
		HashMap<Integer, Integer> sum_till_now = new HashMap<>();
		int sum = 0;
		int count = 0;
		sum_till_now.put(0, 1);
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(sum_till_now.containsKey(sum - k)){
				count += sum_till_now.get(sum -k);
			}
			sum_till_now.put(sum, sum_till_now.getOrDefault(sum, 0)+1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		SubarrayWithGivenSum s = new SubarrayWithGivenSum();
		int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
		int[] arr2 = {1, 2, 3, 7, 5};
		System.out.println(s.isPresent(arr1, 8));
		System.out.println(s.subarrayWithGivenSum(arr2, 12));
	}

}
