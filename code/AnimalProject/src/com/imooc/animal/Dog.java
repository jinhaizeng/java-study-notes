package com.imooc.animal;

public class Dog extends Animal {
	//����
	private String sex;
	
	//���췽��
	public Dog() {
		
	}

	//getter setter
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//������˯��
	public void sleep() {
		System.out.println(this.getName()+"����"+this.getMonth()+"���´��ˣ�");
	}
}
