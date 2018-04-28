package net.kang.subSum;

public class Example01 {
	static int[] arr={6, -7, 3, -1, 5, 2};
	public static int sum(int start, int end){
		int result=0;
		for(int k=start;k<=end;k++){
			result+=arr[k];
		}
		return result;
	}
	public static void main(String[] args){
		int result=Integer.MIN_VALUE;
		long start=System.nanoTime();
		for(int k=0;k<arr.length;k++){
			for(int l=k;l<arr.length;l++){
				int subsum=sum(k, l); // �̷��� ����� �ϸ� �ð� ���⵵�� O(n^3)�� ������ ������ �׷��� ���� �˰����� �ƴϴ�. �׷��� Example02�� ���ؼ� �ּ������� ���纸�� ������ �غ���.
				if(result<subsum) result=subsum;
			}
		}
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
