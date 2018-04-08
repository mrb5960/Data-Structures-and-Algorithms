package com.ctci.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

import com.ctci.util.stack.MyStack;

public class StackOfStacks {
	
	private int sizeOfStack;
	private int currentStack;
	private ArrayList<MyStack<Integer>> stacks;

	public StackOfStacks(int sizeOfStack){
		this.sizeOfStack = sizeOfStack;
		this.currentStack = -1;
		this.stacks = new ArrayList<MyStack<Integer>>();
	}
	
	public boolean isCurrentFull(){
		return stacks.get(currentStack).isFull();
	}
	
	public boolean isEmpty(){
		return currentStack == -1;
	}
	
	public boolean isCurrentEmpty(){
		return stacks.get(currentStack).isEmpty();
	}
	
	public void push(int data){
		if(currentStack == -1){
			currentStack++;
			stacks.add(new MyStack<Integer>(sizeOfStack));
			stacks.get(currentStack).push(data);
		}
		else if(isCurrentFull()){
			currentStack++;
			stacks.add(new MyStack<Integer>(sizeOfStack));
			stacks.get(currentStack).push(data);
		}
		else{
			stacks.get(currentStack).push(data);
		}	
	}
	
	public int pop(){
		if(isEmpty())
			throw new EmptyStackException();
		if(isCurrentEmpty()){
			stacks.remove(currentStack);
			currentStack--;
			if(currentStack >= 0)
				return stacks.get(currentStack).pop();
			else
				throw new EmptyStackException();
		}
		else{
			return stacks.get(currentStack).pop();
		}
	}
	
	public int peek(){
		if(isEmpty())
			throw new EmptyStackException();
		if(isCurrentEmpty()){
			stacks.remove(currentStack);
			currentStack--;
			if(currentStack >= 0)
				return stacks.get(currentStack).peek();
			else
				throw new EmptyStackException();
		}
		else{
			return stacks.get(currentStack).peek();
		}
	}
	
	public static void main(String[] args) {
		StackOfStacks sos = new StackOfStacks(3);
		try{
			//sos.peek();
			//sos.pop();
			sos.push(1);
			System.out.println("Peek " + sos.peek());
			sos.push(2);
			System.out.println("Peek " + sos.peek());
			sos.push(3);
			System.out.println("Peek " + sos.peek());
			sos.push(4);
			System.out.println("Peek " + sos.peek());
			System.out.println(sos.pop());
			System.out.println("Peek " + sos.peek());
			System.out.println(sos.pop());
			System.out.println("Peek " + sos.peek());
			System.out.println(sos.pop());
			System.out.println("Peek " + sos.peek());
			System.out.println(sos.pop());
			System.out.println("Peek " + sos.peek());
			System.out.println(sos.pop());
		}
		catch(EmptyStackException e){
			System.out.println("Stack is empty");
		}
	}

}
