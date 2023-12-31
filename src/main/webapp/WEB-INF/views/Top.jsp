<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="/css/Top.css">
<link rel="stylesheet" type="text/css" href="/css/PopUp.css">
<link rel="stylesheet" type="text/css" href="/css/Common.css">
<link rel="stylesheet" type="text/css" href="/css/Bottom.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@200&display=swap">

<script src="/jquery/jquery-3.7.0.min.js"></script>
<script src="/script/common.js"></script>
<script src="/script/zipCheck.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<div id="header">
	<div id="searchBox">
		<div id="searchlogo">
			<a href="/" class="mainLogo">dessertFairy</a>
		</div>
		<div>
			<button class="upBtn"><img src="../image/x.png"></button>
		</div>	
		<form action="/search" method="get" name="keyword">
			<div id="searchCon">
				<input type="text" name="keyword" placeholder="Search" class="searchInput" size="40">
				<button class="inputBtn" onclick="dp_menu"><img src="../image/search.png"></button>
				<p class="keyword">
					관련 키워드 : 
					<a href="/dessert?flag=브레드"> 빵,</a>
					<a href="/dessert?flag=쿠키"> 쿠키,</a>
					<a href="/dessert?flag=푸딩"> 푸딩,</a>
					<a href="/search?keyword=초코"> 초코</a>
				</p>
			</div>
		</form>
	</div>
	<div id="logo">
		<a href="/" class="mainLogo">dessertFairy</a>
	</div>   <!-- top logo -->
	<div id="mainmenu">
		<c:choose>
			<c:when test="${ssKey!=null and ssKey.m_role=='admin'}">
				<ul>
					<li><a href="/shopMgt" class="mainLogo">상점 관리</a></li>
					<li><a href="/productMgt" class="mainLogo">상품 관리</a></li>
					<li><a href="/orderMgt" class="mainLogo">주문 관리</a></li>
					<li><a href="/memberMgt" class="mainLogo">고객 관리</a></li>
				</ul>
			</c:when>
		
			<c:when test="${ssKey==null or ssKey.m_role=='mem'}">
				<ul>
					<li><a href="/cake" class="mainLogo">주문제작 케이크</a></li>
					<li><a href="/dessert" class="mainLogo">디저트</a></li>
					<li><a href="/reviewList" class="mainLogo">포토후기</a></li>
					<li><a href="/myPage" class="mainLogo">마이페이지</a></li>
				</ul>
			</c:when>
		</c:choose>
	</div>   <!-- mainmenu end -->
	<div id="topmenu">
		<c:choose>
			<c:when test="${ssKey!=null}">
				<ul>
					<li class="name">${ssKey.m_name}</li>
					<li class="nim">님</li>
					<li><a href="/logoutProc">로그아웃</a></li>
				</ul>
			</c:when>
			
			<c:when test="${ssKey==null}">
				<ul>
					<li><a href="/login">로그인</a></li>
					<li><a href="/register">회원가입</a></li>
				</ul>
			</c:when>
		</c:choose>
		<button class="topSearchBtn"><img src="../image/search.png"></button>
	</div>   <!-- topmenu end -->
	<div id="blank">
	</div>   <!-- blank end -->
</div>   <!-- header end -->