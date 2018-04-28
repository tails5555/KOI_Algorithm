package net.kang.backpack;

import java.util.ArrayList;

public class Example02 {
	static class Gem{
		int mass; // 질량
		int value; // 값어치
		public Gem(int mass, int value){
			this.mass=mass;
			this.value=value;
		}
		@Override
		public String toString(){
			return String.format("Gem[%dkg, %d$]", this.mass, this.value);
		}
	}
	static Gem[] list={new Gem(2, 3), new Gem(1, 2), new Gem(3, 3), new Gem(2, 2), new Gem(5, 6)};
	static int bpLimit=5;
	static ArrayList<Gem> finalList=new ArrayList<Gem>();
	static class Node{
		Gem base;
		int index;
		Node left;
		Node right;
		public Node(Gem base, int index){
			this.base=base;
			this.index=index;
			this.left=null;
			this.right=null;
		}
		public void insert(Gem gem){
			if(this.right==null) this.right=new Node(new Gem(base.mass-gem.mass, base.value+gem.value), index+1);
			else this.right.insert(gem);
			if(this.left==null) this.left=new Node(new Gem(base.mass, base.value), index+1);
			else this.left.insert(gem);
		}
		public void print(){
			if(this.left!=null) left.print();
			System.out.printf("%s %d ", this.base, this.index);
			if(this.right!=null) right.print();
		}
		public void indexPrint(int index){
			if(this.left!=null) left.indexPrint(index);
			if(this.index==index){
				System.out.printf("%s %d ", this.base, this.index);
			}
			if(this.right!=null) right.indexPrint(index);
		}
		public void finalListMake(){
			if(this.left!=null) left.finalListMake();
			if(this.index==list.length && this.base.mass==0){
				finalList.add(this.base);
			}
			if(this.right!=null) right.finalListMake();
		}
	}
	public static int solution(ArrayList<Gem> list){
		int result=Integer.MIN_VALUE;
		for(Gem g : list){
			if(g.mass==0 && result<g.value){
				result=g.value;
			}
		}
		return result;
	}
	public static void main(String[] args){
		long start=System.nanoTime();
		Node bst=new Node(new Gem(bpLimit, 0), 0); // Example01과 다르게 조금 쉬운 방법으로 이진탐색트리를 이용해서 작성을 해봤다.
		for(Gem g : list){
			bst.insert(g); // 여기서 삽입하는데 걸리는 시간은 각 단계 별로 2^(단계) 씩 걸리게 된다. 각 순서대로 시간이 오래 걸리게 된다.
		}
		for(int k=0;k<=list.length;k++){
			bst.indexPrint(k);
			System.out.println();
		}
		bst.finalListMake(); // 마지막 리스트에서 최종적으로 0을 만족하는 것들만 골라오게 된다.
		System.out.println(solution(finalList)); // 여기서는 마지막 리스트를 선형 탐색을 하게 되어 최댓값을 골라오는 과정이다. 시간복잡도는 아까와 마찬가지로 O(2^n)이 걸리게 된다고 하나??
		long end=System.nanoTime();
		System.out.println(Math.abs(start-end));
	}
}
