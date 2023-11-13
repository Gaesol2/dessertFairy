<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/MemberSearch.css">
<script src="/script/MemberSearch.js"></script>


<div id="search">
	<form action="memberSearchProc" method="post" name="idSearchForm">
	<div id="Box">
		<p class="Tap">아이디 찾기</p>
		<div id="idTextBox">
			<span>
				<input type="text" name="m_name" class="idChk in" title="이름" placeholder="이름을 입력하세요." size="35">
			</span>
			<span>
				<input type="text" name="m_phone" class="idChk in" title="전화번호" placeholder="전화번호를 입력하세요." size="35">
			</span>
		</div>
		<div id="idSearch">
	      <label for="button" class="searchBtn">아이디 찾기</label>
		  <input id="button" type="hidden">
       </div>
       <div id="a_div">
       	  <a href="/memberPwSearch" class="ahover">비밀번호 찾기</a>
       </div>
	</div>
	</form>
</div>	           		