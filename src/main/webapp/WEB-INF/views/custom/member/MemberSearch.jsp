<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/MemberSearch.css">
<script src="/script/MemberSearch.js"></script>
<div class="Membersearch_box">	<!-- tabmenu -->
<div onload="document.getElementById('t1').click();">
	<ul>
		<li id="id_tab" class="search_box">	<!-- btnCon -->
			<a href="#id_tab" id="t1">아이디 찾기</a>
			<div class="tabCon">
				<div id="search_Form_box">	<!-- lage_login_box -->
					<form action="memberSearchProc" method="post" name="idSearchForm">
						<table>
							<tr>
								<td>
									<input type="text" name="m_name" title="이름" class="idSearchChk"  placeholder="이름을 입력하시오."><br>
									<input type="text" name="m_phone" title="전화번호" class="idSearchChk"  placeholder="전화번호를 입력하시오.">
								</td>
							</tr>
							<tr>
								<td>
									<div id="idSearch">
										<div id="search_Btn">아이디 찾기</div>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</li>

		<li id="pw_tab" class="search_box">	<!-- btnCon -->
			<a href="#pw_tab">비밀번호 찾기</a>
			<div class="tabcon">
				<div id="search_Form_box">		<!-- lage_login_box -->
					<form action="memberSearchProc" method="post" name="pwSearchForm">
						<table>
							<tr>
								<td>
									<input type="text" name="m_id" title="아이디" placeholder="아이디를 입력하시오."><br>
									<input type="password" name="m_passwd" id="password" class="pwSearchChk" title="비밀번호" placeholder="비밀번호를 입력하시오.">
									<font id="pcombiCheck" size="2" color="green" class="possible"></font><br>
									<input type="password" name="m_passwd2" id="cpassword"  class="pwSearchChk" title="비밀번호 확인" placeholder="비밀번호를 확인">
									<font id="pcheck" size="2" color="green" class="possible"></font>
								</td>
							</tr>
							<tr>
								<td>
									<div id="pwChange">
										<div id="search_Btn">새 비밀번호 설정</div>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</li>
	</ul>
</div>
</div>
