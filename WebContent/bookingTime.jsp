<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	
	<div class="bookingTime-content">
		
		<div class="bookingTime-title">
			 예매
		</div>
		<div class="bookingTime-wrapper">
			
			<div class="movieList-wrapper">
				<div class="title">
					영화
				</div>
				
				<div class="movieList">
					<c:if test="${!empty movieNameList }">
						<c:forEach var="i" begin="0" end="${movieNameList.listSize -1 }">
							<div class="movieList-item">
								${movieNameList.movieName[i] }
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${!empty back }">
							<a href="./bookingTime" class="back">전체목록</a>
					</c:if>
					
				</div>
			</div>
			
			<div class="movieTime-wrapper">
				<div class="title">
					시간
				</div>
				
				<div class="movieTime">
				
					<c:if test="${!empty timeLine }">
						<c:forEach var="i" begin="0" end="${timeLine.listSize -1 }">
							<div class="movieTime-item">
								<div class="time">
									<div class="start">
										${timeLine.startTime[i] }
									</div>
									<div class="end">
										~${timeLine.endTime[i] }
									</div>
								</div>
								<div class="name">
									${timeLine.movieName[i] }
								</div>
								<div class="info">
									<div class="place">
										${timeLine.place[i] }
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty timeLine }">
						<div class="empty">
							영화를 선택해 주세요.
						</div>
					</c:if>
					

				</div>
			</div>
			
		</div>
	</div>
	
	<script src="./js/bookingTime.js"></script>
	<script src="./js/header.js"></script>
</body>
</html>