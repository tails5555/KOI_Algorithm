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
				result=Math.max(result, sum); // 이렇게 계산을 하게 되면 여기서는 큰 변화를 보지 못하는데 근데 배열의 크기가 수억인 경우에는 경우가 달라지게 된다. 최종 시간 복잡도는 O(n^2)
			}
		}
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
