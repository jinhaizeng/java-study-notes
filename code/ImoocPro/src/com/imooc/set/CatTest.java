package com.imooc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CatTest {

	public static void main(String[] args) {
		// �������è����
		Cat huahua = new Cat("����",12,"Ӣ����ëè");
		Cat fanfan = new Cat("����",3,"�л���԰è");
		
		//������è�������HashSet
		Set set = new HashSet();
		set.add(huahua);
		set.add(fanfan);
		//��ʾ����è��Ϣ
		Iterator it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
