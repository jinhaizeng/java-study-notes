package com.imooc.mode;

public class Student {
	// 成员属性：学号、姓名、性别、年龄
	private String studentNo;
	private String studentName;
	private String studentSex;
	private int studentAge;

	private Subject studentSubject;

	// 无参构造方法
	public Student() {

	}

	// 有参构造方法
	public Student(String studentNo, String studentName, String studentSex, int studentAge) {
		this.setStudentNo(studentNo);
		this.setStudentName(studentName);
		this.setStudentSex(studentSex);
		this.setStudentAge(studentAge);
	}

	public Student(String studentNo, String studentName, String studentSex, int studentAge, Subject studentSubject) {
		this.setStudentNo(studentNo);
		this.setStudentName(studentName);
		this.setStudentSex(studentSex);
		this.setStudentAge(studentAge);
		this.setStudentSubject(studentSubject);
	}

	// getter setter
	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public int getStudentAge() {
		return studentAge;
	}

	/**
	 * 给年龄赋值，限定必须在10--100之间，反之赋值为18
	 * 
	 * @param studentAge 传入的年龄
	 */
	public void setStudentAge(int studentAge) {
		if (studentAge < 10 || studentAge > 100)
			this.studentAge = 18;
		else
			this.studentAge = studentAge;
	}

	/**
	 * 获取专业对象，如果没有实例化，先实例化再返回
	 * 
	 * @return 专业对象信息
	 */
	public Subject getStudentSubject() {
		if (this.studentSubject == null)
			this.studentSubject = new Subject(); // 非常重要
		return studentSubject;
	}

	public void setStudentSubject(Subject studentSubject) {
		this.studentSubject = studentSubject;
	}

	/**
	 * 学生自我介绍
	 * 
	 * @return 自我介绍的信息，包括姓名、学号、性别、年龄
	 */
	public String introduction() {
		String str = "学生信息如下：\n姓名：" + this.getStudentName() + "\n学号:" + this.getStudentNo() + "\n性别:"
				+ this.getStudentSex() + "\n年龄:" + this.getStudentAge() + "\n所报专业名称:"
				+ this.getStudentSubject().getSubjectName() + "\n专业编号:" + this.getStudentSubject().getSubjectNo();
		return str;
	}
}
