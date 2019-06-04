package jdbcexam;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//����Ŭ �޸𸮿� �ø��°�. �ȵǸ� class not found exception
		Connection conn =DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE",//jdbc url, ����Ŭ����
						//LOCALHOST = ���� ������ġ/ 1521 ������ ������ġ
						"jdbctest", "jdbctest");
		System.out.println(conn.getClass().getName());//�����ϰԵ� ��ü�� Ŭ������
		DatabaseMetaData mdata=conn.getMetaData();

		System.out.println(mdata.getClass().getName());
		
		System.out.println("���ӵ� db ���� : "+mdata.getDatabaseProductName());
		
		conn.close();
	}

}
