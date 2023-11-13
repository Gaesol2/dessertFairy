<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<meta charset="UTF-8">
<title>회원 리뷰 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/Review.css">
<script src="/script/Review.js"></script>
<div id="review">
	<%-- <h2>${reviews.m_id}님의 전체 게시글 수 : 전체 게시글 수 : ${reviewTot}</h2> --%>
	<table class="listTable">
	    <tr>
	       <th>글번호</th>
	       <th>제목</th>
	       <th>내용</th>
	       <th>등록일</th>
	       <th>조회수</th>
	       <th>비밀번호</th>
	       <th>별점</th>
	       <th>이미지</th>
	       <th>경로</th>
	       <th>답글</th>
	       <th>아이디</th>
	    </tr>
      	<c:choose>
        	<c:when test="${reviewTot>0}"> 
        		<c:forEach var="reviews" items="${reviews}"> 
		             <tr>
		                <td class="col2"><a href="/myContent?r_no=${reviews.r_no}">${reviews.r_subject}</a>
		                <td class="col1">${reviews.r_subject}</td>
		                <td class="col3">${reviews.r_content}</td>
		                <td class="col5">${reviews.r_regdate}</td>
		                <td class="col4">${reviews.r_readcount}</td>
		                <td class="col4">${reviews.r_passwd}</td>
		                <td class="col4">${reviews.r_star}</td>
		                <td class="col4">${reviews.r_image}</td>
		                <td class="col4">${reviews.r_path}</td>
		                <td class="col4">${reviews.r_reply}</td>
		                <td class="col4">${reviews.m_id}</td>
		             </tr>
        		</c:forEach>
        	</c:when>
        	
	        <c:when test="${reviewTot==0}">
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
				  <a href="mylist?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
				</c:if>
				    
				<c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
				  <a href="mylist?curPage=${p}&curBlock=${pageDto.curBlock}">
				    <span><c:out value="${p}" /></span>
				  </a>&nbsp;&nbsp;
				</c:forEach>
			
				<c:if test="${pageDto.endPg<pageDto.pgCnt}">
				  <a href="mylist?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
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