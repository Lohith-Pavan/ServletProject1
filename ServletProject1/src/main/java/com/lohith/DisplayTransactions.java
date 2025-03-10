package com.lohith;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tpage = request.getParameter("page");
		int page = Integer.parseInt(tpage);
		int total = 10;
		if(page == 1) {
			page = 1;
		}else {
			page = (page - 1) * total + 1;
		}
		
	}

}
