package net.kang.combinationDP;

public class Example02 {
	static int[][] dp=new int[101][101];
	static int N=4;
	static int R=2;
	public static int solution(int n, int r){
		if(r==R) return 1;
		if(n==N) return 0;
		return solution(n+1, r+1)+solution(n+1, r);
	}
	// 이것이 무엇을 의미하는 걸까? 이를 실행하면 시간 복잡도는 O(2^n)이 되는 건 알 것이다.
	// 쉽게 이야기해서 n층까지 내려갔을 경우에 r이랑 딱 맞는 수의 개수를 구하는 거로 생각하면 쉽게 접근이 가능하다.
	// 그러나 이렇게 하는 짓은 시간 복잡도가 장난아니게 복잡해진다는 것을 느낄 수 있을 것이다. 이를 DP를 이용해서 접근을 해보도록 한다.
	public static void main(String[] args){
		System.out.println(solution(0, 0));
	}
}
