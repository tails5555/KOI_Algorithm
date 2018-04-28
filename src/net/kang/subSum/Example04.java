package net.kang.subSum;

public class Example04 {
	static int[] arr={6, -7, 3, -1, 5, 2};
	public static int solution(){
		int result=Integer.MIN_VALUE;
		int sum=0;
		for(int k=0;k<arr.length;k++){
			sum=Math.max(sum, 0)+arr[k];
			result=Math.max(sum, result);
		}
		return result;
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution()); // �������� ��ȭ���� ���Ͽ� ���� ������ ��� �� �ִ� ����̴�. ������ �� sum(��������)+���� ������ �� ���ؼ� ��󳻰� �Ǹ� ������ ���� �ð� ���⵵�� ��Ƴ� �� �ִ�. �ð����⵵�� O(n).
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
