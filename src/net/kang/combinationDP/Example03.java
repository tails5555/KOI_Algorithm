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
	// �̴� ���̳����� ��Ʈ��ŷ�� �̿��� ������� ������ �غô�. �Ʊ�� �ݴ�� ���ﰢ���� �̿��ؼ� Ǯ�̸� �ϴ� ����ε� �����ϴµ� �����ϱ� �ٶ�鼭...
	public static void main(String[] args){
		System.out.println(solution(0, 0));
		for(int k=0;k<=N;k++){
			System.out.println(Arrays.toString(Arrays.copyOfRange(dp[k], 0, k+1)));
		}
	}
}
