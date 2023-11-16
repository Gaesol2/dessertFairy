<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<script src="/script/Contact.js"></script>

<div id="contact">
  <div>
    <div class="mainList">
		<p class="reviewName">상점관리</p>
    </div>
    <div class="topList">
      <ul class="list">
        <li><a href="/shopMgt">후기 목록</a></li>
        <li><a href="/adminContact">문의 목록</a></li>
        <li><a href="/reviewWrite">배너 변경</a></li>
      </ul>
    </div>
  </div>
  <div id="contactContent">
  	<a href="/contactWrite">문의글 목록</a>
  		<table class="conTable">
	      <tr>
	         <th class="con2">번호</th>
	         <th class="con3">제목</th>
	         <th class="con4">작성자</th>
	         <th class="con6">작성일</th>
	      </tr>
<%-- 	 	      <c:choose> --%>
<%--   	            <c:when test="${fn:length(contactList)>0}">  --%>
<%--  	              <c:forEach var="contact" items="${contactList}">  --%>
<!-- 	               <tr> -->
<%-- 	               	  <td class="con2">${contact.t_no}</td> --%>
<%-- 	              <c:if test="${ssKey.m_role=='admin'}"> --%>
<%-- 	                  <td class="con3"><a href="/contactContent?t_no=${contact.t_no}">${contact.t_subject}</a> --%>
<%-- 	              </c:if>  --%>
<%-- 	                  <td class="con4">${contact.m_id}</td> --%>
<%-- 	                  <td class="con5">${contact.t_readcount}</td> --%>
<%-- 	                  <td class="con6">${contact.t_regdate}</td> --%>
<!-- 	               </tr> -->
<%--  	            </c:forEach> --%>
<%--  	         </c:when> --%>
<%--  	         <c:when test="${fn:length(contactList)==0}"> --%>
<!--  	            <tr style="text-align: center;" height="30px;"> -->
<!--  	               <th colspan="6">등록된 문의글이 없습니다.</th> -->
<!--  	            </tr> -->
<%--  	         </c:when> --%>
<%--  	      </c:choose> --%>
 	      
 	      
 	      <c:forEach var="contact" items="${contactList}" varStatus="status">
			    <tr style="text-align:center;">
			        <td><c:out value="${contact.t_no}"/></td> 
			        <td>    
			        <c:if test="${contact.t_secret eq 'N'}" >
			            <img src="${pageContext.request.contextPath}/image/secret.png" class="secretImg" width="20" height="20" alt="비밀글" />
			            <c:choose>
			                <c:when test="${ssKey.m_id == contact.m_id || ssKey.m_role=='admin'}">
			                    <a href="/adminContactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
			                </c:when>
			                <c:otherwise><a href="/adminContactContent?t_no=${contact.t_no}">${contact.t_subject}비밀글은 작성자와 관리자만 볼 수 있습니다.</a></c:otherwise>
			            </c:choose>
			        </c:if>
			        <c:if test="${contact.t_secret eq 'Y'}" >
			            <a href="/adminContactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
			        </c:if>
			        </td>
			        <td><c:out value="${contact.m_id}"/></td>            
			        <td><c:out value="${contact.t_regdate}"/></td>
			    </tr>
			</c:forEach>
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
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