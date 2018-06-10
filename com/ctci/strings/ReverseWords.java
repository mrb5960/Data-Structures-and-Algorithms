package com.ctci.strings;

public class ReverseWords {

	// time complexity is O(n + w*s) where s is the size of the largest word and w are the number of words.
	String reverseWords(String input){
		StringBuilder output = new StringBuilder(input.length());
		int startIndex = -1;
		for(int i = input.length()-1; i >= 0; i--){
			if(input.charAt(i) == ' ' || i == 0){
				if(i == 0)
					startIndex = i;
				else
					startIndex = i+1;
				while(startIndex != input.length() && input.charAt(startIndex) != ' '){
					output.append(input.charAt(startIndex));
					startIndex++;
				}
				output.append(' ');
			}
		}
		return output.toString();
	}
	
	String reverseString(String input){
		char rev[] = input.toCharArray();
		int left = 0;
		int right = input.length()-1;
		
		while(left < right){
			char temp = rev[left];
			rev[left] = rev[right];
			rev[right] = temp;
			left++;
			right--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rev.length; i++)
			sb.append(rev[i]);
		
		return sb.toString();
	}
	
	String reverseWords2(String input){
		StringBuilder output = new StringBuilder(input.length());
		int beginIndex = 0;
		String rev = "";
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == ' ' || i == input.length()-1){
				if(i != input.length()-1)
					rev = reverseString(input.substring(beginIndex, i));
				else
					rev = reverseString(input.substring(beginIndex, i+1));
				beginIndex = i+1;
				output.append(rev);
				if(i != input.length()-1){
					output.append(' ');
				}
			}
		}
		output.reverse();
		return output.toString();
	}
	
	public static void main(String[] args) {
		String input = " I love      programming very much";
		System.out.println(new ReverseWords().reverseWords2(input));
	}
}
