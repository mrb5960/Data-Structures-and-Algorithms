package com.ctci.linkedlist;

import com.ctci.util.linkedlist.Node;
import com.ctci.util.linkedlist.SinglyLinkedList;
import com.ctci.util.stack.MyStack;

public class Palindrome {

	// using size of the linked list 
	public boolean checkPalindrome1(SinglyLinkedList<Integer> sll){
		MyStack<Integer> ms = new MyStack<>(sll.getSize());
		Node<Integer> head = sll.getHeadPtr();
		Node<Integer> current = head;
		while(current != null){
			ms.push(current.getData());
			current = current.getNext();
		}
		current = head;
		int middle = 0;
		if(sll.getSize()%2 == 0)
			middle = sll.getSize()/2;
		else
			middle = sll.getSize()/2+1;
		for(int i = 0; i < middle; i++){
			System.out.println("Top " + ms.peek() + " current " + current.getData());
			if(ms.pop() != current.getData()){
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	// without using size of the linked list, use runner pointer
	public boolean checkPalindrome2(SinglyLinkedList<Integer> sll){
		MyStack<Integer> ms = new MyStack<>(sll.getSize());
		Node<Integer> head = sll.getHeadPtr();
		Node<Integer> slow = head, fast = head;
		while(fast.getNext() != null && fast.getNext().getNext() != null){
			ms.push(slow.getData());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			System.out.println("Slow " + slow.getData() + " Fast " + fast.getData());
		}
		if(fast.getNext() != null)
			ms.push(slow.getData());
		slow = slow.getNext();
		
		
		while(slow != null){
			System.out.println("Slow " + slow.getData() + " top " + ms.peek());
			if(slow.getData() != ms.pop())
				return false;
			slow = slow.getNext();
		}
		return true;
	}
	
	// using recursion
	public class Result{
		Node<Integer> node;
		boolean equal;
		
		public Result(Node<Integer> node, boolean equal){
			this.node = node;
			this.equal = equal;
		}
	}
	
	public Result Recursive(Node<Integer> node, int length){
		if(length == 0){
			Result res = new Result(node, true);
			return res;
		}
		if(length == 1){
			Result res = new Result(node.getNext(), true);
			return res;
		}
		Result result = Recursive(node.getNext(), length - 2);
		if(result.equal == false)
			return result;
		result.equal = (result.node.getData() == node.getData());
		result.node = result.node.getNext();
		
		return result;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(3);
		sll.add(5);
		sll.add(8);
		sll.add(5);
		sll.add(8);
		sll.add(5);
		sll.add(3);	
		Palindrome pal = new Palindrome();
		System.out.println(pal.checkPalindrome1(sll));
		System.out.println(pal.checkPalindrome2(sll));
		Result out = pal.Recursive(sll.getHeadPtr(), sll.getSize());
		System.out.println(out.equal);
	}

}
