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
				int subsum=sum(k, l); // 이렇게 계산을 하면 시간 복잡도가 O(n^3)이 나오기 때문에 그렇게 좋은 알고리즘이 아니다. 그래서 Example02를 통해서 최소한으로 낮춰보는 연습을 해보자.
				if(result<subsum) result=subsum;
			}
		}
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
