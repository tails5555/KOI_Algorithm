package net.kang.fishing.linear;

import java.util.Arrays;

public class Example01 {
	static int[] fond={3, 4, 5, 4, 2, 3, 5, 6, 3, 2, 1, 4};
	static int netSize=5;
	public static int solution0(){
		int[] areaPart=new int[fond.length-netSize+1];
		for(int k=0;k<areaPart.length;k++){
			for(int l=0;l<netSize;l++){
				areaPart[k]+=fond[k+l];
			}
		}
		int index=0, result=areaPart[0];
		for(int k=1;k<areaPart.length;k++){
			if(result<areaPart[k]){
				result=areaPart[k];
				index=k;
			}
		}
		return areaPart[index];
	}
	// 1번째 방법. 선형으로 탐색 연습.
	public static int solution1(){
		int[] areaPart=new int[fond.length-netSize+1];
		int[][] areaCheck=new int[fond.length-netSize+1][netSize];
		for(int k=0;k<areaPart.length;k++){
			areaCheck[k]=Arrays.copyOfRange(fond, k, k+5);
			for(int l=0;l<netSize;l++){
				areaPart[k]+=fond[k+l];
			}
		}
		int index=0, result=areaPart[0];
		for(int k=1;k<areaPart.length;k++){
			if(result<areaPart[k]){
				result=areaPart[k];
				index=k;
			}
		}
		System.out.println(Arrays.toString(areaCheck[index]));
		return areaPart[index];
	}
	
	// 2번째 방법. 이분할 탐색 연습.
	public static int binaryMaximum(int[] arr, int start, int end){
		if(start>=end) return arr[start];
		int middle=(start+end)/2;
		return Math.max(binaryMaximum(arr, start, middle), binaryMaximum(arr, middle+1, end));
	}
	public static int solution2(){
		int[] areaPart=new int[fond.length-netSize+1];
		for(int k=0;k<areaPart.length;k++){
			for(int l=0;l<netSize;l++){
				areaPart[k]+=fond[k+l];
			}
		}
		return binaryMaximum(areaPart, 0, areaPart.length-1);
	}
	public static void main(String[] args){
		long startOne=System.nanoTime();
		System.out.println(solution0());
		long endOne=System.nanoTime();
		System.out.println(Math.abs(startOne-endOne));
		long startTwo=System.nanoTime();
		System.out.println(solution2());
		long endTwo=System.nanoTime();
		System.out.println(Math.abs(startTwo-endTwo));
	}

}
