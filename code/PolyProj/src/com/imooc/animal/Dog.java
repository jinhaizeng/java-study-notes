package com.imooc.animal;

public class Dog extends Animal {
	//���ԣ��Ա�
	private String sex;
	
	//���췽��
	public Dog() {
		
	}
	public Dog(String name,int month,String sex) {
		super(name,month);
		this.setSex(sex);
	}
	
	//getter setter
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	//����:˯��
	public void sleep() {
		System.out.println("С������˯��ϰ��");
	}
	
	//�������Զ�������д���෽����
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("������~~~");
	}
}
