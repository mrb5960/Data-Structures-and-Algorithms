package com.ctci.strings;

public class StringCompress {
	
	String getCompressed(String input){
		StringBuilder output = new StringBuilder();
		int count = 0;
		
		for(int i = 0; i < input.length(); i++){
			count++;
			
			if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
				output.append(input.charAt(i));
				output.append(count);
				count = 0;
			}
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		StringCompress sc = new StringCompress();
		System.out.println(sc.getCompressed("aaaaab"));
	}

}
