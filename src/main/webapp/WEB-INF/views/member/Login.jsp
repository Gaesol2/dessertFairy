<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<H1 style="text-align:center;"><a href="/">DessertFairy</a></H1>
<div id="login_box">
	<form action="loginProc" method="post" name="loginForm">
		<ul>
			<li>아이디 : <input type="text" title="아이디"></li>
			<li>비밀번호 : <input type="password" title="비밀번호"></li>
		</ul>
		<div id="submitTop">
		<button type="submit">로그인</button>
		</div>
		<button type="reset">다시쓰기</button>
	</form>
</div>
</body>
</html>