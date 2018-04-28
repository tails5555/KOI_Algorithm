package net.kang.aircontroller;
import java.util.ArrayList;
// 이 문제의 어려움을 극복하기 위하여 vendingMachine 문제를 새로 창조해서 만들어봤으니 공부하면서 참고하길 바라면서...
// 그리고 OverStackError로 인하여 모두를 돌리는 것이 불가능하게 느껴지기 때문에 삼항 연산자를 이용하는 방법에 대해서도 숙지를 해두면 시간 복잡도도 줄이고 좋은 방안으로 풀어나갈 수 있다.
public class Example01 {
	static ArrayList<Integer> result01=new ArrayList<Integer>();
	static ArrayList<Integer> result02=new ArrayList<Integer>();
	static int hT;
	// 일단 온도를 단방향으로 올릴 수 밖에 없는 상황에서 최솟값을 뽑으라고 한다면 이렇게 가능하다.
	public static int solution1(int cT, int count){
		result01.add(cT);
		if(cT<hT)
			return (hT-cT)<10 ? (hT-cT)<5 ? solution1(cT+1, count+1) : solution1(cT+5, count+1) : solution1(cT+10, count+1);
		else if(cT>hT)
			return (cT-hT)<10 ? (cT-hT)<5 ? solution1(cT-1, count+1) : solution1(cT-5, count+1) : solution1(cT-10, count+1);
		else return count;
	}
	// 그러나 실제로 버튼은 양방향으로서 조정이 가능하기 때문에 이런 경우에는 절댓값을 이용해서 차이를 줄여서 출력을 하는데 중점을 뒀다.
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
