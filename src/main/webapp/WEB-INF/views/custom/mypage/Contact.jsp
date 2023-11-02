<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/notice.css">
    <script type="text/javascript" src="/script/notice.js"></script>
<meta charset="UTF-8">
</head>
<body>
<div>
<form action="noticeProc" name="topForm1" method="post" >
<table class="noticeForm">
 <thead>
 <tr>
  <th colspan="2">공지사항등록</th>
 </tr>
 </thead>
 <tbody>
  <tr>
   <td class="col1">공지사항번호</td>
   <td class="col2">
   <input type="text"  name="noti_no" class="chk1" readonly="readonly"
   value="${notice.noti_no}">
   </td>
  </tr>
   <tr>
   <td class="col1">제목</td>
   <td class="col2">
   <input type="text"  name="subject" readonly="readonly"
    value="${notice.subject}">
   </td>
  </tr>
  <tr>
   <td class="col1">작성자</td>
   <td class="col2">
   <input type="text"  name="writer"  value=""${notice.writer}">
   </td>
  </tr>
   <tr>
   <td class="col1">내용</td>
   <td class="col2">
   <textarea readonly="readonly"  rows="10" cols="70" name="content" style="resize: none;" style="resize:none;">${notice.content}</textarea>
   </td>
   </tr>
  <tr>
   <td class="col1">작성일자</td>
   <td class="col2">
   <input type="text" name="regdate" readonly="readonly" value="${notice.regdate}">
   </td>
   <td class="col3">종료일을 선택하시오</td>
  </tr>
  <tr>
   <td class="col1">공지종료</td>
   <td class="col2">
   <input type="date" name="vdate" class="chk1" title="종료일" readonly="readonly" value="${notice.vdate}">
   </td>
  </tr>
  </tbody>
  <tfoot>
   <tr> 
    <td colspan="3">
     <button type="button"
             onclick="location.href='/notice'">공지사항목록</button>
     </td>
   </tr>
  </tfoot>
</table>
<input type="hidden" name="flag" value="insert">
</form>
</div>
</body>
</html>