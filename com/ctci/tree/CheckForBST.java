package com.ctci.tree;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class CheckForBST {
	BST bst;
	Integer last_printed = null;
	
	public CheckForBST(){
		bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
	}
	
	boolean checkBST(){
		//return checkBST(bst.getRoot());
		return checkBST(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	boolean checkBST(Node node){
		if (node == null)
			return true;
		if (!checkBST(node.getLeft()))
			return false;
		if (last_printed != null && node.getData() <= last_printed)
			return false;
		last_printed = node.getData();
		if (!checkBST(node.getRight()))
			return false;
		return true;
	}
	
	boolean checkBST(Node node, int min, int max){
		if (node == null)
			return true;
		if ((min != Integer.MIN_VALUE && node.getData() <= min) || (max != Integer.MAX_VALUE && node.getData() > max))
			return false;
		if (!checkBST(node.getLeft(), min, node.getData()) || !checkBST(node.getRight(), node.getData(), max))
			return false;
		return true;
	}

	public static void main(String[] args) {
		CheckForBST cfb = new CheckForBST();
		System.out.println(cfb.checkBST());
	}
}
