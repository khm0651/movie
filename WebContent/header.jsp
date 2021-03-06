<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<!DOCTYPE html>
<html lang="en">

<body>

	<div class="header">

            <div class="header-left">
                
                <div class="header-left-down">
                    <div class="more-search">
                        <img src="./img/ico-sitemap-white.png" class="more">
                        <img src="img/ico-search-white.png" class="search">

                    </div>
                    <div class="item-wrapper">
                        <a  href="./viewBoxOffice" class="item">
                            영화 
                        </a>
                        <a href="./bookingTime" class="item">
                            예매
                        </a>

                    </div>
                    

                </div>
            </div>

            <div class="header-center">
                <a href="./"><img src="./img/logo.png" class="logo"></a>

            </div>

            <div class="header-right">
                <div class="header-right-up">
                    	<%
							if(session.getAttribute("LOGIN_ID") != null){
								out.println("<div class='item'><a href='./logout'>로그아웃</a></div>");
							}else{
								out.println("<a class='item sign-in'>로그인</a>");
							}
						%>
                    <div class = "item sign-up">
                    	<%
							if(session.getAttribute("LOGIN_ID") != null){
								out.println("<a href='./mypage' class='username'>"+session.getAttribute("LOGIN_ID")+"</a>");
								out.println("<div class='welcome-label'>님 환영합니다.</div>");
							}else{
								out.println("<a href='./join.jsp'>회원가입</a>");
							}
						%>
                       	 
                    </div>

                </div>
                <div class="header-right-down">
                    
                    <div class="item-wrapper">
                        <a href = "./totalReview" class="item review">
                           	리뷰 
                        </a>
                        <a class="item random">
                            랜덤예매
                        </a>
                    </div>
                    
                    <div class="cal-login">
                        <a href="./bookingTime"><img src="./img/ico-schedule-white.png" class="cal"></a>

                        <a href="./mypage"><img src="./img/ico-mymega-white.png" class="login"></a>

                    </div>

                </div>
            </div>
        </div>
		
</body>
</html>