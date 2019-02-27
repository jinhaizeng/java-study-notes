package com.imooc.test;

import com.imooc.singleton.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonOne one = SingletonOne.getInstance();
		SingletonOne two = SingletonOne.getInstance();
		System.out.println(one);
		System.out.println(two);
		System.out.println("==========================");
		SingletonTwo one1 = SingletonTwo.getInstance();
		SingletonTwo two1 = SingletonTwo.getInstance();
		System.out.println(one1);
		System.out.println(two1);
	}

}
