package myservletproject.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Applogout  extends GenericServlet {

		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			res.getWriter().print("Logout Sucess");
			

		}
	}

