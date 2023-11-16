<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/MemberSearch.css">
<script src="/script/MemberSearch.js"></script>

<div id="search">
	<div id="Box">
		<form action="memberPwSearchProc" method="post" name="pwSearchForm">
			<p class="Tap">비밀번호 찾기</p>
			<div id="pwTextBox">
				<input type="text" class="m_id in searchChk" name="m_id" title="아이디" size="30" placeholder="아이디를 입력하세요.">
				<font id="idcheck" size="2" color="red" class="possible"></font>
				<br>
				<input type="text" size="30" class="in" name="quest" readonly="readonly" placeholder="비밀번호 힌트">
				<br>
				<input type="text" size="30" class="in searchChk" title="비밀번호 힌트 답" name="m_answer"  placeholder="비밀번호 힌트 답">
			</div>
			<div id="pwSearch">
				<input type="button" class="searchBtn" value="비밀번호 찾기">
			</div>
			<div id="a_div">
				<a href="/login" class="ahover">로그인/</a>
		      	<a href="/memberIdSearch" class="ahover">아이디 찾기</a>
		    </div>
		</form>       
	</div>
</div>
