package threadexam;

import java.util.Calendar;

public class ThreadLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new Lab1();
		Thread t1 = new Thread(r1);
		Runnable r2 = new Lab2();
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(3 * 1000);
				System.out.println("number of milliseconds since January 1, 1970, 00:00:00 GMT");
			} catch (InterruptedException e) {
			}
		}

	}
}

class Lab1 implements Runnable {
	public void run() {

		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);

		for (int i = 1; i <= 3; i++) {
			try {
				Thread.sleep(10 * 1000); // 10�ʸ���
				System.out.println("������" + month + "�� " + date + "���Դϴ�.");
			} catch (InterruptedException e) {
			}
		}
	}
}

class Lab2 implements Runnable {
	public void run() {

		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(3 * 1000); // 10�ʸ���
				System.out.println(hour + "�� " + minute + "�� " + second + "��");
			} catch (InterruptedException e) {
			}
		}
	}
}
