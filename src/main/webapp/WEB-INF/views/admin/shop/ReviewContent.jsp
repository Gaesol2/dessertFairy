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
		<p class="reviewname">상점관리</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li class="relist"><a href="/shopMgt">후기 목록</a></li>
        <li><a href="/reviewWrite">배너 변경</a></li>
      </ul>
    </div>
  </div>
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
         <td><img src="/upload/${review.r_image}"></td>
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
				    value="${ratings}" class="chkb">
         </td>
      </tr>
      <tr class="reviewBtn">
         <td colspan="2"><input type="button" class="writeSubmit" value="등록"></td>
      </tr>
   </table>
</div>
<form action="replyWriteProc" name="writeForm" method="post" enctype="multipart/form-data">
	<div id="replybox">
		<p class="reply">사장님 답글</p>
		<table class="replytable">
			<tr class="replycontent">
		         <td>
		         	<textarea class="replys" name="reply_content">${r_reply}</textarea>
		         </td>
		    </tr>
			<tr class="reviewBtn">
	         <td colspan="2"><input type="button" class="writeSubmit" value="답글등록"></td>
	      </tr>		    
		</table>
	</div>
	</form>
</body>
</html>