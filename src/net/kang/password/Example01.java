package net.kang.password;
// 이 문장은 잠깐 우리가 배웠던 병합 정렬에 대해서 생각을 다시 해볼 수 있는 기회가 된다. 이를 이용해서 풀어보도록 하자.
public class Example01 {
	public static String solution(int[] password, int start, int part){ 
		String temp="";
		int sum=0;
		if(part==1){
			return Integer.toString(password[start]);
		}
		for(int k=start;k<start+part;k++){
			sum+=password[k];
		}
		if(sum==0 || sum==part){
			return Integer.toString(password[start]);
		}
		else{
			temp+="-";
			temp+=solution(password, start, part/2);
			temp+=solution(password, start+part/2, part/2);
		}
		return temp;
	}
	public static void main(String[] args){
		int[] password1={0, 0, 0, 0};
		int[] password2={1, 1, 0, 1};
		int[] password3={0, 0, 1, 1, 1, 1, 0, 1};
		System.out.println(solution(password1, 0, password1.length));
		System.out.println(solution(password2, 0, password2.length));
		System.out.println(solution(password3, 0, password3.length));
	}
}
