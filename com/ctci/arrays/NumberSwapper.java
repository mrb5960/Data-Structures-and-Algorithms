package com.ctci.arrays;

public class NumberSwapper {

	public static void main(String[] args) {
		int a = 5, b = 2;
		System.out.println("a = " + a + " b = " + b);
		b = b - a; // -3
		a = a + b; // 2
		b = a - b;
		System.out.println("a = " + a + " b = " + b);
	}
}
