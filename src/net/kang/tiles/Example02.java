package net.kang.tiles;

import java.util.Arrays;

public class Example02 {
	static int[] dp=new int[10+1];
	public static int solution(int n){
		for(int k=0;k<=n;k++){
			if(k==0 || k==1) dp[k]=1;
			else dp[k]=dp[k-1]+2*dp[k-2];
		}
		return dp[n];
	}
	// DP를 이용해서 풀이를 하면 시간 복잡도가 O(n)으로 줄어들 수 있다. 방금 전보다 시간 복잡도가 크게 줄어들 수 있으니 참고할 수 있다.
	public static void main(String[] args){
		System.out.println(solution(10));
		System.out.println(Arrays.toString(dp));
	}
}
