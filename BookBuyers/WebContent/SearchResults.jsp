<%@page import="java.sql.ResultSet"%>
<%
StringBuffer sbBody = new StringBuffer();

ResultSet lRes;// will be set by a search method
sbBody.append("<table>");

//while(lRes.next()){
	sbBody.append("<tr>");
		sbBody.append("<td>");
			//image of book will be stored here
		sbBody.append("</td>");
		sbBody.append("<td>");
			//book name will be stored here - each link will lead to the compareTo JSP
		sbBody.append("</td>");
	sbBody.append("</tr>");
//}
sbBody.append("</table>");
sbBody.append("</div>");

//output search results here... may not need a servlet
%>
<%@include file="/WEB-INF/menubar.jspf" %>
	<h1>Search Results</h1>
	<%=sbBody.toString() %>
</body>
</html>