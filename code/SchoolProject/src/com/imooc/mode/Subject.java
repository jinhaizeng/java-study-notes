package com.imooc.mode;
/**
 * רҵ��
 * @author MR Code
 *
 */
public class Subject {
	// ��Ա���ԣ�ѧ�����ơ�ѧ�Ʊ�š�ѧ������
	private String subjectName;
	private String subjectNo;
	private int subjectLife;

	// �޲ι��췽��
	public Subject() {

	}

	// �вι��췽��,ʵ�ֶ����Եĸ�ֵ
	public Subject(String subjectName, String subjectNo, int subjectLife) {
		this.setSubjectName(subjectName);
		this.setSubjectNo(subjectNo);
		this.setSubjectLife(subjectLife);
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public String getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getSubjectLife() {
		return subjectLife;
	}

	// ����ѧ�����ƣ����Ʊ���>0
	public void setSubjectLife(int subjectLife) {
		if (subjectLife <= 0)
			return;
		this.subjectLife = subjectLife;
	}

	/**
	 * רҵ���ܵķ���
	 * @return רҵ���ܵ������Ϣ���������ơ���š�����
	 */
	public String info() {
		String str = "רҵ��Ϣ���£�\nרҵ����:" + this.getSubjectName() + "\nרҵ���:" + this.getSubjectNo() + "\nѧ������:"
				+ this.getSubjectLife();
		return str;
	}
}
