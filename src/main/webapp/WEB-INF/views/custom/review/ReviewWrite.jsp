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
<div>
<form action="reviewWriteProc" name="writeForm" class="mb-3" id="myform" method="post" enctype="multipart/form-data">
   <fieldset>
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
   <table>
      <tr>
         <td>제목</td>
         <td><input type="text" name="r_subject"></td>
      </tr>
      <tr>
         <td>작성자</td>
         <td><input type="text" name="m_id" value="${m_id}" disabled="disabled"></td>
      </tr>
      <tr>
         <td>이미지</td>
         <td><input type="file" name="image2"></td>
      </tr>
      <tr>
         <td>내용</td>
         <td><textarea name="r_content"></textarea></td>
      </tr>
      <tr>
         <td>별점</td>
         <td><input type="text" name="r_star"></td>
      </tr>
      <tr>
         <td>비밀번호</td>
         <td><input type="password" name="r_passwd"></td>
      </tr>
      <tr>
         <td><input type="button" class="writeSubmit" value="등록"></td>
      </tr>
   </table>
</form>
</div>
</body>
</html>