package net.kang.fishing.square;

import java.util.Arrays;

public class Example01 {
	static int[][] fond= { 
						   { 2, 4, 3, 2, 4, 5, 2 }, 
						   { 9, 5, 1, 4, 1, 2, 8 }, 
					       { 4, 3, 7, 4, 7, 3, 4 }, 
					       { 5, 6, 2, 1, 6, 7, 1 } 
					     };
	static int netWidth=3;
	static int netHeight=2;
	public static int solution1(){
		int index1=0, index2=0;
		int[][] areaPart=new int[fond.length-netHeight+1][fond[0].length-netWidth+1];
		int maximum=0;
		for(int k=0;k<areaPart.length;k++){
			for(int l=0;l<areaPart[k].length;l++){
				for(int m=0;m<netHeight;m++){
					for(int n=0;n<netWidth;n++){
						areaPart[k][l]+=fond[k+m][l+n];
					}
				}
				if(maximum<areaPart[k][l]){
					maximum=areaPart[k][l];
					index1=k;
					index2=l;
				}
			}
		}
		/*
		for(int k=0;k<areaPart.length;k++){
			System.out.println(Arrays.toString(areaPart[k]));
		}
		for(int k=index1;k<index1+netHeight;k++){
			for(int l=index2;l<index2+netWidth;l++){
				System.out.print(fond[k][l]+" ");
			}
			System.out.println();
		}
		*/
		return maximum;
	}
	public static int solution2(){
		int[][] areaPart=new int[fond.length-netHeight+1][fond[0].length-netWidth+1];
		for(int k=0;k<areaPart.length;k++){
			for(int l=0;l<areaPart[k].length;l++){
				for(int m=0;m<netHeight;m++){
					for(int n=0;n<netWidth;n++){
						areaPart[k][l]+=fond[k+m][l+n];
					}
				}
			}
		}
		return searchMaximum(areaPart);
	}
	public static int searchMaximum(int[][] arr){
		int[] temp=new int[arr.length];
		for(int k=0;k<arr.length;k++){
			temp[k]=binaryMaximum(arr[k], 0, arr[k].length-1);
		}
		return binaryMaximum(temp, 0, temp.length-1);
	}
	public static int binaryMaximum(int[] arr, int start, int end){
		if(start>=end) return arr[start];
		int middle=(start+end)/2;
		return Math.max(binaryMaximum(arr, start, middle), binaryMaximum(arr, middle+1, end));
	}
	public static void main(String[] args){
		long startOne=System.nanoTime();
		System.out.println(solution1());
		long endOne=System.nanoTime();
		System.out.println(Math.abs(startOne-endOne));
		long startTwo=System.nanoTime();
		System.out.println(solution2());
		long endTwo=System.nanoTime();
		System.out.println(Math.abs(startTwo-endTwo));
	}
}
