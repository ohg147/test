package day4;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		char play[][] = { { 'X', 'X', 'X', 'R', 'X', 'R' }, { 'R', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'R', 'X', 'X', 'X' }, { 'R', 'X', 'X', 'x', 'X', 'X' }, { 'X', 'R', 'F', 'X', 'X', 'X' },
				{ 'X', 'R', 'X', 'R', 'X', 'R' }, };

		int catchNum = 0;
		/*
		 * R�� �䳢�̰� F�� ����� ������ ��ġ�� ������ �ְ� ������ ��ġ���� �밢���� �������θ� �̵� �����ϴ�. ���� ���� 2���� �迭 �����Ϳ���
		 * �䳢�� ��� ��ڴ°�?
		 */
		int fPosi = 0;
		int fPosj = 0;

		// ����
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'F') {
					fPosi = i;
					fPosj = j;
					break;
				}
			}
		}

		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'R') {
					if (fPosi == i) {
						catchNum++;
					}
					if (fPosj == j) {
						catchNum++;
					}

					if ((i + j == fPosi + fPosj || i - j == fPosi - fPosj)) {
						catchNum++;
					}
				}
//						if ((i == fPosi || j == fPosj || fPosi - fPosj == i-j || fPosi + fPosj  == i+j ) && play[i][j] == 'R')
//							catchNum++;
//					}
			}
		}
		System.out.println("������ ��ġ : (" + fPosi + "," + fPosj + ")");
		System.out.printf("����� �䳢�� %d ���� ��´�.", catchNum);
	}
}