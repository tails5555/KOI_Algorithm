package net.kang.reverse;
// �˰��� ���� �ð��� ����� ������ �����Ͽ� ��� ȣ���� �����غ��ٸ�...
/*
 * 1. ������ ������ �����ε��� �Ѵ�.
 * 2. ��� �۾��� ���� ���� �۾��� ó���Ѵ�.
 * 3. ���ȣ�⿡ ���ؼ� �۾��� ���ش�. �״ϱ� ������ ������ ���� ����� �������ڴ� �̾߱�.
 */
public class Example03 {
	public static int solution(int n){
		if(n<10) return n; // 1�� ����
		int decimal=(int)Math.pow(10.0, (int)Math.log10(n));
		return (n%10)*decimal+solution((n%decimal)/10)*10+n/decimal;
		// (n%10)*decimal+n/decimal�� 3���� ���� �̾߱�. solution((n%decimal)/10)*10 �κ��� 2���� �̾߱�.
	}
	// �� ��� ������ �̿��غ��� �� ���ڸ�, �� ���ڸ����� ���� �ٲ㰡�鼭 int ������ ��ȯ�� �ϴ� ����� �� �� �ִ�. �ð� ���⵵�� ������ O(log n)�ε� Ž�� ������ ���̸鼭 ȿ������ �˰����� �ϼ��� �� �ִ�.
	public static void main(String[] args){
		System.out.println(solution(1234));
		System.out.println(solution(54321));
		System.out.println(solution(123456));
		System.out.println(solution(1230));
		System.out.println(solution(45600));
		System.out.println(solution(40203000));
	}
}
