package net.kang.reverseDP;

public class Example01 {
	static int[] dp=new int[50001];
	public static int solution(int x){
		for(int k=1;k<=x;k++){
			if(k<10) dp[k]=k;
			else dp[k]=dp[k/10]+(k%10)*(int)Math.pow(10, (int)Math.log10(k)); // �ƴ� �ٵ� ��� ������ ���ؼ� ���ڸ� ������ �۾��� ����ؾ� �ұ�? �̸� �����غ���.
		}
		return dp[x];
	}
	public static void main(String[] args){
		int x=12345;
		System.out.println(solution(x));
	}
}
