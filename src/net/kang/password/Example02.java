package net.kang.password;
import java.util.LinkedList;
import java.util.Queue;
public class Example02 {
	static Queue<Character> q=new LinkedList<Character>();
	public static void rockNRoll(char[] arr){
		for(int k=0;k<arr.length;k++){
			q.add(arr[k]);
		}
	}
	public static void solution(int start, int part, char v){
		if(q.isEmpty()) return;
		if(v=='-'){
			q.remove();
			solution(start, part/2, q.peek());
			q.remove();
			solution(start+part/2, part/2, q.peek());
		}
		else{
			for(int k=start;k<start+part;k++){
				System.out.print(v);
			}
		}
	}
	public static void main(String[] args){
		String password1="0";
		rockNRoll(password1.toCharArray());
		solution(0, 4, q.peek());
		q.remove();
		System.out.println();
		String password2="1";
		rockNRoll(password2.toCharArray());
		solution(0, 4, q.peek());
		q.remove();
		System.out.println();
		String password3="-1-01";
		rockNRoll(password3.toCharArray());
		solution(0, 4, q.peek());
		q.remove();
		System.out.println();
		String password4="--01-1-01";
		rockNRoll(password4.toCharArray());
		solution(0, 8, q.peek());
		q.remove();
		
	}
}
