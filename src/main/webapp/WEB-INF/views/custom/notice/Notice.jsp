<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/Notice.css">
<script src="/script/Notice.js"></script>

<div id="notice">
	<input type="hidden" name="n_no" readonly="readonly" value="${notice.n_no}">
		<div>
			<p class="noList">공지사항내용</p>  
		</div>
		<div id="noticeDetailList">
			<table class="noticeDetailTable">
				<tbody>
					<tr class="nl">
						<td class="nl1">제목</td>
						<td class="nl2">
							<input type="text" name="n_subject" readonly="readonly" class="chk in" title="제목" size="85" value="${notice.n_subject}">
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">작성자</td>
						<td class="nl2">
							<input type="text" name="n_writer" class="chk in" readonly="readonly" value="${notice.n_writer}" size="85">

						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">내용</td>
						<td class="nl2">
							<textarea class="chk in" rows="10" cols="60" name="n_content" readonly="readonly">${notice.n_content}</textarea>

						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="line"></div>
			
			<div id="notiBtnBox">
				  <button type="button" class="notiBtn" onclick="location.href='/notice'">공지사항 목록</button>
			</div>
		</div>
		<input type="hidden" name="flag" value="insert">
</div>