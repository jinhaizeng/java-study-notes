package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo2 {

	public static void main(String[] args) {
		// ����һ��FileInputStream����
		try {
			FileInputStream fis = new FileInputStream("imooc.txt");
			byte[] b = new byte[100];
			fis.read(b);							//���ļ���ȡ���ֽ�������
			System.out.println(new String(b));		//���ֽ�����ת���ַ���
			fis.close(); // ������������������ʱ��һ��Ҫ�ر�����������ͷ���Դ
		} catch (FileNotFoundException e) {
			// FileNotFoundException��IOException�����࣬���IOException��ǰ��FileNotFoundException����Զ��ִ�в���
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
