package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.MeetingVO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * ������ ��ü ����Ʈ ���  ��û�� �������ڿ� ����
		 * ���� ���� �� : �ش� ���� id �� �ش� ���� ���� ��� 
		 * ���� ��ư Ŭ���� : ���� ����
		 */	
		//action="���������α׷��ּ�"= form�±� �Ȱ� �ޱ�/ ������ ��� ���̵� �ޱ�
		String tmpId = request.getParameter("id"); //Parameter= String���� ���� Attribute �� ��ü
		String action = request.getParameter("action");
		NewsDAO dao=new NewsDAO();//����� NewsDAO ��ü ����
		String key=request.getParameter("key");
		String searchType=request.getParameter("searchType");
		List<NewsVO> list = null;
		if(action!=null ) {
			//��û�� ���ڿ� ������ if�� �ȸ����� 
			//���ڿ��� ���� id int�� 
			if(action.equals("read")&&tmpId!=null) {
				//������ �� : �ش� ���� id �� �ش� ���� ���� ���
				//��û�� ���ڿ� action=read & newsid xxx
				NewsVO vo=dao.listOne(Integer.parseInt(tmpId)); //dao��Ű���� �ִ� listOne Ŭ�� �̿� id �޾� �ϳ��� ��±�� �� vo�� ����
				request.setAttribute("vo", vo); //���� vo��ü�� servlet�� ���� = action���� ������ jsp�� �ѱ������ Attribute
				list = dao.listAll();
			}else if(action.equals("delete")&&tmpId!=null) {
				if(dao.delete(Integer.parseInt(tmpId))) {  //delete��� �Լ��� dao������ // id�� ����� ������ -jsp=ȭ�鿡 �޼������
					request.setAttribute("msg","������");
				}else {
					request.setAttribute("msg", "�����ȵ�");
				}	
				list = dao.listAll();
			}else if(action.equals("search")) {
				list=dao.search(key,searchType);
			}else if (action.equals("listwriter")) {
				list=dao.search(key,"writer");
			}
			//action�̳� id �� �޴°� �ʿ���� �⺻������ ����Ʈ �����̴� �ٷ� servlet�� ����= jsp�� �ѱ������
		}else {
			list = dao.listAll();
		}
		request.setAttribute("list", list);
		//���ϸ� jsp�� foward ��û�� 
		// getRequestDispatcher=A���������� B�������� �̵��� ��, A���������� ������ request���� B�������� ������ �� �ִ�
		request.getRequestDispatcher("jspexam/Newsview.jsp").forward(request, response);
		
	}
	
	/* form�±׿� post= ����� �Է��Ѱ� �������̴°� 
	 *  ���� �ۼ� =write
	 *  ���� ����=update
	 *  
	 *  �ۼ���/����/���� �ʿ�
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); //�ѱ۷� ���� servlet�� �޾� ���� 

		String action = request.getParameter("action");
		String id = request.getParameter("id");//vo�� id��ü�� id���� =jsp���� getID�� ������
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsVO vo = new NewsVO(); //vo �� get �Ѱ� �־��ֱ����� ��ü ����
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);

		NewsDAO dao = new NewsDAO(); //dao�� �Լ� ������� ��ü ����

		if (action.equals("insert")) { //���� �ۼ�
			boolean result = dao.insert(vo); //insert�� vo�� ������ �� �ְ� , boolean�̴� ��������� ����

			if (result) { //boolean���� ���ϵ� ���� ����
				request.setAttribute("msg", "������ ���������� �ԷµǾ����!!!"); //jsp�� msg ���̱����� servlet�� ����
			} else {
				request.setAttribute("msg", "�����Է¿� �����ϰ� �Ǿ����!!!");
			}

		} else if (action.equals("update")&&id!=null) { //���� ����
			vo.setId(Integer.parseInt(id));
			boolean result = dao.update(vo);

			if (result) {
				request.setAttribute("msg", "������ ���������� �����Ǿ����!!!");
			} else {
				request.setAttribute("msg", "���� ������ �����ϰ� �Ǿ����!!!");
			}
		}
		request.setAttribute("list", dao.listAll()); //post������ �׻� ����Ʈ ���̱� ����
		request.getRequestDispatcher("jspexam/Newsview.jsp").forward(request, response);
	}
}
