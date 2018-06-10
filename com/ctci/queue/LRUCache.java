package com.ctci.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
	
	HashMap<Integer, Integer> map;
	Queue<Integer> queue;
	int size;
	
	public LRUCache(int size) {
		map = new HashMap<>();
		queue = new LinkedList<>();
		this.size = size;
	}
	
	
	public int get(int key){
		if(map.containsKey(key)){
			queue.offer(queue.poll());
			return map.get(key);
		}
		else
			return -1;
	}
	
	public void put(int key, int value){
		
	}

	public static void main(String[] args) {
		
	}

}
