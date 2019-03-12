package com.imooc.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedDemo {

	public static void main(String[] args) {
		// 创建缓冲输入输出流
		try {
			FileOutputStream fos = new FileOutputStream("imooc.txt");
			//BufferedOutputStream是FileOutputStream的子类所以要实现bos的创建应用fos来创建
			BufferedOutputStream bos = new BufferedOutputStream(fos);	
			
			FileInputStream fis = new FileInputStream("imooc.txt");
			//创建缓冲输入流也同理
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			bos.write(50);
			bos.write('a');
			bos.flush();
			System.out.println(bis.read());
			System.out.println((char)bis.read());
			
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
