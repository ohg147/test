package day11;
import java.util.*;//����Ŭ�� �� Hashset �θ�������

public class LottoSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs=new HashSet<Integer>(); //<>�� ���� ����Ÿ�������ϴϱ� ���°� ������
		//����Ʈȭ  �θ�� Set���� �ص��ǰ� HashSet���ε���
		
//		for(int i=0;hs.size()<10;i++) {//���� size / size�� Ȯ�����������ϱ� ����� ����������
//			hs.add(new Random().nextInt(21)+10);
			//���� �ϱ����� .add()
			//i��� ������ while���� ����
		while(true) {
			hs.add(new Random().nextInt(21)+10);
			if(hs.size()==10) {
				break;
			}
			
		}System.out.println("������ �ζ� ��ȣ : "+hs);
		
	}

}
