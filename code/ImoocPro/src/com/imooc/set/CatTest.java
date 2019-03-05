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
		Set set = new HashSet();
		set.add(huahua);
		set.add(fanfan);
		//显示宠物猫信息
		Iterator it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
