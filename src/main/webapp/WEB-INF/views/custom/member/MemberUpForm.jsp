<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>
<script src="/script/MemberJoin.js"></script>

<form action="memUpProc" name="topForm1" method="post" >
	<div id="mypage">
		<div>
			<div id="mypagelist">
				<p class="introduction">마이페이지</p>
			</div>
			<div class="topList">
				<ul class="list">
					<li class="reList"><a href="/myPage">내 정보</a></li>
					<li><a href="/cartList">장바구니</a></li>
					<li><a href="/orderList">주문목록</a></li>
					<li><a href="/contactList">문의하기</a></li>
				</ul>
			</div>
		</div>
		<div id="myUpForm">
			<h3 class="info">회원정보 수정</h3>
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
						<input type="text" class="chk1 in" name="m_name" value="${mdto.m_name}"size="30">
					</span>
				</div>
				<div class="mpl">
					<p class="mpl1">비밀번호</p>
					<span class="mpl2">
						<input type="password" class="in" name="m_passwd" value="${mdto.m_passwd}" size="30" readonly="readonly">
						<input class="update_pw" type="button" value="비밀번호 변경">
					</span>
				</div>
				<div class="mpl">
					<p class="mpl1">이메일</p>
					<span class="mpl2">
						<input type="text" class="chk1 in" name="m_email" value="${mdto.m_email}"size="30">
					</span>
				</div>
				<div class="mpl">
					<p class="mpl1">연락처</p>
					<span class="mpl2">
						<input type="text" class="chk1 in" name="m_phone1" value="010"size="5">
						<input type="text" class="chk1 in" name="m_phone" value="${mdto.m_phone}" size="10">
					</span>
				</div>
				<div class="mpl">
					<p class="mpl1">우편번호</p>
					<span class="mpl2">
						<input type="text" class="chk1 in" name="m_zipcode" value="${mdto.m_zipcode}"size="30" title="우편번호" readonly="readonly" id="sample6_postcode">
						<button type="button" onclick="zipCheck()">우편번호 찾기</button>
					</span>
				</div>
				<div class="mpl">
					<p class="mpl1">주소</p>
					<span class="mpl2">
						<input type="text" class="chk1 in" name="m_address" value="${mdto.m_address}"size="40" title="주소" readonly="readonly" id="sample6_address">
						<input type="text" class="chk1 in" name="m_address2" value="${mdto.m_address2}"size="15" id="sample6_detailAddress">
						<input type="hidden" id="sample6_extraAddress">
					</span>
				</div>
			</div>
		</div>   
		<div id="upBtn"> 
		      <input class="submit1"  name="update" type="button" value="회원정보수정"/>
		</div>
	</div>
</form>