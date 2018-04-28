package net.kang.threegame;

import java.util.Arrays;

// ���� ������ 3�� ����� �ս��� ã�� �˰����� �غ��غô�. ������ x%3=0�� �ϸ� ��������, ������ �츮�� ������ �ð��� ��ǻ�Ͱ� �̿��ϴ� �ð��� ���� ����� �غ��� ��ȸ�� �������� �ؼ� �ۼ��� �غô�.
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
