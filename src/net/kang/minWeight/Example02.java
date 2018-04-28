package net.kang.minWeight;

import java.util.HashMap;
import java.util.Stack;
public class Example02 {
	static class Vertex{
		String title;
		Edge[] edges;
		public Vertex(String title){
			this.title=title;
			this.edges=new Edge[0];
		}
		@Override
		public boolean equals(Object obj) {
			if((obj instanceof Vertex)==false) return false;
			Vertex v=(Vertex)obj;
			return this.title.equals(v.title);
		}
	}
	static class Edge{
		int weight;
		Vertex vertex;
		public Edge(int weight, Vertex vertex){
			this.weight=weight;
			this.vertex=vertex;
		}
	}
	static Vertex[] createVertex(){
		Vertex[] V=new Vertex[]{ new Vertex("1"), new Vertex("2"), new Vertex("3"), new Vertex("4"), new Vertex("5"), new Vertex("6"), new Vertex("7")};
		V[0].edges=new Edge[]{ new Edge(47, V[1]), new Edge(69, V[2])};
		V[1].edges=new Edge[]{ new Edge(47, V[0]), new Edge(57, V[3]), new Edge(124, V[4])};
		V[2].edges=new Edge[]{ new Edge(69, V[0]), new Edge(37, V[3]), new Edge(59, V[4]), new Edge(86, V[5])};
		V[3].edges=new Edge[]{ new Edge(57, V[1]), new Edge(37, V[2]), new Edge(27, V[5]), new Edge(94, V[6])};
		V[4].edges=new Edge[]{ new Edge(124, V[1]), new Edge(59, V[2]), new Edge(21, V[6])};
		V[5].edges=new Edge[]{ new Edge(86, V[2]), new Edge(27, V[3]), new Edge(40, V[6]) };
		V[6].edges=new Edge[]{ new Edge(94, V[3]), new Edge(21, V[4]), new Edge(40, V[5]) };
		return V;
	}
	static Vertex[] graph;
	static HashMap<String, Integer> sum=new HashMap<String, Integer>();
	public static int minimumWeight(Stack<Vertex> nextVertex, Vertex start, Vertex end){
		if(sum.get(start.title+end.title)!=null) return sum.get(start.title+end.title);
		if(start.equals(end)) return 0;
		int result=Integer.MAX_VALUE;
		nextVertex.add(start);
		for(Edge e : start.edges){
			if(!nextVertex.contains(e.vertex)){
				int accWeight=e.weight+minimumWeight(nextVertex, e.vertex, end);
				if(result>accWeight) result=accWeight;
			}
		}
		nextVertex.pop();
		sum.put(start.title+end.title, result);
		System.out.printf("%s에서 %s까지 %d만큼 이동\n", start.title, end.title, result);
		return result;
	}
	public static void main(String[] args){
		graph=createVertex();
		System.out.println(minimumWeight(new Stack<Vertex>(), graph[0], graph[graph.length-1]));
	}
}
