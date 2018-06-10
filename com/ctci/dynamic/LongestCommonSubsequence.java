package com.ctci.dynamic;

public class LongestCommonSubsequence {
	
	static int count1 = 0;
	static int count2 = 0;
	
	// time complexity is 2^(s1.length() + s2.length())
	int getLCSRec(String s1, String s2, int p1, int p2){
		count1++;
		if(p1 < 0 || p2 < 0)
			return 0;
		else if(s1.charAt(p1) == s2.charAt(p2))
			return getLCSRec(s1, s2, p1 - 1, p2 - 1) + 1;
		else{
			int lcs1 = getLCSRec(s1, s2, p1 - 1, p2);
			int lcs2 = getLCSRec(s1, s2, p1, p2 - 1);
			return lcs1 > lcs2 ? lcs1 : lcs2;
		}	
	}
	
	// time complexity is O(s1.length() * s2.length())
	int getLCSMem(String s1, String s2){
		int[][] memo = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++){
				memo[i][j] = -1;
			}
		}
		return getLCSMem(s1, s2, s1.length()-1, s2.length()-1, memo);
	}
	
	int getLCSMem(String s1, String s2, int p1, int p2, int[][] memo){
		count2++;
		if(p1 < 0 || p2 < 0)
			return 0;
		if(memo[p1][p2] != -1)
			return memo[p1][p2];
		else if(s1.charAt(p1) == s2.charAt(p2))
			memo[p1][p2] = getLCSMem(s1, s2, p1 - 1, p2 - 1, memo) + 1;
		else{
			int lcs1 = getLCSMem(s1, s2, p1 - 1, p2, memo);
			int lcs2 = getLCSMem(s1, s2, p1, p2 - 1, memo);
			memo[p1][p2] = lcs1 > lcs2 ? lcs1 : lcs2;
		}	
		return memo[p1][p2];
	}
	
	void printLCS(String s1, String s2, int l1, int l2){
		int[][] memo = new int[l1+1][l2+2];
		
		for(int i = 0; i <= l1; i++){
			for(int j = 0; j <= l2; j++){
				if(i == 0 || j == 0){
					memo[i][j] = 0;
				}
				if(s1.charAt(i) == s2.charAt(j)){
					memo[i][j] = 1 + memo[i-1][j-1];
				}
				else{
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				}
			}
		}
		
		int i = l1 - 1, j = l2 - 1;
		
		while(i > 0 && j > 0){
			//if(memo[i][j] == )
		}
	}
	
	// time complexity is O(s1.length() * s2.length())
	int getLCSBottomUp(String s1, String s2){
		int[][] memo = new int[s1.length()+1][s2.length()+1];
		
		getLCSBottomUp(s1, s2, memo);
		return memo[s1.length()][s2.length()];
	}
	
	
	void getLCSBottomUp(String s1, String s2, int[][] memo){
		for(int row = 1; row < memo.length; row++){
			for(int col = 1; col < memo[0].length; col++){
				int p1 = row - 1;
				int p2 = col - 1;
				if(s1.charAt(p1) == s2.charAt(p2)){
					memo[row][col] = memo[p1][p2] + 1;
				}
				else{
					memo[row][col] = memo[row-1][col] > memo[row][col-1] ? memo[row-1][col] : memo[row][col-1];
				}
			}
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "abksddkljenocijerwmkcvoikwlkngoicxoiiuanktnweoicknkewiocbbweoksjdnkgf.,xc";
		String s2 = "sdlk;sdafjoicxukneknoicvxoinsdnewbslkjdgkadfklsadkljgneiuoixcknsadoihagsdl;kj";
		//System.out.println(lcs.getLCSRec(s1, s2, s1.length()-1, s2.length()-1));
		//System.out.println(LongestCommonSubsequence.count1);
		System.out.println(lcs.getLCSMem(s1, s2));
		System.out.println(LongestCommonSubsequence.count2);
		System.out.println(lcs.getLCSBottomUp(s1, s2));
	}

}
