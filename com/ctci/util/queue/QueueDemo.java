package com.ctci.util.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		System.out.println(">>>>>>>>>>>> Queue <<<<<<<<<<<<");
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return -1;
				else if(o1 < o2)
					return 1;
				else
					return 0;
			}});
		
		max_heap.offer(1);
		max_heap.offer(2);
		max_heap.offer(3);
		System.out.println(">>>>>>>>> Priority Queue - Max heap <<<<<<<<<");
		System.out.println(max_heap.poll());
		System.out.println(max_heap.poll());
		System.out.println(max_heap.poll());
	}

}
