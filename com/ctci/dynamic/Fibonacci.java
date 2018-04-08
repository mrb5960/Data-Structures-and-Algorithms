package com.ctci.dynamic;

public class Fibonacci {
	
	// time complexity is O(2^n) and space complexity is n as there will be only O(n) calls at max in the stack at a time.
	int getFibRec(int n){
		if( n == 0 || n == 1)
			return n;
		return getFibRec(n-1) + getFibRec(n-2);
	}
	
	// time complexity and space complexity are O(1) as constant number of values are stored i.e a, b and c
	// this is called a bottom-up approach 
	// you are moving from bottom i.e. 0 to top i.e. n
	int getFibIter(int n){
		if( n == 0 || n == 1)
			return n;
		else{
			int a = 0;
			int b = 1;
			int c = 0;
			for(int i = 2; i <= n; i++){
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
	
	// this is same as above but using memoization
	// time and space complexity is 0(n)
	int getFibIterMemo(int n){
		if( n == 0 || n == 1)
			return n;
		else{
			int[] memo = new int[n+1];
			memo[0] = 0;
			memo[1] = 1;
			for(int i = 2; i <= n; i++){
				memo[i] = memo[i-1] + memo[i-2];
			}
			return memo[n];
		}
	}
	
	// time and space complexity is 0(n)
	// this method is called top-down approach of DP also known as memoization
	// you are starting from the top i.e. n and going towards 0.
	int getFibDP(int n){
		return getFibDP(n, new int[n+1]);
	}
	
	int getFibDP(int n, int[] memo){
		if(n == 0 || n == 1)
			return n;
		if(memo[n] == 0)
			memo[n] = getFibDP(n-1, memo) + getFibDP(n-2, memo);
		return memo[n];
	}

	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		System.out.println("Dynamic: " + fb.getFibDP(20));
		System.out.println("Iterative: " + fb.getFibIter(20));
		System.out.println("Iterative with memo: " + fb.getFibIterMemo(20));
	}

}
