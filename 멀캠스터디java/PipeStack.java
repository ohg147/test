package lol;

import java.util.*;

class Solution {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stk = new Stack<Character>();
		// Stack<Integer> stk= new Stack<Integer>();
		// ���ÿ� �ε��� �ְų�.
		// ���ÿ� arrangement ��Ʈ������ ��ȣ �ϳ��� �ְ� ���߿� ���ٰŴ�

		for (int i = 0; i < arrangement.length(); i++) {// �ϳ��� ��
			if (arrangement.charAt(i) == '(') {
				stk.add(arrangement.charAt(i));
			} else {// ')' �϶�
				stk.pop();// ���������� ���ý��ΰ� ��

				if (arrangement.charAt(i - 1) == '(') { // ���ÿ��� ���� �ᱹ ()�϶�=������
					answer += stk.size(); // ���� ����ŭ ������ �������� ����

				} else { // ')'�� �϶�
					answer++;// ���� ��ȣ ��ŭ ������ ����
				}
			}
		}
		return answer;
	}
}