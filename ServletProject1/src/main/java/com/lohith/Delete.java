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

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Connection con = Dbcon.getCon();
		
		String query = "delete from user_details where user_name = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			if(i>0) {
				RequestDispatcher rd = request.getRequestDispatcher("DisplayAll");
				rd.forward(request, response);
			}
			else {
				pw.print("<h2>Deletion is not done</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
