<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>
</head>
<div id="mypage">
		<div class="mypagelist">
			<p class="introduction">마이페이지</p>
		</div>
		<div class="toplist">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
<table>
	<thead>
		<tr>
			<th id="info">회원정보</th>
		</tr>
	</thead>
	<tbody>
		<tr class="col">
			<td class="col1">아이디</td>
			<td class="col2">${mdto.m_id}</td>
		</tr>
		<tr class="col">
			<td class="col1">이름</td>
			<td class="col2">${mdto.m_name}</td>
		</tr>
		<tr class="col">
			<td class="col1">이메일</td>
			<td class="col2">${mdto.m_email}</td>
		</tr>
		<tr class="col">
			<td class="col1">연락처</td>
			<td class="col2">${mdto.m_phone}</td>
		</tr>
		<tr class="col">
			<td class="col1">우편번호</td>
			<td class="col2">${mdto.m_zipcode}</td>
		</tr>
		<tr class="col">
			<td class="col1">주소</td>
			<td class="col2">${mdto.m_address}
				<br>${mdto.m_address2}
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr class="tabBtn"> 
			<td>
				<input  name="update" type="button" onclick="update('u')" value="정보수정"/>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  name="delete" type="button" onclick="update('d')" value="회원탈퇴"/>
			</td>
		</tr>
	</tfoot>
</table>
<form name="upForm" id="upForm" action="" method="post">
  <input type="hidden" id="memID" name="m_id" value="${mdto.m_id}">
  <input type="hidden" id="pw" name="m_passwd" value="${mdto.m_passwd}">
</form>
</div>