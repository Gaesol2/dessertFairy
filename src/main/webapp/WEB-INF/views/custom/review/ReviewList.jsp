<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Reviewlist.css">
</head>
<div id="review">
  <div id="top">
    <div class="Mainlist">
		<p class="reviewname">포토후기</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="">후기 목록</a></li>
        <li><a href="">후기 글쓰기</a></li>
        <li><a href="">내 글보기</a></li>
      </ul>
    </div>
  </div>
  <div class="reviewlist">
  	<div>
  		<table class="reviewtable">
	      <tr class="headcolor">
	         <th>작성자</th>
	         <th>제목</th>
	         <th>작성일</th>
	         <th>조회수</th>
	      </tr>
	 	      <c:choose>
  	            <c:when test="${fn:length(reviewList)>0}"> 
 	              <c:forEach var="review" items="${reviewList}"> 
	               <tr>
	                  <td class="col2">${review.m_id}</td>
	                  <td class="col1"><a href="/reviewContent?r_no=${review.r_no}">${review.r_subject}</a>
	                  <input type="hidden" value="${review.r_no}">
	                  </td>
	                  <td class="col3">${review.r_regdate}</td>
	                  <td class="col4">${review.r_readcount}</td>
	               </tr>
 	            </c:forEach>
 	         </c:when>
 	         <c:when test="${fn:length(reviewList)==0}">
 	            <tr style="text-align: center;" height="30px;">
 	               <th colspan="5">등록된 상품이 없습니다.</th>
 	            </tr>
 	         </c:when>
 	      </c:choose>
	   <tr>
	    <td colspan="6" style="text-align: center;">
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
	  </table>
	  <form action="" name="content" method="post">
		<input type="hidden" name="bno" value="">
		<input type="hidden" name="curPage" value="${pageDto.curPage}">
		<input type="hidden" name="curBlock" value="${pageDto.curBlock}">
	 </form>
  	</div>
  </div>
</div>