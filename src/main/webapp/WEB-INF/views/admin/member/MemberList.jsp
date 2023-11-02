<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<div id="mCount">
		총 회원수 : &nbsp;${memberTot}
	</div>
	
	<c:choose>
		<c:when test="${memberTot==0}">
			<h2>아직 회원이 없습니다.</h2>
		</c:when>
		
		<c:when test="${memberTot>0}">
			<table>
				<tr>
					<th>회원 아이디</th>
					<th>회원 이름</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>주소</th>
				</tr>
				
				<c:forEach var="member" items="${members}">
					<tr>
						<td><a href="/productDetail?m_id=${member.m_id}">${member.m_id}</a></td>
						<td>${member.m_name}</td>
						<td>${member.m_phone}</td>
						<td>${member.m_email}</td>
						<td>${member.m_address}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>		
	</c:choose>
</body>
</html>