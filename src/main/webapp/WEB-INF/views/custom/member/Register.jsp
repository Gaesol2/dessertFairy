<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/Member.css">
<script src="/jquery/jquery-3.7.0.min.js"></script>
<script src="/script/zipCheck.js"></script>
<script src="/script/MemberJoin.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<div id="joinBox">
	<form action="registerProc" name="joinForm" method="post">
		<div id="joinTable">
			<div class="regis">
				<h2 class="name">회원 가입</h2>
				<h5 class="name">(*은 필수입력)</h5>
			</div>
				<div class="regisBox">
					<p class="col1">*아이디</p>
					<span>
						<input type="text" class="chk idchk" name="m_id" title="아이디" size="30">
						<br>
						<font id="idcheck" size="2" color="red" class="possible"></font>
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col2">*비밀번호</p>
					<span>
						<input type="password" id="password" class="chk" size="30" name="m_passwd" title="비밀번호">
						<br>
						<font id="pcombiCheck" size="2" color="green" class="possible"></font>
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col3">*비밀번호 확인</p>
					<span>
						<input type="password" id="cpassword" class="chk" size="30" name="m_rePasswd" title="비밀번호 확인">
						<br>
						<font id="pcheck" size="2" color="green" class="possible"></font>
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col4">*이름</p>
					<span>
						<input type="text" class="chk" name="m_name" size="25" title="이름">
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col5">이메일</p>
					<span>
						<input type="text" name="m_email" title="이메일" size="35">
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col6">*전화번호</p>
					<span>
<!-- 						<input type="hidden" id="phone" class="chk" name="m_phone" size="30" title="전화번호" > -->
						<input type="text" id="phone" class="chk" value="010" readonly="readonly"/>-
				        <input type='text' id="phone" class="chk" name="m_phone1" size="10" title="전화번호"/>-
				        <input type='text' id="phone" class="chk" name="m_phone2" size="10" title="전화번호"/>
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col7">*우편번호</p>
					<span>
						<input type="text" class="chk" name="m_zipcode" title="우편번호" size="35" readonly="readonly" id="sample6_postcode">
						<button type="button" onclick="zipCheck()">우편번호 찾기</button>
					</span>
				</div>
				<div class="clear"></div>
				
				<div class="regisBox">
					<p class="col8">*주소</p>
					<span>
						<input type="text" class="chk" name="m_address" title="주소" size="30" readonly="readonly" id="sample6_address" >
						<input type="text" class="chk" name="m_address2" size="10" title="상세주소" id="sample6_detailAddress">
						<input type="hidden" id="sample6_extraAddress">
					</span>
				</div>
		</div>
		<div id="joinBtn">
			<button class="m_join" type="button">회원가입</button>
			<button type="reset">다시쓰기</button>
        </div>
	</form>
</div>
