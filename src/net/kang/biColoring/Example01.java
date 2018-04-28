package net.kang.biColoring;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
// BFS로 풀어도 문제에 나와 있는 정답에 대해서만 풀이하는데 무리가 없지, 세번째 그래프에 대해서는 영... 그래서 이는 다음에 생각해보도록 한다.
public class Example01 {
	static final Color BLACK=new Color("BLACK");
	static final Color RED=new Color("RED");
	static final Color NONE=new Color("NONE");
	static class Color{
		String color;
		public Color(String color){
			this.color=color;
		}
		@Override
		public boolean equals(Object obj) {
			if((obj instanceof Color)==false) return false;
			Color c=(Color)obj;
			return this.color.equals(c.color);
		}
		@Override
		public String toString(){
			return String.format("[Color : %s]", this.color);
		}
	}
	static HashMap<Character, String> createGraph01(){
		HashMap<Character, String> graph=new HashMap<Character, String>();
		graph.put('1', "23");
		graph.put('2', "13");
		graph.put('3', "12");
		return graph;
	}
	static HashMap<Character, String> createGraph02(){
		HashMap<Character, String> graph=new HashMap<Character, String>();
		graph.put('가', "나다라마바사아자");
		graph.put('나', "가");
		graph.put('다', "가");
		graph.put('라', "가");
		graph.put('마', "가");
		graph.put('바', "가");
		graph.put('사', "가");
		graph.put('아', "가");
		graph.put('자', "가");
		return graph;
	}
	static HashMap<Character, String> createGraph03(){
		HashMap<Character, String> graph=new HashMap<Character, String>();
		graph.put('A', "BD");
		graph.put('B', "AC");
		graph.put('C', "BD");
		graph.put('D', "AC");
		return graph;
	}
	public static HashMap<Character, Color> paintBase(HashMap<Character, String> graph){
		HashMap<Character, Color> paint=new HashMap<>();
		Iterator<Character> vertexList=graph.keySet().iterator();
		while(vertexList.hasNext()){
			paint.put(vertexList.next(), NONE);
		}
		return paint;
	}
	public static boolean BFS(HashMap<Character, String> graph, char startVertex){
		HashSet<Character> visited=new HashSet<Character>();
		Queue<Character> nextList=new LinkedList<Character>();
		HashMap<Character, Color> paint=paintBase(graph);
		boolean isBicolor=true;
		visited.add(startVertex);
		nextList.add(startVertex);
		while(!nextList.isEmpty()){
			char current=nextList.remove();
			String adjectVertex=graph.get(current);
			if(paint.get(current).equals(NONE)){
				paint.put(current, RED);
			}
			System.out.println(current+" "+adjectVertex+" "+paint.get(current));
			for(char vertex : adjectVertex.toCharArray()){
				System.out.println(paint.get(vertex).equals(NONE)+" "+paint.get(vertex).equals(paint.get(current)));
				if(paint.get(vertex).equals(NONE)){
					if(!visited.contains(vertex)){
						paint.put(vertex, BLACK);
					}
					nextList.add(vertex);
					System.out.println(nextList);
				}
				else if(paint.get(vertex).equals(paint.get(current))){
					isBicolor=false;
					while(!nextList.isEmpty()) nextList.remove();
					System.out.println(nextList);
				}
				visited.add(vertex);
			}
			if(!isBicolor) break;
		}
		System.out.println(paint);
		return isBicolor;
	}
	public static void main(String[] args){
		System.out.println(BFS(createGraph01(), '1') ? "OK" : "IMPOSSIBLE");
		System.out.println(BFS(createGraph02(), '가') ? "OK" : "IMPOSSIBLE");
		System.out.println(BFS(createGraph03(), 'A') ? "OK" : "IMPOSSIBLE");
	}
}
