package com.ctci.stack;

import java.util.Stack;

import com.ctci.util.stack.MyStack;

public class Minimum extends MyStack<Integer>{

	private Stack<Integer> minStack;
	
	public Minimum(){
		super(100);
		minStack = new Stack<Integer>();
	}
	
	public void push(int data){
		super.push(data);
		if(data < getMin())
			minStack.push(data);
	}
	
	public Integer pop(){
		int poped = super.pop();
		if(poped == getMin())
			minStack.pop();
		return poped;
	}
	
	public int getMin(){
		if(minStack.empty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
	public Integer peek(){
		return super.peek();
	}

	public static void main(String[] args) {
		Minimum min = new Minimum();
		min.push(5);
		System.out.println("Minimum is " + min.getMin());
		min.push(4);
		System.out.println("Minimum is " + min.getMin());
		min.push(3);
		System.out.println("Minimum is " + min.getMin());
		min.push(6);
		System.out.println("Minimum is " + min.getMin());
		min.push(2);
		System.out.println("Minimum is " + min.getMin());
		System.out.println("Peek " + min.peek());
		min.pop();
		System.out.println("Minimum is " + min.getMin());
		min.pop();
		System.out.println("Minimum is " + min.getMin());
		min.pop();
		System.out.println("Minimum is " + min.getMin());
		min.pop();
		System.out.println("Minimum is " + min.getMin());
		min.pop();
		System.out.println("Minimum is " + min.getMin());
	}
}
