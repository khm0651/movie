
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
	
	<div class="boxoffice-wrapper">


        <div class="black-bar">
            <div class="black-bar-down">
                <span>
                    <img class="homeimg" src="img/home.png" class="logo">
                </span>
                <a href="#">&nbsp;&nbsp;>&nbsp; 영화</a>
                <a href="movie.html">&nbsp;&nbsp;>&nbsp; 전체영화</a>
            </div>
        </div>

        <div class="textBar">
            <p>전체영화</p>
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
            <button type="button" title="전체 영화 보기" class="btn-onair btnOnAir on">개봉작만</button>
            <p class="flo">10개의 영화가 검색되었습니다.</p>
        </div>

        <div class="movie-search">
            <input type="text" title="영화명을 입력하세요" class=".movieSearchBar" placeholder="영화명 검색" class="input-text">
            <input type="button" value="검색"/>
        </div>

    </div>
    
	<div class="review-wrapper">
		
		<div class="boxOffice-content">
			
			<c:if test="${!empty bol }">
				<c:forEach var="i" begin="0" end="${bol.listSize -1 }">
					<div class="card">
                
                    	<img src="${bol.movieImg[i] }" class="img">
                    
    
	                    <div class="card-info-wrapper">
	                        <div class="like">
	                            ♥
	                        </div>
	    
	                        <div class="reservation">
	                                                       예매
	                        </div>
	                        
	                        <input type="hidden" name = "movieName" value="${bol.movieName[i] }" />
	                    </div>
    					
    					
                	</div>
				</c:forEach>
			</c:if>
                			
			
			
		</div>
	</div>
	
</body>
<script src= "./js/boxOffice.js"></script>
</html>