package com.imooc.people;

public class Person {
	int age;

	public Heart getHeart(){
		return new Heart();
	}

	//�ڲ��ࣺ����
	class Heart{
		public String beat(){
			return "����������";
		}
	}

}
