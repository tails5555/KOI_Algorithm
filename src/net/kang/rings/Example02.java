package net.kang.rings;

import java.util.Arrays;

public class Example02 {
	static String road1="RINGSR";
	static String road2="GRGGNS";
	static String road3="RGSGNR";
	static char[][] road={road1.toCharArray(), road2.toCharArray(), road3.toCharArray()};
	static String road4="GGGGRRRR";
	static String road5="IIIIGGGG";
	static String road6="GGGGDDDD";
	static char[][] roadTest={road4.toCharArray(), road5.toCharArray(), road6.toCharArray()};
	// 아까와는 심화로 천사와 악마를 따로 가는 것이 아닌 3개의 선택들 중에서 하는 방안으로 때려보도록 하자.
	public static int solution(char[][] road, char[] scroll, int index, int which, int scrIndex){
		int result=0;
		if(scrIndex>=scroll.length) return 1;
		if(which==0){
			for(int k=index;k<road[0].length;k++){
				if(road[0][k]==scroll[scrIndex]){
					result+=solution(road, scroll, k+1, 1, scrIndex+1);
					result+=solution(road, scroll, k+1, 2, scrIndex+1);
				}
			}
		}
		else if(which==1){
			for(int k=index;k<road[1].length;k++){
				if(road[1][k]==scroll[scrIndex]){
					result+=solution(road, scroll, k+1, 0, scrIndex+1);
					result+=solution(road, scroll, k+1, 2, scrIndex+1);
				}
			}
		}
		else if(which==2){
			for(int k=index;k<road[2].length;k++){
				if(road[2][k]==scroll[scrIndex]){
					result+=solution(road, scroll, k+1, 0, scrIndex+1);
					result+=solution(road, scroll, k+1, 1, scrIndex+1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		for(int k=0;k<road.length;k++){
			System.out.println(Arrays.toString(road[k]));
		}
		String scroll1="RGS";
		System.out.println(scroll1);
		System.out.println(solution(road, scroll1.toCharArray(), 0, 0, 0)/2+solution(road, scroll1.toCharArray(), 0, 1, 0)/2+solution(road, scroll1.toCharArray(), 0, 2, 0)/2);
		// 마지막까지는 중복적으로 2번 더해지기 때문에 오히려 2를 나누어 주는 것이 옳은 방안이다.
		for(int k=0;k<road.length;k++){
			System.out.println(Arrays.toString(roadTest[k]));
		}
		String scroll2="GG";
		System.out.println(scroll2);
		System.out.println(solution(roadTest, scroll2.toCharArray(), 0, 0, 0)/2+solution(roadTest, scroll2.toCharArray(), 0, 1, 0)/2+solution(roadTest, scroll2.toCharArray(), 0, 2, 0)/2);
		// 마지막까지는 중복적으로 2번 더해지기 때문에 오히려 2를 나누어 주는 것이 옳은 방안이다.
	}
}
