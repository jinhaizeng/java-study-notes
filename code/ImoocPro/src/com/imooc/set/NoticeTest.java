package com.imooc.set;

import java.util.ArrayList;
import java.util.Date;

public class NoticeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notice notice1 = new Notice(1,"��ӭ����Ľ����!","����Ա",new Date());
		Notice notice2 = new Notice(2,"��ͬѧ�ǰ�ʱ�ύ��ҵ��","��ʦ",new Date());
		Notice notice3 = new Notice(3,"����֪ͨ��","��ʦ",new Date());
		
		//��ӹ���
		ArrayList noticeList = new ArrayList();
		noticeList.add(notice1);
		noticeList.add(notice2);
		noticeList.add(notice3);
		
		//��ʾ����
		System.out.println("���������Ϊ��");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
			//get����ֵ������һ��object�࣬ΪgetTitle�Ķ���Ҫ����һ��notice��
			//���Ա�����ǿ������ת������object��ת����notice��
				
		}
		
		Notice notice4 = new Notice(4,"���߱༭������ʹ����!","����Ա",new Date());
		noticeList.add(1,notice4);
		
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		System.out.println("***********************************************");
		//ɾ����ʱ�����ҵ�Ĺ���
		noticeList.remove(2);
		//��ʾ����
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		
		//���ڶ��������Ϊ��Java���߱༭������ʹ������
		System.out.println("***********************************************");
		notice4.setTitle("Java���߱༭������ʹ������");
		noticeList.set(1, notice4);
		
		//ע�⣺�ڱ������У�ʹ��setTitle�Ϳ����ˣ��������һ���µĶ������µķ���ȥ�滻
		//notice4��ʱ����Ҫ����ArrayList��set����
		System.out.println("�޸ĺ󹫸������Ϊ��");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
	}

}
