package net.kang.SCV;
// 마치 우리가 수업시간에 했던 합계 최소를 구하는 알고리즘과 비스무리한 문제가 아닐까싶다. 안 보고 연습해보도록 하자.
public class Example01 {
	static int[][] maze={
							{0, 1, 0, 0},
							{0, 0, 1, 0},
							{1, 1, 0, 0},
							{1, 0, 1, 0},
							{1, 1, 0, 0}
						};
	public static int solution(int r, int c){
		int beforeOre=0;
		if(r==0 && c==0) beforeOre=0;
		else if(r==0) beforeOre=solution(r, c-1);
		else if(c==0) beforeOre=solution(r-1, c);
		else beforeOre=Math.max(solution(r-1, c), solution(r, c-1));
		return beforeOre+maze[r][c];
	}
	// 당연하지만 재귀 호출로 푼 결과는 O(r*c)인건 알 것이다. 이를 DP를 이용해서 접근해보는 연습을 해보자.
	public static void main(String[] args){
		System.out.println(solution(4, 3));
	}
}
