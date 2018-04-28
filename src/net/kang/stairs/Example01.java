package net.kang.stairs;
public class Example01 {
	static int stairNum=4;
	static int count=0;
	public static void solution(int current){
		if(current>stairNum) return;
		if(current==stairNum){
			++count;
			return;
		}
		solution(current+1);
		solution(current+2);
	}
	public static void main(String[] args){
		solution(0);
		System.out.println(count);
	}
}
