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

		<div class="reservation-title">���� ����</div>
		<div class="reservation-content">
			<div class="reservation-item">
				<img src="./img/poster1.jpg" class="reservation-poster" />

				<input type="button" value="�������">
				<div class="reservation-ticket">
					<div class="bgImg">
						<div class="movieTitle">���̴� ���� �� ����</div>
						<div class="roomAndSit">
							<div class="room">5��</div>
							<div class="sit">D�� 3��</div>
						</div>

						<div class="dateMovieTime">
							<div class="buyDate">2020-05-13</div>
							<div class="startTime">���� 1:30</div>
							<div class="endTime">���� 3:30</div>
						</div>

						<div class="adultAge">���� 1��</div>
						<div class="price">10000��</div>
					</div>
				</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">�̹���</div>
				<input type="button" value="�������">
				<div class="reservation-ticket">
					<div class="bgImg">
						<div class="movieTitle">���̴� ���� �� ����</div>
						<div class="roomAndSit">
							<div class="room">5��</div>
							<div class="sit">D�� 3��</div>
						</div>

						<div class="dateMovieTime">
							<div class="buyDate">2020-05-13</div>
							<div class="startTime">���� 1:30</div>
							<div class="endTime">���� 3:30</div>
						</div>

						<div class="adultAge">���� 1��</div>
						<div class="price">10000��</div>
					</div>
				</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">�̹���</div>
				<input type="button" value="�������">
				<div class="reservation-ticket">Ƽ��</div>
			</div>

			<div class="reservation-item">
				<div class="reservation-poster">�̹���</div>
				<input type="button" value="�������">
				<div class="reservation-ticket">Ƽ��</div>
			</div>

		</div>
	</div>

	<script src="./js/mypage.js"></script>
	<script src="./js/header.js"></script>
</body>
</html>