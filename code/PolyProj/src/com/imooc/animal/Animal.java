package com.imooc.animal;

public  class Animal {
	//���ԣ��ǳơ�����
	private String name;
	private int month;
	
	//���췽��
	public Animal() {
		
	}
	public Animal(String name,int month) {
		this.setName(name);
		this.setMonth(month);
		
	}
	
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	//�������Զ���
	public void eat() {
		System.out.println("���ﶼ�гԶ���������");
	}
}
