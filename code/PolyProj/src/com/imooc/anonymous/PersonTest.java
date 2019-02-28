package com.imooc.anonymous;

public class PersonTest {
	//根据传入的不同的人的类型，调用对应的read方法
	//方案1 
	public void getRead(Man man) {
		man.read();
	}
	public void getRead(Woman woman) {
		woman.read();
	}
	
	//方案2
	public void getRead(Person person) {
		person.read();			//由父类与子类的关系可知，根据你传入的类型会
								//选择你传入类型重写的read方法
	}
	
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		Man one = new Man();
		Woman two = new Woman();
		test.getRead(one);
		test.getRead(two);
	}
}
