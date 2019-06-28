package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// DB�� ������ Connection�� �����´�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public boolean insert(NewsVO vo) { //������ �����ۼ� ��ư ������ �߻�! - �ۼ���, ����, ���� �Է��ϱ�
		boolean result = true;
		Connection conn = connectDB();//ȣ���ؼ� ���Ḹ��
		PreparedStatement pstmt=null; //pre�Ἥ �����ϴ� ������ �ۼ�. �켱 null
		try {
			pstmt = conn.prepareStatement("insert into news values(news_seq.nextval, ? , ?,?,sysdate,0)"); // ?ä������ؼ�
			//news_seq.nextval �Ϸù�ȣ �ڵ� �����Ͽ� �Ҵ� 1���� ���� 1�� ���� = ���⼭�� ��?ĭ ? ����// ?-�ۼ��� ,?-����,?-����,��¥,cnt0���ͽ���
		
			pstmt.setString(1, vo.getWriter()); //vo�� ����� �� �ҷ� ����
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			int deleteNum = pstmt.executeUpdate(); // pstmt ������ִ�, ó���� ���� ����=int ������ ���
			if (deleteNum != 1) 
				result = false;// �Է¼� 3���� , �ٵǸ� ����
		} catch (SQLException e) {
			result=false;
			System.out.println(e.getMessage());
		}finally {
			close(conn,pstmt); //try�� ������ �������͵� �׳� ���� ���� ���� ���ֱ�
		}
		return result;
	}

	public boolean update(NewsVO vo) {// ������ Ÿ��Ʋ Ŭ���� �߻� - - �ۼ���, ����, ���� �����ϱ� 
		//�� �� Ŭ���̾�Ʈ�κ��� ���۵� ���ο� �������� Query ���ڿ��ȿ��� �ݵ�� �����Ϸ��� �������� id �ۼ� = id ����
		boolean result = true;
		Connection conn=connectDB();
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement("UPDATE NEWS SET writer=?, TITLE=?, content=? WHERE ID=?");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			
			int deleteNum = pstmt.executeUpdate(); 
			if (deleteNum != 1) // 
				result = false;

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}finally{
			close(conn,pstmt);
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		Connection conn=connectDB();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from news where id=?");
			//�ݵ�� Ŭ���̾�Ʈ�κ��� �����Ϸ��� ���� id ��  ����. 
			//id ������ ���޵� id ���� ���� delete ������� ���� �ϰ� ����� b oolean Ÿ������
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate(); 
			if (deleteNum != 1) 
				result = false;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			close(conn,pstmt);
		}
		return result;
	}

	public List<NewsVO> listAll() {//NEWSVO�� ����Ʈ�� ��� ����ϱ����� ����Ʈ ��ü�� ���� 
		Connection conn = connectDB();
		ArrayList<NewsVO> list = new ArrayList<>();
		Statement stmt =null;
		ResultSet res=null; //����Ʈ ���尪 ������

		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(
					"select id,writer,title, content, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news");
			NewsVO vo;
			while (res.next()) { //����� ������ �ϳ��� ���� �ֱ�
				vo = new NewsVO();
				vo.setId(res.getInt(1)); /* ���ε��� */
				vo.setWriter(res.getString(2));
				vo.setTitle(res.getString(3));
				vo.setContent(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn, stmt, res);
		}
		return list;
	}

	public NewsVO listOne(int id) { //id �ϳ��� �� �� �� �̱�
		Connection conn = connectDB();
		NewsVO vo = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			 stmt = conn.createStatement();
			 stmt.executeUpdate("update news set cnt=cnt+1 where id="+id);
			 res = stmt.executeQuery(
				"select id,writer,title, content, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where id="
							+ id);
			vo = new NewsVO();
			res.next();
			vo.setId(res.getInt(1)); /* ���ε��� */
			vo.setWriter(res.getString(2));
			vo.setTitle(res.getString(3));
			vo.setContent(res.getString(4));
			vo.setWritedate(res.getString(5));
			vo.setCnt(res.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return vo;
	}

	private void close(Connection conn, Statement stmt, ResultSet res) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//������ 
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<NewsVO> listWriter(String writer){//�ۼ��� �̸� Ŭ���� �߻� =�ۼ���å�� ����Ʈ�� ����. �ۼ��� �ʿ�
		Connection conn=connectDB();
		List<NewsVO> list=new ArrayList<NewsVO>();//��������������
		Statement stmt=null;
		ResultSet res=null;
		try {
			stmt=conn.createStatement();
			res=stmt.executeQuery("select id,writer, content ,title,to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where writer="
							+ writer);
			NewsVO vo;
			while(res.next()) {
				vo= new NewsVO();
				vo.setId(res.getInt(1));
				vo.setWriter(res.getString(2));
				vo.setContent(res.getString(3));
				vo.setTitle(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return list;
		
	}
	
	public List<NewsVO> search(String key, String searchType){
		Connection conn=connectDB();
		NewsVO vo=null;
		Statement stmt=null;
		ResultSet res=null;
		List<NewsVO> list=new ArrayList<NewsVO>();
		try {
			stmt=conn.createStatement();
			res=stmt.executeQuery("select id,writer, content ,title, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where "
			+searchType +" like '%"+key+"%'");
			while(res.next()) {
				vo= new NewsVO();
				vo.setId(res.getInt(1));
				vo.setWriter(res.getString(2));
				vo.setContent(res.getString(3));
				vo.setTitle(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return list;
	}

}
