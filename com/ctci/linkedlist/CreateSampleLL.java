package com.ctci.linkedlist;

import com.ctci.util.linkedlist.SinglyLinkedList;

public class CreateSampleLL {
	
	public SinglyLinkedList<Integer> getSample(){
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(3);
		sll.add(5);
		sll.add(8);
		sll.add(5);
		sll.add(10);
		sll.add(2);
		sll.add(1);	
		return sll;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
