package mobile;

abstract class Mobile{
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Mobile(){
	}
	public Mobile(String mobileName, int batterySize, String osType) {
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
	//get�̳� set�� ������ ������ ���� ����
	//sauce���� getters setters �����޴� �ϸ� ��
	
	public String getMobileName() {
		return mobileName;
	}
	public int getBatterySize() {
		return batterySize; //���� �̿� �ż���. ���͸������� ��
	}
	public String getOsType() {
		return osType;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;//�ԷµǴ� ���͸� �� ���� ..
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
		
	public abstract void operate(int time) ;//abs�� �����ݷ�!�ٵ�������� ������ �߰�ȣ=�Ϲݸ޼���//{
	//} �ݵ�� �������̵� ����� ��������
	public abstract void charge(int charge);
}
//getters �� setters �̿��ϱ�!


class Ltab extends Mobile{
	public Ltab() {
	}
	public Ltab(String mobileName,int batterySize, String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {//�� abs �ż��� �������̵� ���͸� ���� �ð��� 10�ʾ� ����
		super.setBatterySize(super.getBatterySize()-time*10); 
		
	}
	public void charge(int time) {//�� abs �ż��� �������̵�
		super.setBatterySize(super.getBatterySize()+time*10); 
	}
}
class Otab extends Mobile{
	public Otab() {
	}
	public Otab(String mobileName,int batterySize, String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {//�� abs �ż��� �������̵� ���͸� ���� �ð��� 10�ʾ� ����
		super.setBatterySize(super.getBatterySize()-time*12); 
		
	}
	public void charge(int time) {//�� abs �ż��� �������̵�
		super.setBatterySize(super.getBatterySize()+time*8); 
	}
}

public class MobileTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ltab lt=new Ltab("Ltab",500,"ABC-01");
		Otab ot=new Otab("Otab",1000,"XYZ-20");
		
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("10�� ����");
		lt.charge(10);
		ot.charge(10);
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("5�� ��ȭ");
		lt.operate(5);
		ot.operate(5);
		printTitle();
		printMobile(lt);
		printMobile(ot);
		
	}
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName()+"\t\t"+mobile.getBatterySize()+"\t\t\t"+mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println("Mobile         "+"Battery           "+"OS");
		System.out.println("---------------------------------------");
	}
}
