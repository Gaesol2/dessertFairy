<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/notice.css">
</head>
<div id="mypage">
  <div id="top">
    <div class="mypagelist">
		<p class="introduction">문의하기</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="/myPage">내 정보</a></li>
        <li><a href="/cartList">장바구니</a></li>
        <li><a href="/orderList">주문목록</a></li>
        <li><a href="/contactList">문의하기</a></li>
      </ul>
    </div>
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
</div>