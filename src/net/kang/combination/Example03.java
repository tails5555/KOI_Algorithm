package net.kang.combination;

import java.util.Arrays;

public class Example03 {
	static int[][] dp=new int[10+1][10+1];
	public static int solution(int n, int k){
		for(int a=0;a<=n;a++){
			for(int b=0;b<=Math.min(a, k);b++){
				if(b==0||b==a) dp[a][b]=1;
				else dp[a][b]=dp[a-1][b-1]+dp[a-1][b];
			}
		}
		return dp[n][k];
	} // �ð� ���⵵�� O(n*k)�� �ǽðڴ�.
	public static void main(String[] args){
		System.out.println(solution(10, 10)); // dp�� Ǯ��� �ֱ� �ѵ� ���⼭ �߾��� �ﰢ���� �� �� ���� ���̴�. �ٷ� �Ľ�Į�� �ﰢ���̴�. 
		// �Ľ�Į �ﰢ���� ���Ͽ� ������ ���� ������ ����� ����غ��� ���� ���ڴ�.
		for(int k=0;k<dp.length;k++){
			System.out.println(Arrays.toString(dp[k]));
		}
	}
}
