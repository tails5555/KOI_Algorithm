package net.kang.electricPole;

import java.util.Arrays;
// ������ ���ο� ���� Ǯ��°� ���� �ٽ��ϵ��� �ϰ�, LIS ���信 ���ؼ� ���θ� �غ��鼭 Example01�� �����غ����� ����. �̴� ������ ���α׷��� ���������� ���� �䱸�Ѵٰ� �ϴ� �˾Ƶε��� �սô�. 
public class Example00 {
	static int[] arr=new int[] {1, 2, 5, 2, 3, 1, 4}; // ���⼭ ������������ ������ �ϴ� �迭 ��� �߿��� ���̰� �� �༮�� ã�� ���� �߱��Ѵٰ� �����ϸ� �ǰڴ�.
	// ���� ��� [2, 5] �� [2, 3], [1, 4] ����� ��ǥ���̴�. ���� �� �ڽŵ� �κ� ������ �� �� �ִٴ� ���� [3, 5, 1] ó�� �Ϻθ� ���ͼ� �� �� �ִ� ���� ����ؾ߰ڴ�.
	static int[] dp=new int[arr.length];
	public static int solution(int[] arr){
		int result=Integer.MIN_VALUE;
		for(int k=0;k<arr.length;k++){
			int length=0;
			for(int l=0;l<k;l++){
				if(arr[k]>=arr[l]){
					length=Math.max(length, dp[l]);
				}
			}
			dp[k]=length+1;
			result=Math.max(result, dp[k]);
		}
		return result;
	}
	public static void result(int index, int result){
		if(index==-1) return;
		if(dp[index]==result){
			result(index-1, result-1);
			System.out.print(arr[index]+" ");
		}
		else{
			result(index-1, result);
		}
	}
	public static void main(String[] args){
		System.out.println(solution(arr));
		System.out.println(Arrays.toString(dp));
		for(int k=arr.length-1;k>=0;k--){
			result(k, dp[k]);
			System.out.println();
		}
	}
}
