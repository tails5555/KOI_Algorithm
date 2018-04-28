package net.kang.nawabari;

public class Example01 {
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
	static int black=0;
	static int white=0;
	public static void solution(int startArea, int endArea, int cut){
		boolean isOne=true;
		for(int k=startArea;k<startArea+cut;k++){
			for(int l=endArea;l<endArea+cut;l++){
				if(nawabari[startArea][endArea]!=nawabari[k][l])
					isOne=false; // isOne의 뜻은 무엇일까? 쉽게 이야기해서 나와바리를 나눴을 떄 같은 색상이 있는지에 대해 확인을 하는 작업이다.
			}
		}
		if(isOne){
			if(nawabari[startArea][endArea]==1) black++; // 책이 잘 못 나왔다. black은 1일때 올려주면 되는건데...
			else white++;
			return;
		}
		else{
			solution(startArea, endArea, cut/2); // 2사분면
			solution(startArea+cut/2, endArea, cut/2); // 1사분면
			solution(startArea, endArea+cut/2, cut/2); // 3사분면
			solution(startArea+cut/2, endArea+cut/2, cut/2); // 4사분면
		} // 여기가 4분할을 하는 장면이다. 함수 그래플 기준으로 2사분면, 1사분면, 3사분면, 4사분면 4면으로 나뉘어 볼 수 있다고 생각하면 되겠다.
	}
	public static void main(String[] args){
		solution(0, 0, 8); // 최종 시간 복잡도는 O(4^n)
		System.out.println(white);
		System.out.println(black);
	}
}
