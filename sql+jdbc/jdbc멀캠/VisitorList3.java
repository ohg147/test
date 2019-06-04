package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList3 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT NAME, WRITEDATE, MEMO FROM VISITOR";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", // jdbc url, ����Ŭ����
				// LOCALHOST = ���� ������ġ/ 1521 ������ ������ġ
				"jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// TODO Auto-generated method stub
			// ����Ŭ �޸𸮿� �ø��°�. �ȵǸ� class not found exception

			System.out.println(conn.getClass().getName());
			System.out.println(stmt.getClass().getName());
			System.out.println(rs.getClass().getName());

			while (rs.next()) {
				System.out.print(rs.getString("NAME"));

				System.out.print(rs.getString("WRITEDATE"));

				System.out.println(rs.getString("MEMO"));
			}
		} catch (Exception e) {
			System.err.println("�����߻� : " + e);

		}
	}
}
