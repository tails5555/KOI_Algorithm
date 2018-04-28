package net.kang.airplane;
import java.util.HashSet;
import java.util.Objects;
// ���� �𸣰ڴ� ���� �ٽ� ����
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
	static HashSet<Vertex> visitedList=new HashSet<Vertex>();
	static Vertex[] middleVertex={new Vertex(0, 0), new Vertex(10, 1000), new Vertex(20, 1000), new Vertex(30, 1000), new Vertex(40, 1000), new Vertex(5000, 5000), new Vertex(1000, 60), new Vertex(1000, 70), new Vertex(1000, 80), new Vertex(1000, 90), new Vertex(7000, 7000), new Vertex(10000, 10000)};
	static int answer=Integer.MAX_VALUE;
	static int use=2;
	static int count=0;
	public static int distance(Vertex v1, Vertex v2){
		return (int)Math.sqrt(Math.pow((double)v1.x-v2.x, 2)+Math.pow((double)v1.y-v2.y, 2));
	}
	public static void solution(int index, int useAble, int airline){ // ���⼭ �߿�� ���� �ϴ� ���� �������� ���� ������ ��쿡 ���ؼ� ����� �ؾ߰ڴ�. �׷��� ���ؼ��� ���²� ���� ����� ���̰� �� �κп� ���ؼ� ����� ����� �Ѵ�.
		if(airline>answer) return;
		count++;
		if(useAble==use){
			airline=Math.max(airline, distance(middleVertex[index], middleVertex[middleVertex.length-1])); // �̴� �߰� ������ ���� ������ ���ؼ� ����� ���ִ� �������� �� �� �ִ�. ���������� �߰�����, �߰������� ���������̸� ���ؼ� �� �� �ϳ��� �޾Ƽ� ������ ���ִ� �������� ���� �ǰڴ�.
			if(airline<answer) answer=airline;
			return;
		}
		for(int k=1;k<middleVertex.length-1;k++){
			if(!visitedList.contains(middleVertex[k])){
				visitedList.add(middleVertex[k]);
				System.out.println(visitedList);
				solution(k, useAble+1, Math.max(airline, distance(middleVertex[index], middleVertex[k]))); 
				visitedList.remove(middleVertex[k]);
			}
		}
	}
	public static void main(String[] args){
		visitedList.add(middleVertex[0]);
		solution(0, 0, 0); // �ð� ���⵵�� ����Ⱑ �߰��� ������ Ƚ���� ���� �޶�����. ����Ⱑ �߰��� ���ߴ� ������ ���� m, ������� ���� Ƚ���� n�̶�� ģ�ٸ�, ���� �ð� ���⵵�� O(m^n)���� �� �� �ִ�.
		System.out.println(Math.ceil(answer/10.0)); // ���� ����� ceil�� ��������� ����� �ùٸ��� ���´ٰ� �ұ�?
		System.out.println(count);
		
	}
}
