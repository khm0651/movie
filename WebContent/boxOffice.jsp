
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
	<div class="review-wrapper">
		
		<div class="title">
			BOX Office
		</div>
		<div class="sub-title boxOffice">
			TOP 10
		</div>
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