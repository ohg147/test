package exam3;

import org.springframework.stereotype.Component;

@Component("Evening")
public class EveningGreetingImpl implements Greeting {

	@Override
	public void greet() {
		// TODO Auto-generated method stub
		System.out.println("����� ����Ǽ���.");
	}

	
}
