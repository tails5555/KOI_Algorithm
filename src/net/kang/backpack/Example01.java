package net.kang.backpack;

public class Example01 {
	static class Gem{
		int mass; // 질량
		int value; // 값어치
		public Gem(int mass, int value){
			this.mass=mass;
			this.value=value;
		}
		@Override
		public String toString(){
			return String.format("Gem[%dkg, %d$]", this.mass, this.value);
		}
	}
	static Gem[] list={new Gem(2, 3), new Gem(1, 2), new Gem(3, 3), new Gem(2, 2), new Gem(5, 6)};
	static int bpLimit=5;
	/*
	static int result=0;
	public static void solution(int bpMass, int index){ // 이렇게 하는 방법은 선형적으로 풀이를 하게 되면 최소의 시간으로 골라내는데 문제가 되지 않지만 실질적으로 문제에서 요구하는 사항으로는 절대 옳은 답이 아니다. 그래서 어떻게 정답을 골라낼지에 대해 생각을 해 볼 의무가 있다.
		if(index>=list.length) return;
		else if(bpMass-list[index].mass<0){
			solution(bpMass, index+1);
		}
		else{
			int temp=result+list[index].value;
			if(temp>result){
				result=temp;
				solution(bpMass-list[index].mass, index+1);
			}
			else{
				solution(bpMass, index+1);
			}
			
		}
	}
	*/
	// 그러나 아까처럼 작성을 하게 되면 
	public static int solution(int index, int bpMass){
		if(index>=list.length) return 0;
		else if(list[index].mass>bpMass) return solution(index+1, bpMass);
		else{
			return Math.max(solution(index+1, bpMass), solution(index+1, bpMass-list[index].mass)+list[index].value);
		}
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(solution(0, bpLimit));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
