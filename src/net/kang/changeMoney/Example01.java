package net.kang.changeMoney;

public class Example01 {
	static int[] note={10, 50, 100, 500, 1000};
	static int result=Integer.MAX_VALUE;
	public static void solution(int current, int count){
		if(current<0) return;
		if(current==0){
			if(count<result) result=count;
			return;
		}
		for(int k=0;k<note.length;k++){
			solution(current-note[k], count+1);
		}
	}
	public static void main(String[] args){
		int balance=730;
		long start=System.nanoTime();
		solution(balance, 0); // 여기에 쓰이는 알고리즘은 그렇게 좋은 방안이 절대로 아니라고 본다. 굳이 이렇게까지 오랫동안 반복문을 돌리지 않더라도 효율적으로 계산을 할 수 있는 방법이 있는데 Example02를 참고해보길 바란다.
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(Math.abs(start-end));
	}
}
