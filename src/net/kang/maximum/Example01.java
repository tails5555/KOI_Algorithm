package net.kang.maximum;

public class Example01 {
	// 1. 선형적으로 최댓값을 찾아본다.
	public static int maximum(int[] arr){
		int result=arr[0];
		for(int k=1;k<arr.length;k++){
			if(arr[result]<arr[k]) result=k;
		}
		return result;
	}
	// 2. 분할을 통하여 최댓값을 찾아본다.
	public static int divideMaximum(int[] arr, int start, int end){
		if(start>=end) return arr[start];
		int middle=(start+end)/2;
		return Math.max(divideMaximum(arr, start, middle), divideMaximum(arr, middle+1, end));
	}
	public static void main(String[] args){
		int[] arr={3, 29, 38, 12, 57, 74, 40, 85, 61};
		System.out.println(arr[maximum(arr)]+" "+maximum(arr));
		System.out.println(divideMaximum(arr, 0, arr.length-1));
	}
}
