package net.kang.combinationDP;

import java.util.Arrays;

// �������� Combination�� �ٷ�鼭 ��� �Ľ�Į �ﰢ���� �����غ� ������ ���� ���̴�. �̸� ���� ��� �����غ����� �մϴ�.
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
