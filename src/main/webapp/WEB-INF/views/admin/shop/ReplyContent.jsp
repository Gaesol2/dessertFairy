<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/Review.css">
<script src="/script/Review.js"></script>

<div id="review">
	<form action="replyWriteProc" name="replyForm" id="replyForm" method="post">
	<input type="hidden" name="r_no" value="${review.r_no}">
		<div>
			<div class="mainList">
				<p class="reviewName">상점관리</p>
			</div>
			<div class="topList">
				<ul class="list">
					<li><a href="/shopMgt">후기 목록</a></li>
					<li><a href="/adminContact">문의 목록</a></li>
				</ul>
			</div>
		</div>
		  
		<div id="Contentreview">
			<div id="contentMain">
				<span class="contentStar" title="별점" class="chkb" >
					<input type="hidden" name="ratingLength" value="${ratingLength}" readonly="readonly">
					<input type="radio" name="r_star" value="5" id="rate1" onclick="return false;">
					   <label for="rate1" class="conStar">★</label>
					<input type="radio" name="r_star" value="4" id="rate2" onclick="return false;">
					   <label for="rate2" class="conStar">★</label>
					<input type="radio" name="r_star" value="3" id="rate3" onclick="return false;">
					   <label for="rate3" class="conStar">★</label>
					<input type="radio" name="r_star" value="2" id="rate4" onclick="return false;">
					   <label for="rate4" class="conStar">★</label>
					<input type="radio" name="r_star" value="1" id="rate5" onclick="return false;">
					<label for="rate5" class="conStar">★</label>
				</span>
			
				<span class="contentSubject">${review.r_subject}
					<input type="hidden" name="r_subject" readonly="readonly" value="${review.r_subject}" class="chkb" size="40">
				</span>
			
				<span class="contentWrite">${review.m_id}
					<input type="hidden" name="m_id" readonly="readonly" value="${review.m_id}" class="chkb" size="15">
				</span>
			
				<span class="contentRegdate">${review.r_regdate}
					<input type="hidden" name="r_regdate" readonly="readonly" value="${review.r_regdate}" class="chkb" size="10">
			    </span>
			       
			</div>
			<div id="contentMiddle">
				<div>
					<img src="/upload/${review.r_image}" width="500">
				</div>
			</div>
			<div id="contentBottom">
			 	<span class="contentContent">${review.r_content}
					<input type="hidden" name="r_content" readonly="readonly" value="${review.r_content}" class="chkb" size="10">
			 	</span>
			</div>
		</div>
		<div id="replybox">
			<p class="adminReply">사장님 답글</p>
			<span class="replycontent">
		         <textarea class="replys" name="r_reply" placeholder="아직 답글이 없습니다.">${review.r_reply}</textarea>
		    </span>
		</div>
		<div id="replyBtn">
			<c:choose>
				<c:when test="${review.r_reply == null}">
					<span class="reviewBtn1">
					      <button type="button" class="adminWriteSubmit">답글 등록</button>
					</span>          
				</c:when>
				
				<c:when test="${review.r_reply != null}">
					<span class="reviewBtn2">
					      <button type="button" class="replyUpdate">답글 수정</button>
					      <button type="button" class="replyDel">답글 삭제</button>
					</span>          
				</c:when>
			</c:choose>
		</div>
		<input type="hidden" name="r_no" value="${review.r_no}">
	</form>
</div>