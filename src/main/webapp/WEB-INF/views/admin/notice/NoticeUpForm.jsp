<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/notice.css">
<script src="/script/Notice.js"></script>
<script src="/jquery/jquery-3.7.0.min.js"></script>
<body>
	<form action="" name="topForm" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">공지사항수정</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="cl1">공지사항번호</td>
					<td class="cl2">
						<input type="text" name="n_no" readonly="readonly" value="${notice.n_no}">
					</td>
				</tr>
				<tr>
					<td class="cl1">제목</td>
					<td class="cl2">
						<input type="text" name="n_subject" class="chk" title="공지사항제목" value="${notice.n_subject}">
					</td>
				</tr>
				<tr>
					<td class="cl1">작성자</td>
					<td class="cl2">
						<input type="text" name="n_writer" value="${notice.n_writer}">
					</td>
				</tr>
				<tr>
					<td class="cl1">내용</td>
					<td class="cl2">
						<textarea class="chk" title="공지사항내용" rows="10" cols="60" name="n_content" style="resize: none;">${notice.n_content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="cl1">작성일자</td>
					<td class="cl2">
						<input type="text" name="n_regdate" disabled="disabled" value="${notice.n_regdate}">
					</td>
				</tr>
				<tr>
					<td class="cl1">공지종료</td>
					<td class="cl2">
						<input type="date" name="n_vdate" class="chk" title="공지종료일" value="${notice.n_vdate}">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<button type="button" class="submit">공지사항 수정</button>
						<button type="button" onclick="location.href='notice'">공지사항 목록</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>