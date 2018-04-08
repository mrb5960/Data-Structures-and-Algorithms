package com.ctci.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ctci.util.tree.BST;
import com.ctci.util.tree.BST.Node;

public class ListOfDepths {
	
	private HashMap<Integer, ArrayList<Integer>> listOfLists;
	private BST bst;
	
	public ListOfDepths(){
		listOfLists = new HashMap<>();
		bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(8);
	}
	
	public void traverse(){
		
		traverse(bst.getRoot(), 0, listOfLists);

		for(int keys : listOfLists.keySet()){
			List<Integer> temp = listOfLists.get(keys);
			for(int num : temp){
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public void traverse(Node node, int depth, HashMap<Integer, ArrayList<Integer>> listOfLists){
		if(node == null)
			return;
		if(!listOfLists.containsKey(depth))
			listOfLists.put(depth, new ArrayList<>());
		listOfLists.get(depth).add(node.getData());
		depth++;
		traverse(node.getRight(), depth, listOfLists);
		traverse(node.getLeft(), depth, listOfLists);
	}

	public static void main(String[] args) {
		ListOfDepths lod = new ListOfDepths();
		lod.traverse();
	}
}
