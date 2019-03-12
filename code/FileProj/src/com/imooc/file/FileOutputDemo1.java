package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo1 {

	public static void main(String[] args) {
		// 文件拷贝
		try {
			FileInputStream fis = new FileInputStream("happy.jpg");
			FileOutputStream fos = new FileOutputStream("happycopy.jpg");
			
			int n = 0;
			byte[] b = new byte[1024];
			while((n = fis.read(b)) != -1)			//注意，文件较大，所以是一段一段的读入再写入的
				fos.write(b);						//在写满1024个byte以后判断是不是为空，非空则继续写
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
