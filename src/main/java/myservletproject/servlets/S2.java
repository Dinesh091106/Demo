package myservletproject.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/S2")
public class S2 extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		long num =(long)req.getAttribute("num");
		String mail = (String)req.getAttribute("email");
		res.getWriter().println(num+" "+mail);
		
	}
}
