package net.kang.password;

public class Example00 {
	// 10부터 80까지를 이분화해서 출력을 해보는 연습을 잠깐 해보자. 이렇게만 출력되면 된다.
	// 10/20 30/40 50/60 70/80
	public static String solution(int[] arr, int start, int end){ 
		String temp="";
		int middle=(start+end)/2;
		if(end-start>1){
			temp+=solution(arr, start, middle);
			temp+=solution(arr, middle+1, end);
		}
		else{
			return new String(arr[start]+"/"+arr[end]+" ");
		}
		return temp;
	}
	public static void main(String[] args){
		int[] arr={10, 20, 30, 40, 50, 60, 70, 80};
		System.out.println(solution(arr, 0, arr.length-1));
		// (0, 7) -> (0, 3) (4, 7) -> (0, 1) (2, 3) (4, 5) (6, 7)
		int[] arr2={5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80};
		System.out.println(solution(arr2, 0, arr2.length-1));
	}
}
