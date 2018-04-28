package net.kang.combination;
// Combination을 수학적으로 풀어본다면 아래와 같은 점화식을 생각해볼 수 있을까?
// nCk= n-1Ck-1 + n-1Ck 이렇게 나눠볼 수 있다.
// 그리고 nCn은 분명 1이 나오는게 당연한 이야기이고, nC1은 n이 나올 것이다. 이를 이용해서 문장을 작성해보자.
public class Example02 {
	static int solution(int n, int k){
		if(k==1) return n;
		if(k==n) return 1;
		return solution(n-1, k-1)+solution(n-1, k); // 이처럼 문장을 풀어 써보면 아래와 같이 풀이가 된다.
	}
	// solution(10, 2)=10C2=(9C1+9C2)=(9)+(8C1+8C2)=(9)+(8)+(7C1+7C2)...=(9)+(8)+(7)...+(1)=45
	// solution(10, 3)=10C3=(9C2+9C3)=(8C1+8C2+8C2+8C3)=(8)+2*(7C1+7C2)+(7C2+7C3)=(8)+2*(7)+3*(6C1+6C2)+(6C2+6C3) => (8)+2*(7)+3*(6)+4*(5)+5*(4)+...+7*(2)+8*(1)
	// 이렇게 풀이하게 되면 시간 복잡도가 의외로 크게 나오는 것이 당연한 이야기. O(2^n)
	// 이를 DP로 작성해볼 수 있을까? DP를 이용해서 풀어보는 연습을 해보도록 하자. 10C4를 구해보기 위해 다음 예시를 참고하자.
	public static void main(String[] args){
		for(int k=1;k<=10;k++){
			System.out.println(solution(10, k));
		}
	}
}
