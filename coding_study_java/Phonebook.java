package practice;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
        public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashSet <String> hset = new  HashSet<String>();
		//map-put / set-add // hashSet�� key�� �˻�/���� �Ҷ�!
		
        for(String phone : phone_book) //set�� �� �ְ� �ݺ��Ϸ���
			hset.add(phone);
		String temp;
		Iterator <String> it= hset.iterator();
		while(it.hasNext()) {
			temp=it.next(); //���� ��
            
			for(String compare : phone_book) {// ������ �ٽ� �ݺ���
				if(!compare.equals(temp)&& temp.startsWith(compare))
					return false;
			}
		}
		return answer;
	}
}
