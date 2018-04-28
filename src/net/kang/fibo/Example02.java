package net.kang.fibo;

public class Example02 {
	static long[] dp=new long[101];
	public static long solution(int n){
		if(dp[n]!=0) return dp[n];
		if(n<=2) return dp[n]=1;
		return dp[n]=dp[n-1]+dp[n-2];
	}
	public static void main(String[] args){
		for(int k=1;k<=100;k++){
			long start=System.currentTimeMillis();
			long x=solution(k);
			long end=System.currentTimeMillis();
			System.out.println(x+" "+k+" "+Math.abs(start-end)); // 이처럼 짧막하게 작성을 하였는데도 불구하고 fibo 100의 값도 손쉽게 구할 수 있게 되니깐 오히려 DP를 이용해서 이득을 볼 수 있는 점을 발견할 수 있다. 실제로 Example01, Example02를 돌려보면서 비교해보는 기회를 가져보도록 하면 좋겠다.
		}
	}
}
