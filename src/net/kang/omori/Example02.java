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
		list2.put("��", new Person("��ȿ", 20));
		list2.put("��", new Person("����", 21));
		list2.put("��", new Person("����", 20));
		list2.put("��", new Person("���", 20));
		list2.put("��", new Person("�糪", 20));
		list2.put("��", new Person("�̳�", 20));
		list2.put("��", new Person("����", 19));
		list2.put("��", new Person("ä��", 18));
		list2.put("��", new Person("����", 18));
		Iterator<Person> peopleList=list2.values().iterator();
		while(peopleList.hasNext()){
			System.out.println(peopleList.next());
		}
	}
}
