package com.lohith;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String password = request.getParameter("upassword");
		String email= request.getParameter("uemail");
		int phonenumber = Integer.parseInt(request.getParameter("uphonenumber"));	
		Connection con = Dbcon.getCon();
		String query = "select * from user_details where user_name = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				pw.print("<form action='Update'>");
				pw.print("<input type = 'text' name = 'name' value= "+rs.getString(1)+">");
				pw.print("<input type = 'text' name = 'password' value = "+rs.getString(2)+">");
				pw.print("<input type = 'text' name = 'email' value = "+rs.getString(3)+">");
				pw.print("<input type = 'text' name = 'phonenumber' value = "+rs.getInt(4)+">");
				pw.print("<input type = 'submit' value = 'submit'>");
				pw.print("</form>");			
			}
			else {
				pw.print("<h2>Editing not done</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
