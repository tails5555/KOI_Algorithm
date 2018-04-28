package net.kang.linearSearch;

public class Example01 {
	public static int linearSearch(int[] arr, int value){
		for(int k=0;k<arr.length;k++){
			if(arr[k]==value) return k;
		}
		return -1;
	}
	public static int binarySearch(int[] arr, int start, int end, int value){
		int middle=(start+end)/2;
		if(arr[middle]==value) return middle;
		else if(value>arr[middle]) return binarySearch(arr, middle+1, end, value);
		else return binarySearch(arr, start, middle-1, value);
	}
	public static void main(String[] args){
		int[] arr={5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
		for(int k=0;k<arr.length;k++){
			int findValue=5*(k+1);
			System.out.printf("<<%d>>\n", findValue);
			long startOne=System.nanoTime();
			System.out.print(linearSearch(arr, findValue));
			long endOne=System.nanoTime();
			System.out.println(" "+Math.abs(startOne-endOne));
			long startTwo=System.nanoTime();
			System.out.print(binarySearch(arr, 0, arr.length-1, findValue));
			long endTwo=System.nanoTime();
			System.out.println(" "+Math.abs(startTwo-endTwo));
		}	
	}
}
