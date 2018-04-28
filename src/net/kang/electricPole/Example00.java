package net.kang.electricPole;

import java.util.Arrays;
// 오늘은 새로운 문제 풀어보는건 내일 다시하도록 하고, LIS 개념에 대해서 공부를 해보면서 Example01를 접근해보도록 하자. 이는 실제로 프로그래밍 문제에서도 많이 요구한다고 하니 알아두도록 합시다. 
public class Example00 {
	static int[] arr=new int[] {1, 2, 5, 2, 3, 1, 4}; // 여기서 오름차순으로 증가를 하는 배열 목록 중에서 길이가 긴 녀석을 찾는 것을 추구한다고 생각하면 되겠다.
	// 예를 들어 [2, 5] 나 [2, 3], [1, 4] 등등이 대표적이다. 물론 나 자신도 부분 수열로 볼 수 있다는 점과 [3, 5, 1] 처럼 일부를 얻어와서 할 수 있는 점도 고려해야겠다.
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
