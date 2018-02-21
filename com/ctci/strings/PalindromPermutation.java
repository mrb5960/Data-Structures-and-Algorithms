package com.ctci.strings;

public class PalindromPermutation {
	
	boolean isPP(String str) {
		char[] arr = str.toCharArray();
		int odd = 0;
		int int_a = Character.getNumericValue('a');
		int int_z = Character.getNumericValue('z');
		
		int[] occurence = new int[int_z - int_a + 1];
		for(char c : arr) {
			int intval = Character.getNumericValue(c) - int_a;
			if(int_a <= intval && intval <= int_z) {
				occurence[intval]++;
				if(occurence[intval] % 2 == 1)
					odd++;
				else
					odd--;
			}
		}
		return odd <= 1;
		
	}

	public static void main(String[] args) {
		String str = "tact coa";
		PalindromPermutation pp = new PalindromPermutation();
		System.out.println(pp.isPP(str));
	}

}
