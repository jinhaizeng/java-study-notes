package com.imooc.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryDemoThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int result = test();
			System.out.println("one和two的商是："+ result);
		} catch (ArithmeticException e) {
			System.out.println("要求除数不允许为零");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(InputMismatchException e) {
			System.out.println("请输入整数");
			e.printStackTrace();
		}
	}

	public static int test() throws ArithmeticException,InputMismatchException {
		Scanner input = new Scanner(System.in);
		System.out.println("=====运算开始=====");
		System.out.println("请输入第一个整数：");
		int one = input.nextInt();
		System.out.println("请输入第二个整数：");
		int two = input.nextInt();
		System.out.println("=====运算结束=====");
		return one/two;
	}
}
