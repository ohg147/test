package lol;

public class LinkedList {
	LinkedNode first; // LinekedList�� ù node
	LinkedNode last; // LinekedList�� ������ node

	LinkedList() {
		first = null;
		last = null;
	}

	protected void addFirst(int val) {// STACK
		// null�� ������ �����ϰ� , �̹� �������� �о ���߰�.
		if (first == null) {
			first = new LinkedNode(val);// �� ���ÿ� ��� �����ϰ� ������
			last = first;// �ϳ���
		} else {
			// �� ��� ����
			LinkedNode newStack = new LinkedNode(val);
			// �� ����� ���� ���-.next�� ���� ���� top ���� ����
			newStack.next = first;// �ּҰ�
			// �迭�� ���� ����first�� �и��鼭 ���ε����� ��Ұ� first��
			// ���� first�� �� ���� ����
			// ....
			// �� �� ������ �� ��� �θ�
			first = newStack;
		}
	}

	protected void addLast(int val) {// QUEUE
		if (first == null) {
			first = new LinkedNode(val);
			last = first; // ��ó���̶� �� �ϳ� =front���� last
		} else {
			// �̹� ��忡 ���ְ� ���� ��� �̾ ����
			LinkedNode newQ = new LinkedNode(val);
			// first ����
			// last �þ ó�� last�� ���� ��� �����, ���� ��� ���� last��
			last.next = newQ; // �� ��� ����, �� �ְ� ���ο� ���� ����
			last = last.next; // ���� ��尡 ������ġ��/�ּ�..��ġ
		}
	}

	protected Boolean removeFirst() {
		if (first == null)
			return false;
		else {
			if (first == last) {// 1�� ������

			} else {// �������϶�
				first = first.next; // ������ ȣ���� ������
			}
		}
		return true;

	}

	protected Boolean removeLast() { // n��° ���� =n-1��带 n+1����
		//null �϶� / 1���϶� first=last /�������϶�
		if (first == null)
			return false;
		else {
			if (first == last)
				first = null;
			else {
				//������ġ����=first ��� �ϳ� ����=current
				//��尡 ��� ���� ��带 �θ��鼭 last ���� Ȯ����. last �̸� ����
				//
				LinkedNode current;
				for (current = first; current.next != last; current = current.next)
					;
				//current.next == last / ������尡 ���������� ã����
				current.next = null; // Ŀ��Ʈ -last = Ŀ��Ʈ ������ last �̹Ƿ� null �����ؼ� ���ְ�
				last = current; //���� Ŀ��Ʈ ��ġ�� last�� ��.
			}
		}
		return true;
	}

	protected void printList() {
		LinkedNode current = first;
		while (current != null) { // current ��尡 null �ƴҶ� ���� ����
			System.out.println(current.val);
			current = current.next; // next ��带 current�� ���� ����
		}
	}
}
