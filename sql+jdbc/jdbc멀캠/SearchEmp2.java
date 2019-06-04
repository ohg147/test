package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchEmp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT ENAME " + "FROM EMP join dept using (deptno)" + "WHERE DNAME=?";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {

			System.out.println("Scott ���� ���� �Ϸ�");
			String deptname;
			boolean check = true;
			do {
				System.out.println("�μ��� ? ");
				deptname = sc.nextLine().toUpperCase();
				pstmt.setString(1, deptname);

				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						// ���� ������ �� ����
						System.out.println(deptname + "�μ����� �ٹ��ϴ� ������");
						// �̸� �ݺ��ʿ�, �ʼ�
						do {
							System.out.println("\t" + rs.getString("ENAME"));
						} while (rs.next());

					} else {// ���� �����Ͱ˻� �ȵ� - xxx�μ�Ȯ���ϱ�
						String re_sql = "SELECT DNAME" + " FROM DEPT " + "WHERE DNAME='" + deptname + "'";
						try (Statement re_stmt = conn.createStatement(); // �ٽ� ��ü����
								ResultSet rs2 = re_stmt.executeQuery(re_sql)// ������ޱ�
						) {
							// �μ��˻� ��
							if (rs2.next())
								System.out.println(deptname + "�μ����� �ٹ��ϴ� ������ �����ϴ�.");
							// �μ�����
							else
								System.out.println(deptname + "�μ��� �������� �ʾƿ�. ");
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("���? Y");
				if (!"Y".equals(sc.nextLine().toUpperCase()))
					check = false;
			} while (check);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
