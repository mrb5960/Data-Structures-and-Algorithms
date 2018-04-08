package com.ctci.tree;

//import com.ctci.util.tree.BST.Node;

public class MinimalTree {
	
	private Node root;
	
	public MinimalTree(){
		root = null;
	}
	
	public class Node{
		private Node left = null;
		private Node right = null;
		private int data;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void insert(int[] sorted){
		root = insert(root, sorted, 0, sorted.length - 1);
		preOrderTraversal(root);
	}
	
	public Node insert(Node node, int[] sorted, int start, int end){
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		node = new Node(sorted[mid]);
		node.left = insert(node.left, sorted, start, mid-1);
		node.right = insert(node.right, sorted, mid+1, end);
		return node;
	}
	
	public void preOrderTraversal(Node node){
		if(node != null){
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public static void main(String[] args) {
		int[] sorted = {1,2,3,4,5,6};
		MinimalTree mt = new MinimalTree();
		mt.insert(sorted);
	}
}
