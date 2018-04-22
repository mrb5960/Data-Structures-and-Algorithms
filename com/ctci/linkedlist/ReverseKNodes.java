package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class ReverseKNodes {

	Node<Integer> reverse(int k, Node<Integer> head){
		Node<Integer> current = head;
		Node<Integer> prev = null;
		Node<Integer> next = null;
		int count = 1;
		while(count <= k && current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null){
			head.setNext(reverse(k, next));
		}
		
		return prev;
	}
	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		ReverseKNodes rkn = new ReverseKNodes();
		sll.setHeadPtr(rkn.reverse(3, sll.getHeadPtr()));
		
		System.out.println("After reversal......");
		sll.printAll();
	}
}
