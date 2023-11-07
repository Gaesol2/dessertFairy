<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Review.css">
<script src="/script/Review.js"></script>
<div id="review">
  <div>
    <div class="mainList">
		<p class="reviewName">상점관리</p>
    </div>
    <div class="topList">
      <ul class="list">
        <li><a href="/shopMgt">후기 목록</a></li>
        <li><a href="/reviewWrite">배너 변경</a></li>
      </ul>
    </div>
  </div>
  <div id="myList">
  		<table class="listTable">
	      <tr>
	         <th>별점</th>
	         <th>제목</th>
	         <th>작성자</th>
	         <th>조회수</th>
	         <th>작성일</th>
	      </tr>
	 	      <c:choose>
  	            <c:when test="${fn:length(replyList)>0}"> 
 	              <c:forEach var="reply" items="${replyList}"> 
	               <tr>
	                  <td class="col1">${reply.ratings}</td>
	                  <td class="col2"><a href="/replyContent?r_no=${reply.r_no}">${reply.r_subject}</a>
	                  <td class="col3">${reply.m_id}</td>
	                  <td class="col4">${reply.r_readcount}</td>
	                  <td class="col5">${reply.r_regdate}</td>
	               </tr>
 	            </c:forEach>
 	         </c:when>
 	         <c:when test="${fn:length(replyList)==0}">
 	            <tr style="text-align: center;" height="30px;">
 	               <th colspan="5">등록된 후기가 없습니다.</th>
 	            </tr>
 	         </c:when>
 	      </c:choose>
	  </table>
	  <table class="pageBtn">
		   <tr>
			    <td colspan="6" style="text-align: center;">
			      <c:if test="${pageDto.startPg>pBlock}">
			        <a href="shopMgt?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
			      </c:if>
			      <c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
			        <a href="shopMgt?curPage=${p}&curBlock=${pageDto.curBlock}">
			          <span><c:out value="${p}" /></span>
			        </a>&nbsp;&nbsp;
			      </c:forEach>
			        <c:if test="${pageDto.endPg<pageDto.pgCnt}">
			          <a href="shopMgt?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
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