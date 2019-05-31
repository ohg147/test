package day10;

import java.util.Random;//Random Ŭ�� ����ϱ�

class DuplicateException extends Exception {
	DuplicateException() {
		super("�ߺ��� �ζ� ��ȣ�� �߻��߽��ϴ�.");
	}
}

class LottoMachine {
	private int[] nums;

	public LottoMachine() {
		nums = new int[6];
	}

	public void creatLottoNums() {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Random().nextInt(20) + 1;
		}
	}

	public void checkLottoNums() throws DuplicateException {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					throw new DuplicateException();
				}
			}
		}
	}

	public int[] getNums() {
		return nums;
	}
}

public class LottoGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LottoMachine lot = new LottoMachine();

		// lot�� ����ϸ� �ּҰ����ͼ�
		// ���迭 �����ʿ�����
		int lot1[];
		try {

			lot.creatLottoNums();
			lot.checkLottoNums();

		} catch (DuplicateException e) {
			// System.out.println("�ߺ��� �ζ� ��ȣ�� �߻��߽��ϴ�");
			System.out.println("���� �߻� : " + e.getMessage());// �ڵ� dupŬ�� ������Ʈ
			return;//main�� ������ jvm���װ��� �� �ý���������
			//system.exit(-1); �������� �Ⱦ��°� ����
		}

		lot1 = lot.getNums();
		// �׷��� ���迭���� �̰����� length�� ����������
		for (int i = 0; i < lot1.length; i++) {
			System.out.print(lot1[i]);
			if (i < lot1.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
