package com.ctci.arrays;

public class EquilibriumPoint {
	
	int getEP(int arr[]){
		int sumBefore = 0;
		int sumAfter = 0;
		
		for(int i = 0; i < arr.length; i++){
			sumAfter += arr[i];
		}
		
		for(int i = 0; i < arr.length; i++){
			sumAfter -= arr[i];
			if(sumAfter == sumBefore)
				return i+1;
			sumBefore += arr[i];
		}
		
		return -1;
	}

	public static void main(String[] args) {
		EquilibriumPoint ep = new EquilibriumPoint();
		int[] arr = {1, 3, 5, 2, 2};
		System.out.println(ep.getEP(arr));
	}

}
