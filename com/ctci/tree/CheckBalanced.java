package com.ctci.tree;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class CheckBalanced {
	BST bst;
	
	public CheckBalanced(){
		bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(8);
		//bst.insert(9);
		bst.insert(0);
	}
	
	public boolean isBalanced(){
		return getHeight(bst.getRoot()) != Integer.MIN_VALUE;
	}
	
	private int getHeight(Node node){
		if(node == null)
			return -1;
		
		int left = getHeight(node.getLeft());
		if(left == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int right = getHeight(node.getRight());
		if(right == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int diff = left - right;
		
		if(Math.abs(diff) > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		CheckBalanced cb = new CheckBalanced();
		System.out.println(cb.isBalanced());
	}
}
