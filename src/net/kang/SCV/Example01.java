package net.kang.SCV;
// ��ġ �츮�� �����ð��� �ߴ� �հ� �ּҸ� ���ϴ� �˰���� �񽺹����� ������ �ƴұ�ʹ�. �� ���� �����غ����� ����.
public class Example01 {
	static int[][] maze={
							{0, 1, 0, 0},
							{0, 0, 1, 0},
							{1, 1, 0, 0},
							{1, 0, 1, 0},
							{1, 1, 0, 0}
						};
	public static int solution(int r, int c){
		int beforeOre=0;
		if(r==0 && c==0) beforeOre=0;
		else if(r==0) beforeOre=solution(r, c-1);
		else if(c==0) beforeOre=solution(r-1, c);
		else beforeOre=Math.max(solution(r-1, c), solution(r, c-1));
		return beforeOre+maze[r][c];
	}
	// �翬������ ��� ȣ��� Ǭ ����� O(r*c)�ΰ� �� ���̴�. �̸� DP�� �̿��ؼ� �����غ��� ������ �غ���.
	public static void main(String[] args){
		System.out.println(solution(4, 3));
	}
}
