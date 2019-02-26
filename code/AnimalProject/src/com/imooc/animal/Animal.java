package com.imooc.animal;

public class Animal {
	//属性
	private String name;	//昵称
	private int month;		//月份
	private String species;    //品种
	
	//构造方法
	public Animal() {
		
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	//方法：吃东西
	public void eat() {
		System.out.println(this.getName()+"在吃东西");
	}
}
