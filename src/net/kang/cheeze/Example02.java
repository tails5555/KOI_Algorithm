package net.kang.cheeze;
import java.util.ArrayList;
// ������ Vertex�� �̿��ؼ� �ֺ��� 3�̻��� ��쿡�� �쿩�� ���ְ�, 2�̸� 0���� ���󺹱� ��Ű�� �˰����� �ۼ��غô�. �̷��Ե� �ϴ� ����� ���ڰ� ���� �ۼ������� �̰� �̿��ؼ� �����ϴ� ���� ����. ���� �ڵ�� ���� ��ư� �Ǿ� �־ �����ϴµ� ������ ��ٷӰ� ������ ���̴�.
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
		System.out.println(Math.abs(start-end)); // ������ �ɸ��� �ð��� ���� �پ���. �ð� ���⵵�� O(ġ���� ����*4����)
	}
}
