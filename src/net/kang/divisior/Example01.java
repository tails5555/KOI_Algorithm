package net.kang.divisior;
public class Example01 {
	
	public static int solution1(int N){
		int result=0;
		for(int k=1;k<=N;k++){
			if(N%k==0){
				result+=k;
			}
		}
		return result;
	}
	public static void main(String[] args){
		int n=40000000;
		long start=System.nanoTime();
		System.out.println(solution1(n));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
