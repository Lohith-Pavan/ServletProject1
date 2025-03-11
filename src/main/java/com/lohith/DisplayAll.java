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

public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Connection con = Dbcon.getCon();
		String query = "select * from user_details";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			pw.print("<table border=2>");
			pw.print("<tr>");
			pw.print("<th>user_name</th>");
			pw.print("<th>password</th>");
			pw.print("<th>email</th>");
			pw.print("<th>phonenumber</th>");
			pw.print("<th>edit</th>");
			pw.print("<th>delete</th>");
			pw.print("</tr>");
			
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>"+rs.getInt(4)+"</td>");
				pw.print("<td><a href='Edit?uname="+rs.getString(1)+"&upassword="+rs.getString(2)+"&uemail="+rs.getString(3)+"&uphonenumber="+rs.getString(4)+"'>edit</a></td>");
				pw.print("<td><a href='Delete?uname="+rs.getString(1)+"'>delete</a></td>");
				pw.print("</tr>");
			}
			
			pw.print("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
