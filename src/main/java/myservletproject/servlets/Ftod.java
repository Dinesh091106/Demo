package myservletproject.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ftod")
public class Ftod extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		String mail = req.getParameter("smail");
		long contact = Long.parseLong(req.getParameter("scon"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			String query = "insert into student values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, mail);
			pst.setLong(4, contact);
			int a = pst.executeUpdate();
			res.getWriter().print(a + "Inserted Sucessfull");
			System.out.println(a + "row inserted");

		} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
