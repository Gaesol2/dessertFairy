<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토리뷰</title>
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/Reviewcontent.css">
<script src="/script/Review.js"></script>
</head>
<body>
<div id="review">
   <div id="top">
    <div class="Mainlist">
		<p class="reviewname">포토후기</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="/reviewList">후기 목록</a></li>
        <li><a href="/reviewWrite">후기 글쓰기</a></li>
        <li><a href="/mylist">내 글보기</a></li>
      </ul>
    </div>
  </div>
  <form action="" name="reviewForm" method="post">
  <input type="hidden" name="r_no" value="${review.r_no }">
	   <table class="reviewtable">
	      <tr>
	         <th>제목</th>
	         <td><input type="text" name="r_subject" readonly="readonly" 
	                    value="${review.r_subject}" class="chkb" size="51"></td>
	      </tr>
	      <tr>
	         <th>작성자</th>
	         <td><input type="text" name="m_id" readonly="readonly" 
	                    value="${review.m_id}" class="chkb" size="51"></td>
	      </tr>
	      <tr>
	         <th>이미지</th>
	         <td><img src="/upload/${review.r_image}" width="380" height="300"></td>
	      </tr>
	      <tr>
	         <th>내용</th>
	         <td><textarea name="r_content" class="chkb" readonly="readonly" 
	                      rows="20" cols="50">${review.r_content}</textarea></td>
	      </tr>
	      <tr>
	         <th>별점</th>
	         <td class="mb-3" title="별점" class="chkb">
	         	<c:choose>
	         	<c:when test = "${ratings}=='★★★★★'">
	         		<input type="hidden" name="r_star" value="5">
		         </c:when>
	         	<c:when test = "${ratings}=='★★★★☆'">
	         		<input type="hidden" name="r_star" value="4">
		         </c:when>
	         	<c:when test = "${ratings}=='★★★☆☆'">
	         		<input type="hidden" name="r_star" value="3">
		         </c:when>
	         	<c:when test = "${ratings}=='★★☆☆☆'">
	         		<input type="hidden" name="r_star" value="2">
		         </c:when>
	         	<c:otherwise>
	         		<input type="hidden" name="r_star" value="1">
		         </c:otherwise>
	         	</c:choose>
					<input type="text" readonly="readonly" value="${ratings}">
	         </td>
	      </tr>
	      <tr>
			<td colspan="2">
				<button type="button" class="reviewUp">후기글 수정</button>
				<button type="button" class="reviewDel">후기글 삭제</button>
			</td>
		 </tr>
	   </table>
  </form>
</div>
<div id="replybox">
	<table class="replytable">
			<c:if test="${fn:length(replyList)>0}">
			<p class="reply">사장님 답글</p>
					<tr class="replycontent">
				         <td colspan="2">
				         	<textarea name="reply_content" class="chkb" readonly="readonly" 
			                      rows="20" cols="50">${r_reply}</textarea>
				         </td>
				    </tr>
			</c:if>
	</table>
</div>
</body>
</html>