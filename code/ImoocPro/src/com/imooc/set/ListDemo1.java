package com.imooc.set;

import java.util.ArrayList;

public class ListDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ArrayList�洢������Ե����ƣ������
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("C");
		list.add("C++");
		list.add("Go");
		list.add("swift");
		//����б���Ԫ�صĸ���
		System.out.println("�б���Ԫ�صĸ���Ϊ��"+list.size());
		
		System.out.println("********************************");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
		
		System.out.println();
		//����һ
		list.remove(2);
		
		//������
		list.remove("C++");
		System.out.println("********************************");
		System.out.println("�Ƴ�C++�Ժ���б�Ԫ��Ϊ��");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
	}

}
