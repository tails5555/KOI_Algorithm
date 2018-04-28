package net.kang.officeTeacher;
// 의외로 전체 탐색법을 이용한다면 그닥 어렵지 않게 접근이 가능할 것이다. 
/* criminal이 15이면, 1+7+7
 * criminal이 16이면, 1+5+5+5
 * criminal이 17이면, 1+7+7+2
 * criminal이 18이면, 1+7+5+5
 * criminal이 19이면, 1+7+7+2+2
 * criminal이 20이면, 1+7+7+5
 * criminal이 21이면, 1+5+5+5+5
 * criminal이 22이면, 1+7+7+7
 */
public class Example01 {
	static int[] ability={2, 5, 7};
	static int criminal=15;
	static int answer=Integer.MAX_VALUE;
	public static void solution(int next, int count){
		if(next>criminal) return;
		if(next==criminal){
			if(count<answer) answer=count;
		}
		for(int k=0;k<ability.length;k++){
			solution(next+ability[k], count+1);
		}
	}
	public static void main(String[] args){
		solution(1, 0);
		if(answer!=Integer.MAX_VALUE)
			System.out.println(answer); // 허나 이렇게 구하게 된다면 시간 복잡도는 O(3^n)이 나와서 오히려 꼬이게 된다. 이를 DP를 이용해서 처리를 해보는 연습을 가지자. 그리고 DP를 이용하여 정답 출력하는 것까지 구현해보자.
		else
			System.out.println(-1);
	}
}
