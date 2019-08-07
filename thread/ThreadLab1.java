package threadexam;

import java.util.Calendar;

public class ThreadLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thr1 t1 = new Thr1();
		Thr2 t2 = new Thr2();
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

	class Thr1 extends Thread {
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


class Thr2 extends Thread {
	public void run() {

		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(3 * 1000); // 10�ʸ���
				System.out.println(hour + "�� " + minute + "�� " + second + "��");
			} catch (InterruptedException e) {}
			

		}
	}
}
