package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest", "jdbctest");
		
		PreparedStatement pstmt=conn.prepareStatement(
				"UPDATE product SET balance=100 WHERE id=?");
		
		pstmt.setString(1, args[0]);
		int update_su=pstmt.executeUpdate();
		System.out.println("������ ���ڵ� �� : "+ update_su);
		System.out.println("��ǰ��ȣ�� "+args[0]+"�� ��ǰ�� balance �ʵ� �����Ϸ�");
		pstmt.close();
		conn.close();
	}

}
