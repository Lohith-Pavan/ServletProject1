package com.lohith;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String lastPage = "Profile3.jsp?page=1";
		Cookie cookies[] = request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				if(c.getName().equals("lastPage")) {
					lastPage = "Profile3.jsp?page="+c.getValue();
					break;
				}
			}
		}
		pw.print("<a href='"+lastPage+"'>All Transactions</a>");
	}
}
