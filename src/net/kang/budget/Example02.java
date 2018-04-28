package net.kang.budget;

public class Example02 {
	static int[] activity={7, 13, 17, 19, 29, 31};
	static boolean[] used={false, false, false, false, false, false};
	static final int LIMITED=40;
	static String maxList="";
	static int result=Integer.MIN_VALUE;
	public static void solution(int accActivity, int index, String answer){
		if(accActivity>LIMITED) return;
		used[index]=true; // 백트래킹을 시작하자.
		if(result<=accActivity){
			result=accActivity;
			maxList=answer;
		}
		for(int k=0;k<activity.length;k++){
			if(used[k]==false && accActivity!=k){
				solution(accActivity+activity[k], k, answer+" "+activity[k]);
			}
		}
		used[index]=false; // 백트래킹을 종료하자.
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		String answer="";
		solution(0, 0, answer);
		long end=System.nanoTime();
		System.out.println(result);
		System.out.println(maxList);
		System.out.println(Math.abs(start-end));
	}
}
