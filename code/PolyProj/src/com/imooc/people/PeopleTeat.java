package com.imooc.people;

public class PeopleTeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person lili = new Person();
		lili.age =12;
		
		//获取内部类对象实例，方式1：new 外部类.new 内部类（即先进大门，再进卧室）
		Person.Heart myHeart = new Person().new Heart(); 
		System.out.println(myHeart.beat());
		
		//获取内部类对象实例，方式2：外部类对象.new 内部类
		myHeart = lili.new Heart();
		System.out.println(myHeart.beat());
		
		//获取内部类对象实例，方式3:(利用外部类中实例化内部类的方法）外部类对象.获取方法
		myHeart = lili.getHeart();
		System.out.println(myHeart.beat());
		}
		
}
