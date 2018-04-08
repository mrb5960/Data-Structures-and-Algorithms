package com.ctci.dynamic;

public class Fibonacci {
	
	int getFib(int n){
		return getFib(n, new int[n+1]);
	}
	
	int getFib(int n, int[] memo){
		if(n == 0 || n == 1)
			return n;
		if(memo[n] == 0)
			memo[n] = getFib(n-1, memo) + getFib(n-2, memo);
		return memo[n];
	}

	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.getFib(5));
	}

}
