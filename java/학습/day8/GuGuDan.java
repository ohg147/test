package day8;
//import���
//package day8.am;
//package day8.pm;
//import day8.Ŭ������;
//import day8.*;������ �ҋ�
//java.lang ��Ű���� Ŭ������ import ���� �ʾƵ� ��
//�̸��� ���� Ŭ�� ���� �� ��Ű���� import �Ҷ� Ŭ���� �տ� ��Ű���� ���̱�
import day5.MethodLab3;//�Ʒ��� ���ϸ� �Ἥ ��밡��

class Multiplication {
	private int dan;
	private int number;
	
	Multiplication() {
	}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication{
	GuGuDanExpr(){ //�⺻���� ������ ���� 
		
	}
	GuGuDanExpr(int dan){
		super(dan);
	}
	GuGuDanExpr(int dan, int number){
		super(dan,number);
	}
	
	static void printAll() { //1�ܺ��� 9�ܱ��� ����ϵ���
		for(int i=1; i<=9;i++) {
			for (int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}//static �� static �ƴ� ���� ������ = ����Ŭ�󽺲� printPart�������
		}
		
	}
	
}

public class GuGuDan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dan =MethodLab3.getRandom(1,20);
		int number =day5.MethodLab3.getRandom(1,20);			
		
		GuGuDanExpr ggdexpr=null;
		if(dan<10&&number<10) {
			ggdexpr =new GuGuDanExpr(dan,number);
			ggdexpr.printPart();
			
		}else if(dan<10&&number>=10){
			ggdexpr=new GuGuDanExpr(dan);
			ggdexpr.printPart();
			
		}else if(dan>=10) {
			GuGuDanExpr.printAll(); //static �� �޼���� �� �޼��� �̸����� ����
		}
		
		//Date d= new Date();
		//system.out.println("������"+d.getDate());		
	}


}
