package net.kang.reverse;

public class Example01 {
	public static void solution(int n){
		if(n==0){
			System.out.println();
			return;
		}
		else{
			System.out.print(n%10);
			solution(n/10);
		}
	}
	public static void main(String[] args){
		solution(1234);
		solution(54321);
		solution(123456);
		// ��������� ū ������ ���� ���ε�, �Ʒ��� ���� ������ ���캸�� �и� 0321, 00654 ��� �տ� 0�� �ٰ� �ȴٴ� ���̴�. �̸� ����� �ڵ�� ���� Example02�� ���캸��.
		solution(1230);
		solution(45600);
		solution(40203000);
	}
}
