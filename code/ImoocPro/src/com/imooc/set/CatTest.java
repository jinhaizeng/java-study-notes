package com.imooc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CatTest {

	public static void main(String[] args) {
		// 定义宠物猫对象
		Cat huahua = new Cat("花花",12,"英国短毛猫");
		Cat fanfan = new Cat("凡凡",3,"中华田园猫");
		
		//将宠物猫对象放入HashSet
		Set<Cat> set = new HashSet();
		set.add(huahua);
		set.add(fanfan);
		//显示宠物猫信息
		Iterator<Cat> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		//在添加一个与花花属性一样的猫
		Cat huahua01 = new Cat("花花",12,"英国短毛猫");
		set.add(huahua01);
		System.out.println("**********************************");
		System.out.println("添加重复数据后的宠物猫信息：");	//如果不重写hashCode()和equals()这两个方法，还是会被添加进去
		it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("**********************************");
		//重新插入一个新宠物猫
		Cat huahua02 =new Cat("花花二代",2,"英国短毛猫");
		set.add(huahua02);
		System.out.println("添加花花二代后的宠物猫信息");
		it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("**********************************");
		//在集合中查找花花的信息并输出
		if(set.contains(huahua)) {
			System.out.println("花花找到了");
			System.out.println(huahua);
		}
		else {
			System.out.println("花花没找到");
		}
		
		//在集合中使用名字查找花花的信息
		//思路：在集合中遍历所有元素，挨个比较名字
		System.out.println("**********************************");
		System.out.println("通过名字查找花花的信息");
		boolean flag = false;
		Cat c = null;
		it = set.iterator();	//重置迭代器，让迭代器从第一个开始（上一个函数遍历到最后了）
		while(it.hasNext()) {
			c = it.next();
			if(c.getName().equals("花花")) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("花花找到了");
			System.out.println(c);
		}
		else {
			System.out.println("花花没找到了");
		}
		
		//删除花花的信息并重新输出
		for(Cat cat:set) {
			if("花花".equals(cat.getName()))
				set.remove(cat);		//此时移除掉"花花"以后，set就被打算了，再遍历就会出问题
				break;					//要解决这个问题，就要再找到以后break
		}
		
		for(Cat cat:set) {
			System.out.println(cat);
		}
		
		//删除集合中的所有宠物猫信息
		System.out.println("**********************************");
		boolean flag1 = set.removeAll(set);
		if(flag1) {
			System.out.println("猫都不见了");
		}
		else {
			System.out.println("猫还在。。。");
		}
		
		
	}

}
