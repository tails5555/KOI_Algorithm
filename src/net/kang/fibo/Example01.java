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
			System.out.println(x+" "+k+" "+Math.abs(start-end)); // 실제로 이렇게 재귀 호출을 하게 된다면 시간 복잡도는 O(2^n)이 나오게 될 뿐더러 탐색 공간도 더럽게 많아지게 된다. 그래서 이를 해결하기 위한 방안으로 DP를 이용해보는 연습을 해보자.
		}
	}
}
