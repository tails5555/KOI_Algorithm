package net.kang.nodes;

import java.util.Arrays;

public class Example02 {
	static int[][] dp=new int[15+1][15+1];
	public static int solution(int start, int end){
		for(int k=1;k<=start;k++){
			for(int l=1;l<=Math.max(start, end);l++){
				if(k==l) dp[k][l]=0;
				else if(k>l) dp[k][l]=dp[k/2][l]+1;
				else dp[k][l]=dp[k][l/2]+1;
			}
		}
		return dp[start][end];
	}
	// º¸·ù
	public static void print(int start, int end){
		if(start>=1 && dp[start][end]==dp[start/2][end]+1){
			System.out.println(start);
			print(start/2, end);
		}
		if(end>=1 && dp[start][end]==dp[start][end/2]+1){
			System.out.println(end);
			print(start, end/2);
		}
	}
	public static void main(String[] args){
		int start=5;
		int end=8;
		System.out.println(solution(start, end));
		for(int k=1;k<=Math.max(start, end);k++)
			System.out.println(Arrays.toString(Arrays.copyOfRange(dp[k], 1, Math.max(start+1, end+1))));
		print(start, end);
	}
}
