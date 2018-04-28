package net.kang.subSum;

public class Example03 {
	static int[] arr={6, -7, 3, -1, 5, 2};
	public static int divideSum(int start, int end){
		if(start==end) return arr[start];
		int middle=(start+end)/2;
		int left=Integer.MIN_VALUE;
		for(int k=0;k<=middle-1;k++){
			int sum=0;
			for(int l=k;l<=middle-1;l++){
				sum+=arr[l];
				left=Math.max(left, sum); // �̷��� ����� �ϰ� �Ǹ� ���⼭�� ū ��ȭ�� ���� ���ϴµ� �ٵ� �迭�� ũ�Ⱑ ������ ��쿡�� ��찡 �޶����� �ȴ�. ���� �ð� ���⵵�� O(n^2)
			}
		}
		int right=Integer.MIN_VALUE;
		for(int k=middle;k<=end;k++){
			int sum=0;
			for(int l=k;l<=end;l++){
				sum+=arr[l];
				right=Math.max(right, sum); // �̷��� ����� �ϰ� �Ǹ� ���⼭�� ū ��ȭ�� ���� ���ϴµ� �ٵ� �迭�� ũ�Ⱑ ������ ��쿡�� ��찡 �޶����� �ȴ�. ���� �ð� ���⵵�� O(n^2)
			}
		}
		return Math.max(left, right);
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(divideSum(0, arr.length-1));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end)); // �̷��� ��ȵ� �ð��� ���� ��쿡�� �� ����������, ���߿� �����Ͱ� ��������ϰ� �������� ��쿡�� ũ�� �پ��� ������ �� �� �ִ�. ���� �ð� ���⵵�� O(N log N)
	}
}
