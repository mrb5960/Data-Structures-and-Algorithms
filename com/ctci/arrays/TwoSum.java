package com.ctci.arrays;

import java.util.ArrayList;
import java.util.HashMap;

// return indices of numbers in an array whose sum is equal to a given target 

public class TwoSum {
	
	ArrayList<Integer> isPresent(int[] arr, int target){
		ArrayList<Integer> list = new ArrayList<>();
		int remainder = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > target)
				continue;
			remainder = target - arr[i];
			if(map.containsKey(remainder)){
				list.add(i);
				list.add(map.get(remainder));
				return list;
			}
			else{
				map.put(arr[i], i);
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		ArrayList<Integer> tempList = ts.isPresent(arr, target);
		if(tempList.size() == 0)
			System.out.println("No numbers present");
		else
			for(int n: tempList)
				System.out.print(n + " ");
	}

}
