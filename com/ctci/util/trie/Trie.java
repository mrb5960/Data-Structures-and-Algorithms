package com.ctci.util.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	public class TrieNode{
		Map<Character, TrieNode> children;
		boolean end;
		
		public TrieNode(){
			children = new HashMap<>();
			end = false;
		}
	}
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String s){
		insert(root, s, 0);
	}
	
	private void insert(TrieNode node, String s, int index){
		if(index == s.length()){
			node.end = true;
			return;
		}
		if(node.children.containsKey(s.charAt(index))){
			insert(node.children.get(s.charAt(index)), s, ++index);
		}
		else{
			node.children.put(s.charAt(index), new TrieNode());
			insert(node.children.get(s.charAt(index)), s, ++index);
		}
	}
	
	public boolean search(String s){
		return search(root, s, 0);
	}
	
	private boolean search(TrieNode node, String s, int index){
		if(index == s.length())
			return node.end;
		if(node.children.containsKey(s.charAt(index)))
			return search(node.children.get(s.charAt(index)), s, ++index);
		else
			return false;
	}
	
	public void delete(String s){
		if(search(s))
			delete(root, s, 0);
		else
			System.out.println("word does not exist in trie");
	}
	
	public boolean delete(TrieNode node, String s, int index){
		if(index == s.length()){
			if(node.children.size() != 0){
				node.end = false;
				return false;
			}
			else
				return true;
		}
		char ch = s.charAt(index);
		boolean del = delete(node.children.get(ch), s, ++index);
		if(del){
			node.children.remove(ch);
			return node.children.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("mandar");
		trie.insert("man");
		trie.insert("max");
		trie.insert("maddy");
		System.out.println(trie.search("man"));
		System.out.println(trie.search("max"));
		System.out.println(trie.search("mandar"));
		System.out.println(trie.search("maddy"));
		trie.delete("mandar");
		System.out.println(trie.search("max"));
		System.out.println(trie.search("mandar"));
	}
}
