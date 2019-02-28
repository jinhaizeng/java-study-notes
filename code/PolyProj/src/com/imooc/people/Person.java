package com.imooc.people;

public class Person {
	int age;

	public Heart getHeart(){
		return new Heart();
	}

	//内部类：心脏
	class Heart{
		public String beat(){
			return "心脏在跳动";
		}
	}

}
