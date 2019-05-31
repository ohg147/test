package day12;

import java.io.*;
import java.util.*;

public class FileOutExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File isDir = new File("c:/iotest");	 //File�� iotest�ּҿ� ��ü����
		if (!isDir.exists()) {
	        	isDir.mkdirs(); //���λ��� api
	        }
		
		try(FileWriter fw = new FileWriter("C:/iotest/today.txt");
				PrintWriter out = new PrintWriter(fw)){
			//�ּҰ����� ���ϻ����ϰ� �����Է°�ü ����
			//�׸��� ����϶�
			printDayInfo(out);
			//
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			
		}catch(IOException e) {
			System.out.println("���Ͽ� �����ϴ� ���� ������ �߻��߽��ϴ�.");
		}
		
	}
	
	static void printDayInfo(PrintWriter out) {
		
		GregorianCalendar gc = new GregorianCalendar();
		//API �̿� ��ü����
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH) + 1;//���� 0���� �ϱ� 1�����߷��� 
		int day = gc.get(Calendar.DATE);
		int week = gc.get(Calendar.DAY_OF_WEEK);//���� INT�� ���� ,,,�ٲ����
		
		out.println("������ " + year + "�� "+ month + "�� "+ day + "���Դϴ�.");
		out.println("������ " + getWeek(week) +"�����Դϴ�.");
		//������� ����
		
		gc = new GregorianCalendar(1995,2,9);
		int birthWeek = gc.get(Calendar.DAY_OF_WEEK);
		out.println("���� " + getWeek(birthWeek) + "���Ͽ� �¾���ϴ�.");
	}
	
	static String getWeek(int week) {
		switch(week) {
		case 1: return "��";
		case 2: return "��";
		case 3: return "ȭ";
		case 4: return "��";
		case 5: return "��";
		case 6: return "��";
		default: return "��";
		}
	}
}
