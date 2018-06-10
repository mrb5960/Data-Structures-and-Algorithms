package com.ctci.arrays;

public class ReverseArrayInGroups {
	
	void reverse(int[] arr, int k){
		for(int i = 0; i < arr.length; i += k){
			int left = i;
			int right = Math.min(i + k - 1, arr.length - 1);
			
			while(left < right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
	}

	public static void main(String[] args) {
		ReverseArrayInGroups raig = new ReverseArrayInGroups();
		int[] arr = {1, 2, 3, 4, 5};
		raig.reverse(arr, 3);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

}
