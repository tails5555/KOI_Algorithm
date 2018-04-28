package net.kang.mole;
import java.util.Arrays;
import java.util.Stack;
import java.util.HashSet;
import java.util.Objects;
//이는 DFS를 Stack 자료구조를 통해서 풀어봤다.
public class Example02 {
	static class Vertex{
		int x;
		int y;
		public Vertex(int x, int y){
			this.x=x;
			this.y=y;
		}
		public int getX(){
			return this.x;
		}
		public int getY(){
			return this.y;
		}
		@Override
		public boolean equals(Object obj) {
			if((obj instanceof Vertex)==false) return false;
			Vertex v=(Vertex)obj;
			return this.x==v.getX() && this.y==v.getY();
		}
		@Override
		public int hashCode(){
			return Objects.hash(x, y);
		}
		@Override
		public String toString(){
			return String.format("[%d, %d]", this.x, this.y);
		}
	}
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
		Stack<Vertex> nextList=new Stack<Vertex>();
		HashSet<Vertex> visitedList=new HashSet<Vertex>();
		nextList.push(new Vertex(x, y));
		visitedList.add(new Vertex(x, y));
		int[] dx={1, 0, -1, 0};
		int[] dy={0, 1, 0, -1};
		while(!nextList.isEmpty()){
			Vertex nextVer=nextList.pop();
			System.out.printf("[%d, %d] ", nextVer.getX(), nextVer.getY());
			moleCaves[nextVer.getX()][nextVer.getY()]=setPoint;
			for(int k=0;k<dx.length;k++){
				if(areaLimit(nextVer.getX()+dx[k], nextVer.getY()+dy[k])){
					if(moleCaves[nextVer.getX()+dx[k]][nextVer.getY()+dy[k]]==-1 && !visitedList.contains(new Vertex(nextVer.getX()+dx[k], nextVer.getY()+dy[k]))){
						nextList.push(new Vertex(nextVer.getX()+dx[k], nextVer.getY()+dy[k]));
						visitedList.add(new Vertex(nextVer.getX()+dx[k], nextVer.getY()+dy[k]));
					}
				}
			}
		}
		System.out.println(setPoint);
	}
	public static void main(String[] args){
		int moleCount=1;
		for(int k=0;k<moleCaves.length;k++){
			for(int l=0;l<moleCaves[k].length;l++){
				if(moleCaves[k][l]==-1){
					DFSsearch(k, l, moleCount);
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
