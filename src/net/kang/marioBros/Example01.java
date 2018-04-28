package net.kang.marioBros;

import java.util.HashSet;
// 좀 어렵다. 일단 좀 읽어보고 공부를 해보도록 합니다... 아까 비행기처럼 그림을 그려보면서 간단하게 그려보면서 이해를 하는 것이 도움이 되지 않을까 싶구나...
public class Example01 {
	static class Jump{
		int index;
		int power;
		boolean use;
		public Jump(int index, int power, boolean use){
			this.index=index;
			this.power=power;
			this.use=use;
		}
	}
	static Jump[] island=new Jump[] {new Jump(0, 7, true), new Jump(3, 4, true), new Jump(6, 8, true), new Jump(8, 6, true), new Jump(12, 2, false), new Jump(13, 2, true), new Jump(14, 2, true), new Jump(15, 7, true)};
	static HashSet<Integer> visited=new HashSet<Integer>();
	public static boolean cMario(int mario, int index){
		return island[index].index<=island[mario].index+island[mario].power;
	}
	public static boolean cLuigi(int luigi, int index){
		return (island[index].index<=island[luigi].index+island[index].power) && island[index].use; 
	}
	public static int solution(int mario, int luigi, int index){
		int result=0;
		if(index>=island.length-1){
			if(cMario(mario, index) && cLuigi(luigi, index)) result=1;
			else result=0;
		}
		else{
			System.out.println(mario+" "+luigi+" "+index);
			if(cMario(mario, index)) result+=solution(index, luigi, index+1);
			if(cLuigi(luigi, index)) result+=solution(mario, index, index+1);
			result+=solution(mario, luigi, index+1);
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(solution(0, 0, 1));
	}
}
