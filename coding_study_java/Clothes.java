package practice;

import java.util.HashMap;

public class Clothes {
	public int solution(String[][] clothes) {
        int answer = 1; //�ǻ�� 1���� �����̴ϱ� =������ �ϳ��� ����
        HashMap <String,Integer> hmap=new HashMap<>();
        // ����, ������ ���� ���� =hmap
        
        for(int i=0;i<clothes.length;i++) {//���� �ֱ�[i][1] ������ //�ߺ�������ϱ�
        	if(hmap.containsKey(clothes[i][1])) hmap.put(clothes[i][1], hmap.get(clothes[i][1])+1);
        	else //�⺻������ +1
        		hmap.put(clothes[i][1],1);
        }
        for(int n: hmap.values()) {
        	answer *=(n+1); //�⺻�� ����� �� a+b+(a*b)��
        }
        //���� �� ���Դ� ���� -1 �ؾ���
        answer -=1;
        
        return answer;
	}
}
/*������
 * for(int i=0;i<clothes.length;i++) {//���� �ֱ�[i][1] ������ //�ߺ�������ϱ�
        if(hmap.containsKey(clothes[i][1])) 
                hmap.put(clothes[i][1], hmap.getOrDefault(clothes[i][1],1)+1);
       	else //�⺻������ +1
        		hmap.put(clothes[i][1],2); (n+1)��� �ѹ��� 1�� +1�Ѱ� ���� �ٲ�
        }
        for(String key: hmap.keySet()) {
        	answer *=hmap.get(key);
        }
        
        �Ǵ�
        else //�⺻������ +1
        		hmap.put(clothes[i][1],1); 1�����ϰ�
        }
        for(String key: hmap.keySet()) {
        	answer *=(hmap.get(key)+1); �� value���� +1��
        }
 */
