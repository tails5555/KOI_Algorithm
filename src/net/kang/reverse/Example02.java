package net.kang.reverse;

public class Example02 {
	static boolean first=true;
	public static void solution(int n){
		if(n==0){
			first=true;
			System.out.println();
			return;
		}
		else if(n%10==0 && first) solution(n/10);
		else{
			System.out.print(n%10);
			first=false;
			solution(n/10);
		}
	}
	public static void main(String[] args){
		solution(1234);
		solution(54321);
		solution(123456);
		// first라는 부울 변수를 추가하니 뒤에 0이 있을지언정 거꾸로 출력을 하는데 문제가 없게 된다. 최종 시간 복잡도는 O(log n)이 되겠다.
		// 재귀 호출로 풀어보는 것이 아니라 관계기반 알고리즘으로 수정을 해보도록 합니다.
		solution(1230);
		solution(45600);
		solution(40203000);
	}
}
