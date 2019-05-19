[TOC]  
**eclipse中显示提示的快捷键："alt"+"/"**  
**eclipse中调整格式的快捷键:"shift"+"ctrl"+"f"**  
**入门碎知识点**：成员 = 属性 + 方法  
# 一、java面向对象
**面向对象具有三大特征：封装、继承、多态**
## 1.类和对象
* 类是模子，确定对象将会拥有的特征（属性）和行为（方法）
* 对象是类的实例表现
* 类是对象的类型（抽象概念，即模板）
* 对象是特定类型的数据（一个看得到、摸得着的具体实体）
* 属性：对象具有的各种静态特征
* 方法：对象具有的各种动态行为
### 1.1创建类
示例代码
```java
package com.imooc.cat;
/**
 * 宠物猫类
 * @author MR Code
 *
 */
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;
	
	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		System.out.println("小猫快跑");
	}
	//吃鱼的方法
	public void eat() {
		System.out.println("小猫吃鱼");
	}

}
```
### 1.2对象实例化
方法中的`局部变量`没有初始值，但对于一个类当中的`成员`，系统对其是有初始值的（大多是0和null）

### 1.3单一职责原则
单一职责原则，即一个类有且只有一个引起功能变化的原因（即一个类最好只有一个功能，干一件事）
### 1.4包名的推荐命名规范
1. 英文字母小写
2. 域名的倒序

### 1.5new关键字
```java
Cat one = new Cat();
```
* Cat one:声明对象，其在内存的**栈**空间中开一个空间取名叫one
* new Cat()：实例化对象。其在内存的**堆**空间中开辟一个空间完成具体对象的相关初始化操作
* 关联堆和栈的操作是通过赋值符号，即把堆空间的内存地址存放到栈中
* 对象实例化的另一种实现方法
```java
Cat one = new Cat();
Cat two = one;
```
相当于把one堆空间的内存地址也给了two，两个对象指向以及操作的是同一块内存区域。就相当于one把房子钥匙也给了two，两个人同时拥有这套房子
区别：
```java
Cat one = new Cat();
Cat two = new Cat();
```
这样实例化的one和two两个对象就是毫无关联的两个对象

## 2.构造方法（特殊的方法）
### 2.1构造方法
构造方法 = 构造函数 = 构造器
即`Cat one = new Cat();`中的`Cat()`
1. 构造方法**与类同名**且没有返回值
2. 构造方法的语句结构
3. 只能在对象实例化的时候调用（只能和new搭档使用）
4. 当没有指定构造方法时，系统会自动添加无参的构造方法
5. 当有指定构造方法，无论是有参、无参的构造方法，都不会自动添加无参的构造方法
6. 一个类中可以由多个构造方法
```java
public 构造方法名（可以指定参数，也可以不）{
    //初试化代码
}
```
**注意:如果定义一个普通的无参无返回值的方法，其名字与类名一致，可以直接通过对象名调用**  
构造方法分类：
* 无参构造方法
* 有参构造方法
```java
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;

	public Cat(String name,int month,double weight,String species){
	name = name;
	month = month;
	weight = weight;
	species = species;
	}
	
	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		System.out.println("小猫快跑");
	}
	//吃鱼的方法
	public void eat() {
		System.out.println("小猫吃鱼");
	}

}
```
以上出现了逻辑错误，就近原则：在赋值过程中，其会优先寻找同一个作用范围内的成员完成赋值操作。所以等号左边的name不是我们预想的cat类里面的成员属性name，而是在无参构造方法中传入参数的name。
为了避免以上的错误，有如下的方法：
1. 修改传入参数，保证传入参数与成员属性的名字不一样
```java
public Cat(String newname,int newmonth,double newweight,String newspecies){
	name = newname;
	month = newmonth;
	weight = newweight;
	species = newspecies;
	}
```
2. 使用this关键字,见下

### 2.2this关键字
this关键字代表的即为当前对象
* this用于对象属性
```java
public Cat(String name,int month,double weight,String species){
	this.name = name;
	this.month = month;
	this.weight = weight;
	this.species = species;
	}
```
* this用于对象动作
```java
this.eat();		//在方法中使用，即表示当前对象执行eat()这个动作。在普通方法中可以直接使用eat()，但是在构造方法中必须使用this.eat()
```
### 2.3构造方法的调用
普通方法是可以被普通方法直接调用的（见以下代码run()中的eat()的调用方法，但是**构造方法不可以直接被普通方法所调用**，构造方法只能在构造方法之间调用。
```java
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;

	public Cat(String name,int month,double weight,String species){
	this.name = name;
	this.month = month;
	this.weight = weight;
	this.species = species;
	}
	
	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		eat();
		System.out.println("小猫快跑");
	}
	//吃鱼的方法
	public void eat() {
		System.out.println("小猫吃鱼");
	}

}
```
同一个构造方法之间，可以通过`this();`的方法调用——调用重载的构造方法
**this();必须放在构造方法的第一条语句，放其他位置会报错**

```java
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;

	public Cat(){

	}
	public Cat(String name,int month,doubel weight,String species){
	this();					//通过this调用无参的构造方法cat();
	//想调用带参的构造方法，可以this("aaa");等类似的表示方法，即直接加参数
	this.name = name;
	this.month = month;
	this.weight = weight;
	this.species = species;
	}
	

}

```
## 3.课程总结
1. 定义类
	```java
	public class 类名{
		//定义属性部分
		[访问修饰符] 数据类型 属性名

		//定义方法部分
		[访问修饰符] 返回值类型 方法名(){

		}
	}
	```
2. 创建并引用对象  
	```java
	类名 对象名 = new 构造方法();
	对象名.属性;
	对象名.方法();
	```
3. 对象实例化  
实例化对象的过程可以分为两个部分
	* 声明对象 `Cat one`
	* 实例化对象 `new Cat();`
	* `Cat one = new Cat();`（这种是一步到位的方法）
4. 构造方法  
构造方法是特殊的方法，用于初始化实例对象，其类名一致，可以重载
# 二、封装
## 1.封装的概念和特点
### 1.1封装的概念
* 将类的某些信息隐藏在类内部，不允许外部程序直接访问
* 通过该类提供的方法来实现对隐藏信息的操作和访问
* 提炼：隐藏对象的信息，流出访问的接口

### 1.2封装的特点
* 只能通过规定的方法访问数据
* 隐藏类的实例细节，方便修改和实现
## 2.封装代码的实现
封装的实现步骤
1. 修改属性的可见性——设为`private`
2. 创建共有方法，getter(取值)/setter(赋值)方法——设为public，用于属性的读写
3. 在getter/setter方法中加入属性控制语句

```java
package com.imooc.cat;
/**
 * 宠物猫类
 * @author MR Code
 *
 */
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	//修改属性的可见性--private，限定只能在当前类内访问
	Private String name;	
	int month;
	double weight;
	String species;
	
	//创建get/set方法
	//在get/set方法中添加对属性的限定
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	/*在main()中使用的示例
	one.setName("凡凡");
	System.out.println(one.getName());
	*/

	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		System.out.println("小猫快跑");
	}
	//吃鱼的方法
	public void eat() {
		System.out.println("小猫吃鱼");
	}

}
```
* 快速生成getter/setter的方法，代码区右键/source/generate getters and setters
* 只有getXXX方法的属性是只读属性
* 只有steXXX方法的属性是只写属性
* 注意：在带参的构造函数中，可以进行对private属性的直接赋值，但是不推荐，还是推荐用getter/setter的方法，这样在getter/setter里面写的判断逻辑才会起作用。否则直接赋值的话可能会出现结果出错无效的后果
* private修饰的属性，在同类中的方法可以直接使用属性名进行赋值等操作，不必用this.属性名

## 3.使用包进行类管理
### 3.1包的类管理
包管理的作用
* 通过包进行java文件管理和解决同名文件冲突问题
* java中一个包中不能出现同名的类，同名的类只能存放在不同的类中

语法：
`package 包名`
注意：
1. 利用关键字package来定义包，注意包的定义一定要在第一行，这一部分的内容还是乖乖看视频吧，[视频](https://pan.baidu.com/play/video#/video?path=%2F%E8%AE%A1%E7%AE%97%E6%9C%BA%E5%AD%A6%E4%B9%A0%2Fjava%E5%B7%A5%E7%A8%8B%E5%B8%88%2F01.Java%E9%9B%B6%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%2F%E6%AD%A5%E9%AA%A4%E4%BA%8C%20java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%2F%E4%BA%8C%20java%E5%B0%81%E8%A3%85%2F1-6%E4%BD%BF%E7%94%A8%E5%8C%85%E8%BF%9B%E8%A1%8C%E7%B1%BB%E7%AE%A1%E7%90%86.mp4&t=3)
2. 一个java源文件中只能有一个package语句
3. 包名全部小写
4. 命名方式：域名倒序+模块+功能

### 3.2包的加载
`import 包名.类名`
示例程序
```java
//方法一：加载包内所有类
import com.imooc.animal.*;   //加载com.imooc.animal下所有类
//方法二 加载包内指定的类
import com.imooc.animal.Cat;	//加载com.imooc.animal下制定的Cat类
//方法三：直接运行包内指定的方法
com.imooc.animal.CatTest text = new com.imooc.animal.CatTets();
```
* 如果两个包内有重名类，同时导入时会出错
* 如果有同名类，想指定使用某个类的方法
	```java
	import com.imooc.mechanics.*;
	import com.imooc.animal.Cat;	//这两个包里面都有Cat类

	//.....此处省略
	com.imooc.mechanics.Cat = new com.imooc.mechanics();
	```
* import 只能加载这个文件内的所有类，子文件夹内的类不会被加载。故`import com.imooc.*`不可能加载所有的类 

### 3.3 static（静态信息）
**特点：static修饰的方法既可以通过类名调用，也可以通过对象名调用**  
**网上看到的小讲解：**
**类的静态成员（静态变量和静态方法）属于类本身**，在类加载的时候就会分配内存，可以通过类名直接去访问，**非静态成员（非静态变量和非静态方法）属于类的对象**，所以只有在类的对象创建（实例化）的时候才会分配内存，然后通过类的对象去访问。  
static关键字的基本作用：方便在没有创建对象的情况下来进行调用（方法/变量）。被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。
#### 3.3.1 静态成员（static放在成员前面）
* static表示静态，用static修饰的变量被称为静态成员或类成员。static修饰的成员具有这样的特征：无论这个类最终实例化出多少对象，这个成员都会共用同一块静态空间，一个对象的static成员变量的修改会导致其他对象对应的static成员变量也跟着变化（实质：地址相同）
* 静态成员从类第一次加载时就产生，一直到这个类不再有任何对象被使用，此时空间才会被释放
* 类对象共用空间 
* 父类的static方法，是不能被子类重写的

静态成员的两只访问方法：
1. 可以通过对象名进行访问：对象名.成员
2. 可以通过类名访问： 类名.成员（推荐使用这种方式），举例：`Cat.price = 2000;`（反正所有对象都是公用一个内存空间）

#### 3.3.2 静态方法/类方法（static+方法） 
注意：
* class前不可以加static（没有静态类）
* 局部变量前不可以加static（没有静态局部变量） 
* this.静态成员是可以成立的
* 在成员方法中可以直接访问类中静态成员
* 静态方法不能直接访问非静态（包括方法和属性），只能直接访问静态成员。如果一定要访问非静态成员的话，只能通过对象实例化后，对象.成员方法的方式访问非静态成员
* 静态方法中不能使用this

#### 3.3.3 代码块
* 代码块——{}
* {}出现在普通方法中被称作普通代码块，顺序执行普通代码块
* {}出现在类定义中被称为构造代码块。构造代码块创建对象时调用，优先于构造方法执行。构造代码块在一个类中也可以有多个，多个构造代码块之间是顺序执行的 
* 构造代码块之前加static，变为静态代码块。类加载时调用，优先于构造代码块执行。多个静态代码块之间是顺序执行的
* 类多次实例化为对象时，静态代码块只会执行一次，构造代码块会在每次实例化的时候执行一次
* 普通代码块可以对普通成员以及静态成员进行赋值，但是静态代码块只可以对静态成员进行赋值。如果一定要访问非静态成员的话，只能通过对象实例化后，对象.属性的方式访问非静态成员  
**代码块执行优先级：静态代码块>构造代码块>普通代码块**

示例代码
```java
package com.imooc.cat;
/**
 * 宠物猫类
 * @author MR Code
 *
 */
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	//修改属性的可见性--private，限定只能在当前类内访问
	Private String name;	
	int month;
	double weight;
	String species;
	
	{
		//构造代码块
	}
	static{
		//静态代码块
	}
	//成员方法：跑动、吃东西
	//跑步的方法
	public void run() {
		{
			//普通代码块
		}
		System.out.println("小猫快跑");
	}

}
```

#### 3.3.4 普通代码块中变量使用的知识
每个代码块都是一个独立的空间。在同一个作用范围不能出现两个同名的变量。在两个代码块中，两个同名变量不相互影响，在代码块中定义的变量，其生存周期只在这个代码块中
代码示例1
```java
public void run(Strig name){
	{
		int temp = 12;
		System.out.println("temp = "+temp);
	}
	{
		int temp = 13;
		System.out.println("temp = "+temp);
	}
}
```
输出结果为：
```java
temp = 12
temp = 13
```
代码示例2
```java
public void run(Strig name){
	{
		int temp = 12;
		System.out.println("temp = "+temp);
	}
		System.out.println("temp = "+temp)
	{
		int temp = 13;
		System.out.println("temp = "+temp);
	}
}
```
此时会报错，因为这两个temp的生存周期都只在两个代码块中，两个代码块中间的的`System.out.println("temp = "+temp)`的`temp`没有定义

代码示例3
```java
public void run(Strig name){
	{
		int temp = 12;
		System.out.println("temp = "+temp);
	}
		int temp = 14;
		System.out.println("temp = "+temp)
	{
		int temp = 13;
		System.out.println("temp = "+temp);
	}
}
```
此时会报错，因为`int temp =14;`的作用范围在这个语句以后到整个方法的}处，包括了`int temp = 13;`所在的内存空间，所以会出现重定义错误。

## 4.小结

# 三、封装综合案例（这一部分还是主要看视频，敲代码）
详情见视频
对象间关联（见视频，[有四种方法](https://pan.baidu.com/play/video#/video?path=%2F%E8%AE%A1%E7%AE%97%E6%9C%BA%E5%AD%A6%E4%B9%A0%2Fjava%E5%B7%A5%E7%A8%8B%E5%B8%88%2F01.Java%E9%9B%B6%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%2F%E6%AD%A5%E9%AA%A4%E4%BA%8C%20java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%2F%E4%B8%89%20java%E5%B0%81%E8%A3%85%E7%BB%BC%E5%90%88%E6%A1%88%E4%BE%8B%2F2-5%E9%80%9A%E8%BF%87%E6%96%B9%E6%B3%95%E5%AE%9E%E7%8E%B0%E5%AD%A6%E7%94%9F%E4%B8%8E%E4%B8%93%E4%B8%9A%E5%85%B3%E8%81%94--%E6%96%B9%E6%A1%882.mp4&t=-1)）
* 方案1：在方法中添加两个参数，分别表示专业名称和学制年限
* 方案2：在方法中添加1和专业对象作为参数，通过其属性获得相关信息
* 方案3：在类中添加专业对象作为属性，通过其属性获得相关信息——代码可以见"SchoolProject"这个工程

# 四、继承（上）
## 1.继承的概念和特点
1. 继承的概念
	* 一种类与类之间的关系
	* 使用已存在的类的定义作为基础建立新类
	* 新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性的继承父亲
2. 继承的关系
	* 满足"A is a B"的关系就可以形成继承关系

### 1.1继承的实现
* 利用"extends"关键字来实现继承——子类在前，父类在后
* 子类继承父类的时候，只能直接继承父类的非私有成员，父类中的私有成员，在子类中是无法获取到的
* 生成子类的快捷方式：创建子类的时候，在superclass中选择要继承的父类
* 父类不可以访问子类特有成员
```java
//编写父类
class Animal{
	//公共的属性和方法
}
//编写子类，继承父类
class Dog extends Animal{
	//子类特有的属性和方法
}
class Cat extends Animal{

}
```
具体的工程见`AnimalProject`这个工程

### 1.2方法的重写
重载和重写的区别
* 方法重载
	1. 同一个类中
	2. 方法名相同，参数列表不同（参数顺序、个数、类型）
	3. 方法的返回值、访问修饰符任意（不做限制）
	4. 与方法的参数名无关
 * 方法重写
	1. 有继承关系的子类中
	2. 方法名相同，参数列表相同（参数顺序、个数、类型）；就是与父类相同
	3. 方法返回值可以不同（只可以是父类对应的子类,可以向下兼容，但是不可以向上兼容）
	4. 访问修饰符的限定范围大于等于父类方法
		```java
		public Animal create(){
			return new Animal();
		}
		public Dog create(){			//Animal是Dog的父类，不报错
			return new Dog();
		}
		public Object create(){			//Object是Animal的父类，报错
			return new Object();
		}
		```
	3. 访问修饰符的访问范围要大于等于父类的访问范围
	4. 与方法的参数名无关（不强制要求相同）

特点：
* 当子类重写父类方法后，子类对象调用的是重写后的方法
* 在子类中，可以定义与父类重名的属性的。调用属性是优先选择子类中的，如果子类中没有重定义，则选择父类的。
 示例代码
 ```java
 //方法重载
 public void sleep(){	

 }

 public String sleep(String name){	//与上面的sleep()在同一个类中，根据上述定义可知，其为方法重载
	 return " ";
 }
 
//方法重写
//子类重写父类吃东西方法
 ```
## 2.访问修饰符
* 公有的：public——访问权限最大，允许在任意位置访问
* 私有的：private——访问权限最小，只允许在本类中进行访问
* 受保护的：protected——允许在当前类、同包子类、挎包子类调用（父子在不同的包下），但是挎包的非子类不能访问，同包的情况下，任意情况都可以访问
* 默认：允许在当前类，挎包子类/非子类不允许调用，同包子类/非子类可以调用

|访问修饰符|本类|同包|子类|其他|
|---------|----|----|---|----|
|private| √    |     |     |
|默认   |  √|     √|      |
|protected  |    |   √|    √| |
|public|   √|   √|   √|    √|

## 2.super关键字的使用
* 子类既可以继承父类的方法，也可以重写自己的方法，如何判定在子类中调用的方法是继承自父类的还是自己写的
* super可以用来访问父类中的方法，如：`super.eat();`
* 父类的构造方法不能被继承，同样也不能被重写
## 3.继承的初始化顺序
主要问题：满足继承关系的子类对象是如何产生的  
执行顺序：父类的静态代码块>子类的静态代码块>父类的构造代码块>父类的构造方法>子类的构造代码块>子类的构造方法  
访问修饰符不影响成员加载顺序，跟书写位置有关  
子类找父类，再找父类的父类，直到找到最后的父亲  
集成后的初始化顺序：  
* 先加载父类静态成员，再加载子类静态成员
* 父类对象构造，子类对象构造  
静态信息加载时，访问修饰符不影响成员加载顺序，跟书写位置有关

## 4.子类自由选择父类的某个构造方法
super使用方法小结
* 访问父类成员方法	`super.print();`
* 访问父类属性		`super.name();`
* 访问父类构造方法	`super();`

构造小结
* 子类的构造的过程中必须调用其父类的构造方法
* 子类构造默认调用父类的无参构造方法（此时父类若是没有定义无参构造，则会报错）
* 子类若想调用父类允许被访问的任意构造方法
	* 使用`super（）`，举例：将`super(name, month)`写在子类构造代码中，这样就是调用父类的双参构造方法
	* `super()`必须写在子类构造方法有效代码的第一行
## 5.super和this的对比
* this：当前类对象的引用
	1. 访问当前类的成员方法
	2. 访问当前类的成员属性
	3. 访问当前类的构造方法
	4. 不能在静态方法中使用

	`this();`会优先执行一下当前类的无参的构造方法
* super：父类对象的引用
	1. 访问父类的成员方法
	2. 访问父类类的成员属性
	3. 访问父类类的构造方法
	4. 不能在静态方法中使用  
this()和super()只能在同一个构造方法中出现一个

## 6.课程小结

# 五、继承（下)
## 1.Object类
### 1.1 Object概念
* Object类是所有类的父类
* 一个类没有使用`extends`关键字明确标识继承关系，则默认继承Obeject类（包括数组）
* Java中的每个类都可以使用Object中定义的方法
* 冷知识：对象.equals(对象)比较的是两个对象的地址是否一样；字符串.equals(字符串)比较的是两个字符串的内容

### 1.2 重写euqals
代码示例
```java
Animal one = new Animal("花花",2);
Animal two = new Animal("花花",2)；
/*equals：
* 1. 继承Object中的equals方法时，比较的是两个引用是否指向同一个对象
* 2. 子类可以通过重写equals方法的形式，改变比较的内容
*/
one.equals(two);
one == two
//这两个判断是一样的，结果是一致的
```
如果要实现这两个对象内容的对比，而不是引用的对比，需要重写（一定注意是重写，不是重载）
```java
public boolean equals(Object obj){
	if(obj == null)		//	此处不判断是否为空，有可能因为传入参数为空导致其他异常——空指针异常
		return false;
	Animal temp = (Animal)obj;
	if(this.getName().equals(temp.getName()) && this.getMonth() == temp.getMonth)
		return true;
	else 
		return false;
}

//另一种方案，上一种方案必须满足obj可以被强制转换成`Animal`类型，此时，这个equals是对上一个方法的重载，所以上一种方法是不可以省去的，不然会报错。即没有上一种方法的代码，就不能合理的写出下一种方案的代码
public boolean equals(Animal obj){
	if(obj == null)
		return false;
	Animal temp = (Animal)obj;
	if(this.getName().equals(temp.getName()) && this.getMonth() == temp.getMonth)
		return true;
	else 
		return false;
}
```
### 1.3 重写toString
```java
/*toString测试：
* 1.输出对象名时，默认会直接调用类中的toString 
* 2.继承Object中的equals方法时，输出对象的字符串表示形式：类型信息+@+地址信息
* 3.子类可以通过重写equals方法的形式， 改变输出的内容以及表现形式
*/
//重写toString
public String toString(){
	return "昵称："+this.getName()+";年龄"+this.getMonth();
}
```

**其他Object的方法重写，可以自己试试，不赘述**

## 2.final关键字
### 2.1final关键字的使用
1. 在类前面添加：被final修饰的类不能有子类（即绝种了）
示例代码
```java
//final class:该类没有子类 书写顺序可以有：public final class\final public class 
public final class Animal{

}
```
2. 在方法的返回值前面添加： 该类的方法不能被子类重写，但是可以正常被子类继承使用
```java
public final void eat(){
	System.out.println(this.getName()+"在吃东西");
}
//此时子类重写父类的方法
```

3. final修饰方法内的局部变量：只要在具体被使用之前进行赋值即可，一旦赋值不允许被修改

4. final修饰类中成员属性：赋值过程只能在是哪些位置进行赋值，其他位置赋值都是非法的
	* 定义直接初始化
	* 构造方法
	* 构造代码块
### 2.2数据类型的使用
* 基本数据类型（直接定义赋值即可）
	如：int float double ...
* 引用数据类型（需要创建对象然后对对象进行操作）
	如: String System 数组
	`Animal one = new Animal();`
### 2.3final修饰引用类型
问题：引用地址是否可以发生改变？属性值是否可以发生改变？
回答：引用地址不可以发生改变，但是属性值是可以发生改变的
示例代码
```java
final Animal animal = new Animal("凡凡",1);	//Animal是一个定义好的类
animal = new Animal();	//报错，异常
animal.month = 12;		//正常
animal.name = "豆豆";	//正常
```
**定义在类中的成员`public static final int temp`，表示temp是一个静态的不允许被修改的成员，他会随着类的加载而产生，在整个类的运行过程中，不允许被修改**

### 2.4final使用方法小结
1. 修饰类表示不允许被继承
2. 修饰方法表示不允许被子类重写
	- final修饰的方法可以被继承
	- 不能修饰构造方法
3. 修改变量表示不允许修改
	- 修饰方法内部的局部变量 》在使用之前被初始化赋值即可
	- 修饰类中成员变量 》只能在定义时、构造方法、构造代码块中进行
	- 修饰基本数据类型的变量 》初始赋值滞后不能更改
	- 引用类型的变量 》 初始化之后不能再指向另一个对象，单对象的内容是可变的
4. 可配合static使用
	表示全局的，不可以被修订的内容。可以用`static final`修饰程序中只需要加载一次，不会被修改的内容

## 注解介绍
重写的快捷方式：`"alt"+"/"`，选中想要重写的内容，可以快速的实现重写
注解分类：
1. 源码注解：注解在源码中存在，编译成.class文件就不存在了
2. 编译时注解：注解在源码和.class文件中都存在
3. 运行时注解：在运行阶段还起作用，甚至会影响运行逻辑的注解

`@override`重写注解


# 六、单例模式
设计模式是软件开发人员在软件开发过程中面临的一般问题的解决方案
设计模式的分类
1. 创建型模式——关注对象创建过程
包括工厂法法模式、建造者模式、抽象工厂模式、原型模式、单例模式
2. 结构型模式——关注类和对象组合
包括桥接模式、代理模式、享元模式、外观模式、装饰器模式、组合模式、适配器模式
3. 行为型模式——关注对象间的通信过程
包括备忘录模式、解释器模式、命令模式、中介者模式、观察者模式、策略模式、状态模式、模板方法模式、访问者模式、迭代子模式、责任链模式

## 1.单例模式
* 目的：使得类的一个对象称为该类系统中的唯一实例
* 定义：一个类有且仅有一个实例，并且自行实例化向整个系统提供
* 要点：
	1. 某个类只能够一个实例
	2. 必须自行创建实例
	3. 必须自行向整个系统提供整个实例
* 实现
	1. 只提供**私有**的构造方法
	2. 含有一个该类的**静态**私有对象
	3. 提供一个静态的**公有**方法用于创建、获取静态私有对象
* 代码实现方案
	1. 饿汉式：对象创建过程中实例化
	2. 懒汉式：静态公有方法中实例化
### 1.1饿汉式代码实现（见工程SingletonProj）
示例代码：
```java
package com.imooc.singleton;

//饿汉式：创建对象实例的时候直接初始化
public class SingletonOne {
	//1、创建类中私有构造
	private SingletonOne() {
		
	}
	
	//2、创建该类型的私有静态实例
	private static SingletonOne instance = new SingletonOne();
	
	//3、创建公有静态方法返回静态实例对象
	public static SingletonOne getInstance() {
		return instance;
	}
}
```
饿汉式特点：创建对象示例的时候直接初始化，空间换时间，加载对象时速度快，但是占用空间大

### 1.2懒汉式的代码实现
```java
package com.imooc.singleton;
//懒汉式：类内实例对象创建时并不直接初始化，指导第一次调用到方法时才完成初始化的才做
public class SingletonTwo {
	//1、创建私有构造方法
	private SingletonTwo() {
		
	}
	//2、创建静态的该类实例对象
	private static SingletonTwo instance = null;
	//3、创建开开放的静态方法提供实例对象
	public static SingletonTwo getInstance() {
		if(instance == null)
			instance = new SingletonTwo();
		
		return instance;
	}
}
```
懒汉式：类内实例对象创建时并不直接初始化，指导第一次调用到方法时才完成初始化的才做
用时间换空间
饿汉式线程安全、懒汉式存在线程风险
### 1.3单例模式的特点及适用场景
* 优点
	1. 在内存中只有一个对象，节省内存空间
	2. 避免频繁的创建销毁对象，提高性能
	3. 避免对共享资源的多重占用
* 缺点
	1. 扩展比较困难
	2. 如果实例化后的对象长期不利用，系统将默认为垃圾进行回收，造成对象状态丢失
* 使用场景
	1. 创建对象时占用资源过多，但同时又需要用到该类对象
	2. 对系统内资源要求统一读写，如读写配置信息
	3. 当多个示例存在可能引起程序逻辑错误，如号码生成器

# 七、多态
## 1.多态的概念
多态：允许不同类的对象对同一消息作出不同的响应 
多态分类：
* 编译时多态
	又叫做设计时多态，通过**方法重载**的方式实现
* 运行时多态
	程序运行时动态决定调用哪个方法（提到多态，通常指的是运行时多态）

多态实现的必要条件：
* 满足继承关系
* 父类引用指向子类对象
## 2.向上转型（父类引用指向子类对象）
`Animal one`是父类引用，`Cat``Dog`是子类对象，`=`相当于父类引用指向子类对象
以下中`Animal`是其父类，`Cat`和`Dog`是对应父类的子类

```java
Animal one = new Animal();			//1
/*向上转型、隐式转型、自动转型
 * 父类引用指向子类实例，可以调用子类重写父类的方法以及父类派生的方法，无法调用子类独有的方法
 * 小类转型为大类
*/
Animal two = new Cat();				//2
Animal three = new Dog();			//3
```

## 3.向下转型（子类引用指向父类对象）
```java
/*向下转型、强制类型转换
 * 子类引用指向父类对象，此处必须进行强转，可以调用子类特有的方法
 * 必须满足转型条件才能进行转换
 * 注意：父类中的静态方法无法被子类重写，所以向上转型之后，只能调用到父类原有的静态方法
 * instanceof运算符:判断左边对象是否满足类型的强转特征
 */
 if(two instanceof Cat)
 {
	Cat temp = (Cat)two;		//此处two的类型是Animal
	temp.eat();
	temp.run();
	temp.getMonth();
	System.out.println("two可以转换为Cat类型");
 }

```
**instanceof可以提高强转的安全性**

## 4.向上类型转换和向下类型转换的应用
详细的代码实现见工程`PolyProj`,应用这一问题体现在`Master`
```java
public class Master {
	/*喂宠物
	 * 喂猫：吃完东西后，主人会带着去玩线球
	 * 喂狗：吃完东西后，主人会带着去睡觉
	 * 养兔子、养鹦鹉、养乌龟...
	 * */
	//version1 每个宠物都定义一个feed函数，利用重载的方式来实现，但是一定对象多了以后
	//代码编写会很繁琐
	public void feed(Cat cat) {
		cat.eat();
		cat.palyBall();
	}
	public void feed(Dog dog) {
		dog.eat();
		dog.sleep();
	}
	
	//version2 可以通过向上转型和向下转型来实现
	public void feed(Animal obj) {
		if(obj instanceof Cat) {
			Cat temp =(Cat) obj;
			temp.eat();
			temp.palyBall();
		}
		else if(obj instanceof Dog) {
			Dog temp =(Dog) obj;
			temp.eat();
			temp.sleep();
		}
	}
	
}
```

[另一个转换的案例](https://pan.baidu.com/play/video#/video?path=%2F%E8%AE%A1%E7%AE%97%E6%9C%BA%E5%AD%A6%E4%B9%A0%2Fjava%E5%B7%A5%E7%A8%8B%E5%B8%88%2F01.Java%E9%9B%B6%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%2F%E6%AD%A5%E9%AA%A4%E4%BA%8C%20java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%2F%E4%B8%83%E3%80%81java%E5%A4%9A%E6%80%81%2F3-9%20%E7%B1%BB%E5%9E%8B%E8%BD%AC%E6%8D%A2%E6%A1%88%E4%BE%8B%EF%BC%88%E4%B8%8B%EF%BC%89.mp4&t=-1)

这种类型转换用于多态很方便，详情见上面那个视频

## 5.abstract
### 5.1抽象类
* java中使用抽象类，限制实例化
	```java
	public abstract class Animal(){

	}
	```
* 抽象类是不允许实例化的，但是可以通过向上转型，指向子类实例（其子类可以实例化）
* 应用场景：某个父类只是知道其子类应该包含怎样的方法，但无法准确知道这些子类如何实现这些方法
* 这个抽象还是要看工程，[网页链接](https://pan.baidu.com/play/video#/video?path=%2F计算机学习%2Fjava工程师%2F01.Java零基础入门%2F步骤二 java面向对象%2F七、java多态%2F3-9 类型转换案例（下）.mp4&t=-1)

### 5.2抽象方法
抽象方法
* 不允许包含方法体，只是表示包含这个方法，为了实现不同对象对同一方法的方法重写
* 子类中必须重写这个抽象方法，子类如果不想重写这个抽象方法，那子类就要被定义成抽象类
* 包含抽象方法的类一定是抽象类
### 5.3抽象类存在的意义
* 在父类中表示这个方法必须存在，方便子类中对这个方法的重写，也保证了子类必须有这个方法
* static final private不能与abstract并存的

### 5.4 [问题](https://pan.baidu.com/play/video#/video?path=%2F%E8%AE%A1%E7%AE%97%E6%9C%BA%E5%AD%A6%E4%B9%A0%2Fjava%E5%B7%A5%E7%A8%8B%E5%B8%88%2F01.Java%E9%9B%B6%E5%9F%BA%E7%A1%80%E5%85%A5%E9%97%A8%2F%E6%AD%A5%E9%AA%A4%E4%BA%8C%20java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%2F%E4%B8%83%E3%80%81java%E5%A4%9A%E6%80%81%2F5-1%20%E9%97%AE%E9%A2%98%E5%BC%95%E5%8F%91%E7%9A%84%E6%80%9D%E8%80%83.mp4&t=11)
* java中只支持单继承
* 如何解决一个类型中需要兼容多种类型特征的问题？
* 以及多个不同类型具有相同特征的问题呢？

## 6.接口
### 6.1定义
* 在`new`那一栏以后选择`interface`
	代码结构
	```java
	public interface IPhoto(){
		public abstract void network();
	}
	```
* 类实现接口
	```java
	public class Camera implements IPhoto{
		public void photo(){

		}
	}

	public class FourthPhone extends ThirdPhone implements Iphoto{
		public void photo(){

		}
	}
	```
* 实现方法（已有接口）
	```java
	IPhoto ip = new FourthPhone();
	ip.photo();
	ip = new Camera();
	ip.photo();						//可以用上述两个对象实现photo()这个功能
	```
### 6.2接口成员——抽象方法&常量
#### 接口定义抽象方法
* 接口定义了某一批类所需要遵守的规范
* 接口不关心这些类的内部数据，也不关心这些类里面方法的实现细节，它只规定这些类里必须提供某些方法
* 接口定义通常以`I`打头
* 接口访问修饰符只能是`public`或者默认
* 接口中抽象方法可不写`abstract`关键字，访问修饰符默认`public`
* 实现接口的类要实现该接口的所有方法，如果不想实现所有的方法，可以将该类定义成`abstract`，即抽象类（抽象类可以只表明这个类有这个功能），这来继承这个抽象类，谁就要实现所有的方法
* 注意接口和抽象类的一个区别：接口的方法不能有方法体，但是抽象类中的方法是可以有方法体的
#### 接口定义抽象常量
* 一般情况下的常量定义`public static final int TEMP = 20;`
* 接口中可以包含常量，默认会加上`public static final`
	代码示例
	```java
	public interface INet(){
		int TEMP = 20;
	}
	//调用接口中的常量
	INet.TEMP;		//注意常量不可以被重写赋值
	```
#### 接口定义为引用型
```java
INet net = new SmartWatch();		//SmartWatch是前面实现接口INet的类，这句话即为：定义一个INet类的对象，引用的空间是SmartWatch()创建的空间
//这么定义对象，可以通过`net.方法`的方式实现接口中的方法，且只能实现接口中定义的方法
System.out.println(net.TEMP)		//此时调用的TEMP是接口中定义的TEMP，而不是SmartWatch中定义的TEMP
```

### 6.3接口成员——默认方法&静态方法
**接口方法调用也是个小关键**
* 默认方法（在接口中定义的）
`default`：默认方法，可以带方法体（其他在接口中定义的方法不能够带方法体）
在接口中定义如下代码：
```java
public interface INet(){
	int TEMP = 20;
	default void connection(){
		System.out.println("我是接口中的默认链接");
	}
}
```
在接口中定义的默认方法，在继承了该接口的类即使没有定义该方法，也不会报错，因为默认使用了该方法
* 静态方法
`static`：静态方法，可以带方法体,同样子类（继承了该接口）没有定义该方法是也不会报错

```java
public interface INet(){
	int TEMP = 20;
	static void stop(){
		System.out.println("我是接口中的默认链接");
	}
}
```
* 默认方法和静态方法的区别
* 默认方法可以通过接口对象调用，静态方法要通过接口名调用
```java
INet net = new SmartWatch();
net.connection();
INet.stop();
```
* 默认方法可以再实现类中重写，并可以通过接口引用调用；静态类不可以再实现类中重写，可以通过接口名调用
示例代码
```java
public void connection(){
	INet.super.connection();	//并非一定要写的内容，表明调用接口中默认的方法
}
```
`INet.`只能调用接口中的静态成员，`Inet.super.`可以调用接口中的默认成员

### 6.4多接口中重命名默认方法处理的解决方案
继承多个接口的示例代码
```java
public class SmartWatch implements INet,IPhoto{

}
```
在多个接口中有重命名的方法，在被同一个类继承的时候，会报错，解决方法如下：对他们重名的内容进行重载
```java
public class SmartWatch implements INet,IPhoto{

	public void connection(){
		System.out.println("Smartwacth connection");		//只是示例，这句并非一定要写
	}

}
```
-------------------
此外，我们还可以实现继承和接口的同时出现，注意：继承一定要在接口的前面
可以继承唯一父类，但是可以同时实现若干接口（实现接口时一定要注意，要一定要实现接口中待实现的方法）
示例代码
```java
public class FourthPhone extends ThirdPhone implements IPhotos,INet{

}
```
如果在继承的父类和实现的接口中同时都有相同签名的方法，调用此方法时，默认调用父类派生的方法，当然在该子类中也可以重写该方法
###6.5多接口名常量处理的解决方案
* 常量在多接口间重命名，解决方法如下：
```java
interface one{
	static int x = 11;
}
interface two{
	static int x = 22;
}
public class TestOne implements One,Two{
	public void test(){
		System.out.println("One.x");
		System.out.println("Two.x");
	}
	
}
```
* 常量在多接口以及继承中重命名，解决方法如下：
```java
interface one{
	static int x = 11;
}
interface two{
	static int x = 22;
}
class Three{
	public static final int x = 33; 
}
public class TestOne implements One,Two{
	public int x = 4;
	public void test(){
		System.out.println(x);
	}
	
}
```

## 7.内部类
### 7.1定义/概念
* 内部类：在java中，可以将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类
* 外部类：包含内部类的类
* 为什么要将一个类定义在另一个里面呢？内部类隐藏在外部类之内，更好的实现了信息隐藏；同时避免其他类的调用，只有对应外部类才能使用
* 内部类分类
	* 成员内部类
	* 静态内部类
	* 方法内部类
	* 匿名内部类
### 7.2成员内部类
成员内部类又被称为普通内部类
示例代码
```java
//外部类人
public class Person{
	int age;

	public Heart getHeart(){
		return new Heart();
	}

	//成员内部类：心脏
	class Heart{
		public String beat(){
			return "心脏在跳动";
		}
	}
}
```
#### 内部类的实例化方法
内部类在外部使用时，无法直接实例化，需要借由外部类信息才能完成实例化
1. 方式1：new 外部类.new 内部类（即先进大门，再进卧室）——生成一个新的外部类以及它的内部类
2. 方式2：外部类对象.new 内部类
3. 方式3:(利用外部类中实例化内部类的方法）外部类对象.获取方法
```java
	Person lili = new Person();
	lili.age =12;
		
	//获取内部类对象实例，方式1：new 外部类.new 内部类（即先进大门，再进卧室）
	Person.Heart myHeart = new Person().new Heart(); 

	//获取内部类对象实例，方式2：外部类对象.new 内部类
	myHeart = lili.new Heart();
	
	//获取内部类对象实例，方式3:(利用外部类中实例化内部类的方法）外部类对象.获取方法
	myHeart = lili.getHeart();
```
#### 内部类的访问修饰符
* 内部类的访问修饰符可以任意，但是访问范围会受到影响
* 内部类可以直接访问外部类的成员；如果出现同名属性，优先访问内部类中定义的
* 如果想要访问外部类中定义的属性（内部类和外部类出现的同名属性）
	使用如下代码`Person.this.age`这句话的意思是，访问Perison这个类中age成员
* 在外部类想要访问内部类的成员，只能通过内部类实例，无法直接访问
* 内部类编译后，class文件命名：`外部类$内部类.class`
* 内部类中是否可以包含于外部类相同方法前面的方法？
### 7.3静态内部类
关键字`static`，静态内部类对象可以不依赖于外部类对象，直接创建
示例代码
```java
public class Person{
	int age;

	public Heart getHeart(){
		return new Heart();
	}

	//成员内部类：心脏
	static class Heart{
		public String beat(){
			return "心脏在跳动";
		}
	}
}
```
注意：
1. 静态内部类中，只能直接访问外部类的静态成员，如果需要调用非静态成员，可以通过对象实例
	例如：`new Person().eat();`
2. 静态内部类对象实例时，可以不依赖于外部类对象
3. 可以通过外部类.内部类.静态成员的方式，访问内部类中的静态成员，
	例如：`Person.Heart.say();`
4. 当内部类属性与外部类属性同名时，默认直接调用内部类中的成员；
	如果需要访问外部类中的静态属性，则可以通过`外部类.属性`的方式；
	如果需要访问外部类中的非静态属性，则可以通过`new 外部类().属性`的方式；
#### 获取静态内部类对象实例

```java
Person.Heart myHeart = new Person.Heart();
```

### 7.4方法内部类
#### 定义
方法内部类：定义在外部类方法中的内部类，也成局部内部类。
方法内部类使用规范
* 定义在方法内部，作用范围也在方法内
* 和方法内部成员使用规则一样，class前面不可以添加`public private protected static`
* 类中不能包含静态成员，但是可以包含`final`修饰的最终成员
* 内部类可以包含抽象方法，但是该内部类要被定义成抽象方法
实例代码：
```java
public Object getHeart(){
	class Heart{
		public int age = 13;
		int temp = 22;

		public void say(){
			System.out.println("hello");
		}

		public void eat(){

		}

		public String beat(){
			new Person().eat();
			return Person.age + "岁的心脏在跳动";
		}
	}

	return new Heart().beat();		//向上转型
}
```
调用`getHeart()`中的`beat()`
```java
	Person lili = new Person();
	lili.age = 12;
	System.out.println(lili.getHeart);
```

### 7.5匿名内部类
对某个类的实例只会使用一次，这个类的名字对整个程序而言可有可无。此时可以将类的定义与类的创建，放到一起完成，简化程序的程序。此种方法定义的内部类没有名字，又被叫做匿名内部类
#### 根据传入的不同的人的类型，调用对应的read方法(详情见`com.imooc.anonymous`)
* 方案一：（方案一、二中类的成员都有定义）
	```java
	public class PersonTest {
	//根据传入的不同的人的类型，调用对应的read方法
	//方案1 
	public void getRead(Man man) {
		man.read();
	}
	public void getRead(Woman woman) {
		woman.read();
	}
	
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		Man one = new Man();
		Woman two = new Woman();
		test.getRead(one);
		test.getRead(two);
	}
	}
	```
* 方案二
	```java
	public class PersonTest {
	//根据传入的不同的人的类型，调用对应的read方法
	//方案2
	public void getRead(Person person) {
		person.read();			//由父类与子类的关系可知，根据你传入的类型会
								//选择你传入类型重写的read方法
	}
	
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		Man one = new Man();
		Woman two = new Woman();
		test.getRead(one);
		test.getRead(two);
	}
	}
	```
* 方案三：使用匿名内部类的方法
```java
	public class PersonTest {
	//根据传入的不同的人的类型，调用对应的read方法
	//方案2
	public void getRead(Person person) {
		person.read();			//由父类与子类的关系可知，根据你传入的类型会
								//选择你传入类型重写的read方法
	}
	
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		test.getRead(new Person(){					//用这种方法实现抽象类中抽象方法的重写
			
			@override
			public void read(){
				System.out.println("男生喜欢读科幻小说");
			}
		})；
		test.getRead(new Person(){					//用这种方法实现抽象类中抽象方法的重写
			
			@override
			public void read(){
				System.out.println("女生喜欢读言情小说");
			}
		})；
	}
	```
匿名内部类：
1. 匿名内部类没有类型名称、实例对象名称
2. 编译后的文件命名：外部类$数字.calss 
3. 无法使用`private public protected abstract static`
4. 无法编写构造方法（因为没有名字）
5. 不能出现静态成员
6. 匿名内部类可以实现接口也可以继承父类，但是不可兼得