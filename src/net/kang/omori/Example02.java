package net.kang.omori;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
public class Example02 {
	static class Person{
		String name;
		int age;
		public Person(String name, int age){
			this.name=name;
			this.age=age;
		}
		@Override
		public String toString(){
			return String.format("[%s : %d]", this.name, this.age);
		}
	}
	public static void main(String[] args){
		HashMap<String, Person> list1=new HashMap<String, Person>();
		TreeMap list2=new TreeMap();
		list2.put("가", new Person("지효", 20));
		list2.put("나", new Person("나연", 21));
		list2.put("다", new Person("정연", 20));
		list2.put("라", new Person("모모", 20));
		list2.put("마", new Person("사나", 20));
		list2.put("바", new Person("미나", 20));
		list2.put("사", new Person("다현", 19));
		list2.put("아", new Person("채영", 18));
		list2.put("자", new Person("쯔위", 18));
		Iterator<Person> peopleList=list2.values().iterator();
		while(peopleList.hasNext()){
			System.out.println(peopleList.next());
		}
	}
}
