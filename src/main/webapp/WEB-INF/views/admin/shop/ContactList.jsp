<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<script src="/script/Contact.js"></script>

<div id="contact">
  <div>
    <div id="contactList">
		<p class="introduction">문의목록</p>
    </div>
    <div class="topList">
      <ul class="list">
        <li><a href="/shopMgt">후기 목록</a></li>
        <li class="reList"><a href="/adminContact">문의 목록</a></li>
      </ul>
    </div>
  </div>
  <div id="contactContent">
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
					    <tr style="text-align:center;">
					        <td class="con5"><c:out value="${contact.t_no}"/>
					        	<input type="hidden" name="t_level" value="${contact.t_level}">
					        </td> 
					        <td class="con6">
					        	<c:if test="${contact.t_level>=1}">
									<span class="replyL">└</span>
								</c:if>   
						        <c:if test="${contact.t_secret eq 'N'}" >
						            <img src="${pageContext.request.contextPath}/image/secret.png" class="secretImg" width="20" height="20" alt="비밀글" />
						            <c:choose>
						                <c:when test="${ssKey.m_id == contact.m_id || ssKey.m_role=='admin'}">
						                    <a href="/adminContactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
						                </c:when>
						                <c:otherwise>비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
						            </c:choose>
						        </c:if>
						        <c:if test="${contact.t_secret eq 'Y'}" >
						            <a href="/adminContactContent?t_no=${contact.t_no}">${contact.t_subject}</a>
						        </c:if>
					        </td>
					        <td class="con7">
					        	<c:choose>
									<c:when test="${contact.t_level>=1}"><span>관리자</span></c:when>
									<c:otherwise>${contact.m_id}</c:otherwise>
								</c:choose>
					        </td>            
					        <td class="con8"><c:out value="${contact.t_regdate}"/></td>
					    </tr>
					</c:forEach>
				</c:when>
				<c:when test="${fn:length(nList)==0}">
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
	        <a href="adminContact?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
	      </c:if>
	      <c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
	        <a href="adminContact?curPage=${p}&curBlock=${pdto.curBlock}">
	          <span><c:out value="${p}" /></span>
	        </a>&nbsp;&nbsp;
	      </c:forEach>
	        <c:if test="${pdto.endPg<pdto.pgCnt}">
	          <a href="adminContact?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
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