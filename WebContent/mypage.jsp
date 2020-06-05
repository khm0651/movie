
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styles/styles.css" />
<link rel="stylesheet" href="./styles/reset.css">
<link rel="stylesheet" href="./styles/mypageStyle.css">
<link rel="stylesheet" type="text/css"
	href="./styles/interMovieStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="./header.jsp"%>
	<div id="myPageContainer">
		<div class="tabs">
			<input type="radio" name="tabs" id="tabone" checked="checked">
			<label for="tabone">예매 내역</label>
			<div class="tab">
				<div class="my-page-content">

					<div class="reservation-title">예매 내역</div>
					<div class="reservation-content">
						<c:if test="${!empty reservation }">
							<c:forEach var="i" begin="0" end="${reservation.listSize -1 }">
								<div class="reservation-item">
									<img src="${reservation.poster[i] }" class="reservation-poster" />
									<input type="button" value="예매취소">
									<div class="reservation-ticket">
										<div class="bgImg">
											<div class="movieTitle">${reservation.movieName[i] }</div>
											<div class="roomAndSit">
												<div class="room">${reservation.place[i] }</div>
												<div class="sit">${reservation.sit[i] }</div>
											</div>

											<div class="dateMovieTime">
												<div class="buyDate">${reservation.buyDate[i] }</div>
												<div class="startTime">${reservation.startTime[i] }</div>
												<div class="endTime">~ ${reservation.endTime[i] }</div>
											</div>

											<div class="adultAge">성인 ${reservation.adult[i] }명 청소년
												${reservation.teenAge[i] }명</div>
											<div class="price">${reservation.price[i] }원</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>

			<input type="radio" name="tabs" id="tabtwo"> 
			<c:if test="${!empty interMovieId }">
				<label for="tabtwo">관심 영화 목록 (${interMovieSize })</label>
			</c:if>
			<div class="tab">
				<div class="interMovieList-container">
					<div class="lst_wrap">
						<form action="delChkBoxAction" method="post">
							<input type="submit" class="delChkBoxBtn" value="삭제" />
							<ul class="lst_detail_t1">

								<c:if test="${!empty interMovieId }">
									<c:forEach var="i" begin="0" end="${interMovieSize - 1 }">
										<li>
											<div class="thumb">
												<a href="https://movie.naver.com${movieDetailHref[i] }">
													<img src="${thumbImgSrc[i] }" />
												</a>
											</div>
											<dl class="lst_dsc">
												<dt class="tit">
													<span class="${movieAge[i] }"></span> <a
														href="https://movie.naver.com${movieDetailHref[i] }">
														<font size="2">${movieTitle[i] }</font>
													</a>
												</dt>

												<dd class="star">
													<dl class="info_star">
														<dd>
															<div class="star_t1">
																<span> ${movieScore[i] } <span class="num">${movieScoreNum1[i] }</span>
																	${movieScoreNum2[i] }
																</span>
															</div>
														</dd>
													</dl>
												</dd>
												<dd>
													<dl class="info_txt1">
														<dt class="tit_t1">개요</dt>
														<dd>${movieOutline[i] }</dd>
														<dt class="tit_t2">감독</dt>
														<dd>${movieDirector[i] }</dd>
														<dt class="tit_t2">배우</dt>
														<dd>${movieActor[i] }</dd>
													</dl>
												</dd>

											</dl>
											
											<div class="delChkBox">
												<input type="checkbox" name="delChkBox"
													value="${interMovieId[i] }" />
											</div>
										</li>
									</c:forEach>
								</c:if>
							</ul>
						</form>
					</div>

				</div>
			</div>

		</div>
	</div>
	<script src="./js/mypage.js"></script>
	<script src="./js/header.js"></script>
</body>
</html>