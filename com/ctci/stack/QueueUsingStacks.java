package com.ctci.stack;

import java.util.EmptyStackException;

import com.ctci.util.stack.MyStack;

public class QueueUsingStacks {
	
	private MyStack<Integer> stack1, stack2;
	
	public QueueUsingStacks(int size){
		stack1 = new MyStack<>(size);
		stack2 = new MyStack<>(size);
	}

	public boolean isFull(){
		return stack1.isFull();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	
	public void enqueue(int data){
		if(!isFull()){
			stack1.push(data);
		}
		else
			System.out.println("Queue is full");
	}
	
	public int dequeue(){
		if(isEmpty())
			throw new EmptyStackException();
		while(!isEmpty())
			stack2.push(stack1.pop());
		int poped = stack2.pop();
		while(!stack2.isEmpty())
			stack1.push(stack2.pop());
		return poped;
	}
	
	public static void main(String[] args) {
		QueueUsingStacks qus = new QueueUsingStacks(3);
		try{
			qus.enqueue(1);
			qus.enqueue(2);
			qus.enqueue(3);
			qus.enqueue(4);
			System.out.println(qus.dequeue());
			qus.enqueue(4);
			//qus.stack1.printStack();
			System.out.println(qus.dequeue());
			System.out.println(qus.dequeue());
			System.out.println(qus.dequeue());
			System.out.println(qus.dequeue());
		}
		catch(EmptyStackException e){
			System.out.println("Queue is empty");
		}
	}
}
