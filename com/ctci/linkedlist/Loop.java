package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class Loop {
	
	public Node<Integer> getLoopStart(SinglyLinkedList<Integer> list){
		Node<Integer> slow, fast, head;
		head = list.getHeadPtr();
		slow = head;
		fast = head;
		boolean isLoop = false;
		
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				isLoop = true;
				break;
			}
		}
		
		if(isLoop){
			slow = head;
			while(slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
		else
			return null;
	}

	public static void main(String[] args) {
		Loop lp = new Loop();
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(3);
		sll.add(5);
		sll.add(8);
		sll.add(5);
		sll.add(8);
		sll.add(5);
		sll.add(3);
		
		// creating a loop in the linkedlist
		Node<Integer> head = sll.getHeadPtr();
		Node<Integer> temp = null;
		int count = 0;
		while(head.getNext() != null){
			if(count == 2)
				temp = head;
			head = head.getNext();
			count++;
		}
		head.setNext(temp);
		
		
		Node<Integer> res = lp.getLoopStart(sll);
		if(res == null)
			System.out.println("No loop");
		else
			System.out.println("Loop head is " + res.getData());
	}

}
