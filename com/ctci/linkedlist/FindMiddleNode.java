package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class FindMiddleNode {
	
	int find(SinglyLinkedList<Integer> sll){
		Node<Integer> slow = sll.getHeadPtr();
		Node<Integer> fast = sll.getHeadPtr();
		
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return slow.getData();
	}

	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		//sll.add(9);
		
		FindMiddleNode fmn = new FindMiddleNode();
		System.out.println(fmn.find(sll));
	}
}
