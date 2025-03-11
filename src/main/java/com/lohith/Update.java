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

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Connection con = Dbcon.getCon();
		String uname = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
		
		String query = "update user_details set password = ?,email = ?,phone_number = ? where user_name = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setInt(3, phonenumber);
			ps.setString(4, uname);
			int i = ps.executeUpdate();
			if(i>0) {
				RequestDispatcher rd = request.getRequestDispatcher("/DisplayAll");
				rd.forward(request, response);
			}
			else {
				pw.print("<h2>Unable to update</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
