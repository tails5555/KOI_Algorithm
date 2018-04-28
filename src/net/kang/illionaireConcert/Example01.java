package net.kang.illionaireConcert;

import java.util.Arrays;
import java.util.Comparator;

class IntegerComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer i1, Integer i2){
		int difference=i1-i2;
		if(difference>0) return -1;
		else if(difference<0) return 1;
		else return 0;
	}
}
// 생각해보면 뭔가 허무한 코딩으로 봐서 시간 복잡도가 장난이 아닐 것으로 생각하고 있을 것이다. 3진으로 탐색을 하면 시간 복잡도가 O(n^3)이 나오는 것이 당연하지만, 비록 짧은 시간으로 줄여볼 수는 없을까? 이를 고려한 방법을 Example02, 03 등등에 정리를 했으니 참고하길 바라면서...
public class Example01 {
	static int dok2=0;
	static int quiett=0;
	static int beenzino=0; // 세 사람을 도끼, 콰이엇, 빈지노로 생각하고 풀어보도록 하겠다. 셋이서 분배를 할 때 도끼와 빈지노의 차이가 최소로 되어야 한다.
	static Integer[] earn1=new Integer[] {6, 4, 4, 4, 6, 9};
	static Integer[] earn2=new Integer[] {2, 10, 1};
	static Integer[] earn3=new Integer[] {1, 1, 1, 4, 6, 1, 1, 1, 1};
	static Integer[] earn4=new Integer[] {20, 1, 4, 76, 30, 68, 5};
	static Integer[] earn5=new Integer[] {78, 15, 74, 82, 78, 85, 3, 40, 44, 53};
	static Integer[] earn6=new Integer[] {94, 12, 18, 38, 79, 21, 38, 42, 56, 93, 94};
	static int searchCount=0;
	static int difference=0;
	public static void solution(Integer[] earn, int index, int d, int q, int b){
		searchCount++;
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
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn1, new IntegerComparator());
		solution(earn1, 0, 0, 0, 0);
		long end=System.nanoTime();
		System.out.println(Arrays.toString(earn1));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+3^6
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn2, new IntegerComparator());
		solution(earn2, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn2));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn3, new IntegerComparator());
		solution(earn3, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn3));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^9
		start=System.nanoTime();
		
		searchCount=0;
		difference=Integer.MAX_VALUE;
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn4, new IntegerComparator());
		solution(earn4, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn4));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+...3^6+3^7
		
		start=System.nanoTime();
		searchCount=0;
		difference=Integer.MAX_VALUE;
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn5, new IntegerComparator());
		solution(earn5, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn5));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^10
		
		start=System.nanoTime();
		searchCount=0;
		dok2=0;
		quiett=0;
		beenzino=0;
		Arrays.sort(earn6, new IntegerComparator());
		solution(earn6, 0, 0, 0, 0);
		end=System.nanoTime();
		System.out.println(Arrays.toString(earn6));
		System.out.printf("difference : %d, [Dok2 : %d / The Quiett : %d / Beenzino : %d]\n", difference, dok2, quiett, beenzino);
		System.out.println(Math.abs(start-end)+" / "+searchCount); // 1+3+3^2+3^3+3^4+3^5+...+3^11
	}
}
