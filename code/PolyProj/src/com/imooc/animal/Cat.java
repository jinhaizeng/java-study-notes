package com.imooc.animal;

public class Cat extends Animal{
	//����:����
	private double weight;
	
	//���췽��
	public Cat() {
		
	}
	public Cat(String name,int month,double weight) {
		super(name,month);			//ֱ�����ø���Ĺ��죬��������
		this.setWeight(weight);
	}
	
	//getter setter
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//�������ܲ�
	public void run() {
		System.out.println("Сè���ֵı���");
	}
	//�������Զ���(��д���෽��)
    @Override
    public void eat() {
    	// TODO Auto-generated method stub
    	System.out.println("è����~~~");
    }
	public void palyBall() {
		// TODO Auto-generated method stub
		System.out.println("è������");;
	}
}
