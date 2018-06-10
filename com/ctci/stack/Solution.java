package com.ctci.stack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class MyQueue<T>{
        
        Stack<T> one, two;
        
        public MyQueue(){
            one = new Stack<>();
            two = new Stack<>();
        }
        
        public void enqueue(T item){
        	if(two.empty())
        		one.push(item);
        	else{
        		while(!two.empty())
        			one.push(two.pop());
        		one.push(item);
        	}
        }
        
        public void dequeue(){
        	if(!two.empty())
        		two.pop();
        	else{
        		while(!one.empty())
        			two.push(one.pop());
        		two.pop();
        	}
        }
        
        public T peek(){
        	if(one.empty())
        		return two.peek();
        	else{
        		while(!one.empty())
        			two.push(one.pop());
        		return two.peek();
        	}
        }
    }
    public static void main(String[] args) {
       /* MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();*/
    	
    	BigDecimal a = new BigDecimal(95.344);
    	BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_UP);
    	System.out.println(roundOff);
    }
}