<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/common.css">
<script src="/script/login.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<H1 style="text-align:center;"><a href="/">DessertFairy</a></H1>
<div class="login_box">
	<form action="loginProc" method="post" name="loginForm">
		<ul>
			<li>아이디 : <input type="text" title="아이디" name="m_id"></li>
			<li>비밀번호 : <input type="password" title="비밀번호" name="m_passwd"></li>
		</ul>
        <button type= "submit" class="loginBtn">로그인</button>
	</form>
</div>
</body>
</html>