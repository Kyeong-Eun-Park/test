<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
	<title>Product list</title>
</head>
<body>

<h1>product list</h1>


<%
	session = request.getSession();

    if(session.getAttribute("userSession") != null){
    	out.print("userSession name : " + session.getAttribute("userSession") + "<br>");
    }
    
    
    if(session.getAttribute("prodId") != null){
    	out.print("방금본 상품 <br>");
    	out.print("아이디 : " + session.getAttribute("prodId") + "<br>");
    	out.print("상품명 : " + session.getAttribute("prodName") + "<br>");
    }
%>


<br>
<a href="/product?name=ipone12&id=i1">ipone12</a>
<a href="/product?name=macbookpro&id=i2">macbookpro</a>


</body>
</html>
