package com.ctci.tree;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class KthLargestInBST {
	
	int count = 0;
	int element = 0;
	
	public void getElement(Node root, int k){
		if(root != null){
			getElement(root.getRight(), k);
			count++;
			if(count == k){
				element = root.getData();
				return;
			}
			getElement(root.getLeft(), k);
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(6);
		bst.insert(1);
		bst.insert(3);
		bst.insert(5);
		bst.insert(7);
		
		KthLargestInBST temp = new KthLargestInBST();
		temp.getElement(bst.getRoot(), 7);
		System.out.println(temp.element);
	}

}
