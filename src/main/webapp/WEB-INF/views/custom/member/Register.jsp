<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/common.css">
<script src="/jquery/jquery-3.7.0.min.js"></script>
<script src="/script/zipCheck.js"></script>
<script src="/script/MemberJoin.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<form action="register" name="joinForm" method="post">
	<table>
		<thead>
			<tr>
				<th>회원 가입</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="idchk" class="chk" name="m_id" title="아이디" 
					placeholder="아이디를 입력하시오.">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="check1" class="chk" name="m_passwd" title="비밀번호" 
					placeholder="비밀번호를 입력하시오.">
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type="password" id="check2" class="chk" name="m_rePasswd" title="비밀번호 확인" 
					placeholder="비밀번호를 확인하시오.">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" class="chk" name="m_name" title="이름" 
					placeholder="고객 실명을 입력하시오.">
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="m_email" title="이메일" 
					placeholder="이메일을 입력하시오.">
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input type="text" class="chk" name="m_phone" title="전화번호" 
					placeholder="전화번호를 입력하시오.(010-1111-1234)">
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<input type="text" class="chk" name="m_zipcode" title="우편번호" readonly="readonly" 
					placeholder="우편번호를 검색하시오." id="sample6_postcode">
					<button type="button" onclick="zipCheck()">우편번호 찾기</button>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" class="chk" name="m_address" title="주소" 
					placeholder="주소">
				</td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td>
					<input type="text" class="chk" name="m_address2" title="상세주소" 
					placeholder="상세주소를 입력하시오.">
				</td>
			</tr>
		</tbody>
		
		<tfoot>
			<tr>
				<td>
					<button class="m_join" type="button">회원가입</button>
					<button type="reset">다시쓰기</button>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
