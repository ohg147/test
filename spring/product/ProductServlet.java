package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//�Ķ���� ��������
		String pid=request.getParameter("pid");
		
		//���ǰ�ü �����Ǵ� ��ȯ=()/(true) ������ �غ� ������ �ڵ����� ����=getSession
		HttpSession session=request.getSession();

		ProductVO product=(ProductVO)session.getAttribute("product");
		//�����Ǿ� ���� �ʴٸ� ProductVO ��ü�� ������ �����ϰ� ���õ� ��ǰ ������ 1 �� 
		//������Ų �Ŀ� ���� ��ü�� �����Ѵ�.
		if(product==null) {
			product =new ProductVO();
		}//�̹� �����Ǿ� �ִ� ��쿡�� �� ��ü�� �����Ͽ� ���õ� ��ǰ ������ 1�� ���� ��Ų��.
		if(pid.equals("p001"))
			product.setAppleNb(1);
		else if(pid.equals("p002"))
			product.setBananaNb(1);
		else if(pid.equals("p003"))
			product.setHalabonNb(1);
		//��û�� jspexam/productView.jsp �Ѱܼ� ��� �����ϰ� �Ѵ�
		session.setAttribute("product",product); //(key,value)
		request.getRequestDispatcher("jspexam/productView.jsp").forward(request, response);
	
	}

}
