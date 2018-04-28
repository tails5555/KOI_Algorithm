package net.kang.illionaireConcert;

import java.util.Arrays;
// 일단 탐색 공간을 줄이는 방법으로 빈지노 형님은 적어도 합계의 1/3 이하이고, 콰이엇 형님은 적어도 합계의 절반 이하일 것이다. 이를 접목해서 풀어보도록 하겠다.
// Example01처럼 반복문을 돌게 된다면 첫번째 상황에서 13, 10, 10이 나와버리는 아이러니한 현상이 발생하게 된다... 그래서 잘못된 부분을 수정하면 difference 비교할때 부등호를 바꿔주도록 하자...
// Example01에서 비교를 했을 경우에 시간 복잡도는 크게 차이가 없다. 다만 합계를 구하는 과정에서 시간이 더 걸리게 되는 상황을 생각해보면 오히려 이 과정을 접근하는 방안도 생각을 해보면 좋겠다는 생각...
public class Example02 {
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
