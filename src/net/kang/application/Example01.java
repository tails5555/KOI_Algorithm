package net.kang.application;
// ������ �׷��� ��ƴٴ� ���� ���α׷����� �����غ��� ���� �����μ� �� ������ ���� �� �ְڴ�. ��Ե� �ѹ� Ǯ����� ����.
public class Example01 {
	static class App{
		int capacity;
		int weight;
		public App(int capacity, int weight){
			this.capacity=capacity;
			this.weight=weight;
		}
		@Override
		public String toString() {
			return "App [capacity=" + capacity + ", weight=" + weight + "]";
		}
		
	}
	static App[] executeApp={ new App(0, 0), new App(30, 3), new App(10, 0), new App(20, 3), new App(35, 5), new App(40, 4) };
	static int dmdCapacity=60;
	public static int solution(int index, int dmdCapacity){
		if(index<0){
			if(dmdCapacity<=0) return 0; // ������ �뷮�� ������ 0�� ��ȯ�ؾ� �ϱ� ������ 0�� �ε������� -1�� ���ؼ� ��ȯ�ϴ� ����� �ִ�.
			else return 987654321; // �ּ��ϰԵ� Integer.MAX_VALUE�� �ؼ� ���ϰ� �ع����� �ᱹ ������ �̻��� ���� ���ͼ� �ּڰ� �Ǻ��� ������� �־ ���⼭�� 987654321�� ��ü�ϱ�� �Ͽ���.
		}
		else if(dmdCapacity<0) return solution(index-1, dmdCapacity); // dmdCapacity�� ������ �Ǻθ��� �ᱹ�� index�� 0�� �κп� ���ؼ� å���� ���� �Ѵ�. �׷��� �ᱹ ���� �ܰ���� ������ ���� ������ ����.
		else return Math.min(solution(index-1, dmdCapacity), solution(index-1, dmdCapacity-executeApp[index].capacity)+executeApp[index].weight); 
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution(executeApp.length-1, dmdCapacity));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
