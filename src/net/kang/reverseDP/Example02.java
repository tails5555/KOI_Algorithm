package net.kang.reverseDP;

public class Example02 {
	static int[] dp=new int[50001];
	public static int solution(int n){
		if(n<10) return n;
		if(dp[n]!=0) return dp[n];
		dp[n]=solution(n/10)+(n%10)*(int)Math.pow(10, (int)Math.log10(n));
		return dp[n];
	}
	public static void print(){
		for(int k=0;k<dp.length;k++){
			if(dp[k]!=0) System.out.println(dp[k]+" "+k);
		}
	}
	public static void main(String[] args){
		System.out.println(solution(12354)); // ��ó�� ������ �Ѵٸ� �Ʊ�� �޸� ��� ���ڿ� ���ؼ� ó���� �� �ʿ䰡 �������� �ȴ�.
		// Example01�� �ð� ���⵵�� O(n log n), Example02�� �ð� ���⵵�� O(log n)���� ����.
		print();
	}
}
