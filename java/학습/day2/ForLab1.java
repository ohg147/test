package day2;

public class ForLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int evenNum = 0, oddNum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				evenNum += i;
			}
			else{
				oddNum += i;
			}
		}
		System.out.println("1���� 100������ ���ڵ� �߿���\n¦���� ����" + evenNum + "�̰� Ȧ���� ����" + oddNum + "�̴�.");
	}
}
