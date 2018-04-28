package net.kang.rings;
import java.util.Arrays;
// 악마의 돌다리, 천사의 돌다리를 번갈아가면서 밟아야 하는 점을 전제조건으로 시작을 해야 한다.
// 이 문제는 자세히 생각해보면 쉬운 문제라서 여기서는 시간 복잡도를 판단하면서 간단하게 끝낼 수 있는 여부만 알아보고 바로 마리오 문제로 넘어가도록 하자.
public class Example01 {	
	static String devil1="RINGSR";
	static String angel1="GRGGNS";
	static char[][] road01={devil1.toCharArray(), angel1.toCharArray()};
	static String devil2="SGNIRSGNIR";
	static String angel2="GNIRSGNIRS";
	static char[][] road02={devil2.toCharArray(), angel2.toCharArray()};
	static String devil3="GGGGRRRR";
	static String angel3="IIIIGGGG";
	static char[][] road03={devil3.toCharArray(), angel3.toCharArray()};
	public static int solution(char[][] road, char[] scroll, int index, int which, int scrIndex){ // 이 반복문의 시간 복잡도를 계산해보면 우선적으로 천사와 악마의 수를 e, road의 길이를 n으로 치고 계산하고, 문자열의 길이를 s로 치자. 시간 복잡도는 O(e*s*n)이 된다.
		int result=0;
		if(scrIndex>=scroll.length) return 1;
		if(which==0){
			for(int k=index;k<road[0].length;k++){
				if(road[0][k]==scroll[scrIndex]){
					result+=solution(road, scroll, k+1, 1, scrIndex+1);
				}
			}
		}
		else if(which==1){
			for(int k=index;k<road[1].length;k++){
				if(road[1][k]==scroll[scrIndex]){
					result+=solution(road, scroll, k+1, 0, scrIndex+1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		for(int k=0;k<road01.length;k++){
			System.out.println(Arrays.toString(road01[k]));
		}
		String scroll1="RGS";
		System.out.println(scroll1);
		System.out.println(solution(road01, scroll1.toCharArray(), 0, 0, 0)+solution(road01, scroll1.toCharArray(), 0, 1, 0));
		for(int k=0;k<road02.length;k++){
			System.out.println(Arrays.toString(road02[k]));
		}
		String scroll2="RINGS";
		System.out.println(scroll2);
		System.out.println(solution(road02, scroll2.toCharArray(), 0, 0, 0)+solution(road02, scroll2.toCharArray(), 0, 1, 0));
		for(int k=0;k<road03.length;k++){
			System.out.println(Arrays.toString(road03[k]));
		}
		String scroll3="GG";
		System.out.println(scroll3);
		System.out.println(solution(road03, scroll3.toCharArray(), 0, 0, 0)+solution(road03, scroll3.toCharArray(), 0, 1, 0));
	}
}
