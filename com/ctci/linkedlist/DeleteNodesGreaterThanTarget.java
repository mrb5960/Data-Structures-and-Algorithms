package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class DeleteNodesGreaterThanTarget {
	
	public Node<Integer> remove(Node<Integer> head, int target){
		Node<Integer> curr = head;
		Node<Integer> pre = null;
		
		// important to check for null
		// if all nodes are greater than target
		while(curr != null && curr.getData() > target){
			curr = curr.getNext();
			head = head.getNext();
		}
		
		pre = curr;
		curr = curr.getNext();
		
		while(curr != null){
			while(curr != null && curr.getData() > target){
				curr = curr.getNext();
			}
			if(curr == null){
				pre.setNext(curr);
				break;
			}
			pre.setNext(curr);
			pre = curr;
			curr = curr.getNext();
		}
		
		return head;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(8);
		sll.add(5);
		sll.add(1);
		sll.add(3);
		sll.add(7);
		sll.add(2);
		sll.add(0);
		sll.add(6);
		sll.add(10);
		DeleteNodesGreaterThanTarget dngt = new DeleteNodesGreaterThanTarget();
		Node<Integer> head = dngt.remove(sll.getHeadPtr(), 6);
		while(head != null){
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

}
