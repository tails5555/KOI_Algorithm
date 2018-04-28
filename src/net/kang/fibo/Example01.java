package net.kang.fibo;

public class Example01 {
	public static long solution(int n){
		if(n<=2) return 1;
		else return solution(n-2)+solution(n-1);
	}
	public static void main(String[] args){
		for(int k=1;k<=100;k++){
			long start=System.currentTimeMillis();
			long x=solution(k);
			long end=System.currentTimeMillis();
			System.out.println(x+" "+k+" "+Math.abs(start-end)); // ������ �̷��� ��� ȣ���� �ϰ� �ȴٸ� �ð� ���⵵�� O(2^n)�� ������ �� �Ӵ��� Ž�� ������ ������ �������� �ȴ�. �׷��� �̸� �ذ��ϱ� ���� ������� DP�� �̿��غ��� ������ �غ���.
		}
	}
}
