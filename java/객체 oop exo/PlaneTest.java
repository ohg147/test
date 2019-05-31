package work;

abstract class Plane{
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		
	}
	public Plane(String planeName, int fuelSize) {
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	public String getPlaneName() {
		return planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	public void refuel(int fuel) {
		fuelSize+=fuel;//private������ ���� Ŭ�󽺶� �����θ�������
	}
	
	public abstract void flight(int distance);

}
 class Airplane extends Plane{
	public Airplane() {
		
	}
	public Airplane(String planeName, int fuelSize) {
		super(planeName,fuelSize);
	}
	public void flight(int distance) {
		super.setFuelSize(super.getFuelSize()-30*(distance/10));
	}
}
 class Cargoplane extends Plane{
	public Cargoplane() {
		
	}
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName,fuelSize);
	}
		public void flight(int distance) {
			super.setFuelSize(super.getFuelSize()-50*(distance/10));
		}
	}


 class PlaneTest {

	public static void main(String[] args) {
	
		Plane[] lt=new Plane[2]; //absŬ�󽺴� ����� �ǵ� �ν��Ͻ�ȭ �ȵǼ� ����Ʈ��.
		//����θ�Plane �� ������ �Ѵ� ���ҷ� ��밡��.
		lt[0] =new Airplane("L747",1000);
		lt[1] =new Cargoplane("C40",1000);
		//�ѹ��� - Plane[] lt={new ..., new...}
		printInfo(lt);
		System.out.println("[100 ����]");
		//for (Plane data: lt) . data.flight(100);
		lt[0].flight(100);
		lt[1].flight(100);
		printInfo(lt);
		System.out.println("[200����]");
		lt[0].refuel(200);
		lt[1].refuel(200);
		printInfo(lt);
	}
	public static void printInfo(Plane[] list) {
		System.out.println("Plane          fuelSize           ");
		System.out.println("--------------------------------");
		//for(Plane data:list){data.getPlaneName() ������. /Plane �θ�ü
		System.out.println(list[0].getPlaneName()+"\t\t"+list[0].getFuelSize());
		
		System.out.println(list[1].getPlaneName()+"\t\t"+list[1].getFuelSize());
		
		
	}

}
