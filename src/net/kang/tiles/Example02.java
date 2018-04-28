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
	// DP�� �̿��ؼ� Ǯ�̸� �ϸ� �ð� ���⵵�� O(n)���� �پ�� �� �ִ�. ��� ������ �ð� ���⵵�� ũ�� �پ�� �� ������ ������ �� �ִ�.
	public static void main(String[] args){
		System.out.println(solution(10));
		System.out.println(Arrays.toString(dp));
	}
}
