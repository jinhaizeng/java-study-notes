package com.imooc.animal;

public class Master {
	/*喂宠物
	 * 喂猫：吃完东西后，主人会带着去玩线球
	 * 喂狗：吃完东西后，主人会带着去睡觉
	 * 养兔子、养鹦鹉、养乌龟...
	 * */
	//version1 每个宠物都定义一个feed函数，利用重载的方式来实现，但是一定对象多了以后
	//代码编写会很繁琐
//	public void feed(Cat cat) {
//		cat.eat();
//		cat.palyBall();
//	}
//	public void feed(Dog dog) {
//		dog.eat();
//		dog.sleep();
//	}
	
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
