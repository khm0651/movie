<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<!DOCTYPE html>
<html lang="en">

<body>

	<div class="header">

            <div class="header-left">
                <div class="header-left-up">
                    <div class="item">
                        VIP LOUNGE
                    </div>
                    <div class = "item">
                        멤버십
                    </div>
                    <div class="item">
                        고객센터
                    </div>
                </div>
                <div class="header-left-down">
                    <div class="more-search">
                        <img src="./img/ico-sitemap-white.png" class="more">
                        <img src="img/ico-search-white.png" class="search">

                    </div>
                    <div class="item-wrapper">
                        <div class="item">
                            영화 
                        </div>
                        <div class="item">
                            예매
                        </div>
                        <div class="item">
                            극장
                        </div>
                    </div>
                    

                </div>
            </div>

            <div class="header-center">
                <img src="./img/logo.png" class="logo">

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
								out.println("<a href='./my-page.jsp' class='username'>"+session.getAttribute("LOGIN_ID")+"</a>");
								out.println("<div class='welcome-label'>님 환영합니다.</div>");
							}else{
								out.println("<a href='./sign-up.jsp'>회원가입</a>");
							}
						%>
                       	 
                    </div>
                    <div class="item">
                        빠른예매
                    </div>
                </div>
                <div class="header-right-down">
                    
                    <div class="item-wrapper">
                        <div class="item">
                            이벤트 
                        </div>
                        <div class="item">
                            스토어
                        </div>
                        <div class="item">
                            혜택
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