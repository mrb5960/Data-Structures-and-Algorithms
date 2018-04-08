package com.ctci.util.tree;

public class BST{
	
	private Node root;
	//public Node root;
	
	public BST(){
		root = null;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public class Node{
		private Node left, right;
		private int data;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public int getData(){
			return this.data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public void setData(int data) {
			this.data = data;
		}
	}
	
	public void insert(int data){
		root = insert(root, data);
		
	}
	
	public Node insert(Node node, int data){
		if(node == null){
			node = new Node(data);
		}
		else if(data < node.data){
			node.left = insert(node.left, data);
		}	
		else
			node.right = insert(node.right, data);
		
		return node;
	}

	public boolean contains(int data){
		return contains(root, data);
	}
	
	public boolean contains(Node node, int data){
		boolean exists = false;
		 
		if(node == null)
			return false;
		System.out.println(node.data);
		if(node.data == data)
			return true;
		if(data < node.data)
			exists = contains(node.left, data);
		if(data > node.data)
			exists = contains(node.right, data);
		return exists;
	}
	
	public void delete(int data){
		// it is important to store the reference in the respective node once delete operation is performed
		root = delete(root, data);
	}
	
	// if 6 is deleted, the left of its parent i.e. 5 should be null and hence it is necessary to store the return value of delete
	public Node delete(Node node, int data){
		if(node == null)
			return node;
		if(data < node.data)
			node.left = delete(node.left, data);
		if(data > node.data)
			node.right = delete(node.right, data);
		if(data == node.data){
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			node.data = getMin(node.right);
			node.right = delete(node.right, node.data);
		}
		return node;
	}
	
	private int getMin(Node node){
		int val = node.data;
		while(node != null){
			if( node.data < val )
				val = node.data;
			node = node.left;
		}
		return val;
	}
	
	public void inOrderTraversal(Node node){
		if(node != null){
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public void preOrderTraversal(Node node){
		if(node != null){
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal(Node node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public static void main(String args[]){
		BST bst = new BST();
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		
		System.out.println("Contains 5 : " + bst.contains(5));
		System.out.println("Contains 6 : " + bst.contains(6));
		
		System.out.println("Preorder : ");
		bst.preOrderTraversal(bst.root);
		System.out.println("\nPostorder : ");
		bst.postOrderTraversal(bst.root);
		System.out.println("\nInorder : ");
		bst.inOrderTraversal(bst.root);
		
		bst.delete(6);
		System.out.println("");
		bst.inOrderTraversal(bst.root);
		bst.delete(1);
		System.out.println("");
		bst.inOrderTraversal(bst.root);
		bst.delete(5);
		System.out.println("");
		bst.inOrderTraversal(bst.root);
		bst.delete(3);
		System.out.println("");
		bst.inOrderTraversal(bst.root);
	}
}