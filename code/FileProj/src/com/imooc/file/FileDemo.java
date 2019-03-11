package com.imooc.file;

import java.io.File;
import java.io.IOException; 

public class FileDemo {

	public static void main(String[] args) {
		//����File����
		File file1 = new File("E:\\Knowledge System\\JAVA\\java study notes\\code\\FileProj\\imooc\\io\\score.txt");
		//�ж����ļ�����Ŀ¼
		System.out.println("�Ƿ���Ŀ¼��"+file1.isDirectory());
		System.out.println("�Ƿ����ļ���"+file1.isFile());
		
		//����Ŀ¼
		File file2 = new File("E:\\Knowledge System\\JAVA\\java study notes\\code\\FileProj\\imooc\\set\\HashSet");
		if(!file2.exists()) {
			file2.mkdirs();
		}
		
		//�����ļ�
		if(!file1.exists()) {
			try { 
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
