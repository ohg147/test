package practice;

import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String partlist : participant) {
			if (map.containsKey(partlist)) // ���������� ���� ������get�Ѱ� value�� +1��
				map.put(partlist, map.get(partlist) + 1);
			else // �⺻������ �������� value=1
				map.put(partlist, 1);
		}
		// �ٸ���� : getOrDefaul(������,value��) +1) = ������ value���� +1 �ϰ� ������ value�� ����Ʈ������ 0
		// �ڵ�����

		// ���� ���Ƶ��� ==i ó��
		for (String partlist : completion)
			map.put(partlist, map.get(partlist) - 1); // ������ �ִ��ſ��� �� -1��

		for (String partlist : map.keySet()) { // key�� ã�Ƽ� ��
			if (map.get(partlist) != 0) { // value�� 0�� �ƴϸ�= �������ζ����� 1�̻��ΰ�
				answer = partlist;
				break;// ����� ȿ�����ø�/ ������ �Ѹ� return�Ǵϱ� ã���� ����
			}
		}
		return answer;
	}
}
