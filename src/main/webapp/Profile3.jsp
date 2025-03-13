<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.lohith.TransactionDto" %>
<%@ page import="com.lohith.TransactionDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
        // Function to toggle all checkboxes based on the "Select All" checkbox
        function toggleSelectAll(selectAllCheckbox) {
            // Get all individual checkboxes
            const checkboxes = document.querySelectorAll('.individual-checkbox');

            // Loop through all checkboxes and set their checked status based on the "Select All" checkbox
            checkboxes.forEach(function(checkbox) {
                checkbox.checked = selectAllCheckbox.checked;
            });
            // Save the "Select All" checkbox state in sessionStorage
            sessionStorage.setItem('selectAllState', selectAllCheckbox.checked);
        }
        // Load the "Select All" state from sessionStorage
        window.onload = function() {
            const selectAllState = sessionStorage.getItem('selectAllState') === 'true';
            const selectAllCheckbox = document.getElementById('selectAll');
            selectAllCheckbox.checked = selectAllState;

            // Also toggle all checkboxes based on the state of "Select All"
            const checkboxes = document.querySelectorAll('.individual-checkbox');
            checkboxes.forEach(function(checkbox) {
                checkbox.checked = selectAllState;
            });
        }
    </script>
</head>
<body>
	<h1>Transactions Table</h1>
	<table border=1>
		<tr>
			<th>Txn_Id</th>
			<th>Txn_Date</th>
			<th>Source_Id</th>
			<th>Destination_Id</th>
			<th>Source_Type</th>
			<th>Destination_Type</th>
			<th>Txn_Amount</th>
			<th><label for="selectAll">Select All</label><input type="checkbox" id="selectAll" onclick="toggleSelectAll(this)">
            </th>
		</tr>
		<% String tpage = request.getParameter("page"); %>
		<% int currentPage = Integer.parseInt(tpage); %>
		<% int total = 4; %>
		<% List<TransactionDto> txn = TransactionDao.getTransactions(currentPage, total); %>
		<% for(TransactionDto txns : txn) { %>
		<tr>
			<th><%=txns.getTxnId()%></th>
			<th><%=txns.getTxnDate()%></th>
			<th><%=txns.getSourceId()%></th>
			<th><%=txns.getDestinationId()%></th>
			<th><%=txns.getSourceType()%></th>
			<th><%=txns.getDestinationType()%></th>
			<th><%=txns.getTxnAmount()%></th>
			<th><input type="checkbox" class="individual-checkbox" name="select" value="select"></th>
		</tr>
		<%} %>
	</table>
	<% int lastPage = (int)Math.ceil(TransactionDao.getTransactionsCount()*1.0/total); %>
	<% int prevPage = currentPage; %>
	<% int nextPage = currentPage; %>
	<a href='Profile3.jsp?page=<%=prevPage==1?prevPage=lastPage:prevPage-1 %>'><</a>
	<% for(int i=1;i<=lastPage;i++) { %>
	<a href='Profile3.jsp?page=<%=i %>'><%=i%></a>
	<%} %>
	<a href='Profile3.jsp?page=<%=nextPage==lastPage?nextPage=1:nextPage+1 %>'>></a>
	<a href='transaction.html'><button>go to previous page</button></a>
	
</body>
</html>