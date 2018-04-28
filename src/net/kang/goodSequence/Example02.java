package net.kang.goodSequence;

import java.util.Arrays;
// ��... �̰� �� ����� ���̵��� �Ƹ� ���߿� �����غ��� Ǯ����� ����.
public class Example02 {
	static int n=10; // �ڸ����� �Ǵ��ϴ� ����.
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
	public static void solution(int digit){ // ���� �ռ��� �ڸ����� �Է¹����� �� �ڸ���ŭ ��� ������ ����ϴ� ���α׷��� ������.
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
