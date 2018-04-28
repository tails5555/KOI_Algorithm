package net.kang.triangle;
public class Example01 {
	public static int solution1(int round){
		int result=0;
		for(int a=1;a<=round;a++){
			for(int b=a;b<=round;b++){
				for(int c=b;c<=round;c++){
					if(a+b+c==round && (a+b)>c) result++; // 문제에서 주어진 것은 각 변의 합이 9이고, 삼각형의 원래 조건으로서는 두 변의 길이의 합이 한 변의 길이보다 무조건 커야 한다는 조건으로 구하면 이렇게 구할 수 있다. 그러나 시간 복잡도가 장난이 아니다.
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
	
	public static int solution3(int round){ // 삼각형이 형성되기 위한 만족 조건을 통하여 시간 복잡도를 O(n3)에서 O(n2)로 단축을 하는 방법이 있다. 이는 수학적으로 생각을 하는 것이 중요한 것으로 판단이 되니 공부하면서 참고를 하도록 하자.
		int result=0;
		for(int a=round/3;a<=round/2;a++){ // 가장 긴 변
			for(int b=1;b<=round/3;b++){ // 가장 짧은 변
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
