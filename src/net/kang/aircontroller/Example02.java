package net.kang.aircontroller;

import java.util.Stack;
import java.util.ArrayList;
public class Example02 {
	static int hT;
	static Stack<Condition> next=new Stack<Condition>();
	static ArrayList<Integer> button=new ArrayList<Integer>();
	static class Condition{
		int current;
		int count;
		public Condition(int current, int count){
			this.current=current;
			this.count=count;
		}
	}
	public static int solution1(int cT, int count){
		next.push(new Condition(cT, count));
		int result=count;
		while(!next.isEmpty()){
			Condition temp=next.pop();
			int difference=Math.abs(temp.current-hT);
			if(difference>(5+10)/2){
				System.out.println(temp.current);
				if(temp.current<hT){
					next.push(new Condition(temp.current+10, temp.count+1));
					button.add(10);
				}
				else{
					next.push(new Condition(temp.current-10, temp.count+1));
					button.add(-10);
				}
			}
			else if(difference>(1+5)/2){
				System.out.println(temp.current);
				if(temp.current<hT){
					next.push(new Condition(temp.current+5, temp.count+1));
					button.add(5);
				}
				else{
					next.push(new Condition(temp.current-5, temp.count+1));
					button.add(-5);
				}
			}
			else if(difference>=1){
				System.out.println(temp.current);
				if(temp.current<hT){
					next.push(new Condition(temp.current+1, temp.count+1));
					button.add(1);
				}
				else{
					next.push(new Condition(temp.current-1, temp.count+1));
					button.add(-1);
				}
			}
			else if(difference==0){
				System.out.println(temp.current);
				result=temp.count;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args){
		int cT=7;
		hT=34;
		System.out.println(solution1(cT, 0));
		System.out.println(button);
	}
}
