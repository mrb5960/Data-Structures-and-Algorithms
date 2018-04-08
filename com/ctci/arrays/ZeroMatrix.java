package com.ctci.arrays;

public class ZeroMatrix {
	
	// check if first row and first col has any zeros
	boolean rowzero = false;
	boolean colzero = false;
	
	void checkFirstRow(int[][] mat) {
		for(int i = 0; i < mat[0].length; i++) {
			if(mat[0][i] == 0) {
				rowzero = true;
				break;
			}
		}
	}
	
	void checkFirstCol(int[][] mat) {
		for(int i = 0; i < mat.length; i++) {
			if(mat[i][0] == 0) {
				colzero = true;
				break;
			}
		}
	}
	
	void checkMatrix(int[][] mat) {
		for(int i = 1; i < mat.length; i++) {
			for(int j = 1; j < mat[0].length; j++) {
				if(mat[i][j] == 0) {
					mat[0][j] = 0;
					mat[i][0] = 0;
				}
			}
		}
	}
	
	void replaceValues(int[][] mat) {
		for(int col = 1; col < mat[0].length; col++) {
			if(mat[0][col] == 0) {
				convertCols(mat, col);
			}
		}
		
		for(int row = 1; row < mat.length; row++) {
			if(mat[row][0] == 0) {
				convertRows(mat, row);
			}
		}
		
		if(colzero)
			convertCols(mat, 0);
		
		if(rowzero)
			convertRows(mat, 0);
	}
		
	void convertCols(int[][] mat, int col) {
		for(int row = 0; row < mat.length; row++) {
			mat[row][col] = 0;
		}
	}
	
	void convertRows(int[][] mat, int row) {
		for(int col = 0; col < mat[0].length; col++) {
			mat[row][col] = 0;
		}
	}
	
	void convertToZeroMatrix(int[][] mat) {
		print2dArray(mat);
		checkFirstCol(mat);
		checkFirstRow(mat);
		checkMatrix(mat);
		replaceValues(mat);
		print2dArray(mat);
	}
	
	void print2dArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}

	public static void main(String[] args) {
		int[][] mat =  {{0, 1, 2, 3}, {4, 5, 6, 7}, 
				{8, 9, 10, 11}, {12, 13, 14, 0}};
		ZeroMatrix zm = new ZeroMatrix();
		zm.convertToZeroMatrix(mat);
	}

}
