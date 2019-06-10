
package binary_serach_tree;
import java.util.*;

public class BinarySerachTree {
	private Node root;

	public BinarySerachTree() {
		root = null;// ��Ʈ ��� ����=�� �������
	}

	public void add(int val) {// ����� ����
		// (1)�� ����
		// 1.������ ����ֳ�?
		Node current = root; // ������ root�����̸�=������ ���ġ
		while (true) {

			if (root == null) {
				root = new Node(val); // ����� ��� ����= ȣ��

			} else { // ���� ��忡 �̹� ������.. ������ ��� ���� �񱳽���
				if (current.val == val) {// ����尪==�����ҳ�尪 : �ߺ��ȉ�=����
					return false;

				} else if (current.val < val) { // ã�� �� �� ũ�� �߽ɿ��� ���������� �������̵�
					current = current.right;
					if (current.right == null) { // �����ʳ�尡 ��������� ��� ����
						current = new Node(val);
					}

				} else if (current.val > val) {
					current = current.left;
					if (current.left == null) {
						current = new Node(val);
					}
				}
			}
		}
	}

	public Boolean search(int val) { // add�� Ž��
		// (2)�� ����
		Node current = root;
		while (true) {
			if (current.val < val)
				current = current.right;
			else if (current.val > val)
				current = current.left;
			else // ���� ��
				current = false;// ����
		}
	}

	public Boolean remove(int val) {
		// (4)�� ����
		// ���� =����
		// ����尪==������ ��尪 : ����� �� �������� : ����� ����Ʈ�� Ȯ��
		// ����Ʈ�� ���� = ����� ����
		// ���� ����Ʈ��=
		// ������ ����Ʈ��=
		// ����=

	}

	private int getkMinVal() { //�迭�� ���� ���ʰ�
		// (3)�� ����
		Node current=root;
		while(true) {
		if(current==null)
			false;
		else if(current!=null) {
			current=current.left;
			if(current==null)
				false;
		}
		}
	}

	private int getkMaxVal() { // ���� �����ʰ�
		// (3)�� ����		
		Node current=root;
		while(true) {
		if(current==null)
			false;
		else if(current!=null) {
			current=current.right;
			if(current==null)
				false;
		}
		}
	}

	public void printTree() {
		System.out.print("[Print tree]");
		System.out.printf("\nMin value: %d", getkMinVal());
		System.out.printf("\nMax value: %d", getkMaxVal());
		System.out.print("\nIn-order : ");
		printInOrder(this.root);
		System.out.print("\nPre-order : ");
		printPreOrder(this.root);
		System.out.print("\nPost-order : ");
		printPostOrder(this.root);
		System.out.print("\nLevel-order : ");
		printLevelOrder(this.root);
	}

//���⼭�� ��¼������
	// ������-�߰���-ū��
	private void printInOrder(Node current) {// ���� : ��-��Ʈ-��
		// (5)�� ����
		while (current != null) {
			System.out.println(current.val);
			printInOrder(current.left);
			printInOrder(current.right);
		}
	}

	private void printPreOrder(Node current) { // ���� : ��Ʈ-��-�� // ������-�߰���-ū��
		// (5)�� ����
		while (current != null) {
			printInOrder(current.left);
			System.out.println(current.val);
			printInOrder(current.right);
		}
	}

	private void printPostOrder(Node current) {// ����: ��-�� -��Ʈ
		// (5)�� ����
		while (current != null) {
			printInOrder(current.right);
			System.out.println(current.val);
			printInOrder(current.left);
		}
	}

	private void printLevelOrder(Node current) { // �������� : ��-�� -��Ʈ??
		// (5)�� ���� //���� queue �� �Ѵ�
		Queue <Integer> Q=new Queue<Integer>();
		
	}
}
