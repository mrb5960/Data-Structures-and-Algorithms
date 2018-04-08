package com.ctci.thread;

class A{
	public synchronized void d1(B b){
		System.out.println("Thread 1 started execution of d1 method");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.last();
	}
	
	public synchronized void last(){
		System.out.println("Inside A's last method");
	}
}

class B{
	public synchronized void d2(A a){
		System.out.println("Thread 2 started execution of d2 method");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.last();
	}
	
	public synchronized void last(){
		System.out.println("Inside B's last method");
	}
}

public class Deadlock extends Thread{
	
	A a = new A();
	B b = new B();
	
	public void m1(){
		this.start();
		a.d1(b);
	}
	
	public void run(){
		b.d2(a);
	}

	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		d.m1();
	}

}
