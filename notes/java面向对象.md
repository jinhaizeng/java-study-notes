[TOC]
# 一、java面向对象
## 1.类和对象
* 类是模子，确定对象将会拥有的特征（属性）和行为（方法）
* 对象是类的示例表现
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
方法中的举办变量没有初始值，但对于一个类当中的成员，系统对其是有初始值的（大多是0和null）

### 1.3单一职责原则
单一职责原则，有叫单一职责原则，即一个类有且只有一个引起功能变化的原因（即一个类最好只有一个功能，干一件事）
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

	public Cat(String name,int month,doubel weight,String species){
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
public Cat(String newname,int newmonth,doubel newweight,String newspecies){
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
public Cat(String name,int month,doubel weight,String species){
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
普通方法是可以被普通方法直接调用的（见以下代码run()中的eat()的调用方法，但是构造方法不可以直接被普通方法所调用，构造方法只能在构造方法之间调用。
```java
public class Cat {
	//成员属性：昵称、年龄、体重、品种
	String name;
	int month;
	double weight;
	String species;

	public Cat(String name,int month,doubel weight,String species){
	name = name;
	month = month;
	weight = weight;
	species = species;
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
## 课程总结
1. 定义类
	```java
	public class 类名{
		//定义属性部分
		[访问修饰符] 数据类型 属性名

		//定义方法部分
		[访问修饰符] 返回值 方法名(){

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
	* 声明对象 Cat one
	* 实例化对象 new Cat();
	* Cat one = new Cat();
4. 构造方法

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
1. 修改属性的可见性——设为`private
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

### 3.3static（静态信息）
#### 静态成员（static放在成员前面）
* static表示静态，用static修饰的变量被称为静态成员或类成员。static修饰的成员具有这样的特征：无论这个类最终实例化出多少对象，这个成员都会共用同一块静态空间，一个对象的static成员变量的修改会导致其他对象对应的static成员变量也跟着变化（实质：地址相同）
* 静态成员从类第一次加载时就产生，一直到这个类不再有任何对象被使用，此时空间才会被释放
* 类对象共用空间 
静态成员的两只访问方法：
1. 可以通过对象名进行访问：对象名.成员
2. 可以通过类名访问： 类名.成员（推荐使用这种方式），举例：`Cat.price = 2000;`

#### 静态方法/类方法（static+方法） 
注意：
* class前不可以加static（没有静态类）
* 局部变量前不可以加static（没有静态局部变量） 
* this.静态成员是可以成立的
* 在成员方法中可以直接访问类中静态成员
* 静态方法不能直接访问非静态（包括方法和属性），只能直接访问静态成员。如果一定要访问非静态成员的话，只能通过对象实例化后，对象.成员方法的方式访问非静态成员
* 静态方法中不能使用this

#### 代码块
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

#### 普通代码块中变量使用的知识
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

# 三、继承
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
	2. 方法名相同，参数列表相同（参数顺序、个数、类型），方法返回值相同
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

## super关键字的使用
* 子类既可以继承父类的方法，也可以重写自己的方法，如何判定在子类中调用的方法是继承自父类的还是自己写的
* super可以用来访问父类中的方法，如：`super.eat();`
* 父类的构造方法不能被继承，同样也不能被重写
## 继承的初始化顺序
主要问题：满足继承关系的子类对象是如何产生的
执行顺序：父类的静态代码块>子类的静态代码块>父类的构造代码块>父类的构造方法>子类的构造代码块>子类的钩子方法
访问修饰符不影响成员加载顺序，跟书写位置有关
子类找父类，再找父类的父类，直到找到最后的父亲
集成后的初始化顺序：
* 先加载父类静态成员，再加载子类静态成员
* 父类对象构造，子类对象构造
静态信息加载时，访问修饰符不影响成员加载顺序，跟书写位置有关

## 子类自由选择父类的某个构造方法
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
## super和this的对比
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