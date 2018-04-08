package com.ctci.dynamic;

import java.util.ArrayList;

public class Robot {
	
	public class Cell{
		int row, col;
		
		public Cell(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	void getPath(boolean[][] grid){
		ArrayList<Cell> path = new ArrayList<>();
		ArrayList<Cell> failed = new ArrayList<>();
		if(getPath(grid, grid.length - 1, grid[0].length - 1, path, failed)){
			for(Cell c : path){
				System.out.println(c.row + " " + c.col);
			}
		}			
		else
			System.out.println("Path does not exist");
	}
	
	boolean getPath(boolean[][] grid, int row, int col, ArrayList<Cell> path, ArrayList<Cell> failed){
		if(row < 0 || col < 0 || !grid[row][col])
			return false;
		
		Cell c = new Cell(row, col);
		
		if(failed.contains(c))
			return false;
		
		// this is required to stop the recursion
		// at cell(0,0) both getPath for the adjacent cells will return false which will indicate that
		// path does not exist 
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(grid, row - 1, col, path, failed) || getPath(grid, row, col - 1, path, failed)){
			path.add(c);
			return true;
		}
		
		failed.add(c);
		return false;
	}

	public static void main(String[] args) {
		boolean[][] grid = {{true, true, true, true},
				{true, true, true, true},
				{true, true, true, true},
				{true, true, true, true}};
		
		Robot r = new Robot();
		r.getPath(grid);
	}

}
