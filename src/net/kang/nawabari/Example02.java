package net.kang.nawabari;
// 이를 관계기반 알고리즘으로 전개해보는 연습도 충분히 해볼 수 있지 않을까?
public class Example02 {
	static int[][] nawabari={
								{ 1, 1, 0, 0, 0, 0, 1, 1 },
								{ 1, 1, 0, 0, 0, 0, 1, 1 },
								{ 0, 0, 0, 0, 1, 1, 0, 0 },
								{ 0, 0, 0, 0, 1, 1, 0, 0 },
								{ 1, 0, 0, 0, 1, 1, 1, 1 },
								{ 0, 1, 0, 0, 1, 1, 1, 1 },
								{ 0, 0, 1, 1, 1, 1, 1, 1 },
								{ 0, 0, 1, 1, 1, 1, 1, 1 }
							};
	static final int BLACK=1;
	static final int WHITE=0;
	public static boolean isOne(int startArea, int endArea, int cut, int color){
		for(int k=startArea;k<startArea+cut;k++){
			for(int l=endArea;l<endArea+cut;l++){
				if(nawabari[k][l]!=color) return false;
			}
		}
		return true;
	}
	public static int solution(int startArea, int endArea, int cut, int color){
		if(cut==1) return (nawabari[startArea][endArea]==color) ? 1 : 0; // 여기서 색깔이 같으면 1를 반환하고, 다르면 0을 반환하는 모습을 볼 수 있다.
		if(isOne(startArea, endArea, cut, color)) return 1; // 어자피 여기서 색상이 같으면 1개로 인정이 되니깐 1를 반환하면 끝이다.
		return solution(startArea, endArea, cut/2, color)+solution(startArea+cut/2, endArea, cut/2, color)+solution(startArea, endArea+cut/2, cut/2, color)+solution(startArea+cut/2, endArea+cut/2, cut/2, color);
		// 위처럼 4분할을 하게 되면 쉽게 구하는데 문제가 없을 것이다. 아시다시피 0은 white, 1은 black이다.
	}
	public static void main(String[] args){
		System.out.println(solution(0, 0, nawabari.length, WHITE));
		System.out.println(solution(0, 0, nawabari.length, BLACK));
		// 이 문장의 시간 복잡도는 애석하게도 O(4^n)이 되겠다.
	}
}
