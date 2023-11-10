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
	<div id="mDetail_box">
		<h2>${member.m_name} 님</h2>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>패스워드</th>
					<th>이메일</th>
					<th>연락처</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>상세주소</th>
					<th>가입일</th>
					<th>권한</th>
				</tr>
			</thead>
		
			<tbody>
					<tr>
						<td>${member.m_id}</td>
						<td>${member.m_passwd}</td>
						<td>${member.m_email}</td>
						<td>${member.m_phone}</td>
						<td>${member.m_zipcode}</td>
						<td>${member.m_address}</td>
						<td>${member.m_address2}</td>
						<td>${member.m_regdate}</td>
						<td>${member.m_role}</td>
					</tr>
			</tbody>
		
			<tfoot>
				<tr>
					<td><a href="/mOrder">주문내역</a></td>&nbsp;&nbsp;
					<td><a href="/mReviewMgt?m_id=${member.m_id}">회원리뷰</a></td>&nbsp;&nbsp;
					<td><a href="/memberMgt">회원목록</a></td>
				</tr>
			</tfoot>
		</table>	
	</div>
</body>
</html>