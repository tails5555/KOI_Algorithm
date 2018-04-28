package net.kang.maze;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.LinkedList;
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
	static char[][] maze={
							{ '#', '#', '#', 'S', '#', '#', 'G', '#' }, 
							{ '#', '*', '*', '*', '*', '#', '*', '#' },
							{ '#', '#', '*', '#', '#', '#', '*', '#' },
							{ '#', '*', '*', '*', '#', '#', '*', '#' },
							{ '#', '*', '#', '#', '*', '*', '*', '#' },
							{ '#', '*', '#', '*', '*', '#', '*', '#' },
							{ '#', '*', '*', '*', '*', '#', '*', '#' },
							{ '#', '#', '#', '#', '#', '#', '#', '#' }
						 };
	static int[][] visitedRoute=new int[maze.length][maze.length];
	static Vertex goalVertex;
	public static Vertex findStart(){
		for(int k=0;k<maze.length;k++){
			for(int l=0;l<maze[k].length;l++){
				if(maze[k][l]=='S') return new Vertex(k, l);
			}
		}
		return new Vertex(0, 0);
	}
	public static Vertex findGoal(){
		for(int k=0;k<maze.length;k++){
			for(int l=0;l<maze[k].length;l++){
				if(maze[k][l]=='G'){
					maze[k][l]='*';
					return new Vertex(k, l);
				}
			}
		}
		return new Vertex(maze.length-1, maze[0].length-1);
	}
	public static boolean areaLimit(int x, int y){
		return ((x>=0) && (x<maze.length)) && ((y>=0) && (y<maze[0].length));
	}
	public static int findRoute(){
		Vertex startVertex=findStart();
		goalVertex=findGoal();
		int[] dx={1, 0, -1, 0};
		int[] dy={0, 1, 0, -1};
		HashSet<Vertex> visitedList=new HashSet<Vertex>();
		Queue<Vertex> nextList=new LinkedList<Vertex>();
		visitedList.add(startVertex);
		nextList.add(startVertex);
		while(!nextList.isEmpty()){
			Vertex nextVertex=nextList.remove();
			if(goalVertex.equals(nextVertex)) break;
			for(int k=0;k<dx.length;k++){
				if(areaLimit(nextVertex.getX()+dx[k], nextVertex.getY()+dy[k])){
					if(maze[nextVertex.getX()+dx[k]][nextVertex.getY()+dy[k]]=='*' && !visitedList.contains(new Vertex(nextVertex.getX()+dx[k], nextVertex.getY()+dy[k]))){
						visitedRoute[nextVertex.getX()+dx[k]][nextVertex.getY()+dy[k]]=visitedRoute[nextVertex.getX()][nextVertex.getY()]+1;
						visitedList.add(new Vertex(nextVertex.getX()+dx[k], nextVertex.getY()+dy[k]));
						nextList.add(new Vertex(nextVertex.getX()+dx[k], nextVertex.getY()+dy[k]));
					}
				}
			}
		}
		return visitedRoute[goalVertex.getX()][goalVertex.getY()];
	}
	static boolean minRoutePrint(int x, int y) {
        if (findStart().equals(new Vertex(x, y))) {
            System.out.printf("%s ", new Vertex(x, y));
            return true;
        }
        int beforeScore = visitedRoute[x][y] - 1;
        int[] dx={1, 0, -1, 0};
		int[] dy={0, 1, 0, -1};
		for(int k=0;k<dx.length;k++){
			if ((areaLimit(x+dx[k], y+dy[k]) && visitedRoute[x+dx[k]][y+dy[k]] == beforeScore && minRoutePrint(x+dx[k], y+dy[k]))){
				System.out.printf("[%d, %d] ", x, y);
				return true;
			}
        }
        return false;
    }
	public static void main(String[] args){
		for(int k=0;k<maze.length;k++){
			for(int l=0;l<maze[k].length;l++){
				System.out.printf("%c", maze[k][l]);
			}
			System.out.println();
		}
		System.out.println(findRoute());
		for(int k=0;k<visitedRoute.length;k++){
			System.out.println(Arrays.toString(visitedRoute[k]));
		}
		minRoutePrint(goalVertex.getX(), goalVertex.getY());
	}
}
