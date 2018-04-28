package net.kang.reverse;
// 알고리즘 수업 시간에 배웠던 조건을 전제하에 재귀 호출을 복습해본다면...
/*
 * 1. 끝나는 조건을 세워두도록 한다.
 * 2. 계산 작업을 들어가되 이전 작업을 처리한다.
 * 3. 재귀호출에 대해서 작업을 해준다. 그니깐 현재의 변수에 대한 계산을 진행하자는 이야기.
 */
public class Example03 {
	public static int solution(int n){
		if(n<10) return n; // 1번 참고
		int decimal=(int)Math.pow(10.0, (int)Math.log10(n));
		return (n%10)*decimal+solution((n%decimal)/10)*10+n/decimal;
		// (n%10)*decimal+n/decimal이 3번에 대한 이야기. solution((n%decimal)/10)*10 부분이 2번의 이야기.
	}
	// 이 재귀 문장을 이용해보면 맨 앞자리, 맨 뒷자리끼리 서로 바꿔가면서 int 형으로 반환을 하는 모습을 볼 수 있다. 시간 복잡도는 어자피 O(log n)인데 탐색 공간을 줄이면서 효율적인 알고리즘을 완성할 수 있다.
	public static void main(String[] args){
		System.out.println(solution(1234));
		System.out.println(solution(54321));
		System.out.println(solution(123456));
		System.out.println(solution(1230));
		System.out.println(solution(45600));
		System.out.println(solution(40203000));
	}
}
