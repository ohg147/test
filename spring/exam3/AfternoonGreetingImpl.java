package exam3;

import org.springframework.stereotype.Component;

@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting {

	@Override
	public void greet() {
		// TODO Auto-generated method stub
		System.out.println("��ſ� ���ĵǼ���.");
	}

	
}
