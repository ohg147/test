package day1;

public class IfTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grade=(int)(Math.random()*101); //0~100

		if(grade>=90)
			System.out.println(grade + "����  A ���");
		
		else if(grade>=80)
			System.out.println(grade + "����  B ���");
		
		else if(grade>=70)
			System.out.println(grade + "����  C ���");
		
		else if(grade>=60)
			System.out.println(grade + "����  D ���");
		
		else 
			System.out.println(grade + "����  E ���");
		
	}

}
