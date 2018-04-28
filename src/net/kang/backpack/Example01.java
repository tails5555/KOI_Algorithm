package net.kang.backpack;

public class Example01 {
	static class Gem{
		int mass; // ����
		int value; // ����ġ
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
	public static void solution(int bpMass, int index){ // �̷��� �ϴ� ����� ���������� Ǯ�̸� �ϰ� �Ǹ� �ּ��� �ð����� ��󳻴µ� ������ ���� ������ ���������� �������� �䱸�ϴ� �������δ� ���� ���� ���� �ƴϴ�. �׷��� ��� ������ ������� ���� ������ �� �� �ǹ��� �ִ�.
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
	// �׷��� �Ʊ�ó�� �ۼ��� �ϰ� �Ǹ� 
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
