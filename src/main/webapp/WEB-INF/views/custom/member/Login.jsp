<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="/css/Common.css">
<link rel="stylesheet" href="/css/Member.css">
<script src="/script/login.js"></script>
</head>
<body>
<h1><a href="/">DessertFairy</a></h1>
<div id="login_box">
	<form action="loginProc" method="post" name="loginForm" class="login">
		<div id="login_input">
		<ul>
			<li>아이디 : <input type="text" title="아이디" name="m_id" class="lInput"></li>
			<li>비밀번호 : <input type="password" title="비밀번호" name="m_passwd" class="lInput"></li>
		</ul>
		</div>
        <button type= "submit" class="loginBtn">로그인</button>
	</form>
	<div id="login_search">
		<a href="/memberIdSearch">아이디 찾기/</a>  
		<a href="/memberPwSearch">비밀번호 찾기</a>  
	</div>
</div>

</body>
</html>