package myservletproject.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/verify")
public class Verify extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("u_email");
		String password = req.getParameter("u_pass");
		res.getWriter().print(name + "    "+password+"  :data fetch from html");
		
		
		
	}

}
