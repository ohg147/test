package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;


@WebServlet("/meeting")
public class meetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String keyword=request.getParameter("keyword");
			String id=request.getParameter("id");
			String action = request.getParameter("action");
			
			MeetingJDBCDAO dao=new MeetingJDBCDAO(); //�������̽��� MeetingDAO�� ��üȭ�ȵ�
			
			if(keyword == null) {
				if(action == "delete") {
					boolean result = dao.delete(Integer.parseInt(id));
					if (result) {
						request.setAttribute("msg", "���� ���������� �����Ǿ����ϴ�.");
					} else {
						request.setAttribute("msg", "���� �������� �ʾҽ��ϴ�.");
					}
				} /*else if (action == "update") {
					boolean result = dao.selectOne(Integer.parseInt(id));
					if (result) {
						request.setAttribute("msg", "���� ���������� �����Ǿ����ϴ�.");
					} else {
						request.setAttribute("msg", "���� �������� �ʾҽ��ϴ�.");
					}
				}*/
				request.setAttribute("list", dao.listAll());
			}else {
				ArrayList<MeetingVO> list=dao.search(keyword);
				if(list.size() == 0) {
					request.setAttribute("msg", keyword+"�˻� �Ұ�");
				}else {
					request.setAttribute("list", dao.search(keyword));
				}
			}
			request.getRequestDispatcher("jspexam/meetingView.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String meetingDate =request.getParameter("meetingdate");
		
		MeetingJDBCDAO dao=new MeetingJDBCDAO();
		MeetingVO vo=new MeetingVO();
		
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		
		boolean result=dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name+"���� ���� ���������� �ԷµǾ����!!!");
		}else {
			request.setAttribute("msg", name+"���� �� �Է¿� �����ϰ� �Ǿ����!!!");
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("jspexam/meetingView.jsp").forward(request,response);
		
	}

}