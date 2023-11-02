<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 페이지</title>
</head>
<body>
	<div id="mDetail">
		<h2>${member.m_name}</h2>
		<table>
			<tr>
				<th>회원 아이디</th>
				<td>${member.m_id}</td>
			</tr>
			
			<tr>
				<th>회원 이름</th>
				<td>${member.m_name}</td>
			</tr>
		
			<tr>
				<th>회원 이메일</th>
				<td>${member.m_email}</td>
			</tr>
		
			<tr>
				<th>회원 연락처</th>
				<td>${member.m_phone}</td>
			</tr>
		
			<tr>
				<th>회원 가입일</th>
				<td>${regdate}</td>
			</tr>
		
			<tr>
				<th>회원 우편번호</th>
				<td>${member.m_zipcode}</td>
			</tr>
		
			<tr>
				<th>회원 주소</th>
				<td>${member.m_address}</td>
			</tr>
		
			<tr>
				<th>회원 상세주소</th>
				<td>${member.m_address2}</td>
			</tr>
			<tfoot>
				<input type="button" value="회원목록" onclick="locatcion.href="memberMgt">
			</tfoot>
		</table>	
	
	</div>
</body>
</html>