package com.ctci.arrays;

public class RotateMatrix {
	
	void rotateMatrix(int[][] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = i; j < arr[0].length - i - 1; j++) {
				int temp = arr[i][j];
				
				arr[i][j] = arr[arr.length - j - 1][i];
				arr[arr.length - j - 1][i] = arr[arr.length - i - 1][arr.length - j - 1];
				arr[arr.length - i - 1][arr.length - j - 1] = arr[j][arr.length - i - 1];
				arr[j][arr.length - i - 1] = temp;
			}
		}
	}

	void print2dArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		//int[][] arr = {{1,1,1},{0,0,0},{1,1,1}};
		//int[][] arr = {{1,1,1,1},{1,0,1,0},{0,1,0,1},{0,0,0,0}};
		int[][] arr = {{1,1},{0,0}};
		RotateMatrix rm = new RotateMatrix();
		rm.print2dArray(arr);
		rm.rotateMatrix(arr);
		System.out.println("Rotated");
		rm.print2dArray(arr);
	}

}
