package net.kang.goodSequence;

import java.util.Arrays;
// 음... 이건 좀 어려운 난이도라서 아마 나중에 생각해보고 풀어보도록 하자.
public class Example02 {
	static int n=10; // 자릿수를 판단하는 변수.
	static int[] goodSequence=new int[81];
	static boolean end=false;
	public static boolean same(int x, int y){
		int k;
		for(k=x;k<y;k++){
			if(goodSequence[k]!=goodSequence[k+y-x]) break;
		}
		return (x==y) ? false : (k==y);
	}
	public static boolean good(int m){
		for(int k=1;k<=m/2;k++){
			for(int l=1;l<=m-k;l++){
				if(same(l, l+k)) return false;
			}
		}
		return true;
	}
	public static void solution(int digit){ // 들어가기 앞서서 자리수를 입력받으면 그 자리만큼 모든 수열을 출력하는 프로그램을 만들어보자.
		if(end) return;
		if(digit>n){
			end=true;
			for(int k=1;k<=n;k++){
				System.out.print(goodSequence[k]);
			}
			return;
		}
		for(int k=1;k<=3;k++){
			goodSequence[digit]=k;
			if(good(digit)) solution(digit+1);
			goodSequence[digit]=0;
		}
	}
	public static void main(String[] args){
		solution(1);
	}
}
