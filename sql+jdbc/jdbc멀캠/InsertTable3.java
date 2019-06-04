package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable3 {//preparedStatement ����ӵ� ���� .ó���� �����Ͱ� �̹������� ��� �ݵ��

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			//JDBC ����̹��� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//������ ���̽��� �����Ѵ�. ������ jdbc url �����Ѵ�.
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest", "jdbctest");
			PreparedStatement stmt =conn.prepareStatement(
					"INSERT into product values (?,?,?,?,?)");
			
			stmt.setString(1, args[0]);

			stmt.setString(2, args[1]);

			stmt.setString(3, args[2]);

			stmt.setInt(4, Integer.parseInt(args[3]));
			stmt.setFloat(5, Float.parseFloat(args[4]));
			
			stmt.executeUpdate();
			System.out.println("�����͵��� �߰��Ͽ����ϴ�.");
			
			stmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println("���� �߻� : "+ e);
		}
	}
}
