
<%@include file="/WEB-INF/menubar.jspf" %>
	<h1>Admin Page</h1>
	<form action="ServiceBroker" method="post">	
		<input type="hidden" id="Service" value="04">
		<input type="submit" value="Sales Report Export">
	</form>
	<form action="ServiceBroker" method="post">	
		<input type="hidden" id="Service" value="05">
		<input type="submit" value="Update B&N Prices">
	</form>
</body>
</html>