<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토리뷰</title>
<link rel="stylesheet" type="text/css" href="/css/star.css">
<link rel="stylesheet" type="text/css" href="/css/Reviewcontent.css">
<script src="/script/Review.js"></script>
</head>
<body>
<div id="review">
   <div id="top">
    <div class="Mainlist">
		<p class="reviewname">상점관리</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li class="relist"><a href="/shopMgt">후기 목록</a></li>
        <li><a href="/reviewWrite">배너 변경</a></li>
      </ul>
    </div>
  </div>
<form action="replyWriteProc" name="replyForm" method="post">
   <table class="reviewtable">
      <tr>
         <th>제목</th>
         <td><input type="text" name="r_subject" readonly="readonly" 
                    value="${review.r_subject}" class="chkb" size="51"></td>
      </tr>
      <tr>
         <th>작성자</th>
         <td><input type="text" name="m_id" readonly="readonly" 
                    value="${review.m_id}" class="chkb" size="51"></td>
      </tr>
      <tr>
         <th>이미지</th>
         <td><img src="/upload/${review.r_image}" width="400" height="300"></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><textarea class="chkb" readonly="readonly" 
                      rows="20" cols="50">${review.r_content}</textarea></td>
      </tr>
      <tr>
         <th>별점</th>
         <td class="mb-3" title="별점" class="chkb">
				<input type="text" readonly="readonly" name="r_star"
				    value="${ratings}" class="chkb">
         </td>
      </tr>
   </table>
	<div id="replybox">
		<table class="replytable">
			<tr>
				<th>사장님 답글</th>
			</tr>
			<tr class="replycontent">
		         <td>
		         	<textarea class="replys" name="r_reply" placeholder="아직 답글이 없습니다.">${review.r_reply}</textarea>
		         </td>
		    </tr>
		    <c:choose>
		    	<c:when test="${review.r_reply == null}">
					<tr class="reviewBtn">
			            <td colspan="2">
							<button type="button" class="writeSubmit">답글 등록</button>
			            </td>
			     	</tr>		    
		    	</c:when>
		    	
		    	<c:when test="${review.r_reply != null}">
					<tr class="reviewBtn">
			            <td colspan="2">
							<button type="button" class="replyUpdate">답글 수정</button>
							<button type="button" class="replyDel">답글 삭제</button>
			            </td>
			     	</tr>		    
		    	</c:when>
		    </c:choose>
		</table>
	</div>
	<input type="hidden" name="r_no" value="${review.r_no}">
</form>
</div>
</body>
</html>