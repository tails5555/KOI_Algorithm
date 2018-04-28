package net.kang.nqueen;
// n-queen 문제는 솔직히 많이 어려운 문제이다. 나중에 기회를 잡아서 풀어보도록 합니다.
import java.util.ArrayList;
import java.util.Arrays;
public class Example01 {
	static int[] qStay;
	static int size;
	static int count=0;
	static ArrayList<int[]> colCase=new ArrayList<int[]>();
	public static boolean confirm(int[] qStay, int row){
		for(int k=0;k<row;k++){
			if(qStay[k]==qStay[row]) return false; // Queen 말들이 같은 열에 있는 경우에는 무조건 false를 반환해야 한다.
			if(Math.abs(qStay[k]-qStay[row])==Math.abs(row-k)) return false; // Queen 말들이 다른 열에 있되 
		}
		return true;
	}
	public static void answer(int[] qStay, int row){
		int N=qStay.length;
		if(row==N){
			count++;
			int[] temp=Arrays.copyOf(qStay, qStay.length);
			colCase.add(temp);
		}
		else{
			System.out.printf("<<%d>>\n", row);
			for(int k=0;k<N;k++){
				System.out.println(row+" "+k);
				System.out.println(Arrays.toString(qStay));
				qStay[row]=k;
				if(confirm(qStay, row)) answer(qStay, row+1);
			}
		}
	}
	public static void main(String[] args){
		size=4;
		qStay=new int[size];
		answer(qStay, 0);
		System.out.println(count);
		for(int k=0;k<colCase.size();k++){
			System.out.println(Arrays.toString(colCase.get(k)));
		}
	}
}
