<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문제작 케이크 요구사항 입력</title>
<script src="/jquery/jquery-3.7.0.min.js"></script>
<script src="/script/calendar.js" ></script>
<link rel="stylesheet" type="text/css" href="/css/Cakeorder.css">
</head>
<body>
<div id="cakeRequest">
	<table>
	  <tr><td>케이크 요구사항 입력:</td></tr>
	  <tr>
	    <td><textarea></textarea></td>
	  </tr>
	  <tr>
	    <td colspan="2">
	    <input type="button" value="확인" 
	           onclick="setCakeText(this)">
	    <input type="button" value="닫기" 
	           onclick="window.close()">
	    </td>
	  </tr>
	</table>
</div>
</body>
</html>