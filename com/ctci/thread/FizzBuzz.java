package com.ctci.thread;

public class FizzBuzz implements Runnable{
	
	public void run(){
		
	}

	public static void main(String[] args) {
		Test test = new Test();
		int num = 30;
		
		Thread three = new Thread(new Runnable(){
			public void run(){
				try{
					if(test.divideByThree(num))
						System.out.print("Fizz");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		Thread five = new Thread(new Runnable(){
			public void run(){
				try{
					if(test.divideByFive(num))
						System.out.print("Buzz");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
			
		three.start();
		five.start();
		try {
			three.join();
			five.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class Test{
		
		public boolean divideByThree(int num){
			if(num % 3 == 0)
				return true;
			else
				return false;
		}
		
		public boolean divideByFive(int num){
			if(num % 5 == 0)
				return true;
			else
				return false;
		}
	}
}
