package net.kang.cutOKPrime;
import java.util.ArrayList;
public class Example02 {
	public static boolean isPrime(int x){
		if(x<2) return false;
		for(int k=2;k<=Math.sqrt(x);k++){ // 이 반복문에서 걸리는 시간은 O(root x)가 되는데 
			if(x%k==0) return false;
		}
		return true;
	}
	static int length=2;
	static ArrayList<Integer> result=new ArrayList<Integer>();
	public static void solution(int digitNum, int num){
		System.out.println(digitNum+" "+num);
		if(digitNum==length){
			if(isPrime(num)){
				result.add(num);
			}
		}
		else{
			if(isPrime(num)){
				solution(digitNum+1, num*10+1);
				solution(digitNum+1, num*10+3);
				solution(digitNum+1, num*10+7);
				solution(digitNum+1, num*10+9); // 그리고 마찬가지로 1의 숫자는 1, 3, 7, 9 중에서 소수를 골라내는 것이 관건이기 때문에 이렇게 계산을 해주면 오히려 아까보다 더욱 빠르게 계산이 가능하다.
			}
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(1, 2);
		solution(1, 3);
		solution(1, 5);
		solution(1, 7); // 어자피 십의 자리 수에서 소수가 될려면 2, 3, 5, 7가 전부다. 그래서 굳이 여러 개의 숫자를 볼 필요가 없이 2, 3, 5, 7로만 비교를 때려주면 된다.
		long end=System.nanoTime();
		System.out.println(result); // 시간 복잡도 : O(4^n * root x)
		System.out.println(Math.abs(start-end));
	}
}
