package com.imooc.test;

import com.imooc.animal.*;

public class Test {
	public static void main(String[] args) {
		Animal one = new Animal();			//1
		/*����ת�͡���ʽת�͡��Զ�ת��
		 * ��������ָ������ʵ�������Ե���������д����ķ����Լ����������ķ������޷�����������еķ���
		 * С��ת��Ϊ����
		*/
		Animal two = new Cat();				//2
		Animal three = new Dog();			//3
		one.eat();
		two.eat();
		three.eat();
		System.out.println("==============");
		/*����ת�͡�ǿ������ת��
		 * ��������ָ������󣬴˴��������ǿת�����Ե����������еķ���
		 * ��������ת���������ܽ���ת�����������ǿתΪ���࣬������֮�䲻����ǿת��
		 */
		if(two instanceof Cat) {
			Cat temp = (Cat)two;
			temp.eat();
			temp.run();
			temp.getMonth();
			System.out.println("two����ת��ΪCat����");
		}
		
		
	}
}
