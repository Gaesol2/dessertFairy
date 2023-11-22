<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<script src="/script/Contact.js"></script>

<div id="contact">
	<div>
		<div id="contactList">
			<p class="introduction">문의 글쓰기</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
	<form action="contactWriteProc" name="conForm" id="myform" method="post">
		<div id="conWrite">
			<p class="spanName">제목</p>
			<span>
				<input type="text" name="t_subject" title="제목" class="chkc in" size="30">
			</span>
			<p class="spanWrite">작성자</p>
			<span>
				<input type="text" name="m_id" class="chkc in" title="작성자" size="30" value="${m_id}" disabled="disabled">
			</span>
		</div>
	      
		<div class="form-inline">
			<div class="secretBox">
				<input type="radio" name="t_secret" id="cs_open" value="Y" class="radio" />
				<span class="ml_10">공개</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="t_secret" id="cs_open" value="N" class="radio" />
				<span class="ml_10">비공개</span>&nbsp;
			</div>
		</div>
	      
		<div id="conContent">
			<p class="spanContent">내용</p>
			<span>
				<textarea name="t_content" class="chkc" title="내용" rows="20" cols="50"></textarea>
			</span>
		</div>
		<div id="conPasswd">
			<p class="spanPasswd">비밀번호</p>
			<span>
				<input type="password" name="t_passwd" title="비밀번호" class="chkc in" size="20"
		        maxlength="6">
		    </span>
			<span class="explanation">*비밀번호는 숫자만 입력 가능하며 4~6글자 입력하시오.</span>
		</div>
		<div id="conBtn">
			<input type="submit" class="conSubmit regis" value="등록">
		</div>
	</form>
</div>