<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>포토리뷰</title>
<script src="/script/Contact.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Contact.css">
<div id="contact">
  <div>
    <div>
		<div id="contactList">
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
  <form action="contactWriteProc" name="conForm" id="myform" method="post">
       <div id="conWrite">
       	 <p class="spanName">제목</p>
         <span><input type="text" name="t_subject" title="제목" class="chkc in" size="30"></span>
         
         <p class="spanWrite">작성자</p>
         <span><input type="text" name="m_id" class="chkc in" title="작성자" size="30" value="${m_id}" disabled="disabled"></span>
       
         <p class="spanSecret">비밀글<input type="checkbox" name="t_secret" title="비밀여부" class="chkb chkbox"></p>
       </div>
       
       <div id="conContent">
	      <p class="spanContent">내용</p>
	      <span>
	      	<textarea name="t_content" class="chkc" title="내용" rows="20" cols="50"></textarea>
	      </span>
       </div>
       <div id="conPasswd">
          <p class="spanPasswd">비밀번호</p>
          <span><input type="password" name="t_passwd" title="비밀번호" class="chkc in" size="20"
                   maxlength="6"></span>
          <span class="explanation">*비밀번호는 숫자만 입력 가능하며 4~6글자 입력하시오.</span>
       </div>
       <div id="conBtn">
<!-- 	      <label for="button" class="writeSubmit regis">등록</label> -->
<!-- 		  <input id="button" type="hidden" > -->
		  <input type="button" class="conSubmit" value="등록">
       </div>
 </form>
</div>