package net.kang.tiles;
public class Example01 {
	public static int solution(int n){
		if(n==0 || n==1) return 1;
		return solution(n-1)+2*solution(n-2);
	} // �ð� ���⵵�� O(2^n)�� �ǽðڴ�. �̸� DP�� �̿��ؼ� �ٿ��� �� ������? �ѹ� �õ��غ���.
	public static void main(String[] args){
		for(int k=0;k<=10;k++){
			System.out.println(solution(k));
		}
	}
}
