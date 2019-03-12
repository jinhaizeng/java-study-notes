package com.imooc.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// ����ʵ���ֽ���ת�ַ���������ֱ������ַ�����

		try {
			FileInputStream fis = new FileInputStream("imooc.txt");
			// �����ֽ������ַ����Ĺ���
			InputStreamReader isr = new InputStreamReader(fis);
			
			int n = 0;
			char[] cbuf = new char[10];
			
			//����һ����ʱnΪ�ֽ�¥����������
			while((n = isr.read()) != -1) {
				System.out.print((char)n);
			}
			//����������ʱnΪʵ�ʶ������ֽ���
			while ((n = isr.read(cbuf)) != -1) {
				String s = new String(cbuf,0,n); 	//���ֽ�����ת��Ϊ�ַ���
				System.out.print(s);
			}
			
			fis.close();
			isr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
