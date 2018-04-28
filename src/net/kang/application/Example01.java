package net.kang.application;
// 오늘은 그렇게 어렵다는 동적 프로그래밍을 복습해보기 좋은 문제로서 이 문제를 뽑을 수 있겠다. 어떻게든 한번 풀어보도록 하자.
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
			if(dmdCapacity<=0) return 0; // 어자피 용량이 낮으면 0을 반환해야 하기 때문에 0의 인덱스에서 -1를 곱해서 반환하는 방법이 있다.
			else return 987654321; // 애석하게도 Integer.MAX_VALUE를 해서 더하게 해버리면 결국 음수로 이상한 값이 나와서 최솟값 판별에 어려움이 있어서 여기서는 987654321를 대체하기로 하였음.
		}
		else if(dmdCapacity<0) return solution(index-1, dmdCapacity); // dmdCapacity가 음수가 되부리면 결국에 index가 0인 부분에 대해서 책임을 져야 한다. 그러니 결국 이전 단계까지 조지는 것이 오히려 정답.
		else return Math.min(solution(index-1, dmdCapacity), solution(index-1, dmdCapacity-executeApp[index].capacity)+executeApp[index].weight); 
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution(executeApp.length-1, dmdCapacity));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
