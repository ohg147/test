package day6;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ù ��° ���ڸ� �Է��ϼ��� :");
		Scanner sc= new Scanner(System.in); 
		int a,b;
		
		a=sc.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ��� :");
		b=sc.nextInt();
		System.out.println(" ������(+, -, *, /)�� �Է��ϼ��� :");
		String c=sc.next();
		
		int result=0;
		switch(c) {
			case "+" : 
				result= a+b;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;
				
			case "-" : 
				if(a>=b) 
					result= a-b;
				else
					result=b-a;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;
				
			case "/" : 
				if(a>=b) 
					result= a/b;
				else
					result=b/a;
				System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				break;
			case "*" : result= a*b;
			System.out.printf("%d �� %d�� %s ���� ����� %d �Դϴ�.", a, b, c, result);
				
		
		}sc.close();
	}
	

}
