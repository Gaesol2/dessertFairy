<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/MemberSearch.css">
<script src="/script/MemberSearch.js"></script>

<div id="search">
	<form action="memberSearchProc" method="post" name="pwSearchForm">
		<div id="Box">
		<p class="Tap">비밀번호 찾기</p>
			<div id="pwTextBox">
					<input type="text" class="idChk idin" name="m_id" title="아이디" size="30" placeholder="아이디를 입력하세요.">
					<br>
					<input type="password" id="password" class="chk in" size="30" name="m_passwd" title="비밀번호" placeholder="비밀번호를 입력하세요.">
					<br>
					<font id="pcombiCheck" size="2" color="green" class="pwFont"></font>
					<br>
					<input type="password" id="cpassword" class="chk in" size="30" name="m_rePasswd" title="비밀번호 확인" placeholder="비밀번호 확인">
					<br>
					<font id="pcheck" size="2" color="green" class="pwFont"></font>
			</div>
			<div id="pwSearch">
				<label for="button" class="searchBtn">비밀번호 변경</label>
				<input id="button" type="hidden">
			</div>
			<div id="a_div">
	       	   <a href="/memberIdSearch" class="ahover">아이디 찾기</a>
	        </div>
		</div>
	</form>       
</div>
