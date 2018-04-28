package net.kang.threegame;
import java.util.List;
import java.util.Arrays;
// ���⼭�� 3�� ����� �� X�� ǥ�ø� �ϴµ� ���� ��� ���� 369 ���ӿ��� �۵��Ǵ� ������� ������ �غ��� �ڵ��� �õ��غ���.
public class Example01 {
	static Integer[] threeNumber={3, 6, 9};
	static List<Integer> clapNumber=Arrays.asList(threeNumber);
	public static void play(int value){
		if(value==0) return;
		else{
			play(value-1);
			if(!threeInclude(value)){
				System.out.print(value+" ");
			}
			else{
				numberClap(value);
				System.out.print(" ");
			}
		}
	}
	public static boolean threeInclude(int value){
		if(value==0) return false;
		return clapNumber.contains(value%10)||threeInclude(value/10);
	}
	public static void numberClap(int value){
		if(value==0) return;
		else{
			numberClap(value/10);
			if(clapNumber.contains((value%10))){
				System.out.print("X");
			}
		}
	}
	public static void main(String[] args){
		System.out.println("369���� ����");
		play(40);
	}
}
