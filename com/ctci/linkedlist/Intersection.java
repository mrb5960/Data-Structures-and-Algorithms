package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class Intersection {
	
	public class Result{
		Node<Integer> node;
		boolean equal;
		
		public Result(){}
		
		public Result(Node<Integer> node, boolean equal){
			this.node = node;
			this.equal = equal;
		}
	}
	
	// this approach does not work if linked lists are of different length
	public Result RecursiveIntersect(Node<Integer> node1, Node<Integer> node2){
		if(node1.getNext() == null && node2.getNext() == null){
			System.out.println("Node1 " + node1.getData() + " Node2 " + node2.getData() + " " + (node1==node2));
			return new Result(node1,node1 == node2);
		}
		Result temp = RecursiveIntersect(node1.getNext() == null ? node1 : node1.getNext(), node2.getNext() == null ? node2 : node2.getNext());
		Result result = new Result();
		System.out.println("Node1 " + node1.getData() + " Node2 " + node2.getData() + " " + (node1==node2));
		System.out.println("equal " + temp.equal);
		
		if(temp.equal && node1 == node2){
			System.out.println("equal " + temp.equal);
			result.equal = true;
			result.node = node1;
		}
		else{
			System.out.println("Here");
			result.equal = false;
			result.node = temp.node;
		}
		return result;
	}

	public boolean ifIntersects(Node<Integer> node1, Node<Integer> node2){
		Node<Integer> tail1 = node1, tail2 = node2;
		while(tail1 != null){
			tail1 = tail1.getNext();
		}
		while(tail2 != null){
			tail2 = tail2.getNext();
		}
		return (tail1 == tail2);
	}
	
	public Node<Integer> findIntersectingNode(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2){
		// padding required if lists are of different length
		if(list1.getSize() < list2.getSize()){
			while(list1.getSize() != list2.getSize())
				list1.addFirst(0);
		}
		else if(list1.getSize() > list2.getSize()){
			while(list1.getSize() != list2.getSize())
				list2.addFirst(0);
		}
		Node<Integer> head1 = list1.getHeadPtr();
		Node<Integer> head2 = list2.getHeadPtr();
		
		while(head1 != head2){
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		
		return head1;
	}
	
	public void intersection(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2){
		Node<Integer> newnode = null;
		if(ifIntersects(list1.getHeadPtr(), list2.getHeadPtr())){
			newnode = findIntersectingNode(list1, list2);
			System.out.println("Lists intersect at " + newnode.getData());
		}
		else
			System.out.println("Lists do not intersect");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list1.add(7);
		list1.add(1);
		list1.add(6);
		Node<Integer> newnode = new Node<>();
		newnode.setData(10);
		list1.setTail(newnode);
		list1.addLast(2);
		list1.addLast(3);
		list2.add(5);
		list2.add(9);
		list2.add(2);
		list2.add(1);
		list2.setTail(newnode);
		list1.printAll();
		list2.printAll();
		
		Intersection inter = new Intersection();
		/*Result res = inter.RecursiveIntersect(list1.getHeadPtr(), list2.getHeadPtr());
		if(res.node == null)
			System.out.println("Lists do not intersect");
		else
			System.out.println("Lists intersect at " + res.node.getData());*/
		
		inter.intersection(list1, list2);
	}

}
