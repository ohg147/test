package day7;
//import java.util.Date;
class Parent{
	int num=1;
}
class Child extends Parent{
	public String toString() { 
		//������ ���������� �ڽſ� �°� �缳��->�̸��� �ǰ��� but ������ �ٲٱ�����='�޼��� �������̵�'
		return "child ��ü �Դϴ�~!";
	}
}

public class ParentChildTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent obj=new Parent(); //��ü����
		System.out.println(obj.toString());
		Child obj2 =new Child();
		System.out.println(obj2.toString());
		System.out.println(obj.num);
		System.out.println(obj2.num);
		System.out.println("��ü�� ����: " + obj);
		System.out.println("��ü�� ����: " + obj2);
		//java.util.Date d =new java.util.Data();
		//System.out.println("��ü�� ���� : "+d);
	}

}
