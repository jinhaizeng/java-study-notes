package com.imooc.string;

public class StringDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ַ���"JAVA ��� ����"
		String str = "JAVA ��� ����";
		//��ӡ����ַ����ĳ���
		System.out.println("�ַ����ĳ����ǣ�"+str.length());
		
		//ȡ���ַ����̡������
		System.out.println(str.charAt(6));
		
		//ȡ���Ӵ������ �����������
		System.out.println(str.substring(5));
		
		//ȡ���Ӵ��������
		System.out.println(str.substring(5,7));
	}
}
