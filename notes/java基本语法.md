[TOC]
## 一、java基本语法
### java初识
#### JDK、JRE、JVM三个概念的区别和联系
#### java程序的结构
类的基本机构
```java
class xxx{
    public  static void main(){

    }
}
//class 是定义类的关键字
//程序的执行是从主方法开始的，即main
public class xxx{

}
```

#### 编写第一个程序遇到的知识
创建package的时候com.imooc是指com文件夹中imooc文件夹内
**保存就是编译的过程**，在保存.java文件的时候，就已经把java文件编译成相应的包以及类了


### java变量与常量
#### 标识符
* 标识符可以由字母、数字、下划线和美元符组成，不能以数字开头（不能出现空格）
* 标识符严格区分大小写
* 标识符不能是关键字和保留字
* 标识符的命名最好能反应其作用
#### 关键字
自行百度
#### 变量
* 变量的三个元素：变量类型、变量名、变量值
* 变量名的命名规则
    1.满足标识符命名规则
    2.符合驼峰法命名规则：多个单词组成的变量名，第一个单词小写，其余单词首字母大写
    3.尽量简单，见名知意
* 类的命名规则
    满足Pascal命名法规范：组成类名的单词的首字母总是要大写的
* 方法名命名规则和变量名命名规则一致
定义变量以后要初始化
`print`为不换行输出，`println`是换行输出
`println()`可以直接表示换行或者也可以`print('\n')`
#### 数据类型

##### 基本数据类型
* 数值型
包括整数类型(byte：1字节、short：2字节、int：4个字节、long：8个字节)和浮点类型(float：4字节、double：8字节)
```java
//用科学计数法表示浮点数
double d = 1.23E5;
float f = 1.23E5f;
```
* 字符型（char：2字节）
字符型字面值：'a'
字符型变量：`char a = 'a';`
String s = "";
* 布尔型（boolen：1字节）
##### 引用数据类型
包括：类（class）、接口（interface）、数组

* 基本数据类型变量的存储
按照作用范围分为：类级、对象实例级、方法级（局部变量）、块级
局部变量定义在栈中
##### java中unicode和ascall码的编码方式
自行百度
#### 类型转换
* 自动类型转换
规则：数据范围小的可以转换成数据范围大的，整形可以转换成浮点数
* 强制类型转换
如果A类型的数据表示范围比B类型大，则将A类型的值赋值给B类型，需要强制类型转换
#### 常量
常量：不能变化的量
```java
int m = 5;
final int N = 6;
m = 6;      //不报错
n = 10;     //报错
```
常量命名规则：常量全部字符都大写，出现多个单词用下划线表示如：`MIN_VALUE`
使用示例：如定义π，保证π不会被修改

### 运算符
略，有问题自己找google，基本语法不赘述

### 流程控制
* 顺序
正常执行顺序
* 选择
如：if-else结构,结构和C语言一样；switch和C语言也一样
* 循环
while循环和C语言一样，continue、break也一样，不记得话去google
* debug调试
    1. 设置断点：双击对应行前数字，会出现点
    2. 执行调试：run as/debug 或者直接dubug（F11debug）
    3. 单步调试：F6一步一步去执行（F5去方法内执行，F8从一个断点直接跳到下一个断点）（循环中的断点，在每次循环都相当于有一个断点）
### 数组
* 数组的声明：
    * 数据类型[] 数组名;
    * 数据类型 数组名[];
* 数组的创建
    1. 先声明后后创建
    数据类型[] 数组名;
    数组名 = new 数据类型[数组长度]；
    2. 声明的同时创建数组
    `int arr = new int[10]`
    还有一种粗暴的方法
    `int[] arr = {1,2,3,4,5,6};`
    注意：数组长度必须指定
* 数组在内存中的存储
数组会被分别在内存中的连续空间，默认初始化为0
局部变量没有默认值，但是数组有默认值（即0）
* 数组的初始化
`int[] arr = {1,2,3,4,5,6,7,8,9,10};`
数组的长度就是初始化时所给数组元素的个数
* 数组元素的引用
数组名[下标]，与C语言相同
* 数组的长度
属性length表示数组的长度，如：arr.length


### 增强型for循环，又叫foreach循环
foreach循环应用：注意这个只能用于数组中
```java
int[] arr = {1,2,3,4,5};
for(int n:arr)                  //作用：把arr数组中的每一个元素拿出来赋值给n，相当于遍历了一步数组arr
    System.out.println(n);      
```

普通的for循环和C语言一致

### 冒泡排序（略，不会自行百度）

### java方法
```java
//这个很重要，是系统输入的示例
Scanner sc = new Scanner(System.in);
sc.nextInt();   //Scanner为类，定义的sc为对象，.nextIn()方法
```
#### 方法的声明和调用
语法格式
```java
/*
访问修饰符 返回类型 方法名（参数列表）{
    方法体
}
*/
//举例
public static void main(String[] args){
    System.out.println("Hello,immoc!");
}
```
**tips**
* 方法在类的内部定义
* 方法不能嵌套定义，即不能在一个方法里再定义一个方法

**方法的分类**
* 无参无返回值方法
示例程序
```java
package com.imooc.method;
import java.util.Scanner;

public class MethodDemo{
    //打印输出星号的方法
    public void printStar(){
        System.out.println(""*****************);
    }
    public static void main(String[] args){
        //创建一个MethodDemo类的对象myMethodDemo
        MethodDemo myMethodDemo = new MethodDemo();     //要使用类对应的方法，就要先定义对象
        //使用对象名.方法名()去调用方法
        myMethodDemo.printStar();
        System.out.println("欢迎来到java的世界！");
        myMethodDemo.printStar();
    }
}
```
* 无参带返回值方法
示例程序
```java
public class Rectangle{
    //求长方形面积的方法
    public int area(){
        int length = 10;
        int width = 5;
        int getArea = length*width;
        return getArea;
    }
    public static void main(String[] args){
        Rectangle rc = new Rectangle();
        System.out.pritln("长方形的面积为：”+rc.area());
    }
}
```
* 有参无返回值方法
示例程序（只写了方法的定义，其他的都差不多，略）
```java
public void max(float a,float b){}
```
* 有参有返回值方法
示例程序（只写了方法的定义，其他的都差不多，略）
```java
public int fac(int n){}
```
* 重点
主方法中调用其他方法，必须用对象来调用对应的方法，但是在其他方法中调用其他方法的话，直接用方法名字就可以了
示例代码
```java
public class ExcahngeDemo{
    public void swap(int a,int b){

    }
    public void swapTest(){
        int m = 5,n = 6;
        swap(m,n);
    }
    public static void main(String[] args){
        int m = 5,n = 6;
        ExchangeDemo ed = new ExchangeDemo();
        ed.swap(m,n);
    }
}
```
#### 数组作为方法参数
示例程序（查找数组元素中是否有对应要求的值）
```java
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

```

#### 方法的重载
方法名相同，但是参数列表不同
* 不是重载的
    `public void hello(){}`
    `public int hello(){}` -参数列表相同，但是返回值不在考虑范围之内
* 是重载的
    `public void hello(){}`
    `public void hello(String s){}`
    `public float hello(float f1,float f2){}`

示例程序（只写了方法的定义，其他的都差不多，略）
```java
//求两个int类型数的和
public int sum(int m ,int n){
    return m+n;
}
//求两个double类型数的和
public double sum(double m, double n){
    return m+n;
}
//求数组元素的累加和
public int sum(int[] arr){
    int result = 0;
    for(int i:arr)
        result += i;
    return result;
}
```
#### 参数的传递
* 基本数据类型的传值
    修改方法中传入参数的值不会对原来被传入参数有影响
* 数组的值
    修改方法中传入数组的值会对原来被传入参数有影响，因为方法中的传入数组其实质就是指向被传入数组的地址，地址一致，导致修改的内容一致（实在不理解的话，再看一遍视频）
#### 可变参数列表
定义：参数的数量是不确定的，可以随时变化
```java
public void sum(int... n){}
```

```java
package com.imooc.method;

public class ArgsDemo {
	//求和
	public void sum(int... n) {
		int sum = 0;
		for(int i:n) {		//用增强型for循环来实现
			sum = sum+i;
		}
		System.out.println("sum ="+sum);
	}
	public static void main(String[] args) {
		ArgsDemo ad = new ArgsDemo();
		ad.sum(1);
		ad.sum(1,2);
		ad.sum(1,2,3);

	}

}
```
**特殊：多个参数+可变参数列表——这种情况，参数在前，可变参数列表在后**
```java
public void search(int n,int... a){}
```
**可变参数列表是可以和数组兼容的，即可以把数组的内容传入可变参数列表**
**数组的值可以传入可变参数列表，但是可变参数列表的值不可以传入数组**
**一个方法中只能有一个可变参数列表**
```java
ArgsDemo1 ad1 = new ArgsDemo1();
ad1.search(3,1,2,3,4,5);
int[] a = {1,2,3,4,5};
ad1.search(3,a)
//这两种方法，实现相同，结果也相同
```
#### 可变参数列表的重载
```java
public void search(int n,int... a){}
public void search(int n,int[] a){}
//会报错，这两个定义方法是一致的，想定于重定义了
```
重载的定义示例
```java
public int sum(int a, int b){}
public int sum(int... a){}
```
**可变参数列表所在的方法是最后被访问的。有不可变参数的方法可以调用，则优先调用他**
#### 注释
* 普通注释
    * //
    * /*    */
* 文档注释:最后生成文档时，会被加入其中
    /**     */
示例程序
```
/**
* 关于可变参数列表和重载的问题
* @author fiona
* @version 1.0
*/
```
#### 方法的调试
与普通的调试差不多，但是可以进入方法内部进行调试（即F5，进入方法内部进行调试；F7由方法内部返回调用出）

#### 作业需求介绍（在java方法那个文件夹中的视频中有讲解）
需求：定义一个类，对数组中的数据进行管理
1-插入数据（暂定9个）
2-显示所有数据
3-在指定位置处插入数据
4-查询能被3整除的数据
0-退出

####