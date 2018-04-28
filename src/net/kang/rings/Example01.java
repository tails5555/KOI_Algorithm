package net.kang.rings;
import java.util.Arrays;
// �Ǹ��� ���ٸ�, õ���� ���ٸ��� �����ư��鼭 ��ƾ� �ϴ� ���� ������������ ������ �ؾ� �Ѵ�.
// �� ������ �ڼ��� �����غ��� ���� ������ ���⼭�� �ð� ���⵵�� �Ǵ��ϸ鼭 �����ϰ� ���� �� �ִ� ���θ� �˾ƺ��� �ٷ� ������ ������ �Ѿ���� ����.
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
	public static int solution(char[][] road, char[] scroll, int index, int which, int scrIndex){ // �� �ݺ����� �ð� ���⵵�� ����غ��� �켱������ õ��� �Ǹ��� ���� e, road�� ���̸� n���� ġ�� ����ϰ�, ���ڿ��� ���̸� s�� ġ��. �ð� ���⵵�� O(e*s*n)�� �ȴ�.
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
