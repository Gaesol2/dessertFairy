<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script src="/script/Contact.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
</head>
<body>
<div id="contact">
	<form action="" name="contactForm" method="post">
		<div id="contactMainBox">
			<div id="contactList">
				<p class="introduction">문의 글</p>
			</div>
			<div class="topList">
				<ul class="list">
					<li><a href="/myPage">내 정보</a></li>
					<li><a href="/cartList">장바구니</a></li>
					<li><a href="/orderList">주문목록</a></li>
					<li><a href="/contactList">문의하기</a></li>
				</ul>
			</div>
			<div id="ContentContact">
				<div id="contactMain">
					<span class="contentSubject">${contact.t_subject}
						<input type="hidden" name="t_no" value="${contact.t_no}">
						<input type="hidden" name="t_subject" readonly="readonly" value="${contact.t_subject}" class="chkc" size="40">
					</span>
					
					<span class="contentWrite">
						<c:choose>
							<c:when test="${contact.t_level>=1}"><span>관리자</span></c:when>
							<c:otherwise>${contact.m_id}</c:otherwise>
						</c:choose>
						<input type="hidden" name="m_id" readonly="readonly" value="${contact.m_id}" size="15">
					</span>
					
					<span class="contentRegdate">${contact.t_regdate}
						<input type="hidden" name="t_regdate" readonly="readonly" value="${contact.t_regdate}" size="10">
					</span>
				       
				</div>
				<div id="contentBottom">
				 	<span class="contentContent">${contact.t_content}
				 		<input type="hidden" name="t_content" readonly="readonly" value="${contact.t_content}" size="10">
				 	</span>
				</div>
			</div>
		</div>
		<div id="contentPasswd">
			<input type="hidden" name="t_passwd" readonly="readonly" value="${contact.t_passwd}" class="chkc in" size="10">
		</div>
		<div id="myBtn">
			<c:if test="${ssKey.m_id == contact.m_id}">
					<button type="button" name="update" class="contactUp" onclick="update('u')">수정</button>
					<button type="button" name="delete" class="contactDel" onclick="update('d')">삭제</button>
			</c:if>
			<button type="button" class="regis" onclick="location.href='/contactList'">목록으로</button>
		</div>
	</form>
</div>
</body>
</html>