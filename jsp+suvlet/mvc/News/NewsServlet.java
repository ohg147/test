package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tmpId = request.getParameter("id");
		String action = request.getParameter("action");
		NewsDAO dao = new NewsDAO();
		if(action!=null&&tmpId!=null) {
			int id = Integer.parseInt(tmpId);
			if(action.equals("read")) {
				NewsVO vo = dao.listOne(id);
				request.setAttribute("vo", vo);
			}else if(action.equals("delete")) {
				if (dao.delete(id))
					request.setAttribute("msg", "������ ���������� �����Ǿ����ϴ�.");
				else
					request.setAttribute("msg", "������ �����ϴµ�  �����߽��ϴ�.");
			}			
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("jspexam/newsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		NewsDAO dao = new NewsDAO();
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if (result) {
				request.setAttribute("msg", "������ ���������� �ԷµǾ����ϴ�.");
			} else {
				request.setAttribute("msg", "���� �Է¿� �����߽��ϴ�.");
			}
		}else if(action.equals("update")){
			vo.setId(Integer.parseInt(id));
			boolean result = dao.update(vo);
			if(result) {
				request.setAttribute("msg", "������ ���������� �����Ǿ����ϴ�.");
			} else {
				request.setAttribute("msg", "���� ������ �����߽��ϴ�.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("jspexam/newsView.jsp").forward(request, response);
	}

}
