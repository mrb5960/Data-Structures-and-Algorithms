package com.ctci.util.tree;

public class Successor {
	
	Node root;
	
	public Successor(){
		root = null;
	}
	
	public class Node{
		int data;
		Node left, right, parent;
		
		public Node(int data, Node parent){
			this.data = data;
			left = null;
			right = null;
			this.parent = parent;
		}
	}
	
	public void insert(int data){
		root = insert(root, data, null);
	}
	
	public Node insert(Node node, int data, Node parent){
		if(node == null){
			node = new Node(data, parent);
		}
		else if(data < node.data){
			node.left = insert(node.left, data, node);
		}	
		else
			node.right = insert(node.right, data, node);
		
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
	
	public Node getLeftmostChild(Node node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	public void getSuccessor(int data){
		if(contains(data)){
			Node inputNode = getNode(root, data);
			Node node = getSuccessor(inputNode);
			if(node == null){
				System.out.println("Does not have a successor");
			}
			else
				System.out.println("Successor is " + node.data);
		}
		else
			System.out.println("Node does not exist");
	}
	
	public Node getNode(Node node, int data){
		if(node.data == data)
			return node;
		if(data < node.data)
			return getNode(node.left, data);
		if(data > node.data)
			return getNode(node.right, data);
		return null;
	}
	
	public Node getSuccessor(Node node){
		if(node.right != null)
			return getLeftmostChild(node.right);
		else{
			Node temp = node;
			Node parentNode = temp.parent;
			while(parentNode != null && parentNode.left != temp){
				temp = parentNode;
				parentNode = parentNode.parent;
			}
			return parentNode;
		}
	}

	public static void main(String[] args) {
		Successor suc = new Successor();
		suc.insert(4);
		suc.insert(2);
		suc.insert(6);
		suc.insert(1);
		suc.insert(3);
		suc.insert(5);
		suc.insert(7);
		suc.getSuccessor(7);
	}

}
