<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">


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
  	<a href="/contactWrite">문의 글쓰기</a>
  		<table class="conTable">
	      <tr>
	         <th>비밀여부</th>
	         <th>번호</th>
	         <th>제목</th>
	         <th>작성자</th>
	         <th>조회수</th>
	         <th>작성일</th>
	      </tr>
	 	      <c:choose>
  	            <c:when test="${fn:length(contactList)>0}"> 
 	              <c:forEach var="contact" items="${contactList}"> 
	               <tr>
	               	  <td class="con1">${contact.t_secret}</td>
	               	  <td class="con2">${contact.t_no}</td>
	                  <td class="con3"><a href="/contactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
	                  <td class="con4">${contact.m_id}</td>
	                  <td class="con5">${contact.t_readcount}</td>
	                  <td class="con6">${contact.t_regdate}</td>
	               </tr>
 	            </c:forEach>
 	         </c:when>
 	         <c:when test="${fn:length(contactList)==0}">
 	            <tr style="text-align: center;" height="30px;">
 	               <th colspan="6">등록된 문의글이 없습니다.</th>
 	            </tr>
 	         </c:when>
 	      </c:choose>
	  </table>
	  <table class="pageBtn">
	   <tr>
	    <td colspan="6">
	      <c:if test="${pageDto.startPg>pBlock}">
	        <a href="contactList?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
	      </c:if>
	      <c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
	        <a href="contactList?curPage=${p}&curBlock=${pageDto.curBlock}">
	          <span><c:out value="${p}" /></span>
	        </a>&nbsp;&nbsp;
	      </c:forEach>
	        <c:if test="${pageDto.endPg<pageDto.pgCnt}">
	          <a href="contactList?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
	        </c:if>
	     </td>
	    </tr>
	  </table>
	  <form action="" name="content" method="post">
		<input type="hidden" name="bno" value="">
		<input type="hidden" name="curPage" value="${pageDto.curPage}">
		<input type="hidden" name="curBlock" value="${pageDto.curBlock}">
	 </form>
  	</div>
</div>