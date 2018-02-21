package com.ctci.strings;

import java.util.HashMap;

public class Replace {

	public static void main(String[] args) {
		String input = "thisismyhouse";
		HashMap<String,String> hm = new HashMap<>();
		hm.put("this", "that");
		hm.put("is", "was");
		hm.put("my", "his");
		hm.put("house", "garden");
		
		System.out.println("Input string: " + input);
		
		for(String key: hm.keySet()){
			System.out.println("key: " + key + " value: " + hm.get(key));
				input = input.replace(key, hm.get(key));
		}
		
		System.out.println("Output string: " + input);
	}

}
