package net.kang.combinationDP;

public class Example02 {
	static int[][] dp=new int[101][101];
	static int N=4;
	static int R=2;
	public static int solution(int n, int r){
		if(r==R) return 1;
		if(n==N) return 0;
		return solution(n+1, r+1)+solution(n+1, r);
	}
	// �̰��� ������ �ǹ��ϴ� �ɱ�? �̸� �����ϸ� �ð� ���⵵�� O(2^n)�� �Ǵ� �� �� ���̴�.
	// ���� �̾߱��ؼ� n������ �������� ��쿡 r�̶� �� �´� ���� ������ ���ϴ� �ŷ� �����ϸ� ���� ������ �����ϴ�.
	// �׷��� �̷��� �ϴ� ���� �ð� ���⵵�� �峭�ƴϰ� ���������ٴ� ���� ���� �� ���� ���̴�. �̸� DP�� �̿��ؼ� ������ �غ����� �Ѵ�.
	public static void main(String[] args){
		System.out.println(solution(0, 0));
	}
}
