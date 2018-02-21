package com.ctci.tree;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class Subtree {
	
	BST bst, bst2;
	
	public Subtree(){
		bst = new BST();
		bst2 = new BST();
		bst.insert(10);
		bst.insert(16);
		bst.insert(15);
		bst.insert(17);
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(0);
		bst.insert(8);
		bst.insert(9);
		bst2.insert(100);
		bst2.insert(2);
		bst2.insert(3);
		bst2.insert(1);
		bst2.insert(6);
		bst2.insert(5);
		bst2.insert(7);
		bst2.insert(0);
		bst2.insert(8);
		bst2.insert(9);
	}
	
	public boolean checkSubtree(){
		StringBuilder t1 = new StringBuilder();
		StringBuilder t2 = new StringBuilder();
		
		getOrder(bst.getRoot(), t1);
		getOrder(bst2.getRoot(), t2);
		
		return (t1.indexOf(t2.toString()) != -1);
	}
	
	public void getOrder(Node node, StringBuilder t){
		if(node == null){
			t.append("X");
			return;
		}
		
		t.append(node.getData() + " ");
		getOrder(node.getRight(), t);
		getOrder(node.getLeft(), t);
	}

	public static void main(String[] args) {
		Subtree st = new Subtree();
		System.out.println(st.checkSubtree());
	}
}
