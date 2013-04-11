<%
String sISBN = ""; //will be pulled from parameter
//do an object lookup to run a SQL statement and pull all of the book's info
String sName = "";
String sImage = "";
String sDescription = "";
String sPrice = "";
String sBNPrice = "";
String sSalePrice = "";
String sBNSale = "";
%>

<%@include file="/WEB-INF/menubar.jspf" %>
	<h1><%=sName %></h1>
	<div id="left">
		<img src="<%=sImage%>" width="400px" height="491px">
		<form action="Checkout" method="post">	
			<input type="submit" value="Buy this!">
		</form>
		<form action="Checkout" method="post">	
			<input type="submit" value="Sell this!">
		</form>
	</div>
	<div id="right">
		<table>
			<tr>
				<td></td><td><h1>B&N's Price</h1></td><td><h1>Our Price</h1></td>
			</tr>	
			<tr>
				<td><h1>Buy Back:</h1></td><td><%=sBNPrice %></td><td><%=sPrice %></td>
			</tr>
			<tr>
				<td><h1>Sell:</h1></td><td><%=sBNSale %></td><td><%=sSalePrice %></td>
			</tr>
		</table>
	</div>
</body>
</html>