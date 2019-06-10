package lol;

import java.util.ArrayList;
import java.util.Arrays;

public class sort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		for (int data : solution(array, commands))
			System.out.println(data);
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// �迭ũ��𸣸� arraylist�� 
		///�迭�� ����ϰ��� �ϴ� ũ�⸸ŭ ���� �Ҵ��ϰ� 
		//arraylist�� �ʿ��Ҷ����� �Ҵ� =�󸮽�Ʈ���Ͱ���
		
		int first = 0, second = 0, third = 0;
		int answer[] = {};
		for (int i = 0; i < commands.length; i++) {
			first = commands[i][0];
			second = commands[i][1];
			third = commands[i][2];

			//int newAryLength = second - first + 1;
			//���� ����°ͺ��� �׳� �ϴ°� �� ��������
			int[] tmp = new int[second - first + 1];
			int newAryIndex = 0;
			for (int j = first - 1; j <= second - 1; j++) {
				tmp[newAryIndex++] = array[j]; //�ڸ� ������ �迭�� ����
			}
			Arrays.sort(tmp);// collections.sort(name)
			arr.add(tmp[third - 1]);//k��° �� ã�Ƽ� arr ����
		}
		//����Ʈ�� �ִ� ���ڸ� answerũ�� ���缭 �߶� ����
		answer = new int[arr.size()];
		for (int j = 0; j < arr.size(); j++) {
			answer[j] = arr.get(j);
		}
		return answer;
	}
}
