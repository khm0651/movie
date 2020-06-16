
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles/arang.css">
	<link rel="stylesheet" href="styles/styles.css">
	<title>회원 가입</title>
	<style>

	</style>
</head>

<body>
	<div class="body-wrapper">
		
	<%@ include file="./header.jsp" %>
	<div id="containerOut">
		<div id="container">
			<h1>회원 가입</h1>
			<p>Fast Movie에 오신 것을 환영합니다.</p>
			<hr>

			<form action="signUP" method="post" accept-charset="UTF-8">
				<h4>로그인 정보</h4>
				<ul class="join_ul">
					<li class="join_li"><label for="id">아이디</label> <input type="text" id="id" name="id"></li>
					<li class="join_li"><label for="pw">패스워드</label> <input type="password" id="pw" name="pw"></li>
				</ul>
				<h4>개인 정보</h4>
				<ul class="join_ul">
					<li class="join_li"><label for="name">이름</label> <input type="text" id="name" name="name"
							placeholder="공백없이 입력하세요"></li>
					<li class="join_li"><label for="number">연락처</label> <input type="text" id="number" name="tel1"
							size="3"> - <input type="text" id="number" name="tel2" size="4"> - <input type="text"
							id="number" name="tel3" size="4"></li>
					<li class="join_li"><label for="addr">주소</label> <input type="text" id="addr" name="addr"></li>
				</ul>

				<div class="button"> 
					<input type="submit" value="회원가입"> <input type="reset" value="다시 쓰기">
				</div>
			</form>
		</div>
	</div>
</body>
<script src="./js/header.js"></script>
</html>