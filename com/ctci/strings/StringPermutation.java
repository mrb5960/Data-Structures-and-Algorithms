package com.ctci.strings;

public class StringPermutation {

	void permutation(String str) {
		permutation(str, "");
	}

	void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} 
		else {
			for (int i = 0; i < str.length(); i++) {
				//String temp1 = str.substring(0,i);
				//String temp2 = str.substring(i+1);
				//System.out.println(str.substring(0,i) + "  " + str.substring(i+1));
				String rem = str.substring(0, i) + str.substring ( i + 1);
				//String temp3 = str.substring(0, i);
				//String temp4 = str.substring ( i + 1);
				//System.out.println(rem + "  " + prefix + str.charAt( i ));
				permutation(rem, prefix + str.charAt( i ));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation sp = new StringPermutation();
		sp.permutation("mandar");
	}

}
