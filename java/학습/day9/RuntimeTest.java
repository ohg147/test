package day9;

import java.net.InetAddress;

public class RuntimeTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Runtime r= Runtime.getRuntime();
		//r.exec("c:/windows/notepad.exe");//�޸��忭
		InetAddress inet=InetAddress.getLocalHost();
		System.out.println(inet);
	}

}
