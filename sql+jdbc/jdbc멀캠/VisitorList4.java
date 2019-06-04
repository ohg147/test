package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList4 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT NAME, WRITEDATE, MEMO FROM VISITOR";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				// jdbc url, ����Ŭ����. LOCALHOST = ���� ������ġ/ 1521 ������ ������ġ
				"jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// ��ü ���ϰ������� null�� �ƴ϶�, ����ִ� resultset ��ü ���ϵ�
			// rs ������ Ȯ�� �Ұ� ���� next ȣ���ؾ߸� �˼�����{
			// ����� ����� �� ���̶� �����ϸ� ����Ʋ�� ����ϰ� ������ "����� �� ����" �̶�� ���
			// ����Ŭ �޸𸮿� �ø��°�. �ȵǸ� class not found exception
			if (rs.next()) {
				do {// ������ �ѹ����� �� �ݺ��� 2������ ����
					System.out.print(rs.getString("NAME"));
					System.out.print(rs.getString("WRITEDATE"));
					System.out.println(rs.getString("MEMO"));
				} while (rs.next());// �����ݷ�!

			} else {
				System.out.println("������ ����");
			}
		} catch (Exception e) {
			System.err.println("�����߻� : " + e.toString());
		}
	}
}

//			if (rs.next()) {
//				while (rs.next()) {
//					System.out.print(rs.getString("NAME"));
//					System.out.print(rs.getString("WRITEDATE"));
//					System.out.println(rs.getString("MEMO"));
//				}
