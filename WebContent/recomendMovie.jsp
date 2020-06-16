
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles/styles.css" />
</head>
<body>
	<%@ include file="./header.jsp" %>

	<div class="review-vidio-modal">
		<div class="vidio-close">X</div>
		<iframe class="_videoPlayer" id="videoPlayer" name="videoPlayer" width="1000px" height="600" frameborder="0" scrolling="no" allowfullscreen="“true”"></iframe>
	</div>	
	
	<div class="boxoffice-wrapper">


        <div class="black-bar">
            <div class="black-bar-down">
                <span>
                    <img class="homeimg" src="img/home.png" class="logo">
                </span>
                <a href="#">&nbsp;&nbsp;>&nbsp; 영화</a>
                <a href="movie.html">&nbsp;&nbsp;>&nbsp; 추천영화</a>
            </div>
        </div>

        <div class="textBar">
            <p>추천영화</p>
        </div>
    </div>

    <div class="movListButton">
        <ul class="topMenu">
            <li class="on"><a href="./viewBoxOffice">박스오피스</a></li>
            <li><a href="./scheduleMovie.jsp">상영예정작</a></li>
            <li><a href="./recomendMovie.jsp">추천영화</a></li>
            <li><a href="./randomMovie.jsp">랜덤영화</a></li>

        </ul>
    </div>
    
    <div class="searchBar">
        <div class="onair-condition">
            <p class="flo">5개의 영화가 추천되었습니다.</p>
        </div>

        <div class="movie-search">
            <input type="text" title="영화명을 입력하세요" class=".movieSearchBar" placeholder="영화명 검색" class="input-text">
            <input type="button" value="검색"/>
        </div>

    </div>
    
	<div class="review-wrapper">
		
		<div class="boxOffice-content">
			
			<div class="vidioForm">
				<div class="review-vidio">
					<div class="click-vidio"></div>
						<iframe src="https://www.youtube.com/embed/9z4ZR68bcAQ?autoplay=1" width="230" height="180" class="youtube-vidio"></iframe>
					</div>
				<div class="vidio-title">어벤져스</div>
				
				<input type="hidden" name = "videoPlayerSrc" value="https://www.youtube.com/embed/9z4ZR68bcAQ?autoplay=1">
			</div>
			
			<div class="vidioForm">
				<div class="review-vidio">
					<div class="click-vidio"></div>
						<iframe src="https://www.youtube.com/embed/8Kza3-NpO9Q?autoplay=1" width="230" height="180" class="youtube-vidio"></iframe>
					</div>
				<div class="vidio-title">데드풀 1</div>
				
				<input type="hidden" name = "videoPlayerSrc" value="https://www.youtube.com/embed/8Kza3-NpO9Q?autoplay=1">
			</div>
			
			<div class="vidioForm">
				<div class="review-vidio">
					<div class="click-vidio"></div>
						<iframe src="https://www.youtube.com/embed/6Wj4rhAalc8?autoplay=1" width="230" height="180" class="youtube-vidio"></iframe>
					</div>
				<div class="vidio-title">데드풀 2</div>
				
				<input type="hidden" name = "videoPlayerSrc" value="https://www.youtube.com/embed/6Wj4rhAalc8?autoplay=1">
			</div>
			
			<div class="vidioForm">
				<div class="review-vidio">
					<div class="click-vidio"></div>
						<iframe src="https://www.youtube.com/embed/NSomUDpzBQ4?autoplay=1" width="230" height="180" class="youtube-vidio"></iframe>
					</div>
				<div class="vidio-title">테이큰 1</div>
				
				<input type="hidden" name = "videoPlayerSrc" value="https://www.youtube.com/embed/NSomUDpzBQ4?autoplay=1">
			</div>
			
			<div class="vidioForm">
				<div class="review-vidio">
					<div class="click-vidio"></div>
						<iframe src="https://www.youtube.com/embed/tjYURzdDugU?autoplay=1" width="230" height="180" class="youtube-vidio"></iframe>
					</div>
				<div class="vidio-title">테이큰 2</div>
				
				<input type="hidden" name = "videoPlayerSrc" value="https://www.youtube.com/embed/tjYURzdDugU?autoplay=1">
			</div>			
			
			

		</div>
	</div>
	
</body>
<script src="./js/header.js"></script>
<script src="./js/totalReview.js"></script>
<script src= "./js/boxOffice.js"></script>
</html>