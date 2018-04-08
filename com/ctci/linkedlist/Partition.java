package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class Partition {
	
	public void makePartitionsBasic(int x, SinglyLinkedList<Integer> sll){
		Node<Integer> current = sll.getHeadPtr();
		SinglyLinkedList<Integer> lt = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> gte = new SinglyLinkedList<Integer>();
		Node<Integer> lastAddedInLt = null;
		
		while(true){
			if(current == null)
				break;
			if(current.getData() < x){
				lt.add(current.getData());
			}
			else{
				gte.add(current.getData());
			}
			current = current.getNext();
		}
		
		System.out.println("Less than list ");
		lt.printAll();
		System.out.println("Greater than or equal to list ");
		gte.printAll();
		lastAddedInLt = lt.getHeadPtr();
		while(lastAddedInLt.getNext() != null)
			lastAddedInLt = lastAddedInLt.getNext();
		
		lastAddedInLt.setNext(gte.getHeadPtr());
		
		System.out.println("Final list");
		lt.printAll();
	}
	
	public void makePartitionsOptimized(int x, SinglyLinkedList<Integer> sll){
		
		Node<Integer> Lhead = sll.getHeadPtr();
		Node<Integer> Ltail = Lhead;
		Node<Integer> current = Lhead;
		Node<Integer> next;
		
		while(true){
			if(current == null)
				break;
			next = current.getNext();
			//System.out.println("Current value is " + current.getData());
			
			if(current.getData() < x){
				current.setNext(Lhead);
				Lhead = current;
				//System.out.println("Head is " + Lhead.getData());
			}
			else{
				Ltail.setNext(current);
				Ltail = current;
				//System.out.println("Tail is " + Ltail.getData());
			}
			current = next;
		}
		Ltail.setNext(null);
		//System.out.println("Final Head is " + Lhead.getData());
		current = Lhead;
		
		while(current!=null){
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}	
	}

	public static void main(String[] args) {
		CreateSampleLL csl = new CreateSampleLL();
		SinglyLinkedList<Integer> sll = csl.getSample();
		
		//System.out.println("Printing sll");
		//sll.printAll();

		Partition part = new Partition();
		System.out.println("Basic algorithm");
		part.makePartitionsBasic(5, sll);
		System.out.println("Optimized algorithm");
		part.makePartitionsOptimized(5, sll);
	}
}
