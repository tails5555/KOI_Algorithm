package net.kang.officeTeacher;
// �ǿܷ� ��ü Ž������ �̿��Ѵٸ� �״� ����� �ʰ� ������ ������ ���̴�. 
/* criminal�� 15�̸�, 1+7+7
 * criminal�� 16�̸�, 1+5+5+5
 * criminal�� 17�̸�, 1+7+7+2
 * criminal�� 18�̸�, 1+7+5+5
 * criminal�� 19�̸�, 1+7+7+2+2
 * criminal�� 20�̸�, 1+7+7+5
 * criminal�� 21�̸�, 1+5+5+5+5
 * criminal�� 22�̸�, 1+7+7+7
 */
public class Example01 {
	static int[] ability={2, 5, 7};
	static int criminal=15;
	static int answer=Integer.MAX_VALUE;
	public static void solution(int next, int count){
		if(next>criminal) return;
		if(next==criminal){
			if(count<answer) answer=count;
		}
		for(int k=0;k<ability.length;k++){
			solution(next+ability[k], count+1);
		}
	}
	public static void main(String[] args){
		solution(1, 0);
		if(answer!=Integer.MAX_VALUE)
			System.out.println(answer); // �㳪 �̷��� ���ϰ� �ȴٸ� �ð� ���⵵�� O(3^n)�� ���ͼ� ������ ���̰� �ȴ�. �̸� DP�� �̿��ؼ� ó���� �غ��� ������ ������. �׸��� DP�� �̿��Ͽ� ���� ����ϴ� �ͱ��� �����غ���.
		else
			System.out.println(-1);
	}
}
