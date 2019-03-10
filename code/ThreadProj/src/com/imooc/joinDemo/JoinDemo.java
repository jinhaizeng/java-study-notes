package com.imooc.joinDemo;

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i=0; i < 10;i++)
			System.out.println(getName()+"正在执行第"+i+"次！");
	}
}
public class JoinDemo {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i < 20; i++)
			System.out.println("主进程运行第"+i+"次！");
	}
}
