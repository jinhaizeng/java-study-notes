package com.imooc.set;

public class Cat {
	private String name;
	private int month;
	private String Species;
	
	//���췽��
	public Cat(String name, int month, String species) {
		super();
		this.name = name;
		this.month = month;
		Species = species;
	}

	//getter��setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getSpecies() {
		return Species;
	}

	public void setSpecies(String species) {
		Species = species;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Species == null) ? 0 : Species.hashCode());
		result = prime * result + month;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() == Cat.class) {
			Cat cat =(Cat)obj;
			return cat.getName().equals(name)&&(cat.getMonth()==month)&&(cat.getSpecies().equals(Species));
		}
		return true;
	}
	
	@Override
	public String toString() {	//����д�Ļ���println������Ƕ���ĵ�ַ
		return "[����=" + name + ", ����=" + month + ", Ʒ��=" + Species + "]";
	}  
	
	
	
}
