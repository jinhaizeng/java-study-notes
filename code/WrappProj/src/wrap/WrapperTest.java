package wrap;

public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer one = new Integer(100);
		Integer two = new Integer(100);
		System.out.println("one==two�Ľ����"+(one == two));			//���false
		
		Integer three = 100;	//�Զ�װ��
		//�൱����ʽ��ִ���ˣ�Integer three = Integer.valueOf(100);
		//��Ϊ������û�У���������ڻ���������һ��
		System.out.println("three==100�Ľ���ǣ�"+(three == 100));	//�Զ�����		//���true
		
		Integer four = 100;
		////�൱����ʽ��ִ���ˣ�Integer three = Integer.valueOf(100);
		//�����ֵ>-128��<127ʱ����ֱ�ӵ��û��������Ѿ��������Ǹ�100
		//��ʱthree��fourָ�򻺴�����ͬһ��ռ�
		System.out.println("three==four�Ľ���ǣ�"+(three == four));		//���true
		
		Integer five = 200;
		System.out.println("five==200�Ľ���ǣ�"+(five == 200));			//���true
		
		Integer six = 200;
		//��ֵ����127����ֱ��ͨ��new integer(200)�����µ�ʵ��������
		System.out.println("five==six�Ľ���ǣ�"+(five==six));			//���false
			
	}

}
