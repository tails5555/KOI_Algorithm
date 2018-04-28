package net.kang.clossroad;
public class Example01 {
	static int width=4;
	static int height=3;
	static int result=0;
	public static void solution(int r, int c, String path){
		if(r>height || c>width || width*r<height*c) return;
		if(r==height && c==width){
			result++;
			System.out.println(path);
			return;
		}
		solution(r+1, c, path+" "+String.format("[%d, %d]", r+1, c));
		solution(r, c+1, path+" "+String.format("[%d, %d]", r, c+1));
	}
	public static void main(String[] args){
		solution(0, 0, "[0, 0]");
		System.out.println(result);
	}
}
