package net.kang.SCV;

import java.util.Arrays;

public class Example02 {
	static int[][] maze={
							{0, 1, 1, 0},
							{0, 0, 1, 0},
							{1, 1, 1, 0},
							{1, 0, 1, 0},
							{1, 1, 1, 0}
						};
	static int[][] dp=new int[5][4];
	public static int solution(int r, int c){
		if(dp[r][c]!=0) return dp[r][c];
		int beforeOre=0;
		if(r==0 && c==0) beforeOre=0;
		else if(r==0) beforeOre=solution(r, c-1);
		else if(c==0) beforeOre=solution(r-1, c);
		else beforeOre=Math.max(solution(r, c-1), solution(r-1, c));
		return dp[r][c]=beforeOre+maze[r][c];
	}
	public static boolean print(int r, int c){
		if(r==0 && c==0){
			System.out.println("(0, 0)");
			return true;
		}
		int beforeOre=dp[r][c]-maze[r][c];
		if((r>0 && dp[r-1][c]==beforeOre && print(r-1, c)) || (c>0 && dp[r][c-1]==beforeOre && print(r, c-1))){
			System.out.printf("(%d, %d)\n", r, c);
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		System.out.println(solution(4, 3));
		for(int k=0;k<dp.length;k++){
			System.out.println(Arrays.toString(dp[k]));
		}
		print(4, 3);
	}
}
