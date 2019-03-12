package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOuptDemo {

	public static void main(String[] args) {
		//创建输出文件流
		FileOutputStream fos;
		FileInputStream fis;
		try {
			fos = new FileOutputStream("imooc.txt",true);
			fis = new FileInputStream("imooc.txt");
			fos.write(50);
			fos.write('a');
			System.out.println(fis.read());
			System.out.println((char)fis.read());
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
