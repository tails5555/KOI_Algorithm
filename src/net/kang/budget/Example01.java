package net.kang.budget;

public class Example01 {
	static int[] activity={7, 13, 17, 19, 29, 31};
	static final int LIMITED=40;
	static int result=Integer.MIN_VALUE;
	static String maxList="";
	public static void solution(int actWeight, int index, String answer){
		if(index>=activity.length){
			if(actWeight<=LIMITED && result<actWeight){
				result=actWeight;
				maxList=answer;
			}
			return;
		}
		solution(actWeight+activity[index], index+1, answer+" "+activity[index]);
		solution(actWeight, index+1, answer);
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
