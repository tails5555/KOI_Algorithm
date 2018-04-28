package net.kang.reverse;

public class Example01 {
	public static void solution(int n){
		if(n==0){
			System.out.println();
			return;
		}
		else{
			System.out.print(n%10);
			solution(n/10);
		}
	}
	public static void main(String[] args){
		solution(1234);
		solution(54321);
		solution(123456);
		// 여기까지는 큰 문제가 없을 것인데, 아래와 같은 문장을 살펴보면 분명 0321, 00654 등등 앞에 0이 붙게 된다는 점이다. 이를 방안한 코드는 다음 Example02를 살펴보자.
		solution(1230);
		solution(45600);
		solution(40203000);
	}
}
