package net.kang.officeTeacher;

import java.util.Arrays;

public class Example03 {
	static int[] dp=new int[1001];
	static int criminal=15;
	static int officer=1;
	static int[] ability={2, 5, 7};
	public static void solution(){
		for(int k=officer+1;k<=criminal;k++){
			dp[k]=12345678; // Integer.MAX_VALUE로 한다면 계산하는데 무리가 다가오게 되어 12345678로 대체하였다.
		}
		for(int k=officer+1;k<=criminal;k++){
			int temp=12345678;
			for(int l=0;l<ability.length;l++){
				if(k>=officer+ability[l])
					temp=Math.min(temp, dp[k-ability[l]]+1);
			}
			dp[k]=temp;
		}
		if(dp[criminal]!=12345678) System.out.println(dp[criminal]);
		else System.out.println(-1);
	} // 이렇게 한다면 아까와 비록 시간 복잡도는 O(n*a)이 나오시겠다만 Queue로 풀이한 방안과 달리 탐색 공간을 크게 줄일 수 있어서 이 방안이 절약적으로 쓰일 수도 있다.
	public static void main(String[] args){
		solution();
		System.out.println(Arrays.toString(Arrays.copyOfRange(dp, officer, criminal+1)));
	}
}
