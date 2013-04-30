<%@ page import="Objects.Book" %>
<%
//parse parameters here to pass to the searchBook function
Book searched = new Book();
StringBuffer sbBody = searched.searchBook(request.getParameter("search"));
%>
<%@include file="/WEB-INF/menubar.jspf" %>
	<h1>Search Results</h1>
	<%=sbBody.toString() %>
</body>
</html>