package com.imooc.animal;

public class Cat extends Animal {
	//����
	private double weight;
	//���캯��
	public Cat() {
		
	}
	
	//setter getter
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//�������ܲ�
	public void run() {
		System.out.println(this.getName()+"��һֻ"+this.getSpecies()+",���ڿ��ֵı���");
	}
	
}