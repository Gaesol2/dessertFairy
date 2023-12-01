<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" type="text/css" href="/css/Member.css">
<script src="/script/MemberJoin.js"></script>

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
					<input type="text" class="chk idchk" name="m_id" title="아이디" size="30"
						placeholder="아이디는 영어만 가능합니다." oninput="handleOnInput(this)" >
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
					<input type="text" id="phone" class="chk" value="010" readonly="readonly" size="5"/>-
			        <input type='text' id="phoneNum" class="chk" name="m_phone" size="30" title="전화번호"/>
			        <font id="phoneCheck" size="2" color="green" class="possible"></font>
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
			
			<div class="regisBox">
				<p class="col4">*비밀번호 힌트</p>
				<span>
					<select name="m_quest" class="hint">
						<option value="당신의 보물 1호는?">당신의 보물 1호는?</option>
						<option value="가장 기억에 남는 선생님 이름은?">가장 기억에 남는 선생님 이름은?</option>
						<option value="direct">직접 입력</option>
					</select>
					<input type="text" name="direct_quest" size="25" title="비밀번호 힌트">
				</span>
			</div>
			
			<div class="clear"></div>
			
			<div class="regisBox">
				<p class="col4">*힌트 답</p>
				<span>
					<input type="text" class="chk" name="m_answer" size="25" title="비밀번호 힌트 답">
				</span>
			</div>
			
			<div class="clear"></div>
		</div>
		<div id="joinBtn">
			<button class="m_join" type="button">회원가입</button>
			<button type="reset">다시쓰기</button>
        </div>
	</form>
</div>
