package net.kang.cheeze;

import java.util.Arrays;
// �̰� �ſ� ��ƴ�. �̰� �ذ��ϸ� �˰��� õ�� �Ҹ� ��´�. �� �˰����� õõ�� �о�鼭 ������ ������ �н��� ����. �Ӹ������� �����ϸ鼭 ¥�⿡�� ���� ������ �ִ� ���̵� ����?
public class Example01 {
	/*
	static int[][] cheeze={
								{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
								{ 0, 0, 0, 1, 1, 0, 0, 0, 0 },
								{ 0, 0, 0, 1, 1, 0, 1, 1, 0 },
								{ 0, 0, 1, 1, 1, 1, 1, 1, 0 },
								{ 0, 0, 1, 1, 1, 1, 1, 0, 0 },
								{ 0, 0, 1, 1, 0, 1, 1, 0, 0 },
								{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
								{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }
							 };
							 */
	static int[][] cheeze={
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		 };
	static int[] dx={1, 0, -1, 0};
	static int[] dy={0, 1, 0, -1};
	public static boolean isInside(int x, int y){
		return (x>=0 && x<cheeze.length) && (y>=0 && y<cheeze[0].length);
	}
	public static boolean done(){
		int count=0;
		for(int k=0;k<cheeze.length;k++){
			for(int l=0;l<cheeze[k].length;l++){
				if(cheeze[k][l]==-1 || cheeze[k][l]>2) cheeze[k][l]=0;
				else if(cheeze[k][l]==2 || cheeze[k][l]==1){
					cheeze[k][l]=1;
					count++;
				}
			}
		}
		return count==0;
	}
	public static void solution(int x, int y){
		cheeze[x][y]=-1;
		for(int k=0;k<dx.length;k++){
			if(isInside(x+dx[k], y+dy[k])){
				if(cheeze[x+dx[k]][y+dy[k]]==0) solution(x+dx[k], y+dy[k]);
				else if(cheeze[x+dx[k]][y+dy[k]]>0) cheeze[x+dx[k]][y+dy[k]]++;
			}
		}
	}
	public static void main(String[] args){
		int hour;
		long start=System.nanoTime();
		for(hour=0;!done();hour++){
			solution(0, 0);
		}
		long end=System.nanoTime();
		System.out.println(hour);
		System.out.println(Math.abs(start-end));
	}
}
