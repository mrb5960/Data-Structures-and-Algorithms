package com.ctci.stack;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack;
    Stack<Integer> minstack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int x) {
        if(minstack.isEmpty() || minstack.peek() >= x)
            minstack.push(x);
        stack.push(x);
    }
    
    public int pop() {
    	// type casting from wrapper Integer to int is important 
    	// java does not create new objects in the range -128 to 127
    	// new objects are created for same values for anything beyond this range
    	// hence comparing the Integer objects gives wrong output as they are 
    	// two different objects with the same value. 
    	// Two solutions to this problem
    	// 1. Either use equals() method which compares only values or
    	// 2. cast to int
        //if((int)stack.peek() == (int)minstack.peek()){
        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		System.out.println("Pop " + ms.pop());
		System.out.println("GetMin " + ms.getMin());
		System.out.println("Pop " + ms.pop());
		System.out.println("GetMin " + ms.getMin());
		System.out.println("Pop " + ms.pop());
		System.out.println("GetMin " + ms.getMin());
	}

}
