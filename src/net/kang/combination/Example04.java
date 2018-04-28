package net.kang.combination;

public class Example04 {
	public static int solution(int n, int k){
		if(k==1) return n;
		if(k==n) return 1;
		return solution(n, k-1)*(n-k+1)/k;
	}
	public static void main(String[] args){
		System.out.println(solution(10, 4));
	}
}
