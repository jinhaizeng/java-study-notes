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

 ### 1.3 length() charAt() substring()示例程序
 ```java
 //定义一个字符串"JAVA 编程 基础"
String str = "JAVA 编程 基础";
//打印输出字符串的长度
System.out.println("字符串的长度是："+str.length());
		
//取出字符“程”并输出
System.out.println(str.charAt(6));
		
//取出子串“编程 基础”并输出
System.out.println(str.substring(5));
		
//取出子串“”编程
System.out.println(str.substring(5,7));
```

### 1.4indexOf()和lastIndxOf()
```java
//定义一个字符串"JAVA编程基础，我喜欢java编程"
String str = new String("JAVA编程基础，我喜欢java编程");
		
//查找字符'A'在字符串中第一次出现的位置
System.out.println("查找字符'A'在字符串中第一次出现的位置:"+str.indexOf('A'));
		
//查找子串"编程"在字符串中第一次出现的位置
System.out.println("子串\"编程\"在字符串中第一次出现的位置"+str.indexOf("编程"));
	
//查找字符'A'在字符串中最后一次出现的位置
System.out.println("查找字符'A'在字符串中最后一次出现的位置:"+str.lastIndexOf('A'));
```
### 1.5getBytes()方法的使用
```java
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
ystem.out.println(str1);
```
### 1.6等于运算符和equals方法的区别
equals判断的是内容是否相同，等于运算符判断的是地址是否相同
```java
//==和equals方法的区别
//定义是哪个字符串，内容都是imooc
String str1 = "imooc";
String str2 = "imooc";
String str3 = new String("imooc");
System.out.println("str1和str2的内容相同？"+(str1.equals(str2)));
System.out.println("str2和str3的内容相同？"+(str2.equals(str3)));

System.out.println("str1和str2的地址相同？"+(str1 = str2));
System.out.println("str2和str3的地址相同？"+(str2 = str3));
```
![str创建对象语句的区别](https://raw.githubusercontent.com/jinhaizeng/java-study-notes/master/%E5%9B%BE%E5%BA%8A/str%E5%88%9B%E5%BB%BA%E5%AF%B9%E8%B1%A1%E8%AF%AD%E5%8F%A5%E7%9A%84%E5%8C%BA%E5%88%AB.PNG)

### 1.7 字符串的不可变性
`String`的不可变性：String对象一旦被创建，则不能修改，是不可变的。所谓的修改其实是创建了新的对象，所指向的内存空间不变。
```java
String s1 = "imooc";
s1 = "hello,"+s1;
//s1不再指向imooc所在的内存空间，而是指向了"hello,imooc"（新创建的对象）
System.out.println("s1="+s1)
```

```java
String s3 = "hello,imooc";
System.out.println("子串："+s3.substring(0,5));			//此句相当如在常量池生成了一个hello，注意此时s3不变
System.out.println("s3="+s3);
```
## 2.StringBuilder
* String和StringBuilder的区别：
	String具有不可变性，而StringBuilder不具备
* 建议：
	当频繁操作字符串时，使用StringBuilder。因为string具有不可变性，当频繁操作String时，会产生大量的中间变量，也会产生很多在常量池中废弃的数据，而使用StringBuilder时可以避免这种情况的发生
* StringBuilder和StringBuffer区别
	* 两者基本相似
	* StringBuffer是线程安全的，StringBuilder则没有，所以性能略高

```java
//定义一个字符串"你好"
StringBuilder str = new StringBuilder("你好");
//在"你好"后面添加内容，将字符串编程"你好,imooc!"
//方法一
Str.append(',');
Str.append("imooc!");
//方法二
Str.append(',').append("imooc!");
//以上两种方法所得到的结果都是相同的

//将字符串编程"你好，imOOC！"
//两种方式：
// 1.使用delete方法删除mooc，然后在插入MOOC
str.delete(4,8).insert(4,"MOOC");
// 2.使用replace方法直接替换
str.replace(4,8,"MOOC");   
```

# 四、java集合
使用集合相关函数，要注意导入包`java.util`
Java中的集合是工具类，可以存储任意数量的具有共同属性的对象
为什么使用集合，而不使用数组呢？
集合的应用场景
* 无法预测存储数据的数量
* 同时存储具有一对一关系的数据
* 需要进行数据的增删
* 数据重复问题

## 1.集合框架的体系结构
由两部分"Collection——类的对象"和"Map——键值对"组成
Collection由三部分组成：
* List——序列：有序，可以有重复，举例：ArrayList，类似动态数组
* Queue——队列：有序，可以有重复，举例：LinkList，表示链表		
* Set——集：无序，不可以有重复，举例：HanshSet，表示哈希集
Map的主要实现类：HashMap（哈希表），以键值对的形式呈现

## 2 List概述
* List是元素有序并且可以重复的集合，称为序列
* List可以精确的控制每个元素的插入位置，或删除某个位置的元素
* List的两个主要实现类是ArrayLiat和LinkedList
### ArrayList
* ArrayList底层由数组实现的
* 动态增长，以满足应用程序的需求
* 在列表尾部插入或删除数据非常有效
* 更适合查找和更新元素
* ArrayList中的元素可以为null
```java
//用ArrayList存储编程语言的名称，并输出
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("C");
		list.add("C++");
		list.add("Go");
		list.add("swift");
		//输出列表中元素的个数
		System.out.println("列表中元素的个数为："+list.size());
		
		System.out.println("********************************");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
		
		System.out.println();
		//方法一
		list.remove(2);
		
		//方法二
		list.remove("C++");
		System.out.println("********************************");
		System.out.println("移除C++以后的列表元素为：");
		for(int i=0;i < list.size(); i++)
		{
			System.out.print(list.get(i)+",");
		}
```

案例：公告管理
需求：
* 公告的添加和显示
* 在指定位置处插入公告
* 删除公告
* 修改公告

公告类属性：
* 编号 id
* 标题 title
* 创建人 creator
* 创建时间 createTime

公告类方法：
* 构造方法
* 获取和设置属性值的方法
详细内容见ImoocPro的包"com.imooc.set"
#### 公告的添加和显示
```java
// TODO Auto-generated method stub
		Notice notice1 = new Notice(1,"欢迎来到慕课网!","管理员",new Date());
		Notice notice2 = new Notice(2,"请同学们按时提交作业！","老师",new Date());
		Notice notice3 = new Notice(3,"考勤通知！","老师",new Date());
		
		//添加公告
		ArrayList noticeList = new ArrayList();
		noticeList.add(notice1);
		noticeList.add(notice2);
		noticeList.add(notice3);
		
		//显示公告
		System.out.println("公告的内容为：");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
			//get返回值类型是一个object类，为getTitle的对象要求是一个notice类
			//所以必须用强制类型转换，把object类转换成notice类
		}
```
#### 公告的删除和修改 
```java
// TODO Auto-generated method stub
		Notice notice1 = new Notice(1,"欢迎来到慕课网!","管理员",new Date());
		Notice notice2 = new Notice(2,"请同学们按时提交作业！","老师",new Date());
		Notice notice3 = new Notice(3,"考勤通知！","老师",new Date());
		
		//添加公告
		ArrayList noticeList = new ArrayList();
		noticeList.add(notice1);
		noticeList.add(notice2);
		noticeList.add(notice3);
		
		//显示公告
		System.out.println("公告的内容为：");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
			//get返回值类型是一个object类，为getTitle的对象要求是一个notice类
			//所以必须用强制类型转换，把object类转换成notice类
				
		}
		
		Notice notice4 = new Notice(4,"在线编辑器可以使用啦!","管理员",new Date());
		noticeList.add(1,notice4);
		
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		System.out.println("***********************************************");
		//删除按时完成作业的公告
		noticeList.remove(2);
		//显示公告
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
		
		
		//将第二条公告改为：Java在线编辑器可以使用啦！
		System.out.println("***********************************************");
		notice4.setTitle("Java在线编辑器可以使用啦！");
		noticeList.set(1, notice4);
		
		//注意：在本例题中，使用setTitle就可以了，如果创建一个新的对象，用新的方法去替换
		//notice4的时候需要调用ArrayList的set方法
		System.out.println("修改后公告的内容为：");
		for(int i=0;i < noticeList.size();i++) {
			System.out.println(i+1+":"+((Notice)(noticeList.get(i))).getTitle());	
		}
```
## 3.Set
Set是元素无序并且不可以重复的集合，被称为集
HashSet
* HashSet是Set的一个重要实现类，称为哈希集
* HashSet中的元素无序并且不可以重复
* HashSet只允许一个null元素
* 具有良好的存取和查找性能
 
Iterator（迭代器）
* Iterator接口可以以统一的方式对各种集合元素进行遍历
* hasNext()方法检测集合中是否还有下一个元素
* next()方法返回集合中的下一个元素
* 将集中元素导入到迭代器中
```java
Iterator it = set.iterator();
//遍历迭代器
while(it.hasNext()){
	System.out.print(it.next()+ "  ");  
}
```

### HashSet的应用例题
案例：用HashSet存储多个表示颜色的英文单词，并输出
单词包括：blue、red、black、yellow和white
```java
package com.imooc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WorldDemo {

	public static void main(String[] args) {
		// 讲英文单词添加到HashSet中
		Set set = new HashSet();
		//向集合中添加元素
		set.add("blue");
		set.add("red");
		set.add("black");
		set.add("yellow");
		set.add("white");
		//显示集合的内容
		System.out.println("集合中的元素为：");
		//将集合中的内容转存到迭代器中
		Iterator it = set.iterator();
		//遍历迭代器并输出元素
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		} 
		
		System.out.println();
		//在集合中插入一个新的单词,重复信息不会被插入到set集合中
		set.add("white");
		it = set.iterator();
		//遍历迭代器并输出元素
		System.out.println("******************************");
		System.out.println("插入重复元素后的输出结果为：");
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		} 
		//插入失败，但是不会报错
	}

}
```
### 宠物猫信息管理
需求
* 添加和显示宠物猫信息
* 查找某只宠物猫的信息并输出
* 修改宠物猫的信息
* 删除宠物猫的信息

属性
* 名字 name
* 年龄 month
* 品种 species

方法
* 构造方法
* 获取和设置属性值的方法
* 其他方法


详细代码内容见`com.imooc.set`包中的`Cat``CatTest`这两个包
`Set<Cat> set = new HashSet();`这条语句限定了加入set集合的元素必须是`Cat`型的元素，这样就保证了以后对这个集合的操作都只会是对`Cat`型的操作
对象加入set，并且遍历（遍历需要把set转换成迭代器，然后迭代遍历）
```java
// 定义宠物猫对象
		Cat huahua = new Cat("花花",12,"英国短毛猫");
		Cat fanfan = new Cat("凡凡",3,"中华田园猫");
		
		//将宠物猫对象放入HashSet
		Set<Cat> set = new HashSet();
		set.add(huahua);
		set.add(fanfan);
		//显示宠物猫信息
		Iterator<Cat> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
```

添加一个属性相同的对象(set在对系统类的时候，重复类是不会被添加进去的。但是对于自定义类，如果不重写`hashCode()和equal()`，是无法实现重复类不会被添加进去这个功能的)
```java
//在添加一个与花花属性一样的猫
		Cat huahua01 = new Cat("花花",12,"英国短毛猫");
		set.add(huahua01);
		System.out.println("**********************************");
		System.out.println("添加重复数据后的宠物猫信息：");	//如果不重写hashCode()和equals()这两个方法，还是会被添加进去
		it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
```

在集合中查找花花的信息并输出（根据对象名查找）
```java
//在集合中查找花花的信息并输出
		if(set.contains(huahua)) {
			System.out.println("花花找到了");
			System.out.println(huahua);
		}
		else {
			System.out.println("花花没找到");
		}
```

在集合中使用名字查找花花的信息，即利用对象属性查找集合中的对象
```java
//在集合中使用名字查找花花的信息
		//思路：在集合中遍历所有元素，挨个比较名字
		System.out.println("**********************************");
		System.out.println("通过名字查找花花的信息");
		boolean flag = false;
		Cat c = null;
		it = set.iterator();	//重置迭代器，让迭代器从第一个开始（上一个函数遍历到最后了）
		while(it.hasNext()) {
			c = it.next();
			if(c.getName().equals("花花")) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("花花找到了");
			System.out.println(c);
		}
		else {
			System.out.println("花花没找到了");
		}
```

在集合中删除指定对象的信息，注意删除掉集合中的对象后，集合会被打乱，可能会出现异常和错误
* 解决方法一——使用break(只有一条满足条件)
```java
//删除花花的信息并重新输出
		for(Cat cat:set) {
			if("花花".equals(cat.getName()))
				set.remove(cat);		//此时移除掉"花花"以后，set就被打算了，再遍历就会出问题
				break;					//要解决这个问题，就要再找到以后break
		}
		
		for(Cat cat:set) {
			System.out.println(cat);
		}
```
* 解决方法二——利用`removeAll`删除其子集（有多条满足条件）
```java
Set<Cat> set1 = new HashSet<Cat>(){
	for(Cat cat : set){
		if(cat.getMonth()<5){
			set1.add(cat);
		}
	}
	set.removeAll(set1);
}
```

删除集合中所有元素
```java
//删除集合中的所有宠物猫信息
		System.out.println("**********************************");
		boolean flag1 = set.removeAll(set);
		if(flag1) {
			System.out.println("猫都不见了");
		}
		else {
			System.out.println("猫还在。。。");
		}
```

## 4.Map
Map:
* Map中的数据是以键值对（key-value）的形式存储的：例如用户名和对应的密码
* key-value以Entry类型的对象实例存在
* 可以通过key值快速的查找value
* 一个映射不能包含重复的键
* 每个键最多只能映射到一个值

HashMap:
* 基于哈希表的Map接口的实现
* 允许使用null值和null键
* key值不允许重复
* HashMap中的Entry对象是无序排列的-
4-2以后都没学，有时间的时候补上

# 四、线程
**线程这一块还是要结合数据结构来看**
* 进程的概念：进程是指可执行程序并存放在计算机存储器的一个指令序列，它是一个动态执行的过程
* 线程可以看做是进程的子程序（通过时间片轮转法）

## 1.线程创建（只有这两种方式）
* 创建一个Thread类，或者一个Thread子类（继承Thread）的对象
* 创建一个实现Runable接口的类的对象
### 1.1Thread类
* Thread类是一个线程类，位于java。lang包下
* thread构造方法

| 构造方法 | 说明 |
| ------- | ---- |
| Thread() | 创建一个线程对象 |
| Thread(String name) | 创建一个具有指定名称的线程对象 |
| Thread(Runnable target) | 创建一个基于Runnable接口实现类的线程对象 |
| Thread(Runnable target,String name) |创建一个基于Runnable接口实现类、指定名称的线程对象|
* Thread类的常用方法

| 方法 | 说明 |
| ---- | ---- |
| public void run() | 线程相关的代码写在该方法中，一般需要重写 |
| public void start() | 启动线程的方法 |
| public static void sleep(long m) | 线程休眠m毫秒的方法 |
| public void join() | 优先执行调用join()方法的线程(抢占式) |

* Runnable接口
	* 只有一个方法run()
	* Runnable是Java中用以实现线程的接口
	* 任何实现线程功能的类都必须实现该接口

### 1.2 通过Thread类创建线程
```java
package com.imooc.thread;

class MyThread extends Thread{
	public void run() {
		System.out.println("该线程正在执行");
	}
}
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		mt.start();		//启动线程
	}

}
```
注意，启动线程是`类名.start()`而不是调用线程内部的类方法。启动线程以后，我们还是执行`run()`里面的代码。同一个线程只能执行一次`start()`方法
### 1.3 通过实现Runnable接口创建线程
* 为什么要实现Runnable接口
	* Java不支持多继承
	* 不打算重写Thread类的其他方法（继承一个类就要重写它的所有方法）

```java
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

	}

}

```
通过Runnable接口来启动线程必须是以下三步：
1. 接口对象实例化
2. 利用接口对象实现线程对象实例化 `Thread(Runnable target)`
3. 启动线程

## 2.线程的状态和生命周期
* 线程的状态：新建（NEW）、可运行状态（Runnable）、正在运行（Running）、阻塞（Blocked）、终止（Dead）
![线程状态之间的转换](https://github.com/jinhaizeng/java-study-notes/blob/master/%E5%9B%BE%E5%BA%8A/%E7%BA%BF%E7%A8%8B%E7%9A%84%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F.PNG?raw=true)
## 3.sleep方法应用
sleep方法将正在运行状态转换为阻塞态，时间要求不精确的情况下使用时ok的
* Thread类的方法`public static void sleep(long millis)`
* 作用：在指定的毫秒数内让正在指定的线程休眠（暂停执行）
* 参数为休眠的时间，单位是毫秒
## 4.join方法应用
* Thread类的方法`public final void join()`
* 作用：等待调用该方法的线程结束后才能执行（抢占其他线程的资源）
实例代码
```java
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
```

* Thread类方法`public final void join(long millis)`
* 作用：等待该进程终止的最长时间为millis毫秒

## 5.线程优先级
* Java为线程类提供了10个优先级
* 优先级可以用整数1-10表示，超过范围会抛出异常
* 主线程默认优先级为5
* 可以用优先级常量表示进程优先级：
	* MAX_PRIORITY：线程的最高优先级10
	* MIN_PRIORITY：线程的最低优先级1
	* NORM_PRIORITY：线程的默认优先级5
* 优先级相关的方法

| 方法 | 说明 |
| ---- | --- |
| public int getPriority() | 获取线程优先级的方法 |
| public void setPriority() |设置线程优先级的方法 |
随便举两个例子
```java
Thread.currentThread().getPriority();	//获取主线程优先级的调用方法

MyThread mt1 = new MyThread("线程1");	//设置线程优先级的两种方法
mt1.setPriority(10);
mt1.setPriority(Thread.MAX_PRIORITY);
```
## 6.线程同步
多线程运行问题
* 各个线程是通过竞争CPU时间而获得运行计划的
* 各线程什么时候得到CPU时间，占用多久，是不可预测的
* 一个正在运行着的线程在什么地方被暂停是不确定的

解决方案
* 使用关键字`synchronized`实现（保证共享对象同一时刻只能被一个进程访问）
* synchronized关键字用在
	* 成员方法
	* 静态方法
	* 语句块

```java
public synchronized void saveAccount(){}
public static synchronized void saveAccount(){}
synchronized(obj){......}
```

## 7.线程间通信
* wait()方法：中断方法的执行，使线程等待
* notify()方法：唤醒处于等待的某一个线程，使其结束等待
* notifyAll()方法：唤醒所有处于等待的线程，使它们结束等待

# 五、java输入输出流
流就是指一连串流动的字符，以先进先出的方式发送信息的通道。
在Java中，使用java.io.File类对文件进行操作
## 1.创建file类对象 
创建file类对象有四种方法,一下举两个例子
* 第一种，直接给出文件的绝对路径，pathname文件的绝对路径
```java
File(String pathname)
//举例
File file = new File("c:\\imooc\\io\\score.txt");
```
* 第二种，(路径，子路径)的模式
```java
File(String parent, String child)
//举例
File file = new File("c:\\imooc","io\\score.txt");
```
* 第三种，文件，子路径
```java
File file = new File("c:\\imooc");
File file = new File(file, "io\\score.txt");
```

## 2.创建文件
### 2.1创建单级目录
创建单级目录使用`mkdir()`方法
```java
	//创建单级目录
		File file2 = new File("E:\\Knowledge System\\JAVA\\java study notes\\code\\FileProj\\io","set");
		if(!file2.exists()) {
			file2.mkdir();
		}
```
### 2.2创建多级目录
创建多级目录使用`mkdirs()`方法
```java
//创建目录
		File file2 = new File("E:\\Knowledge System\\JAVA\\java study notes\\code\\FileProj\\io\\set\\HashSet");
		if(!file2.exists()) {
			file2.mkdirs();
		}
```

## 3.字节流
* 字节输入流`InputStream`	
![字节输入流思维导图](https://github.com/jinhaizeng/java-study-notes/blob/master/%E5%9B%BE%E5%BA%8A/%E5%AD%97%E8%8A%82%E8%BE%93%E5%85%A5%E6%B5%81%E6%80%9D%E7%BB%B4%E5%AF%BC%E5%9B%BE.PNG?raw=true)
* 字节输出流`OutputStream`
![字节输出流思维导图](https://github.com/jinhaizeng/java-study-notes/blob/master/%E5%9B%BE%E5%BA%8A/%E5%AD%97%E8%8A%82%E8%BE%93%E5%87%BA%E6%B5%81%E6%80%9D%E7%BB%B4%E5%AF%BC%E5%9B%BE.PNG?raw=true)

### 3.1FileInputStream
*  从文件系统中的某个文件中获得输入字节
* 用于读取诸如图像数据之类的原始字节流

| 方法名 | 描述|
| ----- | ----- |
| public int read() | 从输入流中读取一个数据字节 |
| public int read(byte[] b) | 从输入流中讲最多b.length个字节的数据读入一个byte数组中 |
| public int read(byte[] b ,int off , int len) | 从输入流中将最多len个字节的数据读入byte数组中,off为偏移量即从第几个字节开始读的 |
| public void close() | 关闭此文件输入流并释放与此流有关的所有系统资源（此点很重要，要防止虚拟机资源被持续占用） |
注意上面的三个函数返回值为int，返回值为读取的字节数。如果返回值为-1，则表示已经到达文件末尾 
* 第一种read方法的使用
```java
//官方文档
public int read()
//举例
package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.IOException;

public class FileInputDemo1 {

	public static void main(String[] args) {
		// 创建一个FileInputStream对象
		try {
			FileInputStream fis = new FileInputStream("imooc.txt");		//这种直接写文件名，相当于在工程目录下找该文件

			int n = 0;
			while((n = fis.read()) != -1) {
				System.out.print((char)n);
				
			}
			
			fis.close();							//完成输入输出流操作的时候，一定要关闭输入输出以释放资源
		} catch (FileNotFoundException e) {	
			//FileNotFoundException是IOException是子类，如果IOException在前，FileNotFoundException将永远都执行不到
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
```
* 第二种方法
```java
//官方文档示例
public int read(byte[] b)
//举例
package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo2 {

	public static void main(String[] args) {
		// 创建一个FileInputStream对象
		try {
			FileInputStream fis = new FileInputStream("imooc.txt");
			byte[] b = new byte[100];
			fis.read(b);							//将文件读取到字节数组中
			System.out.println(new String(b));		//将字节数组转成字符串
			fis.close(); // 完成输入输出流操作的时候，一定要关闭输入输出以释放资源
		} catch (FileNotFoundException e) {
			// FileNotFoundException是IOException是子类，如果IOException在前，FileNotFoundException将永远都执行不到
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
```

* 第三种方法
```java
//官方示例文档
public int read(byte[] b ,int off , int len)
//举例与第二种方法差不多，故略
```

### 3.2FileOutputStream

| 方法名 | 描述|
| ----- | ----- |
| public int write(int b) | 将制定字节写入此文件输出流 |
| public int wirte(byte[] b) | 将b.length个字节从指定byte数组写入此文件输出流中 |
| public int write(byte[] b ,int off , int len) | 将指定byte数组中从偏移量off开始的len个字节写入此文件输出流 |
| public void close() | 关闭此文件输入流并释放与此流有关的所有系统资源（此点很重要，要防止虚拟机资源被持续占用） |

**默认情况下对源文件写入时覆盖式的，如果想非覆盖，应该使用一下的定义方法**
```java
FileOutputStream fos = new FileOutputStream("imooc.txt",true);
```

读写方法的代码示例
```java
package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOuptDemo {

	public static void main(String[] args) {
		//创建输出文件流
		FileOutputStream fos;
		FileInputStream fis;
		try {
			fos = new FileOutputStream("imooc.txt",true);
			fis = new FileInputStream("imooc.txt");
			fos.write(50);
			fos.write('a');
			System.out.println(fis.read());
			System.out.println((char)fis.read());
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
```
**此外，利用字节输入输出流实现文件的复制**
文件拷贝的示例代码
```java
package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo1 {

	public static void main(String[] args) {
		// 文件拷贝
		try {
			FileInputStream fis = new FileInputStream("happy.jpg");
			FileOutputStream fos = new FileOutputStream("happycopy.jpg");
			
			int n = 0;
			byte[] b = new byte[1024];
			while((n = fis.read(b)) != -1)			//注意，文件较大，所以是一段一段的读入再写入的
				fos.write(b);						//在写满1024个byte以后判断是不是为空，非空则继续写
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
```

## 4.缓冲流（字节流的子类）
以前的读写都是对硬盘的操作，但是缓冲流是对内存的操作，所以使用缓冲流可以有效的提高输入输出速度
* 缓冲输入流BufferedInputStream（是文件输入流FileInputStream的子类)
* 缓冲输出流BufferedInputStream（是文件输出流FileOuptputStream的子类）
要实现从缓冲区将文件写入指定地点，当缓冲区满了，会自动执行写操作；当缓冲区不满，要通过`flush()`（close方法也可以实现缓冲区的强制清空），强制清空缓冲区，借此来实现写文件

缓冲输入输出流的创建示例代码
```java
package com.imooc.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedDemo {

	public static void main(String[] args) {
		// 创建缓冲输入输出流
		try {
			FileOutputStream fos = new FileOutputStream("imooc.txt");
			//BufferedOutputStream是FileOutputStream的子类所以要实现bos的创建应用fos来创建
			BufferedOutputStream bos = new BufferedOutputStream(fos);	
			
			FileInputStream fis = new FileInputStream("imooc.txt");
			//创建缓冲输入流也同理
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			bos.write(50);
			bos.write('a');
			bos.flush();
			System.out.println(bis.read());
			System.out.println((char)bis.read());
			
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
```
## 6.字符流
* 字符输入流Reader![字符输入流思维导图](https://github.com/jinhaizeng/java-study-notes/blob/master/%E5%9B%BE%E5%BA%8A/%E5%AD%97%E7%AC%A6%E8%BE%93%E5%85%A5%E6%B5%81%E6%80%9D%E7%BB%B4%E5%AF%BC%E5%9B%BE.PNG?raw=true)
* 字符输出流Writer![字符输出流思维导图](https://github.com/jinhaizeng/java-study-notes/blob/master/%E5%9B%BE%E5%BA%8A/%E5%AD%97%E7%AC%A6%E8%BE%93%E5%87%BA%E6%B5%81%E5%AF%BC%E5%9B%BE.PNG?raw=true)

**字节输入输出流和字符输入输出流的区别**
* 字节输入输出流主要用于读写数据都必须是二进制格式的数据
* 

### 6.1字节字符转换流
* InputStreamReader
* OutputStreamWriter
```java
package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// 用于实现字节流转字符流，这样直接输出字符数据

		try {
			FileInputStream fis = new FileInputStream("imooc.txt");
			// 建立字节流和字符流的关联
			InputStreamReader isr = new InputStreamReader(fis);

			int n = 0;
			char[] cbuf = new char[10];
			
			//方法一：此时n为字节楼读到的数据
			while((n = isr.read()) != -1) {
				System.out.print((char)n);
			}
			//方法二：此时n为实际读到的字节数
			while ((n = isr.read(cbuf)) != -1) {
				String s = new String(cbuf,0,n); 	//将字节数组转换为字符串
				System.out.print(s);
			}
			
			fis.close();
			isr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
```