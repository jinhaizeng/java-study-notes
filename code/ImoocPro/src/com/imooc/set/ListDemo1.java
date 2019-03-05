package com.imooc.set;

import java.util.ArrayList;

public class ListDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//用ArrayList存储编程语言的名称，并输出
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("C");
		list.add("C++");
		list.add("Go");
		list.add("swift");
		//输出列表中元素的个数
		System.out.println("列表中元素的个数为："+list.size());
		
		System.out.println("********************************");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
		
		System.out.println();
		//方法一
		list.remove(2);
		
		//方法二
		list.remove("C++");
		System.out.println("********************************");
		System.out.println("移除C++以后的列表元素为：");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
	}

}
