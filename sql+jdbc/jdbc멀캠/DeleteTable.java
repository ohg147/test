package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest", "jdbctest");
		
		PreparedStatement pstmt=conn.prepareStatement(
				"DELETE from product WHERE balance< ?");
		
		pstmt.setInt(1,Integer.parseInt(args[0]));
		
		int del_su=pstmt.executeUpdate();
		
		System.out.println("��� "+args[0]+"������ ��ǰ ������ "+del_su+"�� �����Ͽ����ϴ�.");
		pstmt.close();
		conn.close();

	}

}
