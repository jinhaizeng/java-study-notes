package test;
import testclass.Cat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat one = new Cat(50);
		System.out.println(one.getAge());
//		String a = "hello world!";
//		System.out.println(a);
		
		
		int[] temp = new int[10];
		System.out.println(temp);
		for(int n:temp) {
			System.out.println(temp[n]);
		}
	}

}
