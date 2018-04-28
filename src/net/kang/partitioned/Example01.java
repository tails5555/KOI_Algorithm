package net.kang.partitioned;
// f(n, k) -> k ������ �ڿ����� ������ n�� ���� �� �ִ� ����� ���� ��������.
// f(n, k) -> f(n-1, 1)+f(n-2, 2)+f(n-3, 3)+...+f(n-k, k) �� ����ϸ� ���ڴ�.
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
		// �ð� ���⵵�� O(n^2)
	}
}
