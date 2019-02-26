[TOC]
# java面向对象
## 类和对象
* 类是模子，确定对象将会拥有的特征（属性）和行为（方法）
* 对象是类的示例表现
* 类是对象的类型（抽象概念，即模板）
* 对象是特定类型的数据（一个看得到、摸得着的具体实体）
* 属性：对象具有的各种静态特征
* 方法：对象具有的各种动态行为
### 创建类
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
### 对象实例化
方法中的举办变量没有初始值，但对于一个类当中的成员，系统对其是有初始值的（大多是0和null）

### 包名的推荐命名规范
1. 英文字母小写
2. 域名的倒序