package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo1 {

	public static void main(String[] args) {
		// 创建一个FileInputStream对象
		try {
			FileInputStream fis = new FileInputStream("imooc.txt");

			int n = 0;
			while((n = fis.read()) != -1) {
				System.out.print((char)n);
				
			}
			
			fis.close();							//完成输入输出流操作的时候，一定要关闭输入输出以释放资源
		} catch (FileNotFoundException e) {	
			//FileNotFoundException是IOException是子类，如果IOException在前，FileNotFoundException将永远都执行不到
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
