package com.ctci.dynamic;

import java.util.ArrayList;
import java.util.List;

public class EarliestTime1 {
	
	void getTime(String s){
		
		StringBuilder sb = new StringBuilder(s);
		sb.deleteCharAt(2);
		StringPermutations sp = new StringPermutations();
		List<String> permutations = sp.getPermutationsHelper(sb.toString());
		String earliest = getEarliestTime(permutations, sb.toString());
		StringBuilder output = new StringBuilder(earliest);
		output.insert(2, ":");
		System.out.println(output);
	}
	
	String getEarliestTime(List<String> permutations, String input){
		String earliest = "";
		int inputMins = convertToMinutes(input);
		int max_mins = 24 * 60;
		int min_mins = Integer.MAX_VALUE;
		int required_time = 0;
		
		List<String> valid = getValidTimes(permutations);
		for(String temp : valid){
			int mins = convertToMinutes(temp);
			if(mins <= max_mins){
				if(mins <= inputMins){
					required_time = max_mins - (inputMins - mins);
				}
				else{
					required_time = mins - inputMins;
				}
				if(required_time < min_mins){
					min_mins = required_time;
					earliest = temp;
				}
			}
		}
		return earliest;
	}
	
	int convertToMinutes(String s){
		int hh = Integer.parseInt(s.substring(0,2));
		int mm = Integer.parseInt(s.substring(2,4));
		int mins = hh * 60 + mm;
		return mins;
	}
	
	List<String> getValidTimes(List<String> permutations){
		List<String> valid = new ArrayList<>();
		for(String temp : permutations){
			int hh = Integer.parseInt(temp.substring(0,2));
			int mm = Integer.parseInt(temp.substring(2,4));
			if((hh < 24) && (mm < 60)){
				valid.add(temp);
			}
		}
		return valid;
	}

	public static void main(String[] args) {
		EarliestTime1 et = new EarliestTime1();
		et.getTime("04:55");
	}
}
