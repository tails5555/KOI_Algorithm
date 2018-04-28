package net.kang.binary;
// �Ʊ�� �߰��� �������� ���̽� ������ �´� �߰� ������ �ǵ��Ƽ� ���� ���� ���� �ٲ㺸�� ������ �غ���.
// �̸� ��ʷ� �ؼ� ��� ȣ���� ���ǿ� ���� ������ �غ� �ʿ䰡 �ִ�. 
// ���� ������ n�� 0�� ���� ���� �۾��� convert(n/decimal, decimal)�� �� �� �ְ� ���� �۾��� ������ number[n%decimal]�� ���������μ� ����.
// �� ������ ���� �ð� ���⵵�� ������ �����ϴ� ���� D, �Է��� �޴� ���� N�� �� log(D)N ��ŭ �ݺ��� �ϴ� O(log n)�� �ǰڴ�.
public class Example01 {
	static char[] number={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'};
	public static String convert(int n, int decimal){
		if(n==0) return "";
		else return convert(n/decimal, decimal)+number[n%decimal];
	}
	public static String toBinary(int n){
		if(n==0) return "";
		else return toBinary(n/2)+n%2;
	}
	public static void main(String[] args){
		for(int k=2;k<=16;k++){
			System.out.printf("%s[%d]\n", convert(1234, k), k);
		}
		System.out.println(toBinary(16)+"[2]");
	}
}
