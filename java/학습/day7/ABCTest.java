package day7;

class A {
	A() {
		super();
		System.out.println("AŬ������ ��ü ����");
	}
}

class B extends A {
	B(int su) {
		System.out.println("BŬ������ ��ü ����");
	}
}

class C extends B {
	C() {
		super(10);
		System.out.println("CŬ������ ��ü ����");
	}
}

public class ABCTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
	}

}
