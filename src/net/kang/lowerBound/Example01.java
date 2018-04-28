package net.kang.lowerBound;

import java.util.Arrays;

public class Example01 {
	public static int linearLowerBound(int[] arr, int start, int value){
		if(start>=arr.length) return arr.length;
		if(arr[start]>=value) return start+1;
		else return linearLowerBound(arr, start+1, value);
	}
	public static int linearUpperBound(int[] arr, int start, int value){
		if(start>=arr.length) return arr.length;
		if(arr[start]>value) return start+1;
		else return linearUpperBound(arr, start+1, value);
	}
	public static void main(String[] args){
		int[] arr={1, 9, 9, 14, 5, 5, 3, 11, 3, 14, 12, 4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(linearLowerBound(arr, 0, 9));
		System.out.println(linearUpperBound(arr, 0, 9));
	}
}
