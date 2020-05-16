<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles.css" />
<link rel="stylesheet" href="./reset.css">
<link rel="stylesheet" href="./mypageStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="./header.jsp"%>

	<div class="my-page-content">

		<div class="reservation-title">예매 내역</div>
		<div class="reservation-content">
			<div class="reservation-item">
				<img src="./img/poster1.jpg" class="reservation-poster" />

				<input type="button" value="예매취소">
				<div class="reservation-ticket">
					<div class="bgImg">
						<div class="movieTitle">레이니 데이 인 뉴욕</div>
						<div class="roomAndSit">
							<div class="room">5관</div>
							<div class="sit">D관 3열</div>
						</div>

						<div class="dateMovieTime">
							<div class="buyDate">2020-05-13</div>
							<div class="startTime">오후 1:30</div>
							<div class="endTime">오후 3:30</div>
						</div>

						<div class="adultAge">성인 1명</div>
						<div class="price">10000원</div>
					</div>
				</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">이미지</div>
				<input type="button" value="예매취소">
				<div class="reservation-ticket">
					<div class="bgImg">
						<div class="movieTitle">레이니 데이 인 뉴욕</div>
						<div class="roomAndSit">
							<div class="room">5관</div>
							<div class="sit">D관 3열</div>
						</div>

						<div class="dateMovieTime">
							<div class="buyDate">2020-05-13</div>
							<div class="startTime">오후 1:30</div>
							<div class="endTime">오후 3:30</div>
						</div>

						<div class="adultAge">성인 1명</div>
						<div class="price">10000원</div>
					</div>
				</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">이미지</div>
				<input type="button" value="예매취소">
				<div class="reservation-ticket">티켓</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">이미지</div>
				<input type="button" value="예매취소">
				<div class="reservation-ticket">티켓</div>
			</div>

		</div>
	</div>

	<script src="./js/mypage.js"></script>
	<script src="./js/header.js"></script>
</body>
</html>