package day6;

class Book {
	String title;
	String author;
	int price;

	Book() {
		title = "�ڹ��� ����";
		author = "���� ��";
		price = 30000; 
	}

	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	String getBookInfo() {
		return title + " " + author + " : " + price;
	}
}

public class Booktest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] bk = new Book[5];
		bk[0] = new Book();
		bk[1] = new Book("���̽��� ����", "david", 10000);
		bk[2] = new Book("r �� ����", "david", 10000);
		bk[3] = new Book("�ڹٽ�ũ��Ʈ�� ����", "david", 10000);
		bk[4] = new Book("html�� ����", "david", 10000);

		for (int i = 0; i < bk.length; i++){
			//for (Book data :bk){  .... data.getBookInfo
			System.out.println(bk[i].getBookInfo());
		}
	}
}
