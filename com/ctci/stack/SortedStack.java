package com.ctci.stack;

import com.ctci.util.stack.MyStack;

public class SortedStack {
	
	private MyStack<Integer> stack1, stack2;
	
	public SortedStack(int size){
		stack1 = new MyStack<>(size);
		stack2 = new MyStack<>(size);
	}
	
	public boolean isFull(){
		return stack1.isFull();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	
	public void push(int data){
		if(isFull())
			System.out.println("Stack is full");
		else if(isEmpty())
			stack1.push(data);
		else{
			while(!isEmpty() && stack1.peek() > data)
				stack2.push(stack1.pop());
			stack1.push(data);
			while(!stack2.isEmpty())
				stack1.push(stack2.pop());
		}
	}
	
	public int pop(){
		return stack1.pop();
	}

	public int peek(){
		return stack1.peek();
	}
	
	// function to sort an unsorted stack
	public MyStack<Integer> getSorted(MyStack<Integer> unsorted, int size){
		MyStack<Integer> sorted = new MyStack<>(size);
		int tmp;
		while(!unsorted.isEmpty()){
			tmp = unsorted.pop();
			while(!sorted.isEmpty() && sorted.peek() > tmp)
				unsorted.push(sorted.pop());
			//System.out.println("Pushed into sorted ");
			sorted.push(tmp);
		}
		return sorted;
	}
	
	public static void main(String[] args) {
		SortedStack ss = new SortedStack(5);
		ss.push(3);
		System.out.println("Peek " + ss.peek());
		ss.push(1);
		System.out.println("Peek " + ss.peek());
		ss.push(5);
		System.out.println("Peek " + ss.peek());
		ss.push(2);
		System.out.println("Peek " + ss.peek());
		ss.push(4);
		System.out.println("Peek " + ss.peek());
		ss.stack1.printStack();
		MyStack<Integer> unsorted = new MyStack<>(5);
		unsorted.push(3);
		unsorted.push(1);
		unsorted.push(5);
		unsorted.push(2);
		unsorted.push(4);
		MyStack<Integer> sorted = ss.getSorted(unsorted, 5);
		System.out.println("Printing sorted stack");
		sorted.printStack();
	}
}
