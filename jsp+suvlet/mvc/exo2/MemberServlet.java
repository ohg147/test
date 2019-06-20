package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		if(name=="")
			name="����";
		if(number=="")
			number="����";
		if(id=="")
			id="����";
		if(pw=="")
			pw="����";
		
		MemberVO vo=new MemberVO();//MemberVO��� VO ��ü�� �����ϰ� 
		vo.setName(name);
		vo.setNumber(number);
		vo.setId(id);
		vo.setPw(pw);
		
		request.setAttribute("objreq", vo);//�� ��ü�� HttpServletRequest ��ü�� �����Ѵ�.
		request.getRequestDispatcher("jspexam/memberView.jsp").//�ѱ��.
        forward(request, response);
	
	}

}
