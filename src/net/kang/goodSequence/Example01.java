package net.kang.goodSequence;
// ���� ������ ���� ���� ��� 3212, 1232123 ����� �ǵ� 123123������ �� �ȴ� �̰Ŵ�.
public class Example01 {
	static int n=3; // �ڸ����� �Ǵ��ϴ� ����.
	static int count=0;
	public static void solution(String num, int digit){ // ���� �ռ��� �ڸ����� �Է¹����� �� �ڸ���ŭ ��� ������ ����ϴ� ���α׷��� ������.
		if(digit>n) return;
		count++;
		System.out.println(num);
		solution("1"+num, digit+1);
		solution("2"+num, digit+1);
		solution("3"+num, digit+1);
	}
	public static void main(String[] args){
		solution("", 0);
		System.out.println("count->"+(count-1));
	}
}
