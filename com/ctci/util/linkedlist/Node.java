package com.ctci.util.linkedlist;

public class Node<T> implements Comparable<T>{

	private T data;
	private Node<T> next;
	
	public Node(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
		//this.data = data;
	}

	public void setData(T val){
		this.data = val;
	}
	
	public T getData(){
		return this.data;
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public void setNext(Node<T> node){
		this.next = node;
	}
	
	@Override
	public int compareTo(T arg) {
		if(this.data == arg)
			return 0;
		else 
			return 1;
	}
	
}
