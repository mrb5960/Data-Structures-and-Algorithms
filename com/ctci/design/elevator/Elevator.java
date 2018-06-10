package com.ctci.design.elevator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator implements Runnable{
	
	PriorityQueue<Integer> upQueue;
	PriorityQueue<Integer> downQueue;
	
	int currentFloor;
	
	public Elevator(){
		downQueue = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if(a < b)
					return 1;
				if(b < a)
					return -1;
				return 0;
			}
		});
		
		upQueue = new PriorityQueue<Integer>();
		currentFloor = 0;
	}

	// destination will be greater than source
	void requestUp(int source, int destination){
		upQueue.add(source);
		upQueue.add(destination);
	}
	
	// source will be greater than destination
	void requestDown(int source, int destination){
		downQueue.add(source);
		downQueue.add(destination);
	}
	
	@Override
	public void run() {
		while(true){
			if(Math.abs(upQueue.peek() - currentFloor) < Math.abs(downQueue.peek() - currentFloor)){
				while(upQueue.size() != 0){
					currentFloor = upQueue.peek();
					System.out.println("Floor " + upQueue.poll());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				while(downQueue.size() != 0){
					currentFloor = downQueue.peek();
					System.out.println("Floor " + downQueue.poll());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			else{
				while(downQueue.size() != 0){
					currentFloor = downQueue.peek();
					System.out.println("Floor " + downQueue.poll());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				while(upQueue.size() != 0){
					currentFloor = upQueue.peek();
					System.out.println("Floor " + upQueue.poll());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}		
	}
	public static void main(String[] args) {
		Elevator e = new Elevator();
		new Thread(e).start();
		e.requestUp(3, 8);
		e.requestUp(4, 9);
	}
}
