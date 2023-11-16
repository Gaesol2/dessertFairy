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
    <div>
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
	</div>
	 <div id="ContentContact">
		  <div id="contactMain">
		         <span class="contentSubject">${contact.t_subject}
		         	<input type="hidden" name="t_subject" readonly="readonly" value="${contact.t_subject}" class="chkb" size="40">
		         </span>
		         
		         <span class="contentWrite">${contact.m_id}
		         	<input type="hidden" name="m_id" readonly="readonly" value="${contact.m_id}" class="chkb" size="15">
		         </span>
		         
		         <span class="contentRegdate">${contact.t_regdate}
		         	<input type="hidden" name="t_regdate" readonly="readonly" value="${contact.t_regdate}" class="chkb" size="10">
		         </span>
		         
		  </div>
		  <div id="contentBottom">
			  	<span class="contentContent">${contact.t_content}
			    	<input type="hidden" name="t_content" readonly="readonly" value="${contact.t_content}" class="chkb" size="10">
			  	</span>
		  </div>
	</div>
<!-- 	<div id="replybox"> -->
<!-- 				<p class="adminReply">사장님 답글</p> -->
<!-- 				<span class="replycontent"> -->
<!-- 			         <input type="text" class="replys" name="r_reply" -->
<%-- 			             value="${contact.r_reply}" placeholder="아직 답글이 없습니다." readonly="readonly"> --%>
<!-- 			    </span> -->
<!-- 	</div> -->
</div>
</body>
</html>