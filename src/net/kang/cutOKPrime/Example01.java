package net.kang.cutOKPrime;
import java.util.ArrayList;
public class Example01 {
	// 에라토스테네스 접근법과 일반적으로 소수를 나누는 경우를 고려할 수 있는데 에라토스테네스 접근법을 이용하게 되면 비록 고전적인 방안이지만, root 2로 줄여서 오히려 시간 복잡도를 그나마 반으로 줄일 수 있기 때문에 효율적으로 볼 수 있겠다.
	public static boolean isPrime(int x){
		if(x<2) return false;
		for(int k=2;k<=Math.sqrt(x);k++){ // 이 반복문에서 걸리는 시간은 O(root x)가 되는데 
			if(x%k==0) return false;
		}
		return true;
	}
	public static boolean isPrimeTwo(int x){ // 이렇게 반복을 하게 되면 시간 복잡도가 O(x)가 나오게 되어서 오히려 시간이 오래 걸릴 수 밖에 없기 때문에 에라토스테네스의 체를 이용한 방법에 대해서 고려를 할 필요가 있다.
		if(x<2) return false;
		for(int k=2;k<x;k++)
			if(x%k==0) return false;
		return true;
	}
	static int length=2;
	static ArrayList<Integer> result=new ArrayList<Integer>();
	public static void solution(int digitNum, int num){
		System.out.println(digitNum+" "+num);
		if(digitNum==length){
			if(num==0) return;
			int temp=num;
			while(temp!=0){
				if(!isPrime(temp)) return;
				temp/=10;
			}
			result.add(num);
		}
		else{
			for(int k=1;k<=9;k++){
				solution(digitNum+1, num*10+k); // 이게 0부터 숫자 자리까지 순차적으로 반복이 되니깐 어째 보면 비효율적이긴 하다... 그래서 소수라는 조건을 붙기 위해서는 일의 자리 숫자가 짝수가 아니어야 하고, 홀수 중에서 5여서도 절대로 안 된다는 조건을 붙여서 다시 작성해보면 시간의 차이를 느끼게 될 것이다.
			}
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		solution(0, 0);
		long end=System.nanoTime();
		System.out.println(result); // 시간 복잡도 : O(9^n * n * root x)
		System.out.println(Math.abs(start-end));
	}
}
