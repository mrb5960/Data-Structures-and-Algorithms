package com.ctci.dynamic;

public class MagicIndex {
	
	void getMagicIndex(int[] arr){
		int index = Integer.MIN_VALUE;
		if((index = getMagicIndex(0, arr.length - 1, arr)) != -1)
			System.out.println("Magic index is " + index);
		else
			System.out.println("Magic index does not exist");
	}
	
	int getMagicIndex(int start, int end, int[] arr){
		if(end < start)
			return -1;
		int mid = (start + end)/2;
		
		int midValue = arr[mid];
		if(midValue == mid)
			return mid;
		
		//left
		int leftIndex = Math.min(mid - 1, midValue);
		int left = getMagicIndex(start, leftIndex, arr);
		if(left >= 0)
			return left;
		
		//right
		int rightIndex = Math.max(mid + 1, midValue);
		int right = getMagicIndex(rightIndex, end, arr);
		
		return right;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,4,4,4,5,6};
		MagicIndex mi = new MagicIndex();
		mi.getMagicIndex(arr);
	}

}
