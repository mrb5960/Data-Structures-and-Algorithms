package com.ctci.util.linkedlist;

public class SinglyLinkedList<T> {
	
	/*@SuppressWarnings("hiding")
	public class Node<T> implements Comparable<T>{

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
		
		@Override
		public int compareTo(T arg) {
			if(this.data == arg)
				return 1;
			else 
				return 0;
		}
		
	}*/
	
	private Node<T> head;
	private Node<T> tail;
	
	public void setHead(Node<T> newnode) {
		newnode.setNext(head);
		head = newnode;
	}

	public void setTail(Node<T> newnode) {
		tail.setNext(newnode);
		tail = newnode;
	}
	
	public T getHead(){
		return head.getData();
	}
	
	public T getTail(){
		return tail.getData();
	}
	
	public Node<T> getHeadPtr(){
		return this.head;
	}
	
	public void setHeadPtr(Node<T> head){
		this.head = head;
	}
	
	public Node<T> getTailPtr(){
		return this.tail;
	}
	
	public void add(T element){
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if ( head == null){
			head = newnode;
			tail = newnode;
		}
		else{
			tail.setNext(newnode);
			tail = newnode;
		}
		//System.out.println("Head is " + head.getData() + " Tail is " + tail.getData());
		printAll();
	}
	
	public void addAtPosition(int index, T element){
		try{
			int count = 0;
			Node<T> current = new Node<T>();
			current = head;
			while (count < index - 1){
				current = current.getNext();
				count++;
			}
			
			Node<T> newnode = new Node<T>();
			newnode.setData(element);
			
			if(current == tail){
				setTail(newnode);
			}
			else{
				newnode.setNext(current.getNext());
				current.setNext(newnode);
			}
			printAll();
		}
		catch(NullPointerException e){
			System.err.println("Index out of bounds");
		}
	}
	
	public void addFirst(T element){
		
		Node<T> newnode = new Node<T>();
		newnode.setData(element);
		if( getSize() == 0){
			head = newnode;
			tail = newnode;
		}
		else{
			newnode.setNext(head);
			head = newnode;
		}
		
		printAll();
	}
	
	public void addLast(T element){
		
		Node<T> newnode = new Node<T>();
		if( getSize() == 0){
			head = newnode;
			tail = newnode;
		}
		else{
			newnode.setData(element);
			tail.setNext(newnode);
			tail = newnode;
		}
		
		printAll();
	}
	
	public boolean contains(T element){
		Node<T> current;
		current = head;
		while(true){
			if( current == null){
				break;
			}
			if( current.compareTo(element) == 1)
				return true;
			current = current.getNext();
		}
		return false;
	}
	
	public int indexOf(T element){
		int index = 0;
		Node<T> current = new Node<T>();
		current = head;
		while(true){
			if( current == null )
				break;
			if( current.compareTo(element) == 1){
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
	}
	
	public boolean removeAtIndex(int index){
		int pos = 0;
		Node<T> current, prev;
		prev = head;
		try{
			if( index == 0){
				head = head.getNext();
			}
			else{
				while(true){
					if(pos != index - 1){
						prev = prev.getNext();
						pos++;
					}
					else
						break;
				}
				current = prev.getNext();
				prev.setNext(current.getNext());
			}
			printAll();
			return true;
		}
		catch(NullPointerException e){
			System.out.println("Index out of bounds");
			printAll();
			return false;
		}
	}
	
	public boolean removeHead(){
		if ( head != null ){
			head = head.getNext();
			return true;
		}
		else
			return false;
	}
	
	public T remove(T element){
		if ( contains(element) ){
			
		}
		return element;
	}
	
	public int getSize(){
		int count = 1;
		if (head == null)
			return 0;
		else{
			Node<T> current;
			current = head;
			while( current.getNext() != null ){
				count ++;
				current = current.getNext();
			}
			return count;
		}
	}
	
	public void printAll(){
		Node<T> current;
		current = head;
		while(true){
			if( current == null)
				break;
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println("Head is " + head.getData() + " Tail is " + tail.getData());
	}

	public static void main(String[] args) {
		SinglyLinkedList<String> sll = new SinglyLinkedList<>();
		sll.addFirst("D");
		sll.addLast("Z");
		sll.add("A");
		sll.add("B");
		sll.add("C");
		sll.addLast("Q");
		sll.addAtPosition(1, "Y");
		sll.addAtPosition(7, "S");
		System.out.println(sll.getSize());
		System.out.println(sll.indexOf("A"));
		System.out.println(sll.indexOf("B"));
		System.out.println(sll.indexOf("K"));
		System.out.println(sll.contains("D"));
		System.out.println(sll.contains("K"));
		System.out.println(sll.removeAtIndex(7));
		System.out.println(sll.removeAtIndex(6));
		System.out.println(sll.removeAtIndex(0));
		System.out.println(sll.removeAtIndex(1));
	}

}
