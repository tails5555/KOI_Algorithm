package net.kang.officeTeacher;

import java.util.Arrays;

public class Example03 {
	static int[] dp=new int[1001];
	static int criminal=15;
	static int officer=1;
	static int[] ability={2, 5, 7};
	public static void solution(){
		for(int k=officer+1;k<=criminal;k++){
			dp[k]=12345678; // Integer.MAX_VALUE�� �Ѵٸ� ����ϴµ� ������ �ٰ����� �Ǿ� 12345678�� ��ü�Ͽ���.
		}
		for(int k=officer+1;k<=criminal;k++){
			int temp=12345678;
			for(int l=0;l<ability.length;l++){
				if(k>=officer+ability[l])
					temp=Math.min(temp, dp[k-ability[l]]+1);
			}
			dp[k]=temp;
		}
		if(dp[criminal]!=12345678) System.out.println(dp[criminal]);
		else System.out.println(-1);
	} // �̷��� �Ѵٸ� �Ʊ�� ��� �ð� ���⵵�� O(n*a)�� �����ðڴٸ� Queue�� Ǯ���� ��Ȱ� �޸� Ž�� ������ ũ�� ���� �� �־ �� ����� ���������� ���� ���� �ִ�.
	public static void main(String[] args){
		solution();
		System.out.println(Arrays.toString(Arrays.copyOfRange(dp, officer, criminal+1)));
	}
}
