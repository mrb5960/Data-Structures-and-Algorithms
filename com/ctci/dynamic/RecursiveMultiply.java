package com.ctci.dynamic;

public class RecursiveMultiply {
	
	int additions = 0;
	
	void Multiply(int x, int y){
		int a = (x > y ? x : y);
		int b = (x < y ? x : y);
		System.out.println(a + " * " + b + " = " + recMul(a, b) + "\nNo of additions: " + additions);
	}
	
	int recMul(int a, int b){
		
		if(b == 0)
			return 0;
		if(b == 1)
			return a;
		int div1 = b/2;
		int div2 = b - div1;
		
		int sum = 0;
		
		if(div1 == div2){
			int res = recMul(a, div1);
			sum = res + res;
			additions++;
		}
		else{
			int res1 = recMul(a, div1);
			int res2 = recMul(a, div2);
			sum = res1 + res2;
			additions++;
		}
		return sum;
	}

	public static void main(String[] args) {
		RecursiveMultiply rm = new RecursiveMultiply();
		rm.Multiply(50, 50);
	}

}
