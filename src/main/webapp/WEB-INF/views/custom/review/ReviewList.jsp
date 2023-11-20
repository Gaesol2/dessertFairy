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
		<p class="reviewName">포토후기</p>
    </div>
    <div class="topList">
      <ul class="list">
        <li class="reList"><a href="/reviewList">후기 목록</a></li>
        <li><a href="/mylist">내 글보기</a></li>
      </ul>
    </div>
  </div>
  <div id="reviewList">
    <div id="col-auto">
     <select class="category" onchange="javascript:category()">
       <option>선택하세요</option>
       <option ${orderby=="new"?"selected":""}>최신순</option>
       <option ${orderby=="old"?"selected":""}>오래된 순</option>
       <option ${orderby=="star"?"selected":""}>별점 높은순</option>
       <option ${orderby=="read"?"selected":""}>조회수 순</option>
     </select>
	</div>
  		<table class="listTable">
	      <tr>
	         <th>별점</th>
	         <th>제목</th>
	         <th>작성자</th>
	         <th>조회수</th>
	         <th>작성일</th>
	      </tr>
	 	      <c:choose>
  	            <c:when test="${fn:length(reviewList)>0}"> 
 	              <c:forEach var="review" items="${reviewList}"> 
	               <tr>
	                  <td class="col1">${review.ratings}</td>
	                  <td class="col2"><a href="/reviewContent?r_no=${review.r_no}">${review.r_subject}</a>
	                  <td class="col3">${review.m_id}</td>
	                  <td class="col4">${review.r_readcount}</td>
	                  <td class="col5">${review.r_regdate}</td>
	               </tr>
 	            </c:forEach>
 	         </c:when>
 	         <c:when test="${fn:length(reviewList)==0}">
 	            <tr class="notList">
 	               <th colspan="5">등록된 상품이 없습니다.</th>
 	            </tr>
 	         </c:when>
 	      </c:choose>
	  </table>
	  <table class="pageBtn">
	   <tr>
	    <td colspan="6">
	      <c:if test="${pageDto.startPg>pBlock}">
	        <a href="reviewList?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
	      </c:if>
	      <c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
	        <a href="reviewList?curPage=${p}&curBlock=${pageDto.curBlock}">
	          <span><c:out value="${p}" /></span>
	        </a>&nbsp;&nbsp;
	      </c:forEach>
	        <c:if test="${pageDto.endPg<pageDto.pgCnt}">
	          <a href="reviewList?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
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