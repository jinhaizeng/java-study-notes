package com.imooc.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// 用于实现字节流转字符流，这样直接输出字符数据

		try {
			FileInputStream fis = new FileInputStream("imooc.txt");
			// 建立字节流和字符流的关联
			InputStreamReader isr = new InputStreamReader(fis);
			
			int n = 0;
			char[] cbuf = new char[10];
			
			//方法一：此时n为字节楼读到的数据
			while((n = isr.read()) != -1) {
				System.out.print((char)n);
			}
			//方法二：此时n为实际读到的字节数
			while ((n = isr.read(cbuf)) != -1) {
				String s = new String(cbuf,0,n); 	//将字节数组转换为字符串
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
