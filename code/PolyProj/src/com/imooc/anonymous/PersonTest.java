package com.imooc.anonymous;

public class PersonTest {
	//���ݴ���Ĳ�ͬ���˵����ͣ����ö�Ӧ��read����
	//����1 
	public void getRead(Man man) {
		man.read();
	}
	public void getRead(Woman woman) {
		woman.read();
	}
	
	//����2
	public void getRead(Person person) {
		person.read();			//�ɸ���������Ĺ�ϵ��֪�������㴫������ͻ�
								//ѡ���㴫��������д��read����
	}
	
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		Man one = new Man();
		Woman two = new Woman();
		test.getRead(one);
		test.getRead(two);
	}
}
