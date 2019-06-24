package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int nb1 =Integer.parseInt(request.getParameter("nb1"));
		int nb2 =Integer.parseInt(request.getParameter("nb2"));
		String oper=request.getParameter("oper");
		
		//���� ����� HttpServletRequest ��ü�� ������ �� 
		//jspexam/calcResult.jsp �� ��û�� forward 

		int result=0;
		if(oper.equals("multiply"))
			result=nb1*nb2;
		else if(oper.equals("plus"))
			result=nb1+nb2;
		else if(oper.equals("minus"))
			result=nb1-nb2;
		else {//"/'�� ���� ����
			if(nb2==0) {
				//String eMsg="������ ����� �� ��° ���ڴ� 0�� �� �����ϴ�!!";
				request.setAttribute("eMsg", "������ ����� �� ��° ���ڴ� 0�� �� �����ϴ�!!");
				request.getRequestDispatcher("/jspexam/errorResult.jsp").forward(request,response);
				return;
			}else
				result=nb1/nb2;
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("/jspexam/calcResult.jsp").forward(request,response);	
	}
}
