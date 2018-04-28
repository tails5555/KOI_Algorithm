package net.kang.mole;

import java.util.Arrays;

// �̴� DFS�� �Ϲ������� ��͸� ���ؼ� Ǯ��ô�.
public class Example01 {
	static int[] moleScore;
	static int[][] moleCaves= {
			{  0, -1, -1,  0, -1,  0,  0,  0 },
			{  0, -1, -1,  0, -1,  0, -1,  0 },
			{ -1, -1, -1,  0, -1,  0, -1,  0 },
			{  0,  0,  0,  0, -1, -1, -1,  0 },
			{  0, -1,  0,  0,  0,  0,  0,  0 },
			{  0, -1, -1, -1, -1, -1,  0, -1 },
			{  0,  0,  0,  0,  0,  0, -1, -1 },// ���������� ������ 1�� �ۼ��Ͽ�����, ���⼱ -1�� ��ü�ؼ� �������� ����.
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
