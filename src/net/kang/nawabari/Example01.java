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
					isOne=false; // isOne�� ���� �����ϱ�? ���� �̾߱��ؼ� ���͹ٸ��� ������ �� ���� ������ �ִ����� ���� Ȯ���� �ϴ� �۾��̴�.
			}
		}
		if(isOne){
			if(nawabari[startArea][endArea]==1) black++; // å�� �� �� ���Դ�. black�� 1�϶� �÷��ָ� �Ǵ°ǵ�...
			else white++;
			return;
		}
		else{
			solution(startArea, endArea, cut/2); // 2��и�
			solution(startArea+cut/2, endArea, cut/2); // 1��и�
			solution(startArea, endArea+cut/2, cut/2); // 3��и�
			solution(startArea+cut/2, endArea+cut/2, cut/2); // 4��и�
		} // ���Ⱑ 4������ �ϴ� ����̴�. �Լ� �׷��� �������� 2��и�, 1��и�, 3��и�, 4��и� 4������ ������ �� �� �ִٰ� �����ϸ� �ǰڴ�.
	}
	public static void main(String[] args){
		solution(0, 0, 8); // ���� �ð� ���⵵�� O(4^n)
		System.out.println(white);
		System.out.println(black);
	}
}
