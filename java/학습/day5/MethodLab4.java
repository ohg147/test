package day5;

public class MethodLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] n1={10,20,30};
		int[] n2={100, 500, 300, 200, 400};
		int[] n3={1, 10, 3, 4, 5, 8, 7, 6, 9, 20};
		
		System.out.println("���� ū ����"+maxNumArray(n1)+"�Դϴ�.");
		System.out.println("���� ū ����"+maxNumArray(n2)+"�Դϴ�.");
		System.out.println("���� ū ����"+maxNumArray(n3)+"�Դϴ�.");
	}
	static int maxNumArray(int[] num) {
		int big=0;
		for(int i=0;i<num.length;i++) {
			if(num[i]>=big) {
				big=num[i];
			
			}
		}return big;
	}

	
	
}
