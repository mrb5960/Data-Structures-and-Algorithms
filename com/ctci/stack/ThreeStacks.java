package com.ctci.stack;

import java.util.EmptyStackException;

public class ThreeStacks {
	
	private int size;
	private int sizes[];
	private int stackarray[];
	
	public ThreeStacks(int noOfStacks, int size){
		this.size = size;
		this.stackarray = new int[noOfStacks * size];
		this.sizes = new int[noOfStacks];
		for(int i = 0; i < noOfStacks; i++)
			sizes[i] = 0;
	}
	
	public boolean isEmpty(int stackNo){
		return (sizes[stackNo - 1] == 0);
	}
	
	public boolean isFull(int stackNo){
		return (sizes[stackNo - 1] == size);
	}
	
	public int getTopIndex(int stackNo){
		//System.out.println("Stack no is " + stackNo);
		int startIndex = (stackNo - 1) * size;
		//System.out.println("Start index is " + startIndex);
		int offset = startIndex + sizes[stackNo - 1];
		//System.out.println("Offset is " + offset);
		return offset;
	}
	
	public void push(int stackNo, int data){
		if(isFull(stackNo))
			System.out.println("Stack " + stackNo + " is full");
		else{
			stackarray[getTopIndex(stackNo)] = data;
			sizes[stackNo-1]++;
		}
	}
	
	public int pop(int stackNo){
		if(isEmpty(stackNo))
			throw new EmptyStackException();
		sizes[stackNo-1]--;
		int num = stackarray[getTopIndex(stackNo)];
		stackarray[getTopIndex(stackNo)] = 0;
		return num;
	}
	
	public int peek(int stackNo){
		if(isEmpty(stackNo))
			throw new EmptyStackException();
		int num = stackarray[getTopIndex(stackNo) - 1];
		return num;
	}
	
	public void print(){
		System.out.println();
		for(int i = 0; i < stackarray.length; i++)
			System.out.print(stackarray[i] + " ");
		System.out.println();
		for(int i = 0; i < sizes.length; i++)
			System.out.print(sizes[i] + " ");
	}

	public static void main(String[] args) {
		ThreeStacks ts = new ThreeStacks(3, 3);
		try{
			ts.push(1, 1);
			ts.push(1, 2);
			ts.push(1, 3);
			ts.push(2, 4);
			ts.push(2, 5);
			System.out.println("Peek " + ts.peek(2));
			ts.push(2, 6);
			ts.push(3, 7);
			ts.push(3, 8);
			ts.push(3, 9);
			ts.print();
			System.out.println(ts.pop(1));
			System.out.println(ts.pop(1));
			System.out.println(ts.pop(1));
			//ts.pop(1);
			System.out.println(ts.pop(3));
			System.out.println(ts.pop(2));
			//ts.peek(1);
			System.out.println("Peek " + ts.peek(2));
			System.out.println("Peek " + ts.peek(3));
			ts.print();
		}
		catch(EmptyStackException e){
			System.out.println("Stack is empty");
		}
	}

}
