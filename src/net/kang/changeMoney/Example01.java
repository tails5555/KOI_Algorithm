package net.kang.changeMoney;

public class Example01 {
	static int[] note={10, 50, 100, 500, 1000};
	static int result=Integer.MAX_VALUE;
	public static void solution(int current, int count){
		if(current<0) return;
		if(current==0){
			if(count<result) result=count;
			return;
		}
		for(int k=0;k<note.length;k++){
			solution(current-note[k], count+1);
		}
	}
	public static void main(String[] args){
		int balance=730;
		long start=System.nanoTime();
		solution(balance, 0); // ���⿡ ���̴� �˰����� �׷��� ���� ����� ����� �ƴ϶�� ����. ���� �̷��Ա��� �������� �ݺ����� ������ �ʴ��� ȿ�������� ����� �� �� �ִ� ����� �ִµ� Example02�� �����غ��� �ٶ���.
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
