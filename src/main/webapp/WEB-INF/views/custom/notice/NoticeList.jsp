<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<meta charset="UTF-8">    
<title>쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="/css/notice.css">
</head>
 <script src="/script/Notice.js"></script>
 <script src="/jquery/jquery-3.7.0.min.js"></script>
	  <div class="clear"></div>
	  <div id="notice">
   <div class="head">
          <p style="text-align: center; font-size: 30px;">공지사항목록</p>          
          <p style="padding: 5px;
                    margin-right: 5px;
                    text-align: right;
                    padding-right: 10px;
                    font-size: 16px;">총 등록글수:${totCnt} </p>
    </div>
   <table class="noticelist">
      <tr>
      <tr style="height: 50px;" class="headcolor">
        <th>순서</th>
        <th>공지사항제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>등록일</th>
        <th>유효일</th>
      </tr>
      <c:choose>
         <c:when test="${fn:length(nList)>0}">
           <c:forEach var="notice" items="${nList}" varStatus="i">
               <tr>
                   <td class="coli1">${notice.rr}
                      <input type="hidden" value="${notice.n_no}">
                    </td>
                  <td class="coli4"><a href="/noticeDetail?n_no=${notice.n_no}">${notice.n_subject}</a></td>
                  <td class="coli4" style="text-align: center;">${notice.n_writer}</td>
                  <td class="coli1 price">${notice.n_readcount}</td>
                  <td class="coli3">${notice.n_regdate}</td>
                  <td class="coli3">${notice.n_vdate}</td>
               </tr>
           </c:forEach>
         </c:when>
         <c:when test="${fn:length(nList)==0}">
         <tr style="text-align: center;" height= "30px;">
           <th colspan="6">등록된 글이없습니다.</th>
         </tr>
         </c:when>
      </c:choose>
      <tr style="text-align: right;height: 30px;">
      <th colspan="6" style="text-align: right; border: 1px solid #ffffff;">
      </th>
      </tr>
     <tfoot>
        <tr>
            <td colspan="6" style="text-align: center; border: 1px solid #ffffff;">
               <c:if test="${pageDto.startPg>pBlock}">
                  <a href="notice?curPage=${pageDto.startPg-pBlock}&curBlock=${pageDto.curBlock-1}">[이전]</a>
               </c:if>
            <c:forEach begin="${pageDto.startPg}" end="${pageDto.endPg}" var="p" step="1">
                  <a href="notice?curPage=${p}&curBlock=${pageDto.curBlock}">
                  <span><c:out value="${p}"/></span>
                  </a>&nbsp;&nbsp;
            </c:forEach>
               <c:if test="${pageDto.endPg<pageDto.pgCnt}">
                 <a href="notice?curPage=${pageDto.startPg+pBlock}&curBlock=${pageDto.curBlock+1}">[다음]</a>
               </c:if>  
            </td>
        </tr>
      </tfoot>
   </table>
  </div>
</html>




