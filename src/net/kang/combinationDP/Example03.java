package net.kang.combinationDP;

import java.util.Arrays;

public class Example03 {
	static int[][] dp=new int[101][101];
	static int N=2;
	static int R=1;
	public static int solution(int n, int r){
		if(r==R) return 1;
		if(n==N) return 0;
		if(dp[n][r]==0)
			dp[n][r]=solution(n+1, r+1)+solution(n+1, r);
		return dp[n][r];
	}
	// 이는 다이나믹컬 백트래킹을 이용한 방법으로 구축을 해봤다. 아까와 반대로 역삼각형을 이용해서 풀이를 하는 방안인데 공부하는데 참고하길 바라면서...
	public static void main(String[] args){
		System.out.println(solution(0, 0));
		for(int k=0;k<=N;k++){
			System.out.println(Arrays.toString(Arrays.copyOfRange(dp[k], 0, k+1)));
		}
	}
}
