package net.kang.police;
import java.util.Objects;
import java.util.ArrayList;
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
	static int cityLength=6;
	static Vertex[] eventVertex={new Vertex(3, 5), new Vertex(5, 5), new Vertex(2, 3)};
	static Vertex police1=new Vertex(1, 1);
	static Vertex police2=new Vertex(cityLength, cityLength);
	static ArrayList<Vertex> police1Route=new ArrayList<Vertex>();
	static ArrayList<Vertex> police2Route=new ArrayList<Vertex>();
	static String forceList="";
	public static int distance(Vertex police, Vertex event){
		return Math.abs(police.x-event.x)+Math.abs(police.y-event.y);
	}
	public static int solution(int index, int result, String police){
		if(index>=eventVertex.length) return result;
		int distance1=distance(police1, eventVertex[index]);
		int distance2=distance(police2, eventVertex[index]);
		result+=Math.min(distance1, distance2);
		if(distance1<distance2){
			police1=eventVertex[index];
			police1Route.add(police1);
			forceList+="police1 ";
		}
		else{
			police2=eventVertex[index];
			police2Route.add(police2);
			forceList+="police2 ";
		}
		return solution(index+1, result, forceList);
	}
	public static void main(String[] args){
		int sol=solution(0, 0, "");
		System.out.println(sol);
		System.out.println("police1 Event -> "+police1Route);
		System.out.println("police2 Event -> "+police2Route);
		System.out.println(forceList);
	}
}
