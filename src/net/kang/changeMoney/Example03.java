package net.kang.changeMoney;

public class Example03 {
	static int[] note={10, 50, 100, 500, 1000};
	static int answer=0;
	static int change=730;
	public static void solution(int accBalance, int index, int count){
		if(index==note.length || accBalance>change) return;
		else if(accBalance==change){
			if(count<answer) answer=count;
			return;
		}
		for(int k=0;accBalance+note[index]*k<=change;k++){
			solution(accBalance+note[index]*k, index+1, count+1);
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(0, 0, 0); // ���� �Ʊ� Example02���� ȿ������ �������� ������, �Ʊ�� ������ �ּڰ����� ������ �˰������� �ۼ��� �ߴµ�, �̷��� �Ѵٸ� ��ü�� ���� �߿��� �ּڰ��� �߱��� �ϴ� �����̱� ������ �̷��� �˰��� ����غ� �ʿ䰡 �ִ�.
		long end=System.nanoTime();
		System.out.println(answer);
		System.out.println(Math.abs(start-end));
	}
}
