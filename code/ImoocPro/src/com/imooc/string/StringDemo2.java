package com.imooc.string;

public class StringDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ַ���"JAVA��̻�������ϲ��java���"
		String str = new String("JAVA��̻�������ϲ��java���");
		
		//�����ַ�'A'���ַ����е�һ�γ��ֵ�λ��
		System.out.println("�����ַ�'A'���ַ����е�һ�γ��ֵ�λ��:"+str.indexOf('A'));
		
		//�����Ӵ�"���"���ַ����е�һ�γ��ֵ�λ��
		System.out.println("�Ӵ�\"���\"���ַ����е�һ�γ��ֵ�λ��"+str.indexOf("���"));
	
		//�����ַ�'A'���ַ��������һ�γ��ֵ�λ��
		System.out.println("�����ַ�'A'���ַ��������һ�γ��ֵ�λ��:"+str.lastIndexOf('A'));
	}

}
 