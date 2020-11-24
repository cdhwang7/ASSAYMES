package Hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public HelloServlet() {
        System.out.println("===> HelloServlet ��ü ����");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> doGet() �޼��� ȣ��");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("��û ��� : " + request.getMethod()+"<br>");
    	out.println("��û URI : " + request.getRequestURI()+"<br>");
    	out.println("��û protocol : " + request.getProtocol()+"<br>");
    	out.println("��û ID ���� : " + request.getParameter("id"));
	}
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> doPost() �޼��� ȣ��");
	}
}








