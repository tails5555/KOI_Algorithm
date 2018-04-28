package net.kang.cutOKPrime;
import java.util.ArrayList;
public class Example01 {
	// �����佺�׳׽� ���ٹ��� �Ϲ������� �Ҽ��� ������ ��츦 ����� �� �ִµ� �����佺�׳׽� ���ٹ��� �̿��ϰ� �Ǹ� ��� �������� ���������, root 2�� �ٿ��� ������ �ð� ���⵵�� �׳��� ������ ���� �� �ֱ� ������ ȿ�������� �� �� �ְڴ�.
	public static boolean isPrime(int x){
		if(x<2) return false;
		for(int k=2;k<=Math.sqrt(x);k++){ // �� �ݺ������� �ɸ��� �ð��� O(root x)�� �Ǵµ� 
			if(x%k==0) return false;
		}
		return true;
	}
	public static boolean isPrimeTwo(int x){ // �̷��� �ݺ��� �ϰ� �Ǹ� �ð� ���⵵�� O(x)�� ������ �Ǿ ������ �ð��� ���� �ɸ� �� �ۿ� ���� ������ �����佺�׳׽��� ü�� �̿��� ����� ���ؼ� ����� �� �ʿ䰡 �ִ�.
		if(x<2) return false;
		for(int k=2;k<x;k++)
			if(x%k==0) return false;
		return true;
	}
	static int length=2;
	static ArrayList<Integer> result=new ArrayList<Integer>();
	public static void solution(int digitNum, int num){
		System.out.println(digitNum+" "+num);
		if(digitNum==length){
			if(num==0) return;
			int temp=num;
			while(temp!=0){
				if(!isPrime(temp)) return;
				temp/=10;
			}
			result.add(num);
		}
		else{
			for(int k=1;k<=9;k++){
				solution(digitNum+1, num*10+k); // �̰� 0���� ���� �ڸ����� ���������� �ݺ��� �Ǵϱ� ��° ���� ��ȿ�����̱� �ϴ�... �׷��� �Ҽ���� ������ �ٱ� ���ؼ��� ���� �ڸ� ���ڰ� ¦���� �ƴϾ�� �ϰ�, Ȧ�� �߿��� 5������ ����� �� �ȴٴ� ������ �ٿ��� �ٽ� �ۼ��غ��� �ð��� ���̸� ������ �� ���̴�.
			}
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(0, 0);
		long end=System.nanoTime();
		System.out.println(result); // �ð� ���⵵ : O(9^n * n * root x)
		System.out.println(Math.abs(start-end));
	}
}
