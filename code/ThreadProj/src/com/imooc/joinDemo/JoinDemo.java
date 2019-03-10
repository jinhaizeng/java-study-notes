package com.imooc.joinDemo;

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i=0; i < 10;i++)
			System.out.println(getName()+"����ִ�е�"+i+"�Σ�");
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
			System.out.println("���������е�"+i+"�Σ�");
	}
}
