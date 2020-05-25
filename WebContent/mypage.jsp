<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles/styles.css" />
<link rel="stylesheet" href="./styles/reset.css">
<link rel="stylesheet" href="./styles/mypageStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="./header.jsp"%>

	<div class="my-page-content">

		<div class="reservation-title">예매 내역</div>
		<div class="reservation-content">
			<c:if test="${!empty reservation }">
				<c:forEach var="i" begin="0" end="${reservation.listSize -1 }">
					<div class="reservation-item">
						<img src="${reservation.poster[i] }" class="reservation-poster" />
		
						<input type="button" value="예매취소">
						<div class="reservation-ticket">
							<div class="bgImg">
								<div class="movieTitle">${reservation.movieName[i] }</div>
								<div class="roomAndSit">
									<div class="room">${reservation.place[i] }</div>
									<div class="sit">${reservation.sit[i] }</div>
								</div>
		
								<div class="dateMovieTime">
									<div class="buyDate">${reservation.buyDate[i] }</div>
									<div class="startTime">${reservation.startTime[i] }</div>
									<div class="endTime"> ~ ${reservation.endTime[i] }</div>
								</div>
		
								<div class="adultAge">성인 ${reservation.adult[i] }명 청소년 ${reservation.teenAge[i] }명</div>
								<div class="price">${reservation.price[i] }원</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
			

		</div>
	</div>

	<script src="./js/mypage.js"></script>
	<script src="./js/header.js"></script>
</body>
</html>