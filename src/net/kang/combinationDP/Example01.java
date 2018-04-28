package net.kang.combinationDP;

import java.util.Arrays;

// 지난번에 Combination을 다루면서 잠깐 파스칼 삼각형을 공부해본 경험이 있을 것이다. 이를 토대로 잠깐 복습해보도록 합니다.
public class Example01 {
	static int[][] pascal=new int[101][101];
	public static int solution(int n, int r){
		for(int k=0;k<=n;k++){
			for(int l=0;l<=Math.min(k, r);l++){
				if(l==0||l==k) pascal[k][l]=1;
				else pascal[k][l]=pascal[k-1][l-1]+pascal[k-1][l];
			}
		}
		return pascal[n][r];
	}
	public static void main(String[] args){
		int n=12;
		int r=12;
		System.out.println(solution(n, r));
		for(int k=0;k<=n;k++){
			System.out.println(Arrays.toString(Arrays.copyOfRange(pascal[k], 0, k+1)));
		}
	}
}
