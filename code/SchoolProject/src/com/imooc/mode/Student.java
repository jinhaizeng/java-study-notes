package com.imooc.mode;

public class Student {
	// ��Ա���ԣ�ѧ�š��������Ա�����
	private String studentNo;
	private String studentName;
	private String studentSex;
	private int studentAge;

	private Subject studentSubject;

	// �޲ι��췽��
	public Student() {

	}

	// �вι��췽��
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
	 * �����丳ֵ���޶�������10--100֮�䣬��֮��ֵΪ18
	 * 
	 * @param studentAge ���������
	 */
	public void setStudentAge(int studentAge) {
		if (studentAge < 10 || studentAge > 100)
			this.studentAge = 18;
		else
			this.studentAge = studentAge;
	}

	/**
	 * ��ȡרҵ�������û��ʵ��������ʵ�����ٷ���
	 * 
	 * @return רҵ������Ϣ
	 */
	public Subject getStudentSubject() {
		if (this.studentSubject == null)
			this.studentSubject = new Subject(); // �ǳ���Ҫ
		return studentSubject;
	}

	public void setStudentSubject(Subject studentSubject) {
		this.studentSubject = studentSubject;
	}

	/**
	 * ѧ�����ҽ���
	 * 
	 * @return ���ҽ��ܵ���Ϣ������������ѧ�š��Ա�����
	 */
	public String introduction() {
		String str = "ѧ����Ϣ���£�\n������" + this.getStudentName() + "\nѧ��:" + this.getStudentNo() + "\n�Ա�:"
				+ this.getStudentSex() + "\n����:" + this.getStudentAge() + "\n����רҵ����:"
				+ this.getStudentSubject().getSubjectName() + "\nרҵ���:" + this.getStudentSubject().getSubjectNo();
		return str;
	}
}
