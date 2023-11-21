<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Review.css">

<div id="review">
	<div class="memMainList">
	
		<p class="memReviewName">${reviews.m_name}님의 후기목록</p>
		<input type="text" name="m_id" value="${member.m_id}">
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
	        	<c:when test="${fn:length(memList)>0}"> 
	        		<c:forEach var="reviews" items="${memList}"> 
			             <tr>
								<td class="col1">${reviews.ratings}</td>
								<td class="col2"><a href="/replyContent?r_no=${reviews.r_no}">${reviews.r_subject}</a>
								<td class="col3">${reviews.m_id}</td>
								<td class="col4">${reviews.r_readcount}</td>
								<td class="col5">${reviews.r_regdate}</td>
							</tr>
	        		</c:forEach>
	        	</c:when>
	        	
		        <c:when test="${fn:length(memList)==0}">
		           <tr class="notList">
		              <th colspan="5">등록된 후기가 없습니다.</th>
		           </tr>
		        </c:when>
	     	</c:choose>
		</table>
	
		<table class="pageBtn">
			<tr>
				<td colspan="6">
					<c:if test="${pageDto.startPg>pBlock}">
					  <a href="mReviewMgt?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
					</c:if>
					    
					<c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
					  <a href="mReviewMgt?curPage=${p}&curBlock=${pageDto.curBlock}">
					    <span><c:out value="${p}" /></span>
					  </a>&nbsp;&nbsp;
					</c:forEach>
				
					<c:if test="${pageDto.endPg<pdto.pgCnt}">
					  <a href="mReviewMgt?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
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
