package net.kang.maximum.TwoDim;
import java.util.Random;
public class Example02 {
	static int[][] arr;
	static Random rand=new Random();
	public static void randArr(){
		for(int k=0;k<arr.length;k++){
			for(int l=0;l<arr[k].length;l++){
				arr[k][l]=rand.nextInt(100000000);
			}
		}
	}
	// 规过1
	public static int solution1(){
		int result=arr[0][0];
		for(int k=0;k<arr.length;k++){
			for(int l=0;l<arr[k].length;l++){
				if(result<arr[k][l]){
					result=arr[k][l];
				}
			}
		}
		return result;
	}
	// 规过2
	public static int[] squareArrays(int x){
		if(x==0){
			int[] temp={arr[0][0]};
			return temp;
		}
		else{
			int[] temp=new int[x*2+1];
			int count=0;
			for(int k=1;k<x+1;k++){
				temp[count]=arr[x][x-k];
				count++;
			}
			for(int k=1;k<x+1;k++){
				temp[count]=arr[x-k][x];
				count++;
			}
			temp[count]=arr[x][x];
			return temp;
		}		
	}
	public static int divideMaximum(int[] arr, int start, int end){
		if(start>=end) return arr[start];
		int middle=(start+end)/2;
		return Math.max(divideMaximum(arr, start, middle), divideMaximum(arr, middle+1, end));
	}
	public static void main(String[] args){
		arr=new int[1000][1000];
		randArr();
		
		long startOne=System.nanoTime();
		System.out.println(solution1());
		long endOne=System.nanoTime();
		System.out.println(Math.abs(startOne-endOne));
		
		long startTwo=System.nanoTime();
		int[] maximum=new int[arr.length];
		for(int k=0;k<arr.length;k++){
			maximum[k]=divideMaximum(squareArrays(k), 0, 2*k);
		}
		long endTwo=System.nanoTime();
		System.out.println(divideMaximum(maximum, 0, maximum.length-1));
		System.out.println(Math.abs(startTwo-endTwo));
		
		long startThree=System.nanoTime();
		int[] maximum2=new int[arr.length];
		for(int k=0;k<arr.length;k++){
			maximum2[k]=divideMaximum(arr[k], 0, arr.length-1);
		}
		long endThree=System.nanoTime();
		System.out.println(divideMaximum(maximum2, 0, maximum.length-1));
		System.out.println(Math.abs(startThree-endThree));
	}
}
