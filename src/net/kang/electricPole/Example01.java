package net.kang.electricPole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
/* 이 문제는 시각화를 통해서 LIS를 공부를 하는데 도움을 주는 문제라고 볼 수 있겠다.
 * LIS : Longest Increasin' Subsequence 최장증가부분수열에 대해서 알아두면 좋은 문제가 되겠다. 
 * LIS에 대해 자세한 개념에 대해서는 Example00에 서술해뒀으니 공부하면서 참고하면 도움이 크다.
 */
public class Example01 {
	static class Wire{
		int x;
		int y;
		public Wire(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString(){
			return String.format("[%d, %d]", this.x, this.y);
		}
	}
	static class WireStartComparator implements Comparator<Wire>{
		@Override
		public int compare(Wire w1, Wire w2){
			int dif=w1.x-w2.x;
			if(dif!=0) return dif;
			return w1.y-w2.y;
		}
	}
	static class WireEndComparator implements Comparator<Wire>{
		@Override
		public int compare(Wire w1, Wire w2){
			int dif=w1.y-w2.y;
			if(dif!=0) return dif;
			return w1.x-w2.y;
		}
	}
	static Wire[] wireList={new Wire(1, 8), new Wire(3, 9), new Wire(8, 11), new Wire(2, 2), new Wire(4, 1), new Wire(6, 4), new Wire(10, 10), new Wire(9, 7), new Wire(7, 6)};
	static int[] dp=new int[wireList.length];
	static ArrayList<Wire> answer=new ArrayList<Wire>();
	public static int solution(int k){
		int count=1;
		for(int a=k-1;a>=0;a--){
			if(wireList[a].y<wireList[k].y){
				count=Math.max(count, dp[a]+1); // count라는 결과는 어자피 1씩 올려줘야 되니깐 참고하면 되겠구나...
			}
		}
		dp[k]=count;
		return count;
	}
	public static void cutting(int index, int result){
		if(index==-1) return;
		if(dp[index]==result){
			cutting(index-1, result-1);
		}
		else{
			answer.add(wireList[index]);
			cutting(index-1, result);
		}
	}
	public static void main(String[] args){
		System.out.println(Arrays.toString(wireList));
		Arrays.sort(wireList, new WireStartComparator());
		System.out.println(Arrays.toString(wireList));
		int result=Integer.MIN_VALUE;
		for(int k=0;k<wireList.length;k++){
			int temp=solution(k);
			if(result<temp) result=temp;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(wireList.length-result); // 이 문제를 접근하는 좋은 방안으로서는 X에 대해서 우선적으로 정렬을 하고 난 후, Y에 대해서 직접적으로 LIS를 따져서 정답을 얻으면 된다.
		cutting(wireList.length-1, result);
		answer.sort(new WireStartComparator());
		System.out.println(answer);
	}
}
