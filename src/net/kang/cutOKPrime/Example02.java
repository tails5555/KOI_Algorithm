package net.kang.cutOKPrime;
import java.util.ArrayList;
public class Example02 {
	public static boolean isPrime(int x){
		if(x<2) return false;
		for(int k=2;k<=Math.sqrt(x);k++){ // �� �ݺ������� �ɸ��� �ð��� O(root x)�� �Ǵµ� 
			if(x%k==0) return false;
		}
		return true;
	}
	static int length=2;
	static ArrayList<Integer> result=new ArrayList<Integer>();
	public static void solution(int digitNum, int num){
		System.out.println(digitNum+" "+num);
		if(digitNum==length){
			if(isPrime(num)){
				result.add(num);
			}
		}
		else{
			if(isPrime(num)){
				solution(digitNum+1, num*10+1);
				solution(digitNum+1, num*10+3);
				solution(digitNum+1, num*10+7);
				solution(digitNum+1, num*10+9); // �׸��� ���������� 1�� ���ڴ� 1, 3, 7, 9 �߿��� �Ҽ��� ��󳻴� ���� �����̱� ������ �̷��� ����� ���ָ� ������ �Ʊ�� ���� ������ ����� �����ϴ�.
			}
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(1, 2);
		solution(1, 3);
		solution(1, 5);
		solution(1, 7); // ������ ���� �ڸ� ������ �Ҽ��� �ɷ��� 2, 3, 5, 7�� ���δ�. �׷��� ���� ���� ���� ���ڸ� �� �ʿ䰡 ���� 2, 3, 5, 7�θ� �񱳸� �����ָ� �ȴ�.
		long end=System.nanoTime();
		System.out.println(result); // �ð� ���⵵ : O(4^n * root x)
		System.out.println(Math.abs(start-end));
	}
}
