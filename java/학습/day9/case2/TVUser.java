package day9.case2;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV();//ȣ���� �԰�ȭTV.java ,���� �Ｚ�� lg����ص� ������
		//TV�� ��ӹ��� �ڼհ�ü�� ���밡��
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}

}
