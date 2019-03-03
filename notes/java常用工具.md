[TOC]
# 一、java异常
## 1.什么是异常
异常本质上是程序上的错误
## 2.异常的分类
异常——Throwable，分为以下两类：
* Error：是程序无法处理的错误，表示运行应用程序中较严重问题。常见错误：虚拟机错误、内存溢出、线程死锁
* Exception：程序本身可以处理的异常。异常处理通常指针对这中类型异常的处理。常见错误：检查错误、非检查错误
    非检查异常：编译器不要求强制处置的异常——空指针异常、数组下标越界、算数异常、类型转换异常
    检查异常：编译器要求必须处理的异常——IO异常、SQL异常
## 3.异常处理
### 3.1基本概念
异常处理机制为：
1. 抛出异常
2. 捕获异常

java规定
* 对于可查异常必须捕捉或者声明抛出
* 允许忽略不可查的Runtime（含子类）和Erro（含子类）

抛出异常和捕获异常通过五个关键字来实现：try、catch、finally、throw、throws  
* 捕获异常
    1. try：执行可能产生异常的代码
    2. catch：捕获异常
    3. finally：无论是否发生异常代码总能执行
* 声明异常
    throws：声明可能要抛出的异常
* 抛出异常
    throw：手动抛出异常

### 3.2try-catch-finally
```java
public void method(){
    try{
        //代码段1
        //产生异常的代码段2
    }catch(异常类型 ex){
        //对唱进行处理的代码段3
    }finally{
        //代码段4
    }
}
```
finally块：无论是否发生异常代码总能执行
try块后可接零个或多个catch块，如果没有catch块，则必须跟一个finally块（catch和finally也是不能单独使用的）
### 3.3 try-catch-finally结构进行异常处理
* 可能发生异常的代码放到try块里
* try块发生异常时，由下面的catch块捕获，处理；如果代码中没有异常，catch块不会执行
* finally块无论catch块是否执行，finally语句块都会被执行
```java
    Scanner input = new Scanner(System.in);
	System.out.println("=====运算开始=====");
try {
	    System.out.println("请输入第一个整数：");
	    int one = input.nextInt();
	    System.out.println("请输入第二个整数：");
	    int two = input.nextInt();
	    System.out.println("one和two的商是："+(one/two));
	}catch(Exception e) {
		System.out.println("程序出错~~~~");
        e.printStackTrace();                    //打印程序出错的信息
	}finlay{
        System.out.println("=====运算结束=====");
    }
```
打印出来的程序出错信息应该从下往上看
### 3.4 多重catch结构处理异常
针对算数异常、输入格式异常进行处理，但安全起见，我们常在多重catch块中添写一个
```java
catch(Exception e) {
		System.out.println("出错了~~~~");
		e.printStackTrace();
	}
```
用他来追踪前面`Exception`子类中无法被捕获的信息
实例程序
```java
    Scanner input = new Scanner(System.in);
	System.out.println("=====运算开始=====");
try {
		System.out.println("请输入第一个整数：");
		int one = input.nextInt();
		System.out.println("请输入第二个整数：");
		int two = input.nextInt();
		System.out.println("one和two的商是："+(one/two));
	}catch(ArithmeticException e) {
		System.out.println("除数不允许为零~~~~");
		e.printStackTrace();
	}catch(InputMismatchException e) {
		System.out.println("请输入整数~~~~");
		e.printStackTrace();
	}catch(Exception e) {
		System.out.println("出错了~~~~");
		e.printStackTrace();
	}finally {
		System.out.println("=====运算结束=====");
	}
```
-------------------------------------------------------------
终止`finally`的语句
`Syemtem.exit(1);`      //当前程序无条件终止运行
--------------------------------------------------------------
return关键字在语句中的使用
```java
    Scanner input = new Scanner(System.in);
	System.out.println("=====运算开始=====");
try {
		System.out.println("请输入第一个整数：");
		int one = input.nextInt();
		System.out.println("请输入第二个整数：");
		int two = input.nextInt();
		return one/two;
	}catch(ArithmeticException e) {
		System.out.println("除数不允许为零~~~~");
		return 0;
	}finally {
		System.out.println("=====运算结束=====");
        return -100000;
	}
```
此时无论是否发生异常，都会直接执行最后的`finally`的`return -10000;`这是`finally`的强制执行的原因。
若想要上面的代码正常使用，可以直接`// return -10000;`
### 3.5 throw & throws
#### throws语法
* 可以通过throws声明将要抛出何种类型的异常，通过throw将产生的异常异常抛出
* 如果一个方法可能会出现异常，但是没有能力处理这种异常，可以再方法声明出用throws子句来声明抛出异常。谁调用了这个方法，谁就要处理这个异常
* throws语句用在方法定义时声明该方法要抛出的异常类型
```java
public void method() throws Exception1,Exception2,...,ExceptionN{
    //可能产生异常的代码 
}
```
* 当方法抛出异常列表中的异常时，方法将不对这些类型及其子类类型的异常作处理，而抛向调用该方法的方法，由他去处理。
* 快速写`try-catch`块的方法，可以选择要放入catch的代码，右键，`surrounded with`选中`try catch Bloack`
示例代码：
```java
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
		}
	}

	public static int test() throws ArithmeticException {
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
```
抛出的一个异常处理类型只能处理一种类型的异常
通过throws抛出异常时，针对可能出现的多种异常情况，解决方案：
1. 方案一：`throws Exception1,Exception2,...,ExceptionN`这样的形式
```java
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
```
2. 方案二：throws后接Exception
```java
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
		}catch(Exception e){                    //此处必须有`Exception`这个catch

        }
	}

	public static int test() throws Exception {
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
```
#### throw语法
* throw用来抛出一个异常
    例如：`throw new IOException`
* throw抛出的只能够是可抛出类Throwable或者其子类的实例对象
    例如：`throw new String("出错了");`是错误的

throw抛出并处理两种异常的方案：
* 方案一：通过try..catch包含throw语句——自己抛出，自己处理
```java
public void method(){
    try{
        //代码段1
        throw new 异常类型();
    }catch(异常类型 ex){
        //对异常进行处理的代码段2
    }
}

```
* 方案二：通过throws在方法声明出抛出异常类型——自己抛出，谁用谁处理，也可以继续向上抛，由上层处理。此时可以抛出与throw对象相同的类型或者其父类
```java
public void method() throw 异常类型{
    //代码段1
    throw new 异常类型();
}
```
示例代码
```java
public class TryDemoFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testAge();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void testAge() throws Exception{

		System.out.println("请输入年龄：");
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if (age < 18 || age > 80) {
			throw new Exception("18岁以下，80岁以上的住客必须由亲友陪同");
		} else {
			System.out.println("欢迎入住本酒店");
		}

	}

}
```

在程序运行过程中，对异常对象的处理的作用：
1. 规避可能出现的风险
2. 完成一些程序的逻辑
示例程序：酒店入住年龄在18岁以下，80岁以上的住客必须由亲友陪同
* 方法1
示例代码
```java
public class TryDemoFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAge();
	}
	public static void testAge() {
		try {
			System.out.println("请输入年龄：");
			Scanner input = new Scanner(System.in);
			int age = input.nextInt();
			if(age<18 || age > 80) {
				throw new Exception("18岁以下，80岁以上的住客必须由亲友陪同");
			}else {
				System.out.println("欢迎入住本酒店");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
```

* 方法2
示例代码
```java
public class TryDemoFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testAge();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void testAge() throws Exception{      //若将Exception改成Throwable也行，因为Throwable是他的子类，即可以抛父类，但是不抛子类

		System.out.println("请输入年龄：");
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if (age < 18 || age > 80) {
			throw new Exception("18岁以下，80岁以上的住客必须由亲友陪同");
		} else {
			System.out.println("欢迎入住本酒店");
		}

	}

}
```

### 3.6自定义异常
* 使用java内置的异常类可以描述在编程时出现的大部分异常情况
* 也可以通过自定义异常描述特定业务产生的异常类型
* 所谓自定义异常，就是定义一个类，去继承Throwable类或者它的子类
自定义异常的定义示例代码（详细代码见ExceptionProj工程的TryDemoFour）：
```java
package com.imooc.test;

public class HotelAgeException extends Exception {
	public HotelAgeException(){
		super("18岁以下，80岁以上的住客必须由亲友陪同");
	}
}
```

### 3.7 异常链
有时候我们会捕获一个异常后再抛出另一个异常，顾名思义就是：将异常发生的原因一个一个串起来，即把底层的异常信息传给上层，然后逐层抛出（详细代码见ExceptionProj工程的TryDemoFive）：
```java
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
			throw new Exception("我是新产生的异常1");
		}
	}
	public static void testThree() throws Exception{
		try {
			testTwo();
		}catch(Exception e) {
			throw new Exception("我是新产生的异常2");
		}
	}	
}
```
此种方法只会抛出"我是新产生的异常2"，若想抛出所有的异常，应该采用如下方法
```java
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
```
### 3.8小结
实际应用中的经验与总结：
* 处理运行时异常，采用逻辑去合理规避同时辅助try-catch处理
* 在多重catch块后面，可以加一个catch(Exception)来处理可能会被遗漏的异常
* 对于不确定的代码，也可以加上try-catch，处理潜在的异常
* 尽量去处理异常，切忌只是简单的调用printStackTrace()去打印输出
* 具体如何处理异常，要根据不同的业务需求和异常类型去决定
* 尽量添加finally语句块去是释放占用的资源
* 当子类重写父类抛出异常的方法时，声明的异常必须是父类方法所声明异常的同类或子类

# 二、java包装类
包装类为了解决基本数据类型没有属性、方法、无法对象化交互的问题
## 1.基本数据和包装类之间的转换
* 装箱：将基本数据类型转换成对应的包装类
* 拆箱：将包装类转换成对应的基本数据类型
```java
int t1 = 2;
//1.自动装箱——即装箱操作
Integer t2 =t1;
		
//测试
System.out.println("int类型变量t1 ="+ t1);
System.out.println("int类型变量t2 ="+ t2);
```

## 2.基本数据类型和字符串之间的转换
这一部分没有搞懂原理，只是会用这个方法而已，有时间要再看一下原理的部分

## 3.需要了解的几点知识
### 3.1包装类对象的初始值
### 3.2包装类对象间的比较
经典例题
```java
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
```
`byte short int long char boolen`都是可以应用对象常量池这个概念的，但是`float double`这个两个概念是不可以应用对象常量值这个概念的
```java
Double d1 = Double.valueOf(100);
Double d2 = Double.valueOf(100);
System.out.println("d1 == d2结果："+(d1 == d2))；		//结果false
```

# 三、字符串处理类
## 1.String常用方法
### 1.1 创建String对象的方法
```java
String s1 = "imooc";			//创建一个字符串对象imooc，名为s1
String s2 = new String();		//创建一个空字符串对象，名为s2
String s3 = new String("imooc");//创建一个字符串对象imooc，名为s3
```
### 1.2String的常用方法
![String的常用方法](https://raw.githubusercontent.com/jinhaizeng/java-study-notes/master/%E5%9B%BE%E5%BA%8A/String%E7%9A%84%E5%B8%B8%E7%94%A8%E6%96%B9%E6%B3%95.PNG)