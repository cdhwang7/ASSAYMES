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
        System.out.println("===> HelloServlet 객체 생성");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> doGet() 메서드 호출");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("요청 방식 : " + request.getMethod()+"<br>");
    	out.println("요청 URI : " + request.getRequestURI()+"<br>");
    	out.println("요청 protocol : " + request.getProtocol()+"<br>");
    	out.println("요청 ID 정보 : " + request.getParameter("id"));
	}
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> doPost() 메서드 호출");
	}
}








