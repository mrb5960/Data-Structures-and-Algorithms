package com.ctci.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	
	public double[] getMedians(int[] arr){
		double[] medians = new double[arr.length];
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return -1;
				else if(o1 < o2)
					return 1;
				else
					return 0;
			}});
		
		for(int i = 0; i < arr.length; i++){
			add(arr[i], highers, lowers);
			rebalance(highers, lowers);
			medians[i] = getMedian(highers, lowers);
		}
		
		return medians;
	}
	
	public void add(int num, PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers){
		if(lowers.size() == 0 || num < lowers.peek())
			lowers.offer(num);
		else
			highers.offer(num);
	}
	
	public void rebalance(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers){
		PriorityQueue<Integer> smaller = highers.size() < lowers.size() ? highers : lowers;
		PriorityQueue<Integer> larger = highers.size() > lowers.size() ? highers : lowers;
		
		if(larger.size() - smaller.size() >= 2){
			smaller.offer(larger.poll());
		}
	}
	
	public double getMedian(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers){
		PriorityQueue<Integer> smaller, larger;
		
		if(highers.size() > lowers.size()){
			smaller = lowers;
			larger = highers;
		}
		else{
			smaller = highers;
			larger = lowers;
		}
		
		// Integer division causes truncation of double result
		// Either cast integer to double or divide by double itself;
		if(smaller.size() == larger.size()){
			return (double) (smaller.peek() + larger.peek()) / 2.0;
		}
		else
			return larger.peek();
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		RunningMedian rm = new RunningMedian();
		double[] output = rm.getMedians(arr);
		for(double d : output)
			System.out.print(d + " ");
	}
}