package net.kang.illionaireConcert;
import java.util.Arrays;
/* Example03에서 최종적으로 도끼 형님의 수입을 빈지노의 수입과 나머지의 총합을 뺀 차이가 도끼와 빈지노의 차이보다 큰 경우를 고려하게 되는 문장을 추가하면
 * 실행하는 횟수가 대폭 줄어들게 되면서 탐색 공간을 줄이게 된다. 쉽게 생각하면 rest가 0보다 작은 경우라고 생각하면 되지 않을까 싶다.
 * Example01~04까지 비교를 하면서 이번에는 시간 복잡도를 줄이는 목표가 아닌 탐색 공간을 줄이는 연습을 해볼 수 있는 좋은 문제로 추천을 하고 넘어가도록 하자.
 * 또한 이처럼 탐색 공간을 줄이기 좋은 문제가 삼각 화단 문제로서 이 문제를 다시 복습해보는 기회를 가졌으면 좋겠다.
 */ 
public class Example04 {
	static int dok2=0;
	static int quiett=0;
	static int beenzino=0; // 세 사람을 도끼, 콰이엇, 빈지노로 생각하고 풀어보도록 하겠다. 셋이서 분배를 할 때 도끼와 빈지노의 차이가 최소로 되어야 한다.
	static int difference=Integer.MAX_VALUE;
	static int sum=0;
	static Integer[] earn1=new Integer[] {6, 4, 4, 4, 6, 9};
	static Integer[] earn2=new Integer[] {2, 10, 1};
	static Integer[] earn3=new Integer[] {1, 1, 1, 4, 6, 1, 1, 1, 1};
	static Integer[] earn4=new Integer[] {20, 1, 4, 76, 30, 68, 5};
	static Integer[] earn5=new Integer[] {78, 15, 74, 82, 78, 85, 3, 40, 44, 53};
	static Integer[] earn6=new Integer[] {94, 12, 18, 38, 79, 21, 38, 42, 56, 93, 94};
	static int searchCount=0;
	public static int sum(Integer[] earn, int index){
		if(index>=earn.length) return 0;
		else return earn[index]+sum(earn, index+1);
	}
	public static void solution(Integer[] earn, int index, int d, int q, int b){
		searchCount++;
		int rest=sum-(d+q+b);
		if(d+rest<q || q+rest<b || d-(b+rest)>difference) return;
		if(q>sum/2 || b>sum/3) return;
		if(index<earn.length){
			solution(earn, index+1, d+earn[index], q, b);
			solution(earn, index+1, d, q+earn[index], b);
			solution(earn, index+1, d, q, b+earn[index]);
		}
		else if((d>=q && q>=b) && ((d-b)>=1 && (d-b)<=difference)){
			difference=d-b;
			dok2=d;
			quiett=q;
			beenzino=b;
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn1, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn1, new IntegerComparator());
		solution(earn1, 0, 0, 0, 0);
		long end=System.nanoTime();
		System.out.println(Arrays.toString(earn1));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+3^6
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn2, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn2, new IntegerComparator());
		solution(earn2, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn2));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn3, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn3, new IntegerComparator());
		solution(earn3, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn3));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^9
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn4, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn4, new IntegerComparator());
		solution(earn4, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn4));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+...3^6+3^7
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn5, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn5, new IntegerComparator());
		solution(earn5, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn5));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^10
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		sum=sum(earn6, 0);
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn6, new IntegerComparator());
		solution(earn6, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn6));
		System.out.printf("sum : %d, difference : %d / [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", sum, difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^11
	}
}
