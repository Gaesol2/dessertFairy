<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<link rel="stylesheet" type="text/css" href="/css/Member.css">
<script src="/jquery/jquery-3.7.0.min.js"></script>
<script src="/script/mypage.js" ></script>
<script src="/script/member.js" ></script>
</head>
<body class="pwPopUp">
<table>
  <tr>
    <td>비밀번호 입력:</td>
    <td><input type="password" id="pwck" class="pwin"></td>
  </tr>
  <tr>
    <td colspan="2" class="pwCheckBtnBox">
	    <input type="button" value="확인" class="pwCheckBtn"
	           onclick="setParentText(this);">
	    <input type="button" value="닫기" class="pwCheckBtn" 
	           onclick="window.close()">
    </td>
  </tr>
</table>
</body>
</html>