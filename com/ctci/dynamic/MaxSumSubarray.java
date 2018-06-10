package com.ctci.dynamic;

public class MaxSumSubarray {
	
	int getMaxSum(int[] arr){
		int max_so_far = 0;
		int max_till_index = 0;
		int start = 0, end = 0, s = 0;
		
		for(int i = 0; i < arr.length; i++){
			max_till_index = max_till_index + arr[i];
			if(max_till_index < 0){
				max_till_index = 0;
				s = i + 1;
			}
			else if(max_so_far < max_till_index){
				max_so_far = max_till_index;
				start = s;
				end = i;
			}
		}
		
		System.out.println("Start index = " + start);
		System.out.println("End index = " + end);
		return max_so_far;
	}

	public static void main(String[] args) {
		MaxSumSubarray mss = new MaxSumSubarray();
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(mss.getMaxSum(arr));
	}
}
