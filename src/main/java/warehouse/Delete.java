package warehouse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wharehouse?user=root&password=root");
	
			String queryString =" delete from product where id=?";
			PreparedStatement pst=con.prepareStatement(queryString);
			req.setAttribute("id", id);
		    req.getRequestDispatcher("Delete.jsp").forward(req, resp);
			pst.setInt(1, id);

			int a= pst.executeUpdate();
			con.close();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     //                                                                                                                                                                                                                                        vv
			resp.getWriter().print(a+"Row Deleted");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
