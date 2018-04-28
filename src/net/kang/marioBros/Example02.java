package net.kang.marioBros;
import java.util.HashSet;
// �� ��ƴ�. �ϴ� �� �о�� ���θ� �غ����� �մϴ�... �Ʊ� �����ó�� �׸��� �׷����鼭 �����ϰ� �׷����鼭 ���ظ� �ϴ� ���� ������ ���� ������ �ͱ���...
public class Example02 {
	static class Jump{
		int index;
		int power;
		boolean use;
		public Jump(int index, int power, boolean use){
			this.index=index;
			this.power=power;
			this.use=use;
		}
		@Override
		public String toString(){
			return String.format("[%d JUMP %d %s]", this.index, this.power, this.use);
		}
	}
	static Jump[] island=new Jump[] {new Jump(0, 3, true), new Jump(1, 3, true), new Jump(3, 1, true), new Jump(4, 3, true)};
	static HashSet<Integer> visited=new HashSet<Integer>();
	public static boolean cMario(int mario, int index){
		System.out.println("index -> "+island[index]+", "+"mario -> "+island[mario]+(island[index].index<=island[mario].index+island[mario].power));
		return island[index].index<=island[mario].index+island[mario].power;
	}
	public static boolean cLuigi(int luigi, int index){
		System.out.println("index -> "+island[index]+", "+"luigi -> "+island[luigi]+((island[index].index<=island[luigi].index+island[index].power) && island[index].use));
		return (island[index].index<=island[luigi].index+island[index].power) && island[index].use; 
	}
	public static int solution(int mario, int luigi, int index){
		int result=0;
		System.out.printf("<<%d>>\n", index);
		if(index>=island.length-1){
			if(cMario(mario, index) && cLuigi(luigi, index)) result=1;
			else result=0;
			System.out.println(mario+" "+luigi+" "+result);
		}
		else{
			System.out.println(island[mario]+" "+island[luigi]+" "+result);
			if(cMario(mario, index)) {
				System.out.println("Mario Move to "+(index+1));
				result+=solution(index, luigi, index+1); // �������� �̵��� �� �ִ� ������ Ž���ؼ� �˻��� �ϵ��� �����Ѵ�.
			}
			if(cLuigi(luigi, index)){
				System.out.println("Luigi Move to "+(index+1));
				result+=solution(mario, index, index+1);
			}
			result+=solution(mario, luigi, index+1);
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(solution(0, 0, 1));
	}
}
