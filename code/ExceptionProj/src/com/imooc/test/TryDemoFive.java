package com.imooc.test;

public class TryDemoFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testThree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testOne() throws HotelAgeException{
		throw new HotelAgeException();
	}
	
	public static void testTwo() throws Exception{
		try{
			testOne();
		}catch(HotelAgeException e){
			throw new Exception("我是新产生的异常1",e);
		}
	}
	public static void testThree() throws Exception{
		try {
			testTwo();
		}catch(Exception e) {
			//throw new Exception("我是新产生的异常2");
			Exception e1 = new Exception("我是新产生的异常2");
			e1.initCause(e);
			throw e1;
		}
	}	
}
