package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class RotateLL {
	
	SinglyLinkedList<Integer> rotate(SinglyLinkedList<Integer> sll, int index){
		
		if(index == 0)
			return sll;
		else if(index > sll.getSize())
			return sll;
		else{
			Node<Integer> current = sll.getHeadPtr();
			Node<Integer> prev = null;
			int count = 1;
			while(count < index){
				prev = current;
				current = current.getNext();
				count++;
			}
			Node<Integer> new_head = current;
			prev.setNext(null);
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(sll.getHeadPtr());
			sll.setHeadPtr(new_head);
			
			return sll;
		}
	}

	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		RotateLL rll = new RotateLL();
		sll = rll.rotate(sll, 10);
		
		System.out.println("After rotation.......");
		sll.printAll();
	}

}
