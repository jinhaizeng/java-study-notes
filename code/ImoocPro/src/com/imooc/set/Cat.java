package com.imooc.set;

public class Cat {
	private String name;
	private int month;
	private String Species;
	
	//构造方法
	public Cat(String name, int month, String species) {
		super();
		this.name = name;
		this.month = month;
		Species = species;
	}

	//getter和setter
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
		return Species;
	}

	public void setSpecies(String species) {
		Species = species;
	}

	@Override
	public String toString() {	//不重写的话，println输出的是对象的地址
		return "[姓名=" + name + ", 年龄=" + month + ", 品种=" + Species + "]";
	}
	
	
	
}
