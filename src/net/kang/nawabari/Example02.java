package net.kang.nawabari;
// �̸� ������ �˰������� �����غ��� ������ ����� �غ� �� ���� ������?
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
		if(cut==1) return (nawabari[startArea][endArea]==color) ? 1 : 0; // ���⼭ ������ ������ 1�� ��ȯ�ϰ�, �ٸ��� 0�� ��ȯ�ϴ� ����� �� �� �ִ�.
		if(isOne(startArea, endArea, cut, color)) return 1; // ������ ���⼭ ������ ������ 1���� ������ �Ǵϱ� 1�� ��ȯ�ϸ� ���̴�.
		return solution(startArea, endArea, cut/2, color)+solution(startArea+cut/2, endArea, cut/2, color)+solution(startArea, endArea+cut/2, cut/2, color)+solution(startArea+cut/2, endArea+cut/2, cut/2, color);
		// ��ó�� 4������ �ϰ� �Ǹ� ���� ���ϴµ� ������ ���� ���̴�. �ƽôٽ��� 0�� white, 1�� black�̴�.
	}
	public static void main(String[] args){
		System.out.println(solution(0, 0, nawabari.length, WHITE));
		System.out.println(solution(0, 0, nawabari.length, BLACK));
		// �� ������ �ð� ���⵵�� �ּ��ϰԵ� O(4^n)�� �ǰڴ�.
	}
}
