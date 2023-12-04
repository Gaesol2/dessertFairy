<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/Notice.css">
<script src="/script/Notice.js"></script>

<div id="notice">
	<form action="/noticeProc" name="topForm" method="post" class="ganerateForm">
		<div>
			<p class="noList">공지사항등록</p>  
		</div>
		<div id="ganerateList">
			<table class="ganerate">
				<tbody>
					<tr class="nl">
						<td class="nl1">제목</td>
						<td class="nl2">
							<input type="text" name="n_subject" class="chk in" title="제목" size="52">
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">작성자</td>
						<td class="nl2">
							<input type="text" name="n_writer" readonly="readonly" class="chk in" title="작성자" value="${ssKey.m_name}" size="3">
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">내용</td>
						<td class="nl2">
							<textarea class="chk" title="공지사항 내용" name="n_content" ></textarea>
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">공지시작</td>
						<td class="nl2">
							<input type="date"  name="n_regdate" class="chk in" title="시작일"  id="startDate" required>  
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">공지종료</td>
						<td class="nl2">
							<input type="date"  name="n_vdate" class="chk in" title="종료일"  id="startDate" required>  
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="line"></div>
			
			<div id="noticeBtnBox">
				<button class="noticeBtn" type="button">공지사항 등록</button>
				<button class="ganerateBtn" type="button" onclick="location.href='notice'">공지사항 목록</button>
			</div>
		</div>
		<input type="hidden" name="flag" value="insert">
	</form>
</div>
