package net.kang.combination;

public class Example01 {
	static int factorial(int n){
		if(n==0) return 1;
		else if(n==1) return 1;
		return n*factorial(n-1);
	}
	static int solution(int n, int k){
		return factorial(n)/(factorial(k)*factorial(n-k));
	} // factorial�� �̿��ؼ� �����ϰ� ¥�� �� �ִµ� �̷��� §�ٸ� �ð� ���⵵�� O(n)���� Ǯ �� �ְڴ�.
	public static void main(String[] args){
		for(int k=1;k<=10;k++){
			System.out.println(solution(10, k));
		}
	}
}