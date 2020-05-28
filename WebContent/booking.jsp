
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./styles/styles.css">
</head>
<body>
    <div class="booking-wrapper">
        
        <%@ include file="./header.jsp" %>

        <div class="booking-content">
            <div class="booking-title">
                예매
            </div>
            <div class="booking-main">
                <div class="booking-left">
                    <div class="booking-main-nav">
                        <div class="booking-nav-label">
                            관람인원선택 (최대 8매 선택 가능)
                        </div>
                        <div class="booking-refresh">
                            초기화
                        </div>
                    </div>
    
                    <div class="booking-count">
                        <div class="adult">
                            <div class="label">
                                성인
                            </div>
                            <div class="btn-wrapper">
                                <div class="m-btn">
                                    -
                                </div>
                                <div class="c-btn">
                                    0
                                </div>
                                <div class="p-btn">
                                    +
                                </div>
                            </div>
                        </div>
    
                        <div class="teenage">
                            <div class="label">
                                청소년
                            </div>
                            <div class="btn-wrapper">
                                <div class="m-btn">
                                    -
                                </div>
                                <div class="c-btn">
                                    0
                                </div>
                                <div class="p-btn">
                                    +
                                </div>
                            </div>
                        </div>
    
                    </div>
    
                    <div class="booking-select">
                        <div class="screen">
                            SCREEN
                        </div>
                        
    
                    </div>
                </div>
                
                <div class="booking-right">
                    <div class="booking-info-title">
                     	${movieName }
                    </div>
                    <div class="booking-info-more">
                        <div class="info-detail">
                            <div class="movie-place">
                                ${place }
                            </div>
                            <div class="movie-day">
                                ${date }
                            </div>
                            <div class="movie-time">
                                ${startTime }${endTime }
                            </div>
                        </div>
                        <div class="info-poster">
                           	 <img src="${movieImg }">
                        </div>
                    </div>

                    <div class="booking-select-info">
                        <div class="select-info">
                            <div class="select-info-wrapper">
                                <div class="boooking-select">
                                    <span></span>선택
                                </div>
                                <div class="boooking-complet">
                                    <span>X</span>예매완료
                                </div>
                            </div>
                            
                        </div>

                        <div class="select-sit-wrapper">
                            <div class="title">
                                선택좌석
                            </div>
                            <div class="select-sit">
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>
                                <div class="selected-sit">
                                    -
                                </div>

                            </div>
                        </div>

                        
                    </div>

                    <div class="booking-result-wrapper">
                        <div class="booking-result-count">
                            <div class="title">
                                성인
                            </div>
                            <div class="count">

                            </div>
                            <div class="title">
                                청소년
                            </div>
                            <div class="count">

                            </div>
                        </div>
                        <div class="booking-result">
                            <div class="title">
                                최종결제금액
                            </div>
                            <div class="result">
                                <span class="result-price">0</span> 원
                            </div>
                        </div>
                        
                        <div class="finish">
                        	구매하기
                        </div>

                    </div>
                </div>

            </div>

        </div>


    </div>
    
    <script src="./js/booking.js"></script>
    <script src="./js/header.js"></script>
</body>
</html>