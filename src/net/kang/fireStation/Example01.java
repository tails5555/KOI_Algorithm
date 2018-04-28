package net.kang.fireStation;
import java.util.HashSet;
public class Example01 {
	static int[] pumpIndex=new int[] {0, 12, 50, 81};
	static int[] fireIndex=new int[] {0, 27, 73};
	static HashSet<Integer> pumpVisited=new HashSet<Integer>();
	static int result=Integer.MAX_VALUE;
	static int count=0;
	public static void solution(int fire, int pump, int pipe){
		count++;
		if(fire>=fireIndex.length-1){
			result=Math.min(result, pipe);
			return;
		}
		else{
			for(int k=1;k<=pumpIndex.length-1;k++){
				if(!pumpVisited.contains(k)){
					pumpVisited.add(k);
					pipe+=Math.abs(fireIndex[fire+1]-pumpIndex[k]);
					solution(fire+1, pump, pipe);
					pipe-=Math.abs(fireIndex[fire+1]-pumpIndex[k]);
					pumpVisited.remove(k);
				}
			}
		}
	}
	public static void main(String[] args){
		solution(0, 0, 0);
		System.out.println(result);
		System.out.println(count); // 시간 복잡도는 얼마나 될까? 소방차의 수를 f, 파이프의 수를 p라고 한다면... O(fp) 가 나오게 된다. 
	}
}
