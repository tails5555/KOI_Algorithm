package net.kang.application;
// 동적 프로그래밍의 실질적인 어려움을 느껴보기 위해서 일부러 하나 작성해봤다. 나중에 고급 난이도로 들어가는 경우에 한번 제대로 공부해보는 기회를 가져보도록 하자...
public class Example02 {
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
	static int[][] sum=new int[101][10001];
	public static int solution(int index, int dmdCapacity){
		for(int k=1;k<=executeApp.length-1;k++){
			for(int l=0;l<=100*(executeApp.length-1);l++){
				if(l>=executeApp[k].weight){
					sum[k][l]=Math.max(sum[k-1][l], sum[k-1][l-executeApp[k].weight]+executeApp[k].capacity);
				}
				else{
					sum[k][l]=sum[k-1][l];
				}
			}
		}
		int result=987654321;
		for(int k=0;k<=100*(executeApp.length-1);k++){
			if(sum[executeApp.length-1][k]>=dmdCapacity && result>k){
				result=k;
			}
		}
		return result;
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution(executeApp.length-1, dmdCapacity));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
