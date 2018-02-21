package com.ctci.util.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> implements Comparable<T> {

	private int size;
	private List<T> stackArray;
	private int top;
	
	public MyStack(){
	}
	
	public MyStack(int size){
		this.size = size;
		stackArray = new ArrayList<T>(size);
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == size - 1);
	}
	
	public void push(T element){
		if(isFull())
			System.out.println("Stack is full");
		else{
			stackArray.add(++top, element);	
			System.out.println("added: " + element);
		}
	}
	
	public T pop(){
		try{
			return stackArray.remove(top--);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack is empty");
			top++;
			return null;
		}
	}
	
	public T peek(){
		try{
			return stackArray.get(top);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack is empty");
			return null;
		}
	}
	
	public void printStack(){
		while(!isEmpty())
			System.out.println(pop());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> ms = new MyStack<Integer>(5);
		ms.peek();
		ms.pop();
		ms.push(0);
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		System.out.println("Removed " + ms.pop());
		System.out.println("Removed " + ms.pop());
		System.out.println("Peek " + ms.peek());
		ms.push(5);
		ms.push(6);
		ms.push(7);
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
