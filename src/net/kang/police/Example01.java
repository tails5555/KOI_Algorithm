package net.kang.police;
import java.util.Objects;
public class Example01 {
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
	static Vertex eventVertex1=new Vertex(3, 2);
	static Vertex eventVertex2=new Vertex(5, 4);
	static Vertex police1=new Vertex(1, 1);
	static Vertex police2=new Vertex(cityLength, cityLength);
	public static void main(String[] args){
		System.out.println("p1 to e1 -> "+(Math.abs(police1.x-eventVertex1.x)+Math.abs(police1.y-eventVertex1.y))); // 진짜 사건발생지점까지 최솟값은 이렇게 구해도 무방하다.
		System.out.println("p2 to e1 -> "+(Math.abs(police2.x-eventVertex1.x)+Math.abs(police2.y-eventVertex1.y)));
		System.out.println("p1 to e2 -> "+(Math.abs(police1.x-eventVertex2.x)+Math.abs(police1.y-eventVertex2.y))); // 진짜 사건발생지점까지 최솟값은 이렇게 구해도 무방하다.
		System.out.println("p2 to e2 -> "+(Math.abs(police2.x-eventVertex2.x)+Math.abs(police2.y-eventVertex2.y)));
	}
}
