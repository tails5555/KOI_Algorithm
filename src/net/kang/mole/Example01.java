package net.kang.mole;

import java.util.Arrays;

// 이는 DFS를 일반적으로 재귀를 통해서 풀어봤다.
public class Example01 {
	static int[] moleScore;
	static int[][] moleCaves= {
			{  0, -1, -1,  0, -1,  0,  0,  0 },
			{  0, -1, -1,  0, -1,  0, -1,  0 },
			{ -1, -1, -1,  0, -1,  0, -1,  0 },
			{  0,  0,  0,  0, -1, -1, -1,  0 },
			{  0, -1,  0,  0,  0,  0,  0,  0 },
			{  0, -1, -1, -1, -1, -1,  0, -1 },
			{  0,  0,  0,  0,  0,  0, -1, -1 },// 문제에서는 구멍을 1로 작성하였지만, 여기선 -1로 대체해서 들어가보도록 하자.
		};
	public static boolean areaLimit(int x, int y){
		return (x>=0 && x<moleCaves.length) && (y>=0 && y<moleCaves[0].length); 
	}
	public static void DFSsearch(int x, int y, int setPoint){
		moleCaves[x][y]=setPoint;
		System.out.printf("[%d, %d] ", x, y);
		int[] dx={1, 0, -1, 0};
		int[] dy={0, 1, 0, -1};
		for(int k=0;k<dx.length;k++){
			if(areaLimit(x+dx[k], y+dy[k])){
				if(moleCaves[x+dx[k]][y+dy[k]]==-1) DFSsearch(x+dx[k], y+dy[k], setPoint);
			}
		}
	}
	public static void main(String[] args){
		int moleCount=1;
		for(int k=0;k<moleCaves.length;k++){
			for(int l=0;l<moleCaves[k].length;l++){
				if(moleCaves[k][l]==-1){
					DFSsearch(k, l, moleCount);
					System.out.println(moleCount);
					moleCount++;
				}
			}
		}
		moleScore=new int[moleCount];
		for(int k=0;k<moleCaves.length;k++){
			for(int l=0;l<moleCaves[k].length;l++){
				moleScore[moleCaves[k][l]]++;
			}
		}
		for(int k=0;k<moleCaves.length;k++){
			System.out.println(Arrays.toString(moleCaves[k]));
		}
		for(int k=1;k<moleScore.length;k++){
			System.out.println(moleScore[k]);
		}
	}
}
