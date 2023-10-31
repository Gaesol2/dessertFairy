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
<form action="reviewContent" name="writeForm" id="myform" method="post" enctype="multipart/form-data">
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
         <td><input type="file" name="image2" readonly="readonly" 
                    value="${review.r_image}" class="chkb"></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><textarea name="r_content" class="chkb" readonly="readonly" 
                      rows="20" cols="50">${review.r_content}</textarea></td>
      </tr>
      <tr>
         <th>별점</th>
         <td class="mb-3" title="별점" class="chkb">
				<input type="text" name="r_star" readonly="readonly"
				    value="${review.r_star}" class="chkb">
         </td>
      </tr>
      <tr class="reviewBtn">
         <td colspan="2"><input type="button" class="writeSubmit" value="등록"></td>
      </tr>
   </table>
</form>
</div>
</body>
</html>