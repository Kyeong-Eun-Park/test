<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>
	메인화면!  
</h1>

<%
	
	session = request.getSession();
    if(session.getAttribute("userSession") != null){
    	out.print("<h3>" + session.getAttribute("userSession")+ "님 반갑습니다." + "</h3>" + "<br>");
    	out.print("<a href='/logout'>logout</a>" +"<br>");
    	
    }else{
    	
    	out.print("<a href='/loginPage'>login</a>" +"<br>");
    	out.print("<a href='/joinPage'>join</a>" +"<br>"); 
    	
    }
    
%>


<a href="/products">products</a>
<a href="/adminPage">admin</a>

</body>
</html>
