<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <!-- 테스트 -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>


    <div class = "body-wrapper">

        <%@include file = "./header.jsp" %>
        
        
        <div class="main-slider">
            <div class="slider">
                <img src="./img/poster1.jpg" class="main-slider-img">
                <img src="./img/poster2.jpg" class="main-slider-img">
                <img src="./img/poster3.jpg" class="main-slider-img">
                <img src="./img/poster1.jpg" class="main-slider-img">
            </div>
        </div>

        <div class="content">
            
            <img src="./img/lala.jpg" class = "bg-img">

            <div class="card-wrapper">
				<c:if test="${!empty bol }">
					<c:forEach var="i" begin="0" end="${bol.listSize -1 }">
						<div class="card">
                
                    <img src="${bol.movieImg[i] }" class="img">
                    
    
                    <div class="card-info-wrapper">
                        <div class="like">
                            ♥
                        </div>
    
                        <a href="./booking?movieName=${bol.movieName[i] }&&movieImg=${bol.movieImg[i]}" class="reservation">
                                                       예매
                        </a>
                    </div>
    
                </div>
					</c:forEach>
				</c:if>
                
    
                

            </div>

            <div class="content-menu-wrapper">

                <div class="movie-search">
                    <div class="ms-wrapper">
                        <input type="text" class="movie-search-input" placeholder="영화명을 입력해주세요">
                        <img src="./img/ico-search-white.png" alt="">
                    </div>
                    
                </div>

                <div class="movie-cal">
                    <img src="./img/ico-schedule-white.png" alt="">
                    <div class="title">상영시간표</div>
                </div>

                <div class="box-office">
                    <img src="./img/ico-sitemap-white.png" alt="">
                    <div class="title">박스오피스</div>
                </div>

                <div class="rappid">
                    <img src="./img/ico-mymega-white.png" alt="">
                    <div class="title">빠른예매</div>
                </div>

            </div>
            
        
        </div>

    </div>

    <script src="js/index.js"></script>
    <script src="./js/header.js"></script>
</body>
</html>