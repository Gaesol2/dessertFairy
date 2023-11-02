<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>포토리뷰</title>
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/Reviewwrite.css">
<script src="/script/Review.js"></script>
<div id="review">
   <div id="top">
    <div class="Mainlist">
		<p class="reviewname">포토후기</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="/reviewList">후기 목록</a></li>
        <li class="rewrite"><a href="/reviewWrite">후기 글쓰기</a></li>
        <li><a href="/mylist">내 글보기</a></li>
      </ul>
    </div>
  </div>
  <form action="reviewWriteProc" name="writeForm" id="myform" method="post" enctype="multipart/form-data">
   <table class="reviewtable">
      <tr>
         <th>제목</th>
         <td><input type="text" name="r_subject" title="제목" class="chkb" size="51"></td>
      </tr>
      <tr>
         <th>작성자</th>
         <td><input type="text" name="m_id" class="chkb" title="작성자" size="51" value="${m_id}" disabled="disabled"></td>
      </tr>
      <tr>
         <th>이미지</th>
         <td><input type="file" name="image2" title="이미지" class="chkb"></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><textarea name="r_content" class="chkb" title="내용" rows="20" cols="50"></textarea></td>
      </tr>
      <tr>
         <th>비밀번호</th>
         <td><input type="password" name="r_passwd" title="비밀번호" class="chkb" size="51"></td>
      </tr>
      <tr>
         <th>별점</th>
         <td class="mb-3" title="별점" class="chkb" >
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
      <tr class="reviewBtn">
         <td colspan="2"><input type="button" class="writeSubmit" value="등록"></td>
      </tr>
   </table>
</form>
</div>