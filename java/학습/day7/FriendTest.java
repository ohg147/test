package day7;

class Person {
	private String name; //����ȣ�� �Ұ� ��� getInfo �� name �θ�

	Person(String name) {
		this.name = name;
	}

	public String getInfo() {
		return name;
	}
}

class Friend extends Person {
	private String phoneNum;
	private String email;

	Friend(String name, String phoneNum, String email) {
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getInfo() {
		return super.getInfo() + "  " + phoneNum + "  " + email;
		//�ż��� �������̵� �����ִ� getInfo�� super�� �θ�
	}
}

public class FriendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend[] f = new Friend[5];

		f[0] = new Friend("a", "01000010001", "a@naver.com");
		f[1] = new Friend("b", "01000020002", "b@naver.com");
		f[2] = new Friend("c", "01000030003", "c@naver.com");
		f[3] = new Friend("d", "01000040004", "d@naver.com");
		f[4] = new Friend("e", "01000050005", "e@naver.com");

		for (int i = 0; i < f.length; i++) {
			//for(Friend data:f)
			System.out.println(f[i].getInfo());
		}
	}

}
