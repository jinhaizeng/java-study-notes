package com.imooc.set;

public class Cat {
	private String name;
	private int month;
	private String Species;
	
	//���췽��
	public Cat(String name, int month, String species) {
		super();
		this.name = name;
		this.month = month;
		Species = species;
	}

	//getter��setter
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
	public String toString() {	//����д�Ļ���println������Ƕ���ĵ�ַ
		return "[����=" + name + ", ����=" + month + ", Ʒ��=" + Species + "]";
	}
	
	
	
}
