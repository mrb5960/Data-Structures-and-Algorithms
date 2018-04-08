package com.ctci.strings;

public class URLify {
	
	int getResultLength(char[] str, int length){
		int spaces = 0;
		int res = 0;
		
		for(int i = 0; i < length; i++){
			if(str[i] == ' '){
				spaces++;
			}
		}
		res = length - spaces + spaces*3;
		return res;
	}
	
	char[] getURL(char[] str, int length){
		int res = getResultLength(str, length);
		char[] output = new char[res];
		int out_index = res - 1;
		
		for(int i = length - 1; i >= 0; i--){
			if(str[i] == ' '){
				output[out_index] = '0';
				output[--out_index] = '2';
				output[--out_index] = '%';
			}
			else{
				output[out_index] = str[i];
			}
			out_index--;
		}
		return output;
	}

	public static void main(String[] args) {
		String temp = "Mr John Smith    ";
		char[] str = temp.toCharArray();
		URLify url = new URLify();
		char[] output = url.getURL(str, 13);
		for(int i = 0; i < output.length; i++)
			System.out.print(output[i]);
	}

}
