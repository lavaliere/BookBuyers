
<%@include file="/WEB-INF/menubar.jspf" %>
<script type="text/javascript">
	var loginStatus = window.location.search.substring(location.search.indexOf("?")+1);
	//alert("Login Status is " + loginStatus);
	if(loginStatus == "failed"){
		alert("Login failed!");
	}
	
</script>
	<h1>Welcome to BookBuyers.com!</h1>
	<a href="#" id="StartSell" onclick="moveCursor('sellTip');">Start Selling</h1></a>	<a href="#" id="StartBuy" onclick="moveCursor('buyTip')">Start Buying</h1></a>
	</div>	
</body>
</html>