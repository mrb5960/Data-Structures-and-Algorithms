package com.ctci.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Boolean[] memo = new Boolean[s.length()];
        return helper(s, 0, new HashSet<String>(wordDict), memo);        
    }
    
    public boolean helper(String s, int start, HashSet<String> wordDict, Boolean[] memo){
    	if(start == s.length())
    		return true;
    	
    	if(memo[start] != null)
    		return memo[start];
        
        for(int end = start; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && helper(s, end, wordDict, memo))
                return memo[start] = true;
        }    
        return memo[start] = false;
    }

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		String s = "leetcode";
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(s, wordDict));
	}
}
