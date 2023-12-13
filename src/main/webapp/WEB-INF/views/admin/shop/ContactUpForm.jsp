<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<script src="/script/Contact.js"></script>

<div id="contact">
	<div>
	    <div id="contactList">
			<p class="introduction">답글수정</p>
	    </div>
  	</div>
	<form action="contactReUpProc" name="conReUpForm" id="conReUpForm" method="post">
		<div id="conWrite">
			<p class="spanName">제목</p>
			<span>
						<input type="text" name="t_subject" title="제목" class="chkc in" size="30" value="${tdto.t_subject}">
			</span>
			<p class="spanWrite">작성자</p>
			<span>
				<input type="text" class="chkc in" title="작성자" size="30" value="${ssKey.m_id}" disabled="disabled">
				<input type="hidden" name="m_id" value="${tdto.m_id}">
			</span>
		</div>
	      
		<div class="form-inline">
			<div class="secretBox">
				<input type="radio" name="t_secret" id="cs_open" value="Y" class="radio" />
				<span class="ml_10">공개</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="t_secret" id="cs_open" value="N" class="radio" />
				<span class="ml_10">비공개</span>&nbsp;
			</div>
		</div>
	      
		<div id="conContent">
			<p class="spanContent">내용</p>
			<span>
				<input type="text" name="t_content" class="chkc contactReContent in" title="내용" value="${tdto.t_content}">
			</span>
		</div>
		<div id="conBtn">
			<input type="submit" class="regis" value="수정">
		</div>
		<input type="hidden" name="t_no" value="${tdto.t_no}">
		<input type="hidden" name="t_level" value="${tdto.t_level}">
		<input type="hidden" name="t_level" value="${tdto.t_group}">
	</form>
</div>