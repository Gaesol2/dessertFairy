<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토리뷰</title>
</head>
<body>
<form action="reviewWriteProc" name="ReviewWriteForm" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="r_subject"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="m_id" disabled="disabled"></td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="file" name="m_id"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="r_content"></textarea></td>
		</tr>
		<tr>
			<td>별점</td>
			<td><input type="text" name="r_subject"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="r_passwd"></td>
		</tr>
		<tr>
			<td><input type="button" value="등록"></td>
		</tr>
	</table>
</form>
</body>
</html>