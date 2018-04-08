package com.ctci.util.heap;

import java.util.Arrays;

public class BinaryMinHeap {
	
	private int capacity;
	private int[] heap;
	private int size;
	
	public BinaryMinHeap(int capacity){
		this.capacity = capacity;
		this.size = 0;
		this.heap = new int[capacity];
		Arrays.fill(heap, -1);
	}
	
	private boolean isEmpty(){
		return size == 0;
	}
	
	private boolean isFull(){
		return capacity == size;
	}
	
	private int getParent(int index){
		return (index-1)/2;
	}
	
	private int getChild(int index, int k){
		return 2 * index + k;
	}
	
	public int getMin(){
		if(isEmpty()){
			System.out.println("Heap is empty");
			return -1;
		}
		return heap[0];
	}
	
	public void insert(int data){
		if(isFull())
			System.out.println("Heap is full");
		else{
			heap[size++] = data;
			bubbleUp(size - 1);
		}
	}
	
	private void bubbleUp(int childIndex){
		int val = heap[childIndex];
		while(childIndex > 0 && val < heap[getParent(childIndex)]){
			heap[childIndex] = heap[getParent(childIndex)];
			heap[getParent(childIndex)] = val;
			childIndex = getParent(childIndex);
		}
	}

	private int extractMin(){
		if(isEmpty()){
			System.out.println("Heap is empty");
			return -1;
		}
		else{
			int min = heap[0];
			delete(0);
			return min;
		}
	}
	
	public void delete(int index){
		if(index < 0 && index > size - 1){
			System.out.println("Incorrect index, size of heap is " + size);
		}
		else{
			heap[index] = heap[size - 1];
			System.out.println("Size is " + size);
			heap[size - 1] = -1;
			size--;
			bubbleDown(index);
		}
	}
	
	private int getMinChildIndex(int parentIndex){
		int child1 = getChild(parentIndex, 1);
		int child2 = getChild(parentIndex, 2);
		if (child1 > size - 1)
			return Integer.MAX_VALUE;
		else if (child2 > size - 1)
			return child1;
		else{ 
			if(heap[child1] < heap[child2])
				return child1;
			else
				return child2;
		}
	}
	
	private void bubbleDown(int parentIndex){
		while(getMinChildIndex(parentIndex) != Integer.MAX_VALUE){
			int minChildIndex = getMinChildIndex(parentIndex);
			if(heap[parentIndex] > heap[minChildIndex]){
				int tmp = heap[minChildIndex];
				heap[minChildIndex] = heap[parentIndex];
				heap[parentIndex] = tmp;
				parentIndex = minChildIndex;
			}
			else 
				break;
		}
	}
	
	public void printHeap(){
		for(int i = 0; i < size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryMinHeap bh = new BinaryMinHeap(10);
		bh.insert(12);
		bh.printHeap();
		bh.insert(31);
		bh.printHeap();
		bh.insert(41);
		bh.printHeap();
		bh.insert(15);
		bh.printHeap();
		bh.insert(6);
		bh.printHeap();
		bh.insert(1);
		bh.printHeap();
		bh.extractMin();
		bh.printHeap();
		bh.delete(1);
		bh.printHeap();
	}
}
