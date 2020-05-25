<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${!empty vidio }">
		<c:forEach var="i" begin="0" end="${size -1 }">
			<iframe width="500" height="300" src="${vidio[i] }"></iframe>
		</c:forEach>
	</c:if>
	
		
</body>
</html>