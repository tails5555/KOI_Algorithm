package net.kang.stairs;
public class Example02 {
	static int stairNum=4;
	static int count=0;
	public static int solution(int current){
		if(current>stairNum) return 0;
		if(current==stairNum){
			return 1;
		}
		return solution(current+1)+solution(current+2);
	}
	public static void main(String[] args){
		System.out.println(solution(0));
	}
}
