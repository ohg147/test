package day6;



public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] pd = new Product[5];

		pd[0] = new Product();
		pd[1] = new Product("��ī������", 3, 30000);
		pd[2] = new Product("���̸�����", 3, 3000);
		pd[3] = new Product("���α�����", 3, 3000);
		pd[4] = new Product("����������", 3, 3000);

		for (Product data : pd) {
			System.out.printf("��ǰ�̸� : %s ��� : %d ���� :%,d��\n", data.getName(), data.getBalance(), data.getPrice());
		}
	}
}
