package com.ctci.dynamic;

import java.util.ArrayList;
import java.util.HashSet;

public class PowerSet {
	
	void getPowerSet(ArrayList<Integer> input){
		HashSet<HashSet<Integer>> powerset = getPowerSetRec(input, input.size() - 1);
		 for(HashSet<Integer> set : powerset){
			 for(int num : set)
				 System.out.print(num + " ");
			 System.out.println();
		 }
	}
	
	HashSet<HashSet<Integer>> getPowerSetRec(ArrayList<Integer> input, int index){
		HashSet<HashSet<Integer>> powerset;
		if(index < 0){
			powerset = new HashSet<HashSet<Integer>>(); 
			powerset.add(new HashSet<Integer>());
			return powerset;
		}
		
		powerset = getPowerSetRec(input, index - 1);
		int last = input.get(index);
		
		HashSet<HashSet<Integer>> moresets = new HashSet<>();
		
		for(HashSet<Integer> set : powerset){
			HashSet<Integer> newset = new HashSet<>();
			newset.addAll(set);
			newset.add(last);
			moresets.add(newset);
			// powerset.add(newset); this will throw concurrent modification exception so we need moresets
			// this is then added to powerset
		}
		powerset.addAll(moresets);
		return powerset;
	}

	public static void main(String[] args) {
		PowerSet ps = new PowerSet();
		ArrayList<Integer> input = new ArrayList<>();
		input.add(0);
		input.add(1);
		input.add(2);
		ps.getPowerSet(input);
	}
}
