package day7;

class SalaryExpr {  //class Ŭ�󽺸� �߰�ȣ.
	
	private int bonus; //�����������ڳ� �ż��带 ���ظ� �����ϵ���
	
	SalaryExpr(){ 
		//bonus=0;
	}//��������� 0�� �Ҵ� -> 0 �Է¾��� �ڵ� �ʱ�ȭ  or this(0);
	
	SalaryExpr(int bonus){ //������ �ż���=Ŭ�󽺸�� ����! ���ϰ�����! �ʿ�� this
		this.bonus=bonus; }
	//�Ű����� ���ʽ� �� �޾Ƽ� ��������� ���� = �����̸� =this
	
	int getSalary(int grade) { 
				if(grade==1)
					 bonus+=100;
				else if(grade==2)
					 bonus+=90;
				else if(grade==3)
					 bonus+=80;
				else if(grade==4)
					 bonus+=70;
				return bonus; //���ϰ� �ϳ�. bonus 
			}
}
public class SalaryExam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month=(int)(Math.random()*12)+1;
		//public Ŭ�󽺾��̶� ��밡��(day5.MethodLab3.getRandom(12);
		int grade=(int)(Math.random()*4)+1;
		
		//���� �̸� ���� .�ʱ�ȭ �ݺ��� �������� ��� �� ����. ���� ��������
		SalaryExpr gift; //���������� �������� =null �� �ؾ���
		if(month%2==0) {
			gift=new SalaryExpr(100); //"salaryexpr(100)(<-arg�ִ°� ȣ��)�� ������ salaryexpr �� �ν��Ͻ��� ����"
			
		}else {
			gift=new SalaryExpr();
			
			
		}//����Ʈ ���� ������ if else ���� ������ �ѹ��� ��.
		System.out.printf("%d�� %d����� ������ %d �Դϴ�",month,grade,gift.getSalary(grade));
	}

}
