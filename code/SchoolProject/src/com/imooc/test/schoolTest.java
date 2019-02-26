package com.imooc.test;

import com.imooc.mode.*;
public class schoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试Subject
		Subject sub1 = new Subject("计算机科学与应用","J0001",4);
		System.out.println(sub1.info());
		System.out.println("*************************");
		//测试Student
		Student stu1 = new Student("501","张三","男",20);
		System.out.println(stu1.introduction());
		System.out.println("*************************");
		Student stu2 = new Student("502","李四","男",18,sub1);
		System.out.println(stu2.introduction());
	}

}
