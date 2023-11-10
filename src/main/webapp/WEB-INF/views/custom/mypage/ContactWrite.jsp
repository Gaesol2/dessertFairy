<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>포토리뷰</title>
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/Review.css">
<script src="/script/Review.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>
<div id="mypage">
  <div>
    <div>
		<div id="mypageList">
			<p class="introduction">문의 글쓰기</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
  </div>
  <form action="reviewWriteProc" name="writeForm" id="myform" method="post" enctype="multipart/form-data">
       <div id="reviewWrite">
       	 <p class="spanName">제목</p>
         <span><input type="text" name="r_subject" title="제목" class="chkb in" size="30"></span>
         
         <p class="spanWrite">작성자</p>
         <span><input type="text" name="m_id" class="chkb in" title="작성자" size="30" value="${m_id}" disabled="disabled"></span>
       </div>
       
       <div id="image_star">
         <p class="spanImage">이미지</p>
         <span><input type="file" name="image2" title="이미지" class="chkb"></span>
	     
	     <p class="spanStar">별점</p>
         <span class="mb-3" title="별점" class="chkb" >
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
         </span>
       </div>
       <div id="reviewContent">
	      <p class="spanContent">내용</p>
	      <span>
	      	<textarea name="r_content" class="chkb" title="내용" rows="20" cols="50"></textarea>
	      </span>
       </div>
       <div id="reviewPasswd">
          <p class="spanPasswd">비밀번호</p>
          <span><input type="password" name="r_passwd" title="비밀번호" class="chkb in" size="20"
                   maxlength="6"></span>
          <span class="explanation">*비밀번호는 숫자만 입력 가능하며 4~6글자 입력하시오.</span>
       </div>
       <div id="reviewBtn">
	      <label for="button" class="writeSubmit regis">등록</label>
		  <input id="button" type="hidden">
       </div>
</form>
</div>