package com.imooc.animal;

public class Cat extends Animal {
	//属性
	private double weight;
	//构造函数
	public Cat() {
		
	}
	
	//setter getter
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//方法：跑步
	public void run() {
		System.out.println(this.getName()+"是一只"+this.getSpecies()+",他在快乐的奔跑");
	}
	
}