package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class Reverse {
	
	public SinglyLinkedList<Integer> reverseLL(SinglyLinkedList<Integer> sll){
		Node<Integer> prev = null, current, next = null;
		current = sll.getHeadPtr();
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		sll.setHeadPtr(prev);
		return sll;
	}

	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		Node<Integer> current = sll.getHeadPtr();
		
		while(current != null){
			System.out.println(current.getData());
			current = current.getNext();
		}
		
		System.out.println("After reversing .... ");
		sll = new Reverse().reverseLL(sll);
		
		current = sll.getHeadPtr();
		
		while(current != null){
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

}
