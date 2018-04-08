package com.ctci.linkedlist;

import com.ctci.util.linkedlist.SinglyLinkedList;
import com.ctci.util.linkedlist.Node;

public class DeleteMiddle {

	public void deleteNode(Node<Integer> current, SinglyLinkedList<Integer> sll){
		Node<Integer> prev = current;
		while(current.getNext()!=null){
			prev = current;
			current.setData(current.getNext().getData());
			current = current.getNext();
		}
		prev.setNext(null);
		sll.printAll();
	}
	
	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		Node<Integer> current = sll.getHeadPtr();
		
		for(int i = 0; i < 6; i++){
			current = current.getNext();
		}
		
		System.out.println("Current is " + current.getData());
		
		DeleteMiddle dm = new DeleteMiddle();
		dm.deleteNode(current, sll);

	}

}
