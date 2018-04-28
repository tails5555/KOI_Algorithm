package net.kang.divisior;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class Example02 {
	static Map<Integer, Integer> factorizate=new HashMap<Integer, Integer>();
	public static void factorization(int N, int d){
		if(N==1) return;
		if(N%d==0){
			if(factorizate.containsKey(d)){
				factorizate.put(d, factorizate.get(d)+1);
				factorization(N/d, d);
			}
			else{
				factorizate.put(d, 1);
				factorization(N/d, d);
			}
		}
		else{
			factorization(N, d+1);
		}
	}
	public static int pow(int x, int y){
		if(y==0) return 1;
		else if(y==1) return x;
		else return x*pow(x, y-1); 
	}
	public static int solution2(){
		int result=1;
		Iterator<Integer> factor=factorizate.keySet().iterator();
		while(factor.hasNext()){
			int temp=0;
			int key=(Integer)factor.next();
			for(int l=0;l<=factorizate.get(key);l++){
				temp+=pow(key, l);
			}
			result*=temp;
		}
		
		return result;
	}
	public static void main(String[] args){
		int n=40000000;
		long start=System.nanoTime();
		factorization(n, 2);
		// System.out.println(factorizate);
		System.out.println(solution2());
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
