<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<meta charset="UTF-8">    
<link rel="stylesheet" type="text/css" href="/css/Notice.css">
<script src="/script/Notice.js"></script>

<div id="notice">
	<div class="head">
		<p class="noList">공지사항</p>          
	</div>
	<div id="customNoticeList">
		<p class="count">총 등록글수:${cnt} </p>
		<table class="noticeTable">
			<tr>
				<th class="nol1">번호</th>
				<th class="nol2">제목</th>
				<th class="nol3">작성자</th>
				<th class="nol4">조회수</th>
				<th class="nol5">등록일</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(nList)>0}">
					<c:forEach var="notice" items="${nList}" varStatus="i">
						<tr>
							<td class="nol1">${notice.n_rr}
								<input type="hidden" value="${notice.n_no}">
							</td>
							<td class="nol2"><a class="noticeLink" href="/noticeDetail?n_no=${notice.n_no}">${notice.n_subject}</a></td>
							<td class="nol3" style="text-align: center;">${notice.n_writer}</td>
							<td class="nol4 price">${notice.n_readcount}</td>
							<td class="nol5">${notice.n_regdate}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:when test="${fn:length(nList)==0}">
					<tr class="notList">
						<th colspan="6">등록된 글이없습니다.</th>
					</tr>
				</c:when>
			</c:choose>
		</table>
		<table class="pageBtn">
			<tr>
				<td colspan="6">
					<c:if test="${pdto.startPg>pBlock}">
						<a href="notice?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						<a href="notice?curPage=${p}&curBlock=${pdto.curBlock}">
							<span><c:out value="${p}" /></span>
						</a>&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${pdto.endPg<pdto.pgCnt}">
						<a href="notice?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<form action="" name="content" method="post">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="curPage" value="${pdto.curPage}">
			<input type="hidden" name="curBlock" value="${pdto.curBlock}">
		</form>
	</div>
</div>