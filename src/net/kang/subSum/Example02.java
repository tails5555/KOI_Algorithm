package net.kang.subSum;

public class Example02 {
	static int[] arr={6, -7, 3, -1, 5, 2};
	public static void main(String[] args){
		int result = Integer.MIN_VALUE;
		long start=System.nanoTime();
		for(int k=0;k<arr.length;k++){
			int sum=0;
			for(int l=k;l<arr.length;l++){
				sum+=arr[l];
				result=Math.max(result, sum); // �̷��� ����� �ϰ� �Ǹ� ���⼭�� ū ��ȭ�� ���� ���ϴµ� �ٵ� �迭�� ũ�Ⱑ ������ ��쿡�� ��찡 �޶����� �ȴ�. ���� �ð� ���⵵�� O(n^2)
			}
		}
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
