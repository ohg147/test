package day6;

class Student {
	String name;
	String project;
	int age;

	// Ŭ������ ���� ����= Ŭ���� ���
	void study() {
		System.out.println(name + " �л��� " + project + "�� �н��մϴ�");
	}

	String getStudentInfo() {
		return "�̸�: " + name + ", ����:" + age;
	}
}

public class studentTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st1 = new Student();// ��ü ����
		st1.name = "�Ѹ�";
		st1.project = "����";
		st1.age = 10;
		st1.study();
		System.out.println(st1.getStudentInfo());

		Student st2 = new Student();// ��ü ����
		st2.name = "��ũ";
		st2.project = "����";
		st2.age = 24;
		st2.study();
		System.out.println(st2.getStudentInfo());

		st1=st2;// ���� ��ü ������.�޸𸮻��� 4����Ʈ ���� 
		System.out.println("st1=st2");
		System.out.println(st1.name);//st1=st2 �ϸ� st2 ������ ��ü��
		System.out.println(st2.name);
		
	}
}
