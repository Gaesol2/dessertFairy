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
  <form action="" name="reviewForm" id="myform" method="post" enctype="multipart/form-data">
	   <table class="reviewtable">
	      <tr>
	         <th>제목</th>
	         <td><input type="text" name="r_subject" 
	                    value="${review.r_subject}" class="chkb" size="51"></td>
	      </tr>
	      <tr>
	         <th>작성자</th>
	         <td><input type="text" name="m_id" readonly="readonly"
	                    value="${review.m_id}" class="chkb" size="51"></td>
	      </tr>
	      <tr>
	         <th>이미지</th>
	         <td><input type="file" name="image2" title="이미지">${review.r_image}
	      		<input type="hidden" name="r_no" value="${review.r_no}">
	         </td>
	      </tr>
	      <tr>
	         <th>내용</th>
	         <td><textarea name="r_content" class="chkb"
	                      rows="20" cols="50">${review.r_content}</textarea></td>
	      </tr>
	      <tr>
	         <th>별점</th>
	         <td class="mb-3" title="별점" class="chkb" >
	         	<input type="hidden" name="ratingLength" value="${ratingLength}">
				<input type="radio" name="r_star" value="5" id="rate1">
					<label for="rate1">★</label>
				<input type="radio" name="r_star" value="4" id="rate2">
					<label for="rate2">★</label>
				<input type="radio" name="r_star" value="3" id="rate3">
					<label for="rate3">★</label>
				<input type="radio" name="r_star" value="2" id="rate4">
					<label for="rate4">★</label>
				<input type="radio" name="r_star" value="1" id="rate5">
					<label for="rate5">★</label>
         </td>
	      </tr>
	      <tr>
			<td colspan="2">
				<button type="button" class="reviewUpdate">후기글 수정</button>
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