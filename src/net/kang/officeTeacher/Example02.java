package net.kang.officeTeacher;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Example02 {
	static int[] ability={2, 5, 7};
	static int[] dp=new int[1001];
	static int officer=1;
	static int criminal=39;
	static int answer=Integer.MAX_VALUE;
	public static void solution(){
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(officer);
		while(!q.isEmpty()){
			int value=q.remove();
			if(value==criminal){
				answer=dp[value];
				System.out.println(dp[value]);
				return;
			}
			for(int k=0;k<ability.length;k++){
				q.add(ability[k]+value);
				if(ability[k]+value<=criminal && dp[ability[k]+value]==0)	
					dp[value+ability[k]]=dp[value]+1;
			}
		}
		answer=-1;
		System.out.println(-1);
	} // �ð� ���⵵�� ability.length�� a��� ġ��, ������ �Ÿ��� n���� ģ�ٸ� O(a*n)�� �ǽðڴ�.
	public static boolean print(int criminal, int second){ // ���������� ����� ������ ���鸸 �۵��� �ȴ�.
		if(second==-1){
			System.out.println("��ºҰ�");
			return true;
		}
		if(second==0 && criminal==officer) return true;
		for(int k=0;k<ability.length;k++){
			int beforeOfficer=criminal-ability[k];
			if(beforeOfficer>=0 && dp[beforeOfficer]==second-1 && print(beforeOfficer, second-1)){
				System.out.println(ability[k]);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		solution();
		System.out.println(Arrays.toString(Arrays.copyOfRange(dp, officer, criminal+1)));
		print(criminal, answer);
	}
}
