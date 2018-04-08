package com.ctci.util.queue;

public class MyQueue<T> {
	
	private Node<T> front, rear;
	
	@SuppressWarnings("hiding")
	class Node<T>{

		private T data;
		private Node<T> next;
		
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
	}
	
	public boolean isEmpty(){
		return ( front == null );
	}
	
	public void enqueue(T element){
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if(isEmpty()){
			front = newnode;
			rear = newnode;
			System.out.println("added " + newnode.getData());
		}
		else{
			rear.setNext(newnode);
			rear = newnode;
			System.out.println("added " + newnode.getData());
		}
	}
	
	public T dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		else{
			Node<T> tmp = front;
			front = front.getNext();
			if(front == null)
				rear = null;
			return tmp.getData();
		}	
	}
	
	public T peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		else
			return front.getData();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> mq = new MyQueue<Integer>();
		System.out.println(mq.peek());
		System.out.println(mq.dequeue());
		mq.enqueue(0);
		mq.enqueue(1);
		System.out.println(mq.peek());
		System.out.println(mq.dequeue());
		System.out.println(mq.peek());
		System.out.println(mq.dequeue());
		System.out.println(mq.peek());
	}

}
