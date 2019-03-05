package com.imooc.set;

import java.util.ArrayList;
import java.util.Date;

public class NoticeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notice notice1 = new Notice(1,"欢迎来到慕课网!","管理员",new Date());
		Notice notice2 = new Notice(2,"请同学们按时提交作业！","老师",new Date());
		Notice notice3 = new Notice(3,"考勤通知！","老师",new Date());
		
		//添加公告
		ArrayList noticeList = new ArrayList();
		noticeList.add(notice1);
		noticeList.add(notice2);
		noticeList.add(notice3);
		
		//显示公告
		System.out.println("公告的内容为：");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
			//get返回值类型是一个object类，为getTitle的对象要求是一个notice类
			//所以必须用强制类型转换，把object类转换成notice类
				
		}
		
		Notice notice4 = new Notice(4,"在线编辑器可以使用啦!","管理员",new Date());
		noticeList.add(1,notice4);
		
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		System.out.println("***********************************************");
		//删除按时完成作业的公告
		noticeList.remove(2);
		//显示公告
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		
		//将第二条公告改为：Java在线编辑器可以使用啦！
		System.out.println("***********************************************");
		notice4.setTitle("Java在线编辑器可以使用啦！");
		noticeList.set(1, notice4);
		
		//注意：在本例题中，使用setTitle就可以了，如果创建一个新的对象，用新的方法去替换
		//notice4的时候需要调用ArrayList的set方法
		System.out.println("修改后公告的内容为：");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
	}

}
