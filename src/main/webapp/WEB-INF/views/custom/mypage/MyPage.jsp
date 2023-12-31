<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>

<div id="mypage">
	<div>
		<div id="mypageList">
			<p class="introduction">마이페이지</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li class="reList"><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li><a href="/orderList?m_name=${mdto.m_name}">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
	<div id="myInfo">
		<h3 class="info">회원정보</h3>
		<div id="infoMain">
			<div class="mpl">
				<p class="mpl1">아이디</p>
				<span class="mpl2">
	                  <input type="text" class="in" name="m_id" readonly="readonly" value="${mdto.m_id}"size="30">
	            </span>
			</div>
			<div class="mpl">
				<p class="mpl1">이름</p>
				<span class="mpl2">
					<input type="text" class="in" name="m_name" readonly="readonly" value="${mdto.m_name}"size="30">
				</span>
			</div>
			<div class="mpl">
				<p class="mpl1">이메일</p>
				<span class="mpl2">
					<input type="text" class="in" name="m_email" readonly="readonly" value="${mdto.m_email}"size="30">
				</span>
			</div>
			<div class="mpl">
				<p class="mpl1">연락처</p>
				<span class="mpl2">
					<input type="text" class="in" name="m_phone1" readonly="readonly" value="010"size="5">
					<input type="text" class="in" name="m_phone" readonly="readonly" value="${mdto.m_phone}"size="10">
				</span>
			</div>
			<div class="mpl">
				<p class="mpl1">우편번호</p>
				<span class="mpl2">
					<input type="text" class="in" name="m_zipcode" readonly="readonly" value="${mdto.m_zipcode}"size="30">
				</span>
			</div>
			<div class="mpl">
				<p class="mpl1">주소</p>
				<span class="mpl2">
					<input type="text" class="in" name="m_address" readonly="readonly" value="${mdto.m_address}"size="40">
					<input type="text" class="in" name="m_address2" readonly="readonly" value="${mdto.m_address2}"size="15">
				</span>
			</div>
		</div>
	</div>	
	<div id="tabBtn"> 
		<input class="button"  name="update" type="button" onclick="update('u')" value="정보수정">
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="button"  name="delete" type="button" onclick="update('d')" value="회원탈퇴">
	</div>
	<form name="upForm" id="upForm" action="" method="post">
		<input type="hidden" id="memID" name="m_id" value="${mdto.m_id}">
		<input type="hidden" id="pw" name="m_passwd" value="${mdto.m_passwd}">
	</form>
</div>