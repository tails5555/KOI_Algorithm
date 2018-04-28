package net.kang.aircontroller;
import java.util.ArrayList;
// �� ������ ������� �غ��ϱ� ���Ͽ� vendingMachine ������ ���� â���ؼ� ���������� �����ϸ鼭 �����ϱ� �ٶ�鼭...
// �׸��� OverStackError�� ���Ͽ� ��θ� ������ ���� �Ұ����ϰ� �������� ������ ���� �����ڸ� �̿��ϴ� ����� ���ؼ��� ������ �صθ� �ð� ���⵵�� ���̰� ���� ������� Ǯ��� �� �ִ�.
public class Example01 {
	static ArrayList<Integer> result01=new ArrayList<Integer>();
	static ArrayList<Integer> result02=new ArrayList<Integer>();
	static int hT;
	// �ϴ� �µ��� �ܹ������� �ø� �� �ۿ� ���� ��Ȳ���� �ּڰ��� ������� �Ѵٸ� �̷��� �����ϴ�.
	public static int solution1(int cT, int count){
		result01.add(cT);
		if(cT<hT)
			return (hT-cT)<10 ? (hT-cT)<5 ? solution1(cT+1, count+1) : solution1(cT+5, count+1) : solution1(cT+10, count+1);
		else if(cT>hT)
			return (cT-hT)<10 ? (cT-hT)<5 ? solution1(cT-1, count+1) : solution1(cT-5, count+1) : solution1(cT-10, count+1);
		else return count;
	}
	// �׷��� ������ ��ư�� ��������μ� ������ �����ϱ� ������ �̷� ��쿡�� ������ �̿��ؼ� ���̸� �ٿ��� ����� �ϴµ� ������ �״�.
	public static int solution2(int cT, int count){
		result02.add(cT);
		int difference=Math.abs(cT-hT);
		if(difference>(5+10)/2)
			return (cT<hT) ? solution2(cT+10, count+1) : solution2(cT-10, count+1);
		else if(difference>(1+5)/2)
			return (cT<hT) ? solution2(cT+5, count+1) : solution2(cT-5, count+1);
		else if(difference>=1)
			return (cT<hT) ? solution2(cT+1, count+1) : solution2(cT-1, count+1);
		else return count;
	}
	public static ArrayList<Integer> button(ArrayList<Integer> list){
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int k=0;k<list.size()-1;k++){
			result.add(list.get(k+1)-list.get(k));
		}
		return result;
	}
	public static void main(String[] args){
		int cT=7;
		hT=35;
		System.out.println(solution1(cT, 0));
		System.out.println(solution2(cT, 0));
		System.out.println(result01);
		System.out.println(button(result01));
		System.out.println(result02);
		System.out.println(button(result02));
	}
}
