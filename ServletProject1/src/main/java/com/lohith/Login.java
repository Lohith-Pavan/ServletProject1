package com.lohith;

import jakarta.servlet.RequestDispatcher;
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

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con  = Dbcon.getCon();
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String query = "select * from user_details where user_name = ? and password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				request.setAttribute("username", rs.getString(1));
				request.setAttribute("email", rs.getString(2));
				request.setAttribute("tel", rs.getString(3));
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
				pw.print("<h2>Login Unsuccessful</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
