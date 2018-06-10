package com.ctci.arrays;

public class Combination {

	static int count = 0;
	final int result = 10;

	void isComb(int[] arr, int intermediate, int index) {
		if (intermediate == result)
			count++;
		if (index > arr.length - 1)
			return;

		isComb(arr, intermediate + arr[index], index + 1);
		isComb(arr, intermediate - arr[index], index + 1);
		isComb(arr, intermediate * arr[index], index + 1);
		isComb(arr, intermediate / arr[index], index + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Combination c = new Combination();
		c.isComb(arr, arr[0], 1);
		System.out.println(count);
	}
}
