<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles/styles.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="./header.jsp" %>
	
	<div class="bookingTime-content">
		
		<div class="review-vidio-modal">
			<div class="vidio-close">X</div>
			<iframe class="_videoPlayer" id="videoPlayer" name="videoPlayer" width="1000px" height="600" frameborder="0" scrolling="no" allowfullscreen="“true”"></iframe>
		</div>
				
		<div class="bookingTime-title">
			 리뷰
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
							<a href="./totalReview" class="back">전체목록</a>
					</c:if>
					
				</div>
			</div>
			
			<div class="movieTime-wrapper">
				<div class="title">
					동영상
				</div>
				
				<div class="movieTime">
				
					<c:if test="${!empty naverVideoThumb }">
						<div class="sub-title" data-set-size="${naverSize }"></div>
						<div class="review-content">
							<c:forEach var="i" begin="0" end="${naverSize -1 }">
								<div class="vidioForm">
									<div class="review-vidio">
										<img alt="" src="${naverVideoThumb[i] }" width="230" height="180">
									</div>
									<div class="vidio-title">${naverVideoTitle[i] }</div>
									<div class="vidio-date">${naverVideoDate[i] }</div>
								</div>
			
								<input type="hidden" name = "videoPlayerSrc" value="https://movie.naver.com${naverVideoPlayerSrc[i] }">
							</c:forEach>
						</div>
						<div class="sub-title">유튜브 리뷰</div>
						<div class="review-content">
							
							<div class="vidioForm">
								<div class="review-vidio">
									<div class="click-vidio"></div>
									<iframe src="${youtubeVidio }" width="230" height="180" class="youtube-vidio"></iframe>
								</div>
								<div class="vidio-title">${youtubeTitle }</div>
							</div>
			
							<input type="hidden" name = "videoPlayerSrc" value="${youtubeVidio }">
							
						</div>
					</c:if>
					
					<c:if test="${empty naverVideoThumb }">
						<div class="empty">
							영화를 선택해 주세요.
						</div>
					</c:if>
					

				</div>
			</div>
			
		</div>
	</div>
	<script src="./js/header.js"></script>
	<script src="./js/totalReview.js"></script>
	
</body>
</html>