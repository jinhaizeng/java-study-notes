package com.imooc.animal;

public class Master {
	/*ι����
	 * ιè�����궫�������˻����ȥ������
	 * ι�������궫�������˻����ȥ˯��
	 * �����ӡ������ġ����ڹ�...
	 * */
	//version1 ÿ�����ﶼ����һ��feed�������������صķ�ʽ��ʵ�֣�����һ����������Ժ�
	//�����д��ܷ���
//	public void feed(Cat cat) {
//		cat.eat();
//		cat.palyBall();
//	}
//	public void feed(Dog dog) {
//		dog.eat();
//		dog.sleep();
//	}
	
	//version2 ����ͨ������ת�ͺ�����ת����ʵ��
	public void feed(Animal obj) {
		if(obj instanceof Cat) {
			Cat temp =(Cat) obj;
			temp.eat();
			temp.palyBall();
		}
		else if(obj instanceof Dog) {
			Dog temp =(Dog) obj;
			temp.eat();
			temp.sleep();
		}
	}
	
}
