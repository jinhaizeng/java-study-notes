package com.imooc.string;

public class StringDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ַ�����byte����֮��Ļ���ת��
		//����һ���ַ���
		String str = new String("JAVA ��� ����");
		//���ַ���ת��Ϊbyte���飬����ӡ���
		byte[] arrs = str.getBytes();
		for(int i=0;i < arrs.length; i++) {
			System.out.print(arrs[i]+" ");
		}
		
		System.out.println();
		//��byte����ת��Ϊ�ַ���
		String str1 = new String(arrs);
		System.out.println(str1);
	}

}
