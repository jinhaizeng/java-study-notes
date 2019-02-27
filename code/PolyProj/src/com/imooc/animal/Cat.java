package com.imooc.animal;

public class Cat extends Animal{
	//属性:体重
	private double weight;
	
	//构造方法
	public Cat() {
		
	}
	public Cat(String name,int month,double weight) {
		super(name,month);			//直接利用父类的构造，很有灵性
		this.setWeight(weight);
	}
	
	//getter setter
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//方法：跑步
	public void run() {
		System.out.println("小猫快乐的奔跑");
	}
	//方法：吃东西(重写父类方法)
    @Override
    public void eat() {
    	// TODO Auto-generated method stub
    	System.out.println("猫吃鱼~~~");
    }
	public void palyBall() {
		// TODO Auto-generated method stub
		System.out.println("猫玩线球");;
	}
}
