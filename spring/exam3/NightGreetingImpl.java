package exam3;

import org.springframework.stereotype.Component;

@Component("night")
public class NightGreetingImpl implements Greeting {

	@Override
	public void greet() {
		// TODO Auto-generated method stub
		System.out.println("�ȳ��� �ֹ�����.");
	}

	
}