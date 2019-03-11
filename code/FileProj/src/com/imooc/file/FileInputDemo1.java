package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo1 {

	public static void main(String[] args) {
		// ����һ��FileInputStream����
		try {
			FileInputStream fis = new FileInputStream("imooc.txt");

			int n = 0;
			while((n = fis.read()) != -1) {
				System.out.print((char)n);
				
			}
			
			fis.close();							//������������������ʱ��һ��Ҫ�ر�����������ͷ���Դ
		} catch (FileNotFoundException e) {	
			//FileNotFoundException��IOException�����࣬���IOException��ǰ��FileNotFoundException����Զ��ִ�в���
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
