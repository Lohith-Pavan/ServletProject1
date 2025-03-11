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
import java.sql.SQLException;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Connection con = Dbcon.getCon();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int phonenumber = Integer.parseInt(request.getParameter("tel"));
		String query = "insert into user_details values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, phonenumber);
			int i = ps.executeUpdate();
			if(i>0) {
//				pw.print("done");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
			else{
//				pw.print("not done");
				response.setContentType("test/html");
				RequestDispatcher rd = request.getRequestDispatcher("registration.html");
				rd.include(request, response);
				pw.print("<h1>Registration Unsucessful</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
