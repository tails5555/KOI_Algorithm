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
	} // 시간 복잡도는 O(n*k)이 되시겠다.
	public static void main(String[] args){
		System.out.println(solution(10, 10)); // dp로 풀어볼수 있긴 한데 여기서 추억의 삼각형을 볼 수 있을 것이다. 바로 파스칼의 삼각형이다. 
		// 파스칼 삼각형을 통하여 조합의 값을 얻어오는 방법도 고려해보는 것이 좋겠다.
		for(int k=0;k<dp.length;k++){
			System.out.println(Arrays.toString(dp[k]));
		}
	}
}
