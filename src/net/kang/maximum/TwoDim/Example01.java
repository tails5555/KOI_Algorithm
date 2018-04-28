package net.kang.maximum.TwoDim;
public class Example01 {
	static int[][] arr={
							{10, 4, 34, 53, 16, 31},
							{30, 32, 50, 6, 21, 3}, 
							{2, 49, 59, 20, 10, 4},
							{39, 49, 60, 21, 94, 2},
							{1, 23, 42, 95, 53, 21},
							{19, 30, 45, 32, 20, 13}
						};
	// 1. 6���� �� ���ҵ��� �Դٸ� ���ٸ� �� ����� ���ؼ� Ǯ���.
	public static int solution1(){
		int result=arr[0][0];
		for(int k=0;k<arr.length;k++){
			for(int l=0;l<arr[k].length;l++){
				if(result<arr[k][l]){
					result=arr[k][l];
				}
			}
		}
		return result;
	}
	// �̴� ���簢����� ��쿡�� �ش��� �ȴ�. ���簢����� ��쿡�� ���Ŀ� �˾ƺ����� ����.
	// 2. 10, 32, 59...�� �������� �ؼ� 6���� ��ķ� �ٽ� �籸���� �ؼ� ���� Ž���� ���� ���� Ž���� �ۼ��غô�.
	public static int[] squareArrays(int x){
		if(x==0){
			int[] temp={arr[0][0]};
			return temp;
		}
		else{
			int[] temp=new int[x*2+1];
			int count=0;
			for(int k=1;k<x+1;k++){
				temp[count]=arr[x][x-k];
				count++;
			}
			for(int k=1;k<x+1;k++){
				temp[count]=arr[x-k][x];
				count++;
			}
			temp[count]=arr[x][x];
			return temp;
		}		
	}
	public static int divideMaximum(int[] arr, int start, int end){
		if(start>=end) return arr[start];
		int middle=(start+end)/2;
		return Math.max(divideMaximum(arr, start, middle), divideMaximum(arr, middle+1, end));
	}
	
	public static void main(String[] args){
		long startOne=System.nanoTime();
		System.out.println(solution1());
		long endOne=System.nanoTime();
		System.out.println(Math.abs(startOne-endOne));
		long startTwo=System.nanoTime();
		int[] maximum=new int[arr.length];
		for(int k=0;k<arr.length;k++){
			maximum[k]=divideMaximum(squareArrays(k), 0, 2*k);
		}
		long endTwo=System.nanoTime();
		System.out.println(divideMaximum(maximum, 0, maximum.length-1));
		System.out.println(Math.abs(startTwo-endTwo));
	}
}
