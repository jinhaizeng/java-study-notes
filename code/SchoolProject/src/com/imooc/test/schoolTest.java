package com.imooc.test;

import com.imooc.mode.*;
public class schoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Subject
		Subject sub1 = new Subject("�������ѧ��Ӧ��","J0001",4);
		System.out.println(sub1.info());
		System.out.println("*************************");
		//����Student
		Student stu1 = new Student("501","����","��",20);
		System.out.println(stu1.introduction());
		System.out.println("*************************");
		Student stu2 = new Student("502","����","��",18,sub1);
		System.out.println(stu2.introduction());
	}

}
