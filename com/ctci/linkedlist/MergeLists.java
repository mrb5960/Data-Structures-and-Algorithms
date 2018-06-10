package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class MergeLists {
	
	public Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		Node<Integer> temp = new Node<>();
		Node<Integer> output = temp;
		while(head1 != null && head2 != null){
			if(head1.getData() < head2.getData()){
				temp.setNext(head1);
				head1 = head1.getNext();
			}
			else{
				temp.setNext(head2);
				head2 = head2.getNext();
			}
			temp = temp.getNext();
		}
		temp.setNext((head1 == null) ? head2 : head1);
		return output.getNext();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll1 = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> ll2 = new SinglyLinkedList<>();
		ll1.add(1);
		ll1.add(3);
		ll1.add(5);
		ll2.add(2);
		ll2.add(4);
		ll2.add(6);
		MergeLists ml = new MergeLists();
		Node<Integer> head = ml.merge(ll1.getHeadPtr(), ll2.getHeadPtr());
		System.out.println("Merged list");
		while(head != null){
			System.out.println(head.getData());
			head = head.getNext();
		}
	}
}
