<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토리뷰</title>
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/reviewwrite.css">
<script src="/script/Review.js"></script>
</head>
<body>
<div id="review">
<form action="reviewWriteProc" name="writeForm" id="myform" method="post" enctype="multipart/form-data">
   <fieldset class="mb-3" >
		<span class="text-bold">별점을 선택해주세요</span>
		<input type="radio" name="reviewStar" value="5" id="rate1">
			<label for="rate1">★</label>
		<input type="radio" name="reviewStar" value="4" id="rate2">
			<label for="rate2">★</label>
		<input type="radio" name="reviewStar" value="3" id="rate3">
			<label for="rate3">★</label>
		<input type="radio" name="reviewStar" value="2" id="rate4">
			<label for="rate4">★</label>
		<input type="radio" name="reviewStar" value="1" id="rate5">
			<label for="rate5">★</label>
	</fieldset>
   <table class="reviewtable">
      <tr>
         <th>제목</th>
         <td><input type="text" name="r_subject" size="51"></td>
      </tr>
      <tr>
         <th>작성자</th>
         <td><input type="text" name="m_id" size="51" value="${m_id}" disabled="disabled"></td>
      </tr>
      <tr>
         <th>이미지</th>
         <td><input type="file" name="image2"></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><textarea name="r_content" rows="20" cols="50"></textarea></td>
      </tr>
      <tr>
         <th>비밀번호</th>
         <td><input type="password" name="r_passwd" size="51"></td>
      </tr>
      <tr>
         <td colspan="2"><input type="button" class="writeSubmit" value="등록"></td>
      </tr>
   </table>
</form>
</div>
</body>
</html>