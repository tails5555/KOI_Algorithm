package net.kang.airplane;
import java.util.HashSet;
import java.util.Objects;
// 이 부분에서 왜 Max를 하는 걸까? 왜냐면 중간지점에서 중간지점까지 최댓값을 구해줘야지 나중에 최소로 필요한 기름통의 개수를 판단할 수 있기 때문이다. 앞서 ppt 자료에 이해하기 그려두겠다.
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
	static HashSet<Vertex> visitedList=new HashSet<Vertex>();
	static Vertex[] middleVertex={new Vertex(0, 0), new Vertex(10, 60), new Vertex(30, 90), new Vertex(50, 20), new Vertex(70, 80), new Vertex(90, 40), new Vertex(100, 100)}; // 숫자가 너무 광범위해져서 (0, 0)부터 (100, 100)까지 보폭을 줄여서 생각해보도록 하자.
	static int answer=Integer.MAX_VALUE;
	static int use=2;
	static int count=0;
	public static int distance(Vertex v1, Vertex v2){
		return (int)Math.sqrt(Math.pow((double)v1.x-v2.x, 2)+Math.pow((double)v1.y-v2.y, 2));
	}
	public static void solution(int index, int useAble, int airline){ // 여기서 중요시 봐야 하는 경우는 연료통의 수가 조금인 경우에 대해서 고려를 해야겠다. 그러기 위해서는 여태껏 구한 경로의 길이가 긴 부분에 대해서 고려를 해줘야 한다.
		if(airline>answer) return; // 이걸 붙이면 시간을 그나마 줄일 수 있으니 참고하도록 하자.
		count++;
		if(useAble==use){
			airline=Math.max(airline, distance(middleVertex[index], middleVertex[middleVertex.length-1])); // 이는 중간 정점과 도착 정점에 대해서 계산을 해주는 과정으로 볼 수 있다. 시작점에서 중간길이, 중간점에서 도착점길이를 비교해서 둘 중 하나를 받아서 저장을 해주는 과정으로 보면 되겠다.
			if(airline<answer) answer=airline;
			return;
		}
		for(int k=1;k<middleVertex.length-1;k++){
			if(!visitedList.contains(middleVertex[k])){
				visitedList.add(middleVertex[k]);
				solution(k, useAble+1, Math.max(airline, distance(middleVertex[index], middleVertex[k]))); 
				visitedList.remove(middleVertex[k]);
			}
		}
	}
	public static void main(String[] args){
		visitedList.add(middleVertex[0]);
		solution(0, 0, 0); // 시간 복잡도는 비행기가 중간에 착륙한 횟수에 따라서 달라진다. 비행기가 중간에 멈추는 정점의 수를 m, 비행기의 착륙 횟수를 n이라고 친다면, 최종 시간 복잡도는 O(m*n)으로 볼 수 있다.
		System.out.println(Math.ceil(answer/10.0)); // 최종 결과에 ceil를 때려줘야지 결과가 올바르게 나온다고 할까?
		System.out.println(count);
	}
}
