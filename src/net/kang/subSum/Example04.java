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
		System.out.println(solution()); // 마지막은 점화식을 통하여 더욱 빠르게 골라낼 수 있는 방법이다. 정답이 곧 sum(이전까지)+현재 데이터 에 대해서 골라내게 되면 오히려 빠른 시간 복잡도로 잡아낼 수 있다. 시간복잡도는 O(n).
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
