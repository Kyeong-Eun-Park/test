<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
	<title>Product detail</title>
</head>
<body>

<h1>product detail</h1>

<%
	session = request.getSession();
    if(session.getAttribute("userSession") != null){
    	out.print("session name : " + session.getAttribute("userSession") + "<br>");
    }
%>


<br>

<h4>  상품 id  : ${prodId} </h4>
<h4>  이름 :  ${prodName} </h4>
</body>
</html>
