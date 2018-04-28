package net.kang.nodes;
public class Example01 {
	public static int solution(int start, int end){
		System.out.printf("solution(%d, %d)\n", start, end);
		if(start==end) return 0;
		else if(start>end) return 1+solution(start/2, end);
		else return 1+solution(start, end/2);
	}
	// �ð� ���⵵�� O(log n)���� �� ���� ������ �����ϴ�. �̸� DP�� �ٽ� ���ؼ��غ����� ����.
	public static void main(String[] args){
		System.out.println(solution(5, 3));
		System.out.println(solution(8, 14));
	}
}
