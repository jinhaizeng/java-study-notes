package com.imooc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WorldDemo {

	public static void main(String[] args) {
		// ��Ӣ�ĵ�����ӵ�HashSet��
		Set set = new HashSet();
		//�򼯺������Ԫ��
		set.add("blue");
		set.add("red");
		set.add("black");
		set.add("yellow");
		set.add("white");
		//��ʾ���ϵ�����
		System.out.println("�����е�Ԫ��Ϊ��");
		//�������е�����ת�浽��������
		Iterator it = set.iterator();
		//���������������Ԫ��
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		} 
		
		System.out.println();
		//�ڼ����в���һ���µĵ���,�ظ���Ϣ���ᱻ���뵽set������
		set.add("white");
		it = set.iterator();
		//���������������Ԫ��
		System.out.println("******************************");
		System.out.println("�����ظ�Ԫ�غ��������Ϊ��");
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		} 
		//����ʧ�ܣ����ǲ��ᱨ��
	}

}
