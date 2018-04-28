package net.kang.vendingMachine;

public class Example02 {
	static int hopeValue;
	public static int solution(int current, int count){
		System.out.println(current+" "+count);
		if(current>=hopeValue) return count;
		return (hopeValue-current)<1000 ? (hopeValue-current)<500 ? solution(current+100, count+1) : solution(current+500, count+1) : solution(current+1000, count+1);
	}
	public static void main(String[] args){
		int currentValue=200;
		hopeValue=2800;
		System.out.println(solution(currentValue, 0));
	}
}
