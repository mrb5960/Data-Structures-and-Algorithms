package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class KthToLast {
	
	public void findKth(int k, Node<Integer> head, SinglyLinkedList<Integer> sll){
		Node<Integer> current = head, runner = head, prev = head;
		for(int i = 0; i < k-1; i++){
			current = current.getNext();
		}
		
		while(true){
				prev = current;
				current = current.getNext();
				if(current == null)
					break;
				runner = runner.getNext();
		}
		
		System.out.println("Current is "+ prev.getData() + " and " + k + "th is "+ runner.getData());
	}

	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		Node<Integer> head = sll.getHeadPtr();
		KthToLast ktl = new KthToLast();
		ktl.findKth(4, head, sll);
	}

}
