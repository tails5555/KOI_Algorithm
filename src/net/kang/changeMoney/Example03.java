package net.kang.changeMoney;

public class Example03 {
	static int[] note={10, 50, 100, 500, 1000};
	static int answer=0;
	static int change=730;
	public static void solution(int accBalance, int index, int count){
		if(index==note.length || accBalance>change) return;
		else if(accBalance==change){
			if(count<answer) answer=count;
			return;
		}
		for(int k=0;accBalance+note[index]*k<=change;k++){
			solution(accBalance+note[index]*k, index+1, count+1);
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(0, 0, 0); // 물론 아까 Example02보다 효율성은 떨어지게 되지만, 아까는 오로지 최솟값만을 따지는 알고리즘으로 작성을 했는데, 이렇게 한다면 전체의 경우들 중에서 최솟값을 발굴을 하는 목적이기 때문에 이러한 알고리즘도 고려해볼 필요가 있다.
		long end=System.nanoTime();
		System.out.println(answer);
		System.out.println(Math.abs(start-end));
	}
}
