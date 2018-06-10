package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;

public class SumLists {

	// numbers and the result are in reverse order
	public void createSumList1(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2){
		int sum1 = 0, sum2 = 0, result = 0, rem = 0;
		sum1 = addElements(list1);
		sum2 = addElements(list2);
		result = sum1 + sum2;
		System.out.println("sum1 " + sum1 + " sum2 " + sum2 + " result " + result);
		
		SinglyLinkedList<Integer> finalList = new SinglyLinkedList<>();
		while(result > 10){
			rem = result % 10;
			finalList.add(rem);
			result /= 10;
		}
		finalList.add(result);
		finalList.printAll();
	}
	
	// numbers and the result are in reverse order
	public Node<Integer> addLists1(Node<Integer> node1, Node<Integer> node2, int carry){
		if(node1 == null && node2 == null && carry == 0){
			return null;
		}
		
		Node<Integer> result = new Node<>();
		int value = carry;
		
		if(node1 != null){
			value += node1.getData();
		}
		
		if(node2 != null){
			value += node2.getData();
		}
		
		result.setData(value % 10);
		
		if(	node1 != null || node2 != null){
			Node<Integer> next = addLists1( node1 == null ? null : node1.getNext(), node2 == null ? null : node2.getNext(), value >= 10 ? 1 : 0);
			result.setNext(next);
		}
		return result;
	}
	
	public void addLists2(SinglyLinkedList<Integer> list3, SinglyLinkedList<Integer> list4){
		// padding required if lists are of different length
		if(list3.getSize() < list4.getSize()){
			while(list3.getSize() != list4.getSize())
				list3.addFirst(0);
		}
		else if(list3.getSize() > list4.getSize()){
			while(list3.getSize() != list4.getSize())
				list4.addFirst(0);
		}
		list3.printAll();
		list4.printAll();
		SinglyLinkedList<Integer> finalList = new SinglyLinkedList<>();
		addLists2(list3.getHeadPtr(), list4.getHeadPtr(), finalList);
		
		finalList.printAll();
	}
	
	public class IntermediateSum{
		private Node<Integer> sum;
		private int carry;
		
		public Node<Integer> getSum() {
			return sum;
		}

		public void setSum(Node<Integer> sum) {
			this.sum = sum;
		}

		public int getCarry() {
			return carry;
		}

		public void setCarry(int carry) {
			this.carry = carry;
		}

		public IntermediateSum(){
			this.setCarry(0);
			this.sum = new Node<Integer>();
			this.sum.setData(0);
		}
	}
	
	public IntermediateSum addLists2(Node<Integer> node1, Node<Integer> node2, SinglyLinkedList<Integer> sll){
		if(node1 == null && node2 == null ){
			IntermediateSum temp = new IntermediateSum();
			return temp;
		}
		
		IntermediateSum prev = addLists2( node1 == null ? null : node1.getNext(), node2 == null ? null : node2.getNext(), sll);
			int result;
			result = prev.getCarry() + node1.getData() + node2.getData();
			
			if(result >= 10){
				prev.getSum().setData(result%10);
				prev.setCarry(1);
			}
			else{
				prev.getSum().setData(result);
				prev.setCarry(0);
			}
			
			sll.addFirst(prev.getSum().getData());
			
		return prev;
	}
	
	public void createSumList2(SinglyLinkedList<Integer> list3, SinglyLinkedList<Integer> list4){
		
	}
	
	public int addElements(SinglyLinkedList<Integer> list){
		Node<Integer> current = list.getHeadPtr();
		int power = 0, sum = 0;
		while(current != null){
			sum += current.getData() * Math.pow(10, power);
			power++;
			current = current.getNext();
		}
		return sum;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// numbers and the result are in reverse order
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		/*list1.add(7);
		list1.add(1);
		list1.add(6);
		list2.add(5);
		list2.add(9);
		list2.add(2);
		list2.add(1);*/
		list1.add(5);
		list2.add(5);
		
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> list4 = new SinglyLinkedList<>();
		list3.add(6);
		list3.add(1);
		list3.add(7);
		list4.add(1);
		list4.add(2);
		list4.add(9);
		list4.add(5);
		
		SumLists sl = new SumLists();
		
		System.out.println("Using 2 lists, numbers are stored in reverse order");
		sl.createSumList1(list1, list2);
		
		System.out.println("Using recursion, numbers are stored in reverse order");
		Node<Integer> result = sl.addLists1(list1.getHeadPtr(), list2.getHeadPtr(), 0);
		while(result != null){
			System.out.print(result.getData() + " ");
			result = result.getNext();
		}
		
		System.out.println("\nUsing recursion, numbers are stored in order");
		sl.addLists2(list3, list4);
	}
}
