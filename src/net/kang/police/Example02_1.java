package net.kang.police;
import java.util.ArrayList;
import java.util.Scanner;
public class Example02_1 {
	static class Vertex{
		int x;
		int y;
		public Vertex(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	static int cityLength;
	static Vertex[] eventVertex;
	static Vertex police1, police2;
	static ArrayList<Integer> force=new ArrayList<Integer>();
	public static int distance(Vertex police, Vertex event){
		return Math.abs(police.x-event.x)+Math.abs(police.y-event.y);
	}
	public static int solution(int index, int result){
		if(index>=eventVertex.length) return result;
		int distance1=distance(police1, eventVertex[index]);
		int distance2=distance(police2, eventVertex[index]);
		result+=Math.min(distance1, distance2);
		if(distance1<=distance2){
			police1=eventVertex[index];
			force.add(1);
		}
		else{
			police2=eventVertex[index];
			force.add(2);
		}
		return solution(index+1, result);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		cityLength=sc.nextInt();
		int eventNum=sc.nextInt();
		eventVertex=new Vertex[eventNum];
		for(int k=0;k<eventVertex.length;k++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			eventVertex[k]=new Vertex(x, y);
		}
		police1=new Vertex(1, 1);
		police2=new Vertex(cityLength, cityLength);
		System.out.println(solution(0, 0));
		for(int k : force){
			System.out.println(k);
		}
	}
}
