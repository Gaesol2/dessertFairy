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
<link rel="stylesheet" type="text/css" href="/css/Review.css">
<script src="/script/Review.js"></script>
</head>
<body>
<div id="review">
   <form action="" name="reviewForm" id="upForm" method="post">
   <input type="hidden" name="r_no" value="${review.r_no}">
      <div>
          <div class="mainList">
            <p class="reviewName">포토후기</p>
          </div>
          <div class="topList">
            <ul class="list">
              <li><a href="/reviewList">후기 목록</a></li>
              <li><a href="/reviewWrite">후기 글쓰기</a></li>
              <li><a href="/mylist">내 글보기</a></li>
            </ul>
          </div>
       </div>
       <div id="Contentreview">
        <div id="contentMain">
               <span class="contentStar" title="별점" class="chkb">
                  <c:choose>
                  <c:when test = "${ratings}=='★★★★★'">
                     <input type="hidden" name="r_star" value="5">
                  </c:when>
                  <c:when test = "${ratings}=='★★★★☆'">
                     <input type="hidden" name="r_star" value="4">
                  </c:when>
                  <c:when test = "${ratings}=='★★★☆☆'">
                     <input type="hidden" name="r_star" value="3">
                  </c:when>
                  <c:when test = "${ratings}=='★★☆☆☆'">
                     <input type="hidden" name="r_star" value="2">
                  </c:when>
                  <c:otherwise>
                     <input type="hidden" name="r_star" value="1">
                  </c:otherwise>
                  </c:choose>
                  <input type="text" readonly="readonly" value="${ratings}">
               </span>
               
               <span class="contentSubject">${review.r_subject}
                  <input type="hidden" name="r_subject" readonly="readonly" value="${review.r_subject}" class="chkb" size="40">
               </span>
               
               <span class="contentWrite">${review.m_id}
                  <input type="hidden" name="m_id" readonly="readonly" value="${review.m_id}" class="chkb" size="15">
               </span>
               
               <span class="contentRegdate">${review.r_regdate}
                  <input type="hidden" name="r_regdate" readonly="readonly" value="${review.r_regdate}" class="chkb" size="10">
               </span>
               
        </div>
        <div id="contentMiddle">
           <div>
                 <img src="/upload/${review.r_image}" width="500">
           </div>
        </div>
        <div id="contentBottom">
              <span class="contentContent">${review.r_content}
                <input type="hidden" name="r_content" readonly="readonly" value="${review.r_content}" class="chkb" size="10">
              </span>
        </div>
        <div id="contentPasswd">
                <input type="password" name="r_passwd" readonly="readonly" value="${review.r_passwd}" class="chkb in" size="10">
        </div>
      </div>

      <div id="replybox">
               <p class="adminReply">사장님 답글</p>
               <span class="replycontent">
                     <input type="text" class="replys" name="r_reply"
                         value="${review.r_reply}" placeholder="아직 답글이 없습니다." readonly="readonly">
                </span>
      </div>
      <div id="myBtn">
      		<c:if test="${ssKey.m_role == 'mem'}">
	           <button type="button" name="update" class="reviewUp" onclick="update('u')">수정</button>
	           <button type="button" name="delete" class="reviewDel" onclick="update('d')">삭제</button>
	        </c:if>
      </div>
   </form>
</div>
</body>
</html>