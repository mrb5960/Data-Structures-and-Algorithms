package com.ctci.strings;

public class IsUnique {
	
	boolean checkIfUnique(char[] arr) {
		for(int i = 0; i < arr.length - 1; i++)
			if(arr[i] == arr[i+1])
				return false;
		return true;
	}
	
	void sortString(char[] arr) {
		printArray(arr);
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
	
	void printArray(char[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
		System.out.println(" ");
	}
	
	void mergeSort(char[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			
			merge(arr, low, mid, high);
		}
	}
	
	void merge(char[] arr, int low, int mid, int high) {
		
		// get the sizes of the temporary arrays
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		// create temporary arrays
		char[] left = new char[n1];
		char[] right = new char[n2];
		
		// copy elements from original array to temporary arrays
		for(int i = 0; i < n1; i++)
			left[i] = arr[low + i];
		for(int j = 0; j < n2; j++)
			right[j] = arr[mid + 1 + j];
		
		// merge two arrays
		int i = 0, j = 0, k = low; //IMP
		while(i < n1 && j < n2) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		// add remaining elements in the original array
		while(i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}

	public static void main(String[] args) {
		String temp = "abcda";
		IsUnique iu = new IsUnique();
		char[] arr = temp.toCharArray();
		iu.sortString(arr);
		System.out.println(iu.checkIfUnique(arr));
	}

}
