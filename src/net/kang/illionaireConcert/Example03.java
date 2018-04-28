package net.kang.illionaireConcert;
import java.util.Arrays;
/* Example02���� �հ��� �������� ���ؼ� ����� �� �غ��� ���̴�. ����, ����, ���밡 ���� ������ �� �������� ����غ����� ����.
 * ���� ���� ������ ������ ������ ��� �������� �ȴٸ� �и� ���̾� ������ ���ͺ��� �۾ƾ� �ϴ� ���� ���������̴�.
 * ���� ���̾� ������ ������ ������ ��� �������� �ȴٸ� ������ ������ ���ͺ��� �۾ƾ� �Ѵٴ� ���� ������������ ������ �غ� �� �ְڴ�.
 * �̴� ���������� �ɷ����� ���� �ƴ϶� Ž�� �߿��� �ɷ����� Ž�� ������ �ּ�ȭ�ϴ� ���� ��ǥ�� �����ϸ� �ǰڴ�.
 */
public class Example03 {
	static int dok2=0;
	static int quiett=0;
	static int beenzino=0; // �� ����� ����, ���̾�, ������� �����ϰ� Ǯ����� �ϰڴ�. ���̼� �й踦 �� �� ������ �������� ���̰� �ּҷ� �Ǿ�� �Ѵ�.
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
		if(d+rest<q || q+rest<b){ // �� ���忡�� ������ �������� ���� ��쿡 ���̾����� ������, Ȥ�� ���̾��� �������� ������ �����뺸�� ������ ������ Ž���� �� �ʿ䰡 ���� �ȴ�.
			return;
		}
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
