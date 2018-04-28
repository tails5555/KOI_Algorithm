package net.kang.binary;
// 아까에서 추가로 지난번에 파이썬 과제로 냈던 추가 과제를 되돌아서 여러 진수 별로 바꿔보는 연습을 해보자.
// 이를 사례로 해서 재귀 호출의 조건에 대해 생각을 해볼 필요가 있다. 
// 종료 조건인 n이 0인 경우와 이전 작업인 convert(n/decimal, decimal)을 볼 수 있고 현재 작업의 시점인 number[n%decimal]를 저장함으로서 만족.
// 이 문장의 최종 시간 복잡도는 진수를 결정하는 수를 D, 입력을 받는 수가 N일 때 log(D)N 만큼 반복을 하니 O(log n)이 되겠다.
public class Example01 {
	static char[] number={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'};
	public static String convert(int n, int decimal){
		if(n==0) return "";
		else return convert(n/decimal, decimal)+number[n%decimal];
	}
	public static String toBinary(int n){
		if(n==0) return "";
		else return toBinary(n/2)+n%2;
	}
	public static void main(String[] args){
		for(int k=2;k<=16;k++){
			System.out.printf("%s[%d]\n", convert(1234, k), k);
		}
		System.out.println(toBinary(16)+"[2]");
	}
}
