package net.kang.goodSequence;
// 좋은 수열의 뜻은 예를 들어 3212, 1232123 등등은 되데 123123같은건 안 된다 이거다.
public class Example01 {
	static int n=3; // 자릿수를 판단하는 변수.
	static int count=0;
	public static void solution(String num, int digit){ // 들어가기 앞서서 자리수를 입력받으면 그 자리만큼 모든 수열을 출력하는 프로그램을 만들어보자.
		if(digit>n) return;
		count++;
		System.out.println(num);
		solution("1"+num, digit+1);
		solution("2"+num, digit+1);
		solution("3"+num, digit+1);
	}
	public static void main(String[] args){
		solution("", 0);
		System.out.println("count->"+(count-1));
	}
}
