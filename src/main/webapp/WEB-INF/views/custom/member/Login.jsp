<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/Common.css">
<link rel="stylesheet" href="/css/Member.css">
<script src="/script/login.js"></script>

<div id="Login">
	<form action="loginProc" method="post" name="loginForm" class="login">
		<div id="loginBox">
			<p class="Tap">로그인</p>
			<div id="loginTextBox">
				<span>
					<input type="text" name="m_id" class="chkt in" title="아이디" placeholder="아이디를 입력하세요." size="38">
				</span>
				<br>
				<span>
					<input type="password" name="m_passwd" class="chkt in" title="비밀번호" placeholder="비밀번호를 입력하세요." size="38">
				</span>
			</div>
			<div id="LoginButton">
		    	<button type= "submit" class="loginBtn">로그인</button>
		    </div>
			<div id="a_div">
				<a href="/memberIdSearch" class="ahover">아이디/</a>
				<a href="/memberPwSearch" class="ahover">비밀번호 찾기</a>
			</div>
		</div>
	</form>
</div>	           		