package com.imooc.method;

import java.util.Scanner;

public class ArraySearch {
	// 查找数组元素值的方法
	public boolean search(int n,int[] arr) {
		boolean flag = false;
		for(int i:arr) {
			if(n == i) {
				flag =true;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50};
		Scanner sc = new Scanner(System.in);
		System.out.println("pelase inpu!");
		int n1 = sc.nextInt();
		ArraySearch as = new ArraySearch();
		boolean flag = as.search(n1, arr1);
		if(flag) {
			System.out.println("i have found it!");
		}
		else {
			System.out.println("i didn't find it!");
		}
		

	}

}
