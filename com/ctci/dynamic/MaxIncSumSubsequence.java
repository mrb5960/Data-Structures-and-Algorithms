package com.ctci.dynamic;

public class MaxIncSumSubsequence {
	
	int getMaxIncSumSubSequence(int[] arr){
		
		// clone() creates a deep copy of the array
		int[] maxArray = arr.clone();
		int[] seq = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			seq[i] = i;
		}
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					//maxArray[i] = Math.max(maxArray[i], maxArray[i] + arr[j]);
					if(maxArray[i] + arr[j] > maxArray[i]){
						maxArray[i] = maxArray[i] + arr[j];
						seq[i] = j;
					}
				}
			}
		}
		
		System.out.println("Input:");
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println("\nMaxArray:");
		
		for(int i = 0; i < maxArray.length; i++)
			System.out.print(maxArray[i] + " ");
		
		System.out.println("\nSequence array:");
		
		for(int i = 0; i < seq.length; i++)
			System.out.print(seq[i] + " ");
		
		System.out.println();
		
		int maxValue = 0;
		int maxValueIndex = -1;
		for(int i = 0; i < maxArray.length; i++){
			if(maxArray[i] > maxValue){
				maxValue = maxArray[i];
				maxValueIndex = i;
			}
		}
		
		System.out.println("Sequence:");
		
		boolean flag = true;
		
		while(flag){
			if(maxValueIndex == seq[maxValueIndex])
				flag = false;
			System.out.print(arr[maxValueIndex] + " ");
			maxValueIndex = seq[maxValueIndex];
		}
		
		return maxValue;
	}

	public static void main(String[] args) {
		MaxIncSumSubsequence miss = new MaxIncSumSubsequence();
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println("\nMax sum: " + miss.getMaxIncSumSubSequence(arr));
	}
}
