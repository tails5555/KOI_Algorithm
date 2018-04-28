package net.kang.threegame;
import java.util.List;
import java.util.Arrays;
// 여기서는 3의 배수일 때 X로 표시를 하는데 예를 들어 실제 369 게임에서 작동되는 기능으로 생각을 해보고 코딩을 시도해보자.
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
		System.out.println("369게임 구현");
		play(40);
	}
}
