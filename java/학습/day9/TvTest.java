package day9;

class TV{ //class ���� public ���� ���� ���������ؾ��� �ƴ� ���� ���ų� 
	private String model;
	private int size;
	private int channel;
	
	public TV() {
		
	}
	public TV(String model, int size, int channel) {
		this.model=model;
		this.size=size;
		this.channel=channel;
	}
	public void channelUp() {
		if(channel>10) {
			channel=1;
		}else {
			channel+=1;
		}
	}
	public void channelDown() {
		if(channel<1) {
			channel=10;
		}else {
			channel-=1;
		}
	}//channel �����ʿ� ���ʿ� ->get,set �ʿ� 
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	//model�� size�� �������ʿ� get ��������ȭ�ƴϴ�set���ʿ� 
	public String getModel() {
		return model;
	}
	public int getSize() {
		return size;
	}
}

class SaleTV extends TV{
	private int price;
	
	public SaleTV() {
		
	}
	public SaleTV(int price,String model,int size,int channel) {
		super(model,size,channel);//super���� ����
		this.price=price;
	}
	public void play() {
		System.out.printf("�Ǹ� TV ä�� %d���� ���θ� �÷��� �մϴ�.",super.getChannel());
	}
	public void sale() {
		System.out.printf("%s ���� ��ǰ�� �Ǹ��մϴ�. %d �� ������ �ּ���.",super.getModel(),this.price);
	}
	public String toString() {//public�ʿ�
		return String.format("�ǸŻ�ǰ���� : �𵨸�(%s), ����(%d��), ũ��(%d)",super.getModel(),this.price,super.getSize() );
	}
}

class RentalTV extends TV implements Rentable{
	private int price;
	public RentalTV() {
		
	}
	public RentalTV(int price,String model,int size,int channel) {
		super(model,size,channel);	
		this.price=price;
	}
	public void play(){
		System.out.printf("�뿩 TV ä�� %d���� ���θ� �÷��� �մϴ�.",super.getChannel());
	}
	public void rent() {
		System.out.printf("%s ���� ��ǰ�� �뿩�մϴ�. %d �� ������ �ּ���.",super.getModel());
	}
	public String toString() {
		return String.format("�ǸŻ�ǰ���� : �𵨸�(%s), ����(%,d��), ũ��(%d)",super.getModel(),this.price,super.getSize() );
	}//String.format ���� ���� �ް� �ƴϸ� printf / ,d 100,000���� ����
}
interface Rentable{
	void rent();
}


public class TvTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaleTV Stv= new SaleTV(300000,"SALETV-1",40,1);
		RentalTV Rtv=new RentalTV(100000,"RENTALTV-10",42,1);
		
		Stv.channelUp();
		Stv.channelUp();
		
		Rtv.channelDown();
		Rtv.channelDown();
		Rtv.channelDown();
		printAllTV(Stv);
		printAllTV(Rtv);
		printRentalTV((Rentable) Rtv);// ����ȯ�ʼ�
	}
	static void printAllTV(TV tv) {
		System.out.println(tv.toString());
		
		if(tv instanceof SaleTV) { //����ȯ
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
//			SaleTV stv=(SaleTV) tv; //����ȯ�ؼ� ��������� �ѹ���ȣ���ϴ°Գ���
//			stv.play();
//			stv.sale();
		}else if(tv instanceof RentalTV)
			((RentalTV)tv).play();
		
	}
	static void printRentalTV(Rentable tv) {//�ƱԸ�Ʈ�� ���޵� Rentable =tv����
		tv.rent();
	}

}














