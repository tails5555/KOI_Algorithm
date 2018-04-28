package net.kang.partitioned;
// f(n, k) -> k 이하의 자연수의 합으로 n을 만들 수 있는 경우의 수로 생각하자.
// f(n, k) -> f(n-1, 1)+f(n-2, 2)+f(n-3, 3)+...+f(n-k, k) 를 고려하면 좋겠다.
public class Example01 {
	static int[] arr=new int[30];
	static int count=0;
	public static void solution(int n, int k){
		if(n==0){
			for(int a=0;a<count;a++){
				System.out.printf("%d ", arr[a]);
			}
			System.out.println();
			return;
		}
		for(int a=Math.min(n, k);a>=1;a--){
			arr[count++]=a;
			solution(n-a, a);
			count--;
		}
	}
	public static void main(String[] args){
		solution(10, 10);
		// 시간 복잡도는 O(n^2)
	}
}
