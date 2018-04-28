package net.kang.nodes;
public class Example01 {
	public static int solution(int start, int end){
		System.out.printf("solution(%d, %d)\n", start, end);
		if(start==end) return 0;
		else if(start>end) return 1+solution(start/2, end);
		else return 1+solution(start, end/2);
	}
	// 시간 복잡도는 O(log n)으로 좀 쉽게 접근이 가능하다. 이를 DP로 다시 재해석해보도록 하자.
	public static void main(String[] args){
		System.out.println(solution(5, 3));
		System.out.println(solution(8, 14));
	}
}
