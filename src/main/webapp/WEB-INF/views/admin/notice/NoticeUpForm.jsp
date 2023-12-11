<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/Notice.css">
<script src="/script/Notice.js"></script>

<div id="notice">
	<form action="" name="topForm" method="post" class="ganerateForm">
	<input type="hidden" name="n_no" readonly="readonly" value="${notice.n_no}">
		<div>
			<p class="noList">공지사항수정</p>  
		</div>
		<div id="ganerateList">
			<table class="ganerate">
				<tbody>
					
					<tr class="nl">
						<td class="nl1">제목</td>
						<td class="nl2">
							<input type="text" name="n_subject" class="chk in" title="제목" size="85" value="${notice.n_subject}">
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">작성자</td>
						<td class="nl2">
							<input type="text" name="n_writer" readonly="readonly" class="chk in" title="작성자" value="${notice.n_writer}" size="85">
						</td>
					</tr>
					<tr class="nl">
						<td class="nl1">내용</td>
						<td class="nl2">
							<textarea class="chk" title="공지사항 내용" name="n_content" >${notice.n_content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="line"></div>
			
			<div id="noticeBtnBox">
				<button type="button" class="submit nDetailBtn">공지사항 수정</button>
                <button type="button" class="nDetailBtn" onclick="location.href='notice'">공지사항 목록</button>
			</div>
		</div>
		<input type="hidden" name="flag" value="insert">
	</form>
</div>
