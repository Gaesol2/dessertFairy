<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<div id="mCount">
		총 회원수 : &nbsp;${memberTot}
	</div>
	
	<div id="mList">
		<c:choose>
			<c:when test="${memberTot==0}">
				<h2>아직 회원이 없습니다.</h2>
			</c:when>
			
			<c:when test="${memberTot>0}">
				<table>
					<tr>
						<th>회원 아이디</th>
						<th>회원 이름</th>
						<th>가입일</th>
						<th>권한</th>
					</tr>
					
					<c:forEach var="member" items="${members}">
						<tr>
							<td><a href="/memberDetail?m_id=${member.m_id}">${member.m_id}</a></td>
							<td>${member.m_name}</td>
							<td>${member.m_regdate}</td>
							<td>${member.m_role}</td>
						</tr>
					</c:forEach>
					<table class="pageBtn">
					   <tr>
						<td colspan="6">
						  <c:if test="${pdto.startPg>pBlock}">
						   <a href="memberMgt?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
						 </c:if>
						 <c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						   <a href="memberMgt?curPage=${p}&curBlock=${pdto.curBlock}">
						     <span><c:out value="${p}" /></span>
						   </a>&nbsp;&nbsp;
						 </c:forEach>
						 	  <c:if test="${pdto.endPg<pageDto.pgCnt}">
						    	<a href="memberMgt?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
						    </c:if>
						</td>
					  </tr>
					</table>
					<form action="" name="content" method="post">
						<input type="hidden" name="bno" value="">
						<input type="hidden" name="curPage" value="${pdto.curPage}">
						<input type="hidden" name="curBlock" value="${pdto.curBlock}">
					</form>
				</table>
			</c:when>		
		</c:choose>
	</div>
</body>
</html>