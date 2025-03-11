package com.lohith;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String tpage = request.getParameter("page");
		int page = Integer.parseInt(tpage);
		int total = 4;
		List<TransactionDto> txn = TransactionDao.getTransactions(page, total);
		pw.print("<table border = 1>");
		pw.print("<tr>");
		pw.print("<th>Txn_Id</th>");
		pw.print("<th>Txn_Date</th>");
		pw.print("<th>source_Id</th>");
		pw.print("<th>Destination_Id</th>");
		pw.print("<th>Source_Type</th>");
		pw.print("<th>Destination_Type</th>");
		pw.print("<th>Txn_Amount</th>");
		pw.print("</tr>");
		for(TransactionDto txns : txn) {
			pw.print("<tr>");
			pw.print("<td>"+txns.getTxnId()+"</td>");
			pw.print("<td>"+txns.getTxnDate()+"</td>");
			pw.print("<td>"+txns.getSourceId()+"</td>");
			pw.print("<td>"+txns.getDestinationId()+"</td>");
			pw.print("<td>"+txns.getSourceType()+"</td>");
			pw.print("<td>"+txns.getDestinationType()+"</td>");
			pw.print("<td>"+txns.getTxnAmount()+"</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		int lastPage = (int)Math.ceil(TransactionDao.getTransactionsCount()*1.0/total);
		int prevPage = page;
		int nextPage = page;
		pw.print("<a href='DisplayTransactions?page="+(prevPage==1?prevPage=lastPage:prevPage-1)+"'><<</a>");
		for(int i=1;i<=lastPage;i++) {
			pw.print("<a href='DisplayTransactions?page="+i+"'>"+i+"</a>");
		}
		pw.print("<a href='DisplayTransactions?page="+(nextPage==lastPage?nextPage=1:nextPage+1)+"'>>></a>");

		pw.close();
	}

}
