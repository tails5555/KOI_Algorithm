package net.kang.triangle;
public class Example01 {
	public static int solution1(int round){
		int result=0;
		for(int a=1;a<=round;a++){
			for(int b=a;b<=round;b++){
				for(int c=b;c<=round;c++){
					if(a+b+c==round && (a+b)>c) result++; // �������� �־��� ���� �� ���� ���� 9�̰�, �ﰢ���� ���� �������μ��� �� ���� ������ ���� �� ���� ���̺��� ������ Ŀ�� �Ѵٴ� �������� ���ϸ� �̷��� ���� �� �ִ�. �׷��� �ð� ���⵵�� �峭�� �ƴϴ�.
				}
			}
		}
		return result;
	}
	static int count=0;
	static int[][][] arr=new int[21][21][21];
	public static void solution2(int a, int b, int c, int round){
		if(a+b+c==round){
			if(a<=b && b<=c && (a+b)>c && arr[a][b][c]==0){
				count++;
				arr[a][b][c]=1;
			}
			return;
		}
		solution2(a+1, b, c, round);
		solution2(a, b+1, c, round);
		solution2(a, b, c+1, round);
	}
	
	public static int solution3(int round){ // �ﰢ���� �����Ǳ� ���� ���� ������ ���Ͽ� �ð� ���⵵�� O(n3)���� O(n2)�� ������ �ϴ� ����� �ִ�. �̴� ���������� ������ �ϴ� ���� �߿��� ������ �Ǵ��� �Ǵ� �����ϸ鼭 ���� �ϵ��� ����.
		int result=0;
		for(int a=round/3;a<=round/2;a++){ // ���� �� ��
			for(int b=1;b<=round/3;b++){ // ���� ª�� ��
				int c=round-(a+b);
				if((b+c)>a && (b<=c && c<=a)) result++;
			}
		}
		return result;
	}
	public static void main(String[] args){
		long startOne=System.nanoTime();
		System.out.println(solution1(18));
		long endOne=System.nanoTime();
		System.out.println(Math.abs(startOne-endOne));
		long startTwo=System.nanoTime();
		solution2(1, 1, 1, 18);
		System.out.println(count);
		long endTwo=System.nanoTime();
		System.out.println(Math.abs(startTwo-endTwo));
		long startThree=System.nanoTime();
		System.out.println(solution3(18));
		long endThree=System.nanoTime();
		System.out.println(Math.abs(startThree-endThree));
	}
}
