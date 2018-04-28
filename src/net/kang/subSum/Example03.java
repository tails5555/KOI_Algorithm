package net.kang.subSum;

public class Example03 {
	static int[] arr={6, -7, 3, -1, 5, 2};
	public static int divideSum(int start, int end){
		if(start==end) return arr[start];
		int middle=(start+end)/2;
		int left=Integer.MIN_VALUE;
		for(int k=0;k<=middle-1;k++){
			int sum=0;
			for(int l=k;l<=middle-1;l++){
				sum+=arr[l];
				left=Math.max(left, sum); // 이렇게 계산을 하게 되면 여기서는 큰 변화를 보지 못하는데 근데 배열의 크기가 수억인 경우에는 경우가 달라지게 된다. 최종 시간 복잡도는 O(n^2)
			}
		}
		int right=Integer.MIN_VALUE;
		for(int k=middle;k<=end;k++){
			int sum=0;
			for(int l=k;l<=end;l++){
				sum+=arr[l];
				right=Math.max(right, sum); // 이렇게 계산을 하게 되면 여기서는 큰 변화를 보지 못하는데 근데 배열의 크기가 수억인 경우에는 경우가 달라지게 된다. 최종 시간 복잡도는 O(n^2)
			}
		}
		return Math.max(left, right);
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		System.out.println(divideSum(0, arr.length-1));
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end)); // 이러한 방안도 시간은 작은 경우에는 꽤 낭비이지만, 나중에 데이터가 부지기수하게 많아지는 경우에는 크게 줄어들는 경향을 볼 수 있다. 이의 시간 복잡도는 O(N log N)
	}
}
