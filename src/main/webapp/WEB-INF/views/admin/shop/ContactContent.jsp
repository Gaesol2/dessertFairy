<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<script src="/script/Contact.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Contact.css">

<div id="contact">
	<div>
		<p class="introduction">문의 글 보기</p>
	</div>
	<div id="ContentContact">
		<form action="adminContactReply" method="post" name="replyForm">
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
			
			<div id="contentBtn">
				<span class="contentBtnBox">
					<button type="button" class="regis" onclick="location.href='/adminContact'">목록으로</button>
					<button type="submit" class="regis">답변하기</button>
				</span>
			</div>
			<input type="hidden" name="t_no" value="${contact.t_no}">
			<input type="hidden" name="t_level" value="${contact.t_level}">
			<input type="hidden" name="t_group" value="${contact.t_group}">
		</form>
	</div>
</div>