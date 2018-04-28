package net.kang.minimumSum;
import java.util.Arrays;
import java.util.HashSet;
// �� ������ ������ �� ����� �����̴�. ���߿� ��ȸ�� ��Ƽ� �ٽ� �����غ��� ��ȸ�� ���������� ����. �ʹ� ��ƴ� �̤�
public class Example01 {
	static int[][] arr1={
							{1, 5, 3},
							{2, 4, 7},
							{5, 3, 5}
						};
	static int[][] arr2={
							{2, 3, 2, 4, 6},
							{9, 2, 4, 6, 3},
							{3, 4, 6, 7, 2},
							{6, 2, 4, 6, 1},
							{1, 5, 7, 2, 5}
						};
	static int score=Integer.MAX_VALUE;
	static HashSet<Integer> visited=new HashSet<Integer>();
	public static void solution(int r, int value){
		System.out.println(visited+" "+value);
		if(value>score) return;
		if(r==arr1.length){
			if(value<score) score=value;
			return;
		}
		for(int k=0;k<arr1[0].length;k++){
			if(!visited.contains(k)){
				visited.add(k);
				solution(r+1, value+arr1[r][k]);
				visited.remove(k);
			}
		}
	}
	public static void main(String[] args){
		for(int k=0;k<arr1.length;k++){
			System.out.println(Arrays.toString(arr1[k]));
		}
		solution(0, 0);
		System.out.println(score);
	}
}
