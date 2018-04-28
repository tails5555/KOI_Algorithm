package net.kang.backpack;

import java.util.Arrays;

public class Example03 {
	static class Gem{
		int mass; // 질량
		int value; // 값어치
		public Gem(int mass, int value){
			this.mass=mass;
			this.value=value;
		}
		@Override
		public String toString(){
			return String.format("Gem[%dkg, %d$]", this.mass, this.value);
		}
	}
	static Gem[] list={new Gem(2, 3), new Gem(1, 2), new Gem(3, 3), new Gem(2, 2), new Gem(5, 6)};
	static int bpLimit=5;
	static int[][] dp=new int[list.length+1][bpLimit+1];
	public static int solution(){
		for(int k=1;k<=list.length;k++){
			for(int l=1;l<=bpLimit;l++){
				if(list[k-1].mass>l) dp[k][l]=dp[k-1][l];
				else dp[k][l]=Math.max(dp[k-1][l], dp[k-1][l-list[k-1].mass]+list[k-1].value);
			}
		}
		return dp[list.length][bpLimit];
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution());
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
		for(int k=0;k<dp.length;k++){
			System.out.println(Arrays.toString(dp[k]));
		}
	}
}
