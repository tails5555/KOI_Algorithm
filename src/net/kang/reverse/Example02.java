package net.kang.reverse;

public class Example02 {
	static boolean first=true;
	public static void solution(int n){
		if(n==0){
			first=true;
			System.out.println();
			return;
		}
		else if(n%10==0 && first) solution(n/10);
		else{
			System.out.print(n%10);
			first=false;
			solution(n/10);
		}
	}
	public static void main(String[] args){
		solution(1234);
		solution(54321);
		solution(123456);
		// first��� �ο� ������ �߰��ϴ� �ڿ� 0�� ���������� �Ųٷ� ����� �ϴµ� ������ ���� �ȴ�. ���� �ð� ���⵵�� O(log n)�� �ǰڴ�.
		// ��� ȣ��� Ǯ��� ���� �ƴ϶� ������ �˰������� ������ �غ����� �մϴ�.
		solution(1230);
		solution(45600);
		solution(40203000);
	}
}
