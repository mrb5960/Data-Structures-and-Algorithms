package com.ctci.strings;

public class SortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dcba";
		char[] temp = s.toCharArray();
		StringBuilder reversed = new StringBuilder();
		for(int i = 0; i < temp.length - 1; i++){
			for(int j = 0; j < temp.length - i - 1; j++){
				if(temp[j] > temp[j+1]){
					char c = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = c;
				}
			}
		}
		for(int i = 0; i < temp.length; i++){
			reversed.append(temp[i]);
		}
		System.out.println(reversed.toString());
	}

}
