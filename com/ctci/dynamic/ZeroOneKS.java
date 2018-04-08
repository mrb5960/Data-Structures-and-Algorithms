package com.ctci.dynamic;

public class ZeroOneKS {
	
	static int count = 0;
	
	int knapSack(int item, int max_weight, int[] weights, int[] values){
		count++;
		if(item == 0 || max_weight < 0)
			return 0;
		else if(weights[item] > max_weight)
			return knapSack(item-1, max_weight, weights, values);
		else{
			int exclude = knapSack(item-1, max_weight, weights, values);
			int include = values[item] + knapSack(item-1, max_weight - weights[item], weights, values);
			return exclude > include ? exclude : include;
		}
	}
	
	int knapSackMemo(int item, int max_weight, int[] weights, int[] values){
		int[][] memo = new int[item+1][max_weight+1];
		for(int i = 0; i < item+1; i++){
			for(int j = 0; j < max_weight+1; j++){
				memo[i][j] = -1;
			}
		}
		return knapSackMemo(item, max_weight, weights, values, memo);
	}
	
	int knapSackMemo(int item, int max_weight, int[] weights, int[] values, int[][] memo){
		count++;
		if(item == 0 || max_weight < 0)
			return 0;
		else if(memo[item][max_weight] != -1)
			return memo[item][max_weight];
		else if(weights[item] > max_weight)
			memo[item][max_weight] =  knapSackMemo(item-1, max_weight, weights, values, memo);
		else{
			int exclude = knapSackMemo(item-1, max_weight, weights, values, memo);
			int include = values[item] + knapSackMemo(item-1, max_weight - weights[item], weights, values, memo);
			memo[item][max_weight] =  exclude > include ? exclude : include;
		}
		return memo[item][max_weight];
	}

	public static void main(String[] args) {
		ZeroOneKS ks = new ZeroOneKS();
		int[] weights = {0, 1, 2, 4, 2, 5};
		int[] values = {0, 5, 3, 5, 3, 2};
		System.out.println(ks.knapSackMemo(5, 10, weights, values) + " " + ZeroOneKS.count);
	}
}
