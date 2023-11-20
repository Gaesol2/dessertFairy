<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/Member.css">

<div id="member">
	<h2 class="memName">${member.m_name} 님</h2>
	<table class="memberDetail">
		<thead>
			<tr>
				<th class="mod1">아이디</th>
				<th class="mod2">이메일</th>
				<th class="mod3">연락처</th>
				<th class="mod4">우편번호</th>
				<th class="mod5">주소</th>
				<th class="mod6">상세주소</th>
				<th class="mod7">가입일</th>
				<th class="mod8">권한</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="mod1">${member.m_id}</td>
				<td class="mod2">${member.m_email}</td>
				<td class="mod3">${member.m_phone}</td>
				<td class="mod4">${member.m_zipcode}</td>
				<td class="mod5">${member.m_address}</td>
				<td class="mod6">${member.m_address2}</td>
				<td class="mod7">${member.m_regdate}</td>
				<td class="mod8">${member.m_role}</td>
			</tr>
		</tbody>
	</table>
	<div id="memberBtn">
		<a href="/mOrderList?m_id=${member.m_id}" class="memBtn">주문내역</a>
		<a href="/mReviewMgt?m_id=${member.m_id}" class="memBtn">회원리뷰</a>
		<a href="/memberMgt" class="memBtn">회원목록</a>
	</div>	
</div>
