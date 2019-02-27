package com.imooc.singleton;
//懒汉式：类内实例对象创建时并不直接初始化，指导第一次调用到方法时才完成初始化的才做
public class SingletonTwo {
	//1、创建私有构造方法
	private SingletonTwo() {
		
	}
	//2、创建静态的该类实例对象
	private static SingletonTwo instance = null;
	//3、创建开开放的静态方法提供实例对象
	public static SingletonTwo getInstance() {
		if(instance == null)
			instance = new SingletonTwo();
		
		return instance;
	}
}
