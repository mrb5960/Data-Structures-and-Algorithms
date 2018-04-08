package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

import java.util.HashSet;

public class RemoveDups {
	
	public void withBuffer(Node<Integer> head, SinglyLinkedList<Integer> sll){
		Node<Integer> current, prev;
		HashSet<Integer> hs = new HashSet<>();
		current = head;
		prev = head;
		while(true){
			if(current == null)
				break;
			if(hs.contains(current.getData())){
				prev.setNext(current.getNext());
				current = current.getNext();
			}
			else{
				hs.add(current.getData());
				prev = current;
				current = current.getNext();
			}
		}
		
		sll.printAll();
	}
	
	public void noBuffer(Node<Integer> head, SinglyLinkedList<Integer> sll){
		Node<Integer> current, prev, next;
		current = head;
		prev = head;
		while(true){
			if(current == null)
				break;
			prev = current;
			next = current.getNext();
			while(next!=null){
				if(current.getData() == next.getData()){
					prev.setNext(next.getNext());
					prev = next;
					next = next.getNext();
				}
				else{
					next = next.getNext();
					prev = prev.getNext();
				}
			}
			current = current.getNext();
		}
		sll.printAll();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(0);
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(0);
		sll.add(4);
		sll.add(5);
		sll.add(1);
		
		Node<Integer> head = sll.getHeadPtr();
		RemoveDups rd = new RemoveDups();
		
		System.out.println("No buffer");
		rd.noBuffer(head, sll);
		
		//System.out.println("With buffer");
		//rd.withBuffer(head, sll);
	}

}
