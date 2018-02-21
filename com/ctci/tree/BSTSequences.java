package com.ctci.tree;

import java.util.ArrayList;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class BSTSequences {
	
	BST bst;
	
	public BSTSequences(){
		bst = new BST();
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
	}
	
	public void generateSeq(){
		ArrayList<ArrayList<Integer>> seq = generateSeq(bst.getRoot());
		for(ArrayList<Integer> list : seq){
			for(int num : list){
				System.out.print(num + " ");
			}
			System.out.println();
		}
			
	}
	
	public ArrayList<ArrayList<Integer>> generateSeq(Node node){
		if(node == null)
			return null;
		ArrayList<ArrayList<Integer>> root = new ArrayList<>();
		ArrayList<ArrayList<Integer>> left = generateSeq(node.getLeft());
		ArrayList<ArrayList<Integer>> right = generateSeq(node.getRight());
		if(left != null && right != null){
			for(ArrayList<Integer> l : left)
				for(ArrayList<Integer> r : right){
					ArrayList<Integer> temp1 = new ArrayList<>();
					temp1.add(node.getData());
					temp1.addAll(l);
					temp1.addAll(r);
					ArrayList<Integer> temp2 = new ArrayList<>();
					temp2.add(node.getData());
					temp2.addAll(r);
					temp2.addAll(l);
					root.add(temp1);
					root.add(temp2);
				}
		}
		else if(left == null && right != null){
			for(ArrayList<Integer> r : right){
				ArrayList<Integer> temp1 = new ArrayList<>();
				temp1.add(node.getData());
				temp1.addAll(r);
				root.add(temp1);
			}
		}
		else if(left != null && right == null){
			for(ArrayList<Integer> l : left){
				ArrayList<Integer> temp1 = new ArrayList<>();
				temp1.add(node.getData());
				temp1.addAll(l);
				root.add(temp1);
			}
		}
		else{
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(node.getData());
			root.add(temp);
		}
		return root;
	}

	public static void main(String[] args) {
		BSTSequences bsts = new BSTSequences();
		bsts.generateSeq();
	}

}
