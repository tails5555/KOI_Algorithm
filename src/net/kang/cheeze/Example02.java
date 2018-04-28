package net.kang.cheeze;
import java.util.ArrayList;
// 오히려 Vertex를 이용해서 주변이 3이상인 경우에는 녹여서 없애고, 2이면 0으로 원상복귀 시키는 알고리즘을 작성해봤다. 이렇게도 하는 방법을 필자가 직접 작성했으니 이걸 이용해서 공부하는 것을 권장. 앞의 코드는 존나 어렵게 되어 있어서 공부하는데 오히려 까다롭게 느껴질 것이다.
public class Example02 {
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
	static class Vertex{
		int x;
		int y;
		public Vertex(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int[] dx={1, 0, -1, 0};
	static int[] dy={0, 1, 0, -1};
	public static boolean isInside(int x, int y){
		return (x>=0 && x<cheeze.length) && (y>=0 && y<cheeze[0].length);
	}
	public static ArrayList<Vertex> findOne(){
		ArrayList<Vertex> result=new ArrayList<Vertex>();
		for(int k=0;k<cheeze.length;k++){
			for(int l=0;l<cheeze.length;l++){
				if(cheeze[k][l]==1) result.add(new Vertex(k, l));
			}
		}
		return result;
	}
	public static void edgeChange(ArrayList<Vertex> oneVertex){
		for(Vertex v : oneVertex){
			for(int m=0;m<dx.length;m++){
				if(isInside(v.x+dx[m], v.y+dy[m])){
					if(cheeze[v.x+dx[m]][v.y+dy[m]]==0){
						cheeze[v.x][v.y]++;
					}
				}
			}	
		}
		for(Vertex v : oneVertex){
			if(cheeze[v.x][v.y]>=3) cheeze[v.x][v.y]=0; 
			else if(cheeze[v.x][v.y]==2) cheeze[v.x][v.y]=1;
		}
	}
	public static int solution(){
		int hour=0;
		while(!findOne().isEmpty()){
			edgeChange(findOne());
			hour++;
		}
		return hour;
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution());
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end)); // 심지어 걸리는 시간도 많이 줄어든다. 시간 복잡도는 O(치즈의 개수*4방향)
	}
}
