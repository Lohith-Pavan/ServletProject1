package com.lohith;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
     public static List<TransactionDto> getTransactions(int page,int total){
    	 if(page == 1) {
 			page = 0;
 		}else {
 			page = (page - 1) * total;
 		}
    	 List<TransactionDto> txn = new ArrayList<>();
    	 Connection con = Dbcon.getCon();
    	 String query = "select * from transactions limit ? offset ?";
    	 try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, total);
			ps.setInt(2, page);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int txnId = rs.getInt(1);
			    Date txnDate = rs.getDate(2);
			    int sourceId = rs.getInt(3);
			    int destinationId = rs.getInt(4);
			    String sourceType = rs.getString(5);
			    String destinationType = rs.getString(6);
			    double txnAmount = rs.getDouble(7);
			    TransactionDto transactionDto = new TransactionDto(txnId,txnDate,sourceId,destinationId,sourceType,destinationType,txnAmount);
			    txn.add(transactionDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return txn;
     }
     public static int getTransactionsCount() {
    	 int count = 0;
    	 Connection con = Dbcon.getCon();
    	 String query = "select count(*) from transactions";
    	 try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return count;
     }
}
