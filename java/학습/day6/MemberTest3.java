package day6;

class Member3 {
	String name;
	String account;
	String passwd;
	int birthyear;

//	Member3() {
//		System.out.println("��ü ����");
//	}
//
//	Member3(String n, String a, String p, int by) {
//		name = n;
//		account = a;
//		passwd = p;
//		birthyear = by;
	Member3(String name, String account, String passwd, int birthyear) {
		this.name = name;
		this.account = account;
		this.passwd = passwd;
		this.birthyear = birthyear;

	
	}
}

public class MemberTest3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member3 objA[] = new Member3[3];

		objA[0] = new Member3("��ī��", "001", "111", 2000);
		objA[1] = new Member3("���̸�", "002", "222", 2000);
		objA[2] = new Member3("���α�", "003", "333", 2000);
//		objA[0].name = "��ī��";
//		objA[0].account = "001";
//		objA[0].passwd = "1111";
//		objA[0].birthyear = 2000;
		// System.out.println("ȸ��1: "+
		// objA[0].name+"("+objA[0].account+","+objA[0].passwd+","+objA[0].birthyear+")");

//		objA[1] = new Member3();
//		objA[1].name = "���̸�";
//		objA[1].account = "002";
//		objA[1].passwd = "2222";
//		objA[1].birthyear = 2000;
		// System.out.println("ȸ��2: "+
		// objA[1].name+"("+objA[1].account+","+objA[1].passwd+","+objA[1].birthyear+")");

//		objA[2] = new Member3();
//		objA[2].name = "���α�";
//		objA[2].account = "003";
//		objA[2].passwd = "3333";
//		objA[2].birthyear = 2000;
		// System.out.println("ȸ��3: "+
		// objA[2].name+"("+objA[2].account+","+objA[2].passwd+","+objA[2].birthyear+")");
		for (int i = 0; i < objA.length; i++)
			System.out.println("ȸ��" + i + ":" + objA[i].name + "(" + objA[i].account + "," + objA[i].passwd + ","
					+ objA[i].birthyear + ")");
	}
}
