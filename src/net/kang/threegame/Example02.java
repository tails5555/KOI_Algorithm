package net.kang.threegame;

import java.util.Arrays;

// 서비스 문제로 3의 배수를 손쉽게 찾는 알고리즘을 준비해봤다. 실제로 x%3=0을 하면 끝이지만, 실제로 우리가 생각한 시간과 컴퓨터가 이용하는 시간에 대해 계산을 해보는 기회를 가지도록 해서 작성을 해봤다.
public class Example02 {
	public static int digitSum(int value){
		if(value==0) return 0;
		return (value%10)+digitSum(value/10);
	}
	public static void main(String[] args){
		int[] a={Integer.MAX_VALUE, Integer.MAX_VALUE-1, Integer.MAX_VALUE-2, 12345, 3};
		System.out.println(Arrays.toString(a));
		for(int k=0;k<a.length;k++){
			System.out.printf("<<%d>>\n", a[k]);
			long startOne=System.nanoTime();
			System.out.println((a[k]%3==0));
			long endOne=System.nanoTime();
			System.out.println(endOne+"-"+startOne);
			System.out.println(endOne-startOne);
			
			long startTwo=System.nanoTime();
			System.out.println((digitSum(a[k])%3==0));
			long endTwo=System.nanoTime();
			System.out.println(endTwo+"-"+startTwo);
			System.out.println(endTwo-startTwo);
		}
	}
}
