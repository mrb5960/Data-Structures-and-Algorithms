package com.ctci.stack;

import com.ctci.util.queue.MyQueue;

public class AnimalShelter {
	
	private MyQueue<Dog> dogQueue = new MyQueue<>();
	private MyQueue<Cat> catQueue = new MyQueue<>();
	private int order = 0;
	
	
	
	public class Animal{
		private int order;
		private String name;
		
		public Animal(String name){
			this.name = name;
		}
		
		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}
		
		public boolean isOlder(Animal a){
			return this.order > a.getOrder();
		}
	}
	
	public class Dog extends Animal{

		public Dog(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
	}
	
	public class Cat extends Animal{

		public Cat(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
	}
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		System.out.println("Name " + a.name + " order " + a.order);
		if(a instanceof Dog)
			dogQueue.enqueue((Dog) a);
		else
			catQueue.enqueue((Cat) a);
	}
	
	public Animal dequeueAny(){
		Dog d = dogQueue.peek();
		Cat c = catQueue.peek();
		if(d.isOlder(c))
			return dogQueue.dequeue();
		else
			return catQueue.dequeue();
	}
	
	public Animal dequeueDog(){
		return dogQueue.dequeue();
	}
	
	public Animal dequeueCat(){
		return catQueue.dequeue();
	}

	public static void main(String[] args) {
		AnimalShelter as = new AnimalShelter();
		as.enqueue(as.new Dog("A"));
		as.enqueue(as.new Dog("B"));
		as.enqueue(as.new Dog("C"));
		as.enqueue(as.new Dog("D"));
		as.enqueue(as.new Cat("E"));
		as.enqueue(as.new Cat("F"));
		as.enqueue(as.new Cat("G"));
		as.enqueue(as.new Cat("H"));
		System.out.println(as.dequeueAny().name);
		System.out.println(as.dequeueAny().name);
		System.out.println(as.dequeueAny().name);
		System.out.println(as.dequeueDog().name);
		System.out.println(as.dequeueDog().name);
		System.out.println(as.dequeueCat().name);
	}
}
