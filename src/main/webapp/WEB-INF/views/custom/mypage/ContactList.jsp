<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<script src="/script/Contact.js"></script>

<div id="contact">
	<div>
		<div>
			<div id="contactList">
				<p class="introduction">문의하기</p>
			</div>
			<div class="topList">
				<ul class="list">
					<li><a href="/myPage">내 정보</a></li>
					<li><a href="/cartList">장바구니</a></li>
					<li><a href="/orderList">주문목록</a></li>
					<li class="reList"><a href="/contactList">문의하기</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="contactContent">
 		<div id="contactBtn">
 			<a href="/contactList" class="now">문의목록 /</a>
		  	<a href="/myContact" class="writeBtn">내 글보기 /</a>
		  	<a href="/contactWrite" class="writeBtn">문의 글쓰기</a>
 		</div>
		<table class="conTable">
			<tr>
				<th class="con1">번호</th>
				<th class="con2">제목</th>
				<th class="con3">작성자</th>
				<th class="con4">작성일</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(contactList)>0}">
					<c:forEach var="contact" items="${contactList}" varStatus="status">
						<tr>
							<td class="con5"><c:out value="${contact.t_no}"/></td> 
							<td class="con6">    
								<c:if test="${contact.t_secret eq 'N'}" >
									<img src="${pageContext.request.contextPath}/image/secret.png" class="secretImg" width="20" height="20" alt="비밀글" />
									<c:choose>
										<c:when test="${ssKey.m_id == contact.m_id || ssKey.m_role=='admin'}">
											<a href="/contactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
										</c:when>
									<c:otherwise>비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${contact.t_secret eq 'Y'}" >
									<a href="/contactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
								</c:if>
							</td>
							<td class="con7"><c:out value="${contact.m_id}"/></td>            
							<td class="con8"><c:out value="${contact.t_regdate}"/></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:when test="${fn:length(contactList)==0}">
					<tr class="notList">
						<th colspan="6">등록된 글이없습니다.</th>
					</tr>
				</c:when>
			</c:choose>
		</table>
		<table class="pageBtn">
			<tr>
				<td colspan="6">
					<c:if test="${pdto.startPg>pBlock}">
						<a href="contactList?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						<a href="contactList?curPage=${p}&curBlock=${pdto.curBlock}">
							<span><c:out value="${p}" /></span>
						</a>&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${pdto.endPg<pdto.pgCnt}">
						<a href="contactList?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<form action="" name="content" method="post">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="curPage" value="${pdto.curPage}">
			<input type="hidden" name="curBlock" value="${pdto.curBlock}">
		</form>
	</div>
</div>