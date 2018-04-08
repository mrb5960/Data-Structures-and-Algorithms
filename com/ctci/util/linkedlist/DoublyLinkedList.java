package com.ctci.util.linkedlist;

public class DoublyLinkedList<T> {
	
	@SuppressWarnings("hiding")
	class Node<T> implements Comparable<T>{

		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public void setData(T data){
			this.data = data;
		}
		
		public T getData(){
			return this.data;
		}
		
		public void setNext(Node<T> next){
			this.next = next;
		}
		
		public Node<T> getNext(){
			return this.next;
		}
		
		public void setPrev(Node<T> prev){
			this.prev = prev;
		}
		
		public Node<T> getPrev(){
			return this.prev;
		}
		
		@Override
		public int compareTo(T arg) {
			if (this.data == arg)
				return 0;
			else 
				return 1;
		}
		
	}
	
	private Node<T> head, tail;
	
	public void add( T element ){
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if ( head == null ){
			head = newnode;
			tail = newnode;
		}
		else{
			tail.setNext(newnode);
			newnode.setPrev(tail);
			tail = newnode;
		}
	}
	
	public void addFirst(T element){
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if ( head == null ){
			head = newnode;
			tail = newnode;
		}
		else{
			newnode.setNext(head);
			head.setPrev(newnode);
			head = newnode;
		}
	}
	
	public void addAtPosition(int index, T element){
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if ( -1 < index && index < getSize() ){
			
			if ( index == 0 )
				addFirst(element);
			else if ( index == getSize() )
				add(element);
			else{
				Node<T> current = head;
				for ( int i = 0; i < index; i++ )
					current = current.getNext();
				Node<T> temp = current.getPrev();
				newnode.setNext(current);
				newnode.setPrev(temp);
				current.setPrev(newnode);
				temp.setNext(newnode);
			}
		}
		else
			System.err.println("Index out of bounds");
	}
	
	public int getSize() {
		int size;
		Node<T> current = head;
		if ( current == null )
			size = 0;
		else
			size = 1;
		while ( true ) {
			if ( current.getNext() != null ) {
				size++;
				current = current.getNext();
			}
			else
				break;
		}
		return size;
	}
	
	public static void main(String[] args) {
		

	}

}
