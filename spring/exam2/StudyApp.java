package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory =new ClassPathXmlApplicationContext("StudentBean");
		// st1, st2, st3 �̸��� �� ��ü���� ����
		Student st1=(Student)factory.getBean("st1");

		Student st2=(Student)factory.getBean("st2");

		Student st3=(Student)factory.getBean("st3");
		
		System.out.println(st1.getName()+"�� "+st1.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		System.out.println(st2.getName()+"�� "+st2.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		System.out.println(st3.getName()+"�� "+st3.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
	}

}
