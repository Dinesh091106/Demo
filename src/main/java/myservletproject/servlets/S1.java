package myservletproject.servlets;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/S1")
public class S1 extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		long contact = Long.parseLong(req.getParameter("contact"));
		req.setAttribute("num",contact);
		String mail = req.getParameter("email");
		req.setAttribute("email", mail);
		RequestDispatcher rd = req.getRequestDispatcher("S2");
		rd.forward(req, res);
		
	}
	
}
