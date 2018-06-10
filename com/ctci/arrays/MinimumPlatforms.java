package com.ctci.arrays;

import java.util.Arrays;

public class MinimumPlatforms {
	
	int getMinimumPlatforms(int[] arrival, int[] departure){
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int platforms = 1;
		int result = 1;
		int i = 1, j = 0;
		
		while(i < arrival.length && j < arrival.length){
			if(arrival[i] < departure[j]){
				platforms++;
				i++;
				
				if(platforms > result)
					result = platforms;
			}
			else{
				platforms--;
				j++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		MinimumPlatforms mp = new MinimumPlatforms();
		int[] arrival = {900, 940, 950, 1100, 1500, 1800};
		int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
		System.out.println(mp.getMinimumPlatforms(arrival, departure));
	}

}
