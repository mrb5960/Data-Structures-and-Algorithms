package com.ctci.thread;

abstract class BaseClass{
	public void getInfo(int num){
		System.out.println(num);
	}
}

public class AbstractDemo extends BaseClass {

	public static void main(String[] args) {
		BaseClass bc = new AbstractDemo();
		bc.getInfo(5);
	}

}
