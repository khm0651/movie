
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles/styles.css" />
</head>
<body>
	<%@ include file="./header.jsp"%>



	<div class="review-wrapper">

		<div class="review-vidio-modal">
			<div class="vidio-close">X</div>
			<iframe class="_videoPlayer" src="" id="videoPlayer" name="videoPlayer" width="1000px" height="600" frameborder="0" scrolling="no" allowfullscreen="“true”"></iframe>
		</div>

		<div class="title">동영상</div>
		<c:if test="${!empty videoThumb }">
			<div class="sub-title" data-set-size="${size }"></div>
			<div class="review-content">
				<c:forEach var="i" begin="0" end="${size -1 }">
					<div class="vidioForm">
						<div class="review-vidio">
							<img alt="" src="${videoThumb[i] }" width="230" height="180">
						</div>
						<div class="vidio-title">${videoTitle[i] }</div>
						<div class="vidio-date">${videoDate[i] }</div>
					</div>

					<input type="hidden" name = "videoPlayerSrc" value="https://movie.naver.com${videoPlayerSrc[i] }">
				</c:forEach>
			</div>
		</c:if>
	</div>
	<script src="./js/review.js"></script>
	<script src="./js/header.js"></script>
</body>


</html>