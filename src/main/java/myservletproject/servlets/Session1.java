package myservletproject.servlets;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/Session1")
public class Session1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email"); 
		String password = req.getParameter("password"); 
		if(email.equals("charlie@gmail.com")&&password.equals("abc")) {
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			resp.sendRedirect("sessiontwo");
			
		}
		else 
			resp.getWriter().print("Invalid User.....");
	}

	

}
