package day6;

import java.util.Scanner;

public class ScannerLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b;

		while (true) {//��ü �ݺ���
			System.out.println("ù ��° ���ڸ� �Է��ϼ��� :");
			a = sc.nextInt();

			System.out.println("�� ��° ���ڸ� �Է��ϼ��� :");
			b = sc.nextInt();

			if (a <= 0 || b <= 0) {
				System.out.println("���� �� please");
				continue;// �ݺ����������� ��� / �����γ����������� �� ã�Ƶ� �ٽ� ���ǽ� �϶�
			}
			System.out.println(" ������(+, -, *, /)�� �Է��ϼ��� :");
			String c = sc.next();
			// ���� ���϶� �ٽ� ���� �ϴ� ���/ ������ �����ϵ��� �ݺ���/�������϶� break�ɾ� ���ื��

			int result = 0;
			switch (c) {
			case "+":
				result = a + b;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;

			case "-":
				if (a >= b)
					result = a - b;
				else
					result = b - a;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;

			case "/":
				if (a >= b)
					result = a / b;
				else
					result = b / a;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;
			case "*":
				result = a * b;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);

			}
			sc.close();
		}
	}

}
