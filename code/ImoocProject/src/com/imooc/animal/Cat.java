package com.imooc.animal;
/**
 * 宠物猫类
 * @author MR Code
 *
 */
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;
	
	public Cat() {
		System.out.println("我是宠物猫~~~");
	}
	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		System.out.println("小猫快跑");
	}
	//吃鱼的方法
	public void eat() {
		System.out.println("小猫吃鱼");
	}

}
