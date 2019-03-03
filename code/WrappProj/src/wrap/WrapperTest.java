package wrap;

public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer one = new Integer(100);
		Integer two = new Integer(100);
		System.out.println("one==two的结果："+(one == two));			//结果false
		
		Integer three = 100;	//自动装箱
		//相当于隐式的执行了：Integer three = Integer.valueOf(100);
		//因为缓存区没有，所以其会在缓存区构建一个
		System.out.println("three==100的结果是："+(three == 100));	//自动拆箱		//结果true
		
		Integer four = 100;
		////相当于隐式的执行了：Integer three = Integer.valueOf(100);
		//当这个值>-128且<127时，会直接调用缓存区内已经构建的那个100
		//此时three和four指向缓存区的同一块空间
		System.out.println("three==four的结果是："+(three == four));		//结果true
		
		Integer five = 200;
		System.out.println("five==200的结果是："+(five == 200));			//结果true
		
		Integer six = 200;
		//数值超过127，会直接通过new integer(200)构造新的实例化对象
		System.out.println("five==six的结果是："+(five==six));			//结果false
			
	}

}
