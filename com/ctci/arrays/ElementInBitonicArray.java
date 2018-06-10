package com.ctci.arrays;

public class ElementInBitonicArray {
	
	// find the pivot element or the bitonic point
	public int findPivotIndex(int[] arr){
		int start = 0, end = arr.length - 1;
		if(arr[start] < arr[end])
			return 0;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
				return mid;
			else if(arr[start] <= arr[mid])
				start = mid + 1;
			else
				end = mid - 1; 
		}
		
		return 0;
	}
	
	// binary search for ascending ordered side
	public int ascBinarySearch(int[] arr, int start, int end, int num){
		if(arr.length == 0 || num < arr[start] || num > arr[end])
			return -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] == num)
				return mid;
			else if(num < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return -1;
	}
	
	// binary search for descending ordered side
	public int descBinarySearch(int[] arr, int start, int end, int num){
		if(arr.length == 0 || num > arr[start] || num < arr[end])
			return -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] == num)
				return mid;
			else if(num > arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return -1;
	}
	
	public int findElement(int[] arr, int num){
		int pivotIndex = findPivotIndex(arr);
		System.out.println("Pivot index: " + pivotIndex);
		if(arr[pivotIndex] == num)
			return pivotIndex;
		int index = ascBinarySearch(arr, 0, pivotIndex, num);
		if(index != -1)
			return index;
		else
			return descBinarySearch(arr, pivotIndex+1, arr.length-1, num);
		
	}

	public static void main(String[] args) {
		int[] arr = {8, 16, 24, 32, 64, 50, 25, 5};
		ElementInBitonicArray temp = new ElementInBitonicArray();
		System.out.println(temp.findElement(arr, 64));
	}

}
