package myservletproject.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class Addproduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String brand= (req.getParameter("brand"));
		double pprice = Double.parseDouble(req.getParameter( "pprice"));
		double discount = Double.parseDouble(req.getParameter("discount"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wharehouse","root","root");
//			String query = "insert into producct values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, brand);
			pst.setDouble(3, pprice);
			pst.setDouble(4, discount);
			int a = pst.executeUpdate();
			System.out.println(a);
			resp.getWriter().print(a+"Row inserted");
			
			
		}
	
		catch (Exception e) {
		
		}
		
	
	}

}
