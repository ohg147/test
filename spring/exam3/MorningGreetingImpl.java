package exam3;

import org.springframework.stereotype.Component;

@Component("morning")
public class MorningGreetingImpl implements Greeting {

	@Override
	public void greet() {
		// TODO Auto-generated method stub
		System.out.println("������ ��ħ�Դϴ�.");
	}
	
}
