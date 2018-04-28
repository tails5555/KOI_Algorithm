package net.kang.changeMoney;

public class Example02 {
	static int[] note={10, 50, 100, 500, 1000};
	public static int solution(int balance, int index, int count){
		if(balance<=0 || index<0) return count;
		return (balance<note[index]) ? solution(balance, index-1, count) : solution(balance-note[index], index, count+1);
	}
	public static void main(String[] args){
		int change=730;
		long start=System.nanoTime();
		int sol=solution(change, note.length-1, 0); // 이렇게 삼항 연산자를 이용해서 간략하게 짜는 방안으로서 시간을 엄청 단축시키게 되었다. 삼
		long end=System.nanoTime();
		System.out.println(sol);
		System.out.println(Math.abs(start-end));
	}
}
