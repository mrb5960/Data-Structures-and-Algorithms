package com.ctci.tree;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class FirstCommonAncestor {
	
	BST bst;
	int ancestor;
	
	public FirstCommonAncestor(){
		ancestor = 0;
		bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(0);
	}

	public void getAncestor(int p, int q){
		if(getAncestor(bst.getRoot(), p, q) == Integer.MAX_VALUE)
			System.out.println("Ancestor of " + p + " and " + q + " is " + ancestor);
		else
			System.out.println("No common ancestor");
	}
	
	public int getAncestor(Node node, int p, int q){
		if(node == null) 
			return Integer.MIN_VALUE;
		if(node.getData() == p)
			return p;
		if(node.getData() == q)
			return q;
		int left = getAncestor(node.getLeft(), p, q);
		int right = getAncestor(node.getRight(), p, q);
		
		if(left == p && right == q || left == q && right == p){
			ancestor = node.getData();
			return Integer.MAX_VALUE;
		}
		
		if(left == p || right == p)
			return p;
		
		if(left == q || right == q)
			return q;
		
		if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		FirstCommonAncestor fca = new FirstCommonAncestor();
		fca.getAncestor(4, 9);
	}

}
