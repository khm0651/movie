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
                        <div class="item">
                            영화 
                        </div>
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
								out.println("<div class='item sign-in'>로그인</div>");
							}
						%>
                    <div class = "item sign-up">
                    	<%
							if(session.getAttribute("LOGIN_ID") != null){
								out.println("<a href='./mypage' class='username'>"+session.getAttribute("LOGIN_ID")+"</a>");
								out.println("<div class='welcome-label'>님 환영합니다.</div>");
							}else{
								out.println("<a href='./sign-up.jsp'>회원가입</a>");
							}
						%>
                       	 
                    </div>

                </div>
                <div class="header-right-down">
                    
                    <div class="item-wrapper">
                        <div class="item">
                           	극장 
                        </div>
                        <div class="item">
                            게시판
                        </div>
                        <div class="item">
                            랜덤예매
                        </div>
                    </div>
                    
                    <div class="cal-login">
                        <img src="./img/ico-schedule-white.png" class="cal">

                        <img src="./img/ico-mymega-white.png" class="login">

                    </div>

                </div>
            </div>
        </div>
		
</body>
</html>