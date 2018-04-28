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
			System.out.println(x+" "+k+" "+Math.abs(start-end)); // ��ó�� ª���ϰ� �ۼ��� �Ͽ��µ��� �ұ��ϰ� fibo 100�� ���� �ս��� ���� �� �ְ� �Ǵϱ� ������ DP�� �̿��ؼ� �̵��� �� �� �ִ� ���� �߰��� �� �ִ�. ������ Example01, Example02�� �������鼭 ���غ��� ��ȸ�� ���������� �ϸ� ���ڴ�.
		}
	}
}
