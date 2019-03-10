package com.imooc.runnable;

class PrintRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在运行！");
		
	}
}

public class RunnableTest {

	public static void main(String[] args) {
		PrintRunnable pr = new PrintRunnable();
		Thread t1 = new Thread(pr);
		t1.start();
		Thread t2 = new Thread(pr);
		t2.start();
	}
}