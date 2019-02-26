package com.imooc.animal;

public class Dog extends Animal {
	//属性
	private String sex;
	
	//构造方法
	public Dog() {
		
	}

	//getter setter
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//方法：睡觉
	public void sleep() {
		System.out.println(this.getName()+"现在"+this.getMonth()+"个月大了！");
	}
}
