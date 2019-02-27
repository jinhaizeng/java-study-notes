package com.imooc.test;

import com.imooc.animal.*;

public class Test {
	public static void main(String[] args) {
		Animal one = new Animal();			//1
		/*向上转型、隐式转型、自动转型
		 * 父类引用指向子类实例，可以调用子类重写父类的方法以及父类派生的方法，无法调用子类独有的方法
		 * 小类转型为大类
		*/
		Animal two = new Cat();				//2
		Animal three = new Dog();			//3
		one.eat();
		two.eat();
		three.eat();
		System.out.println("==============");
		/*向下转型、强制类型转换
		 * 子类引用指向父类对象，此处必须进行强转，可以调用子类特有的方法
		 * 必须满足转型条件才能进行转换（即父类可强转为子类，但子类之间不可以强转）
		 */
		if(two instanceof Cat) {
			Cat temp = (Cat)two;
			temp.eat();
			temp.run();
			temp.getMonth();
			System.out.println("two可以转换为Cat类型");
		}
		
		
	}
}
