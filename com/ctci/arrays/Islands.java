package com.ctci.arrays;

/*
 * Finding the number of islands using DFS
 * Time complexity is m*n
 * m is the number of rows and n is the number of columns
 * Space complexity is also m*n
 */
public class Islands {
	
	public int getIslands(int[][] input){
		int count = 0;
		boolean[][] memo = new boolean[input.length][input[0].length];
		
		for(int row = 0; row < input.length; row++){
			for(int col = 0; col < input[0].length; col++){
				if(input[row][col] == 1 && !memo[row][col]){
					getIslandsHelper(input, row, col, memo);
						count += 1;
				}
			}
		}
		
		return count;
	}
	
	public void getIslandsHelper(int[][] input, int row, int col, boolean[][] memo){
		if(row > input.length - 1 || row < 0 ||
			col > input[0].length - 1 || col < 0 ||
			memo[row][col] || input[row][col] == 0){
			return;
		}
		else{
			memo[row][col] = true;
			for(int row_offset = -1; row_offset < 2; row_offset++){
				for(int col_offset = -1; col_offset < 2; col_offset++){
					if(row_offset == 0 && col_offset == 0)
						continue;
					getIslandsHelper(input, row + row_offset, col + col_offset, memo);
				}
			}
		}
	}
	
	
	// Arrays are pass by reference in Java.
	public void test(){
		int[] arr = {1, 1};
		System.out.println("Before change: " + arr[0] + " " + arr[1]);
		testHelper(arr);
		System.out.println("After change: " + arr[0] + " " + arr[1]);		
	}
	
	public void testHelper(int[] arr){
		arr[0] = 0;
		arr[1] = 0;
	}

	public static void main(String[] args) {
		int[][] input = {{0,1,0},{1,1,1},{0,1,0}};
		Islands i = new Islands();
		System.out.println(i.getIslands(input));
	}

}
