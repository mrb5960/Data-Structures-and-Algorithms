package com.ctci.arrays;

public class ElementInRotatedSorted1 {
	
	public int findPivotIndex(int[] arr){
		int start = 0, end = arr.length - 1;
		if(arr[start] < arr[end])
			return 0;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] > arr[mid+1])
				return mid+1;
			else if(arr[start] <= arr[mid])
				start = mid + 1;
			else
				end = mid - 1; 
		}
		
		return 0;
	}
	
	public int findElementIndex(int[] arr, int pivotIndex, int num){
		int start = 0, end = arr.length - 1;
		if(pivotIndex > 0 && num <= arr[pivotIndex-1] && num >= arr[start]){
			return binarySearch(arr, start, pivotIndex-1, num);
		}
		else{
			return binarySearch(arr, pivotIndex, end, num);
		}
	}
	
	public int binarySearch(int[] arr, int start, int end, int num){
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
	
	public int findElement(int[] arr, int num){
		int pivotIndex = findPivotIndex(arr);
		System.out.println("Pivot Index: " + pivotIndex);
		return findElementIndex(arr, pivotIndex, num);
	}

	public static void main(String[] args) {
		int[] arr = {4,5,1,2,3};
		ElementInRotatedSorted1 temp = new ElementInRotatedSorted1();
		System.out.println(temp.findElement(arr, 3));
	}
}
