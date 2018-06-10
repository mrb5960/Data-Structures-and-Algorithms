package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class Temp {
	
	public Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
		Node<Integer> head = null;
		Node<Integer> curr = null;
        int sum = 0;
        int carry = 0;
        while(l1 != null && l2 != null){
            //carry = 0;
            sum = carry + l1.getData() + l2.getData();
            if(sum > 9){
                sum = sum % 10;
                carry = sum / 10;
            }
            
            Node<Integer> newnode = new Node<Integer>(sum);
            if(head == null){
                head = newnode;
                curr = newnode;
            }
            else{
            	curr.setNext(newnode);
            	curr = curr.getNext();
            }
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        
        while(l1 != null){
            sum = carry + l1.getData();
            if(sum > 9){
                sum = sum % 10;
                carry /= 10;
            }
            
            Node<Integer> newnode = new Node<Integer>(sum);
            if(head == null){
                head = newnode;
                curr = newnode;
            }
            else{
            	curr.setNext(newnode);
            	curr = curr.getNext();
            }
            l1 = l1.getNext();
        }
        
        while(l2 != null){
            sum = carry + l2.getData();
            if(sum > 9){
                sum = sum % 10;
                carry /= 10;
            }
            
            Node<Integer> newnode = new Node<Integer>(sum);
            if(head == null){
                head = newnode;
                curr = newnode;
            }
            else{
                curr.setNext(newnode);
                curr = curr.getNext();
            }
            l2 = l2.getNext();
        }
        
        return head;
    }

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list1.add(2);
		list1.add(4);
		list1.add(3);
		list2.add(5);
		list2.add(6);
		list2.add(4);
		//list2.add(1);
		
		Node<Integer> head = new Temp().addTwoNumbers(list1.getHeadPtr(), list2.getHeadPtr());
		
		while(head != null){
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}

}
