package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo1 {

	public static void main(String[] args) {
		// �ļ�����
		try {
			FileInputStream fis = new FileInputStream("happy.jpg");
			FileOutputStream fos = new FileOutputStream("happycopy.jpg");
			
			int n = 0;
			byte[] b = new byte[1024];
			while((n = fis.read(b)) != -1)			//ע�⣬�ļ��ϴ�������һ��һ�εĶ�����д���
				fos.write(b);						//��д��1024��byte�Ժ��ж��ǲ���Ϊ�գ��ǿ������д
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
