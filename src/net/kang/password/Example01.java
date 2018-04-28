package net.kang.password;
// �� ������ ��� �츮�� ����� ���� ���Ŀ� ���ؼ� ������ �ٽ� �غ� �� �ִ� ��ȸ�� �ȴ�. �̸� �̿��ؼ� Ǯ����� ����.
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
