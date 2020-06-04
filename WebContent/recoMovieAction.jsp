<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:set var="chkAction" value="${chkAction }"/>

<script>
	if(${chkAction}) {
	alert("나의 관심영화 목록을 확인하세요!");
	window.close();
	}
</script>
<script>
	alert("관심가는 영화를 선택해주세요");
	window.history.back();
</script>
</body>
</html>