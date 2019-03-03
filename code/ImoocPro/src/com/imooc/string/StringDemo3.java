package com.imooc.string;

public class StringDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//字符串和byte数组之间的互相转换
		//定义一个字符串
		String str = new String("JAVA 编程 基础");
		//将字符串转换为byte数组，并打印输出
		byte[] arrs = str.getBytes();
		for(int i=0;i < arrs.length; i++) {
			System.out.print(arrs[i]+" ");
		}
		
		System.out.println();
		//将byte数组转换为字符串
		String str1 = new String(arrs);
		System.out.println(str1);
	}

}
