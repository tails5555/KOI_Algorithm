package net.kang.tiles;
public class Example01 {
	public static int solution(int n){
		if(n==0 || n==1) return 1;
		return solution(n-1)+2*solution(n-2);
	} // 시간 복잡도는 O(2^n)이 되시겠다. 이를 DP를 이용해서 줄여볼 수 있을까? 한번 시도해보자.
	public static void main(String[] args){
		for(int k=0;k<=10;k++){
			System.out.println(solution(k));
		}
	}
}
