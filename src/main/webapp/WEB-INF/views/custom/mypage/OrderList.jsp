<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/DessertOrder.css">
</head>
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>
<div id="mypage">
	<div>
		<div id="mypageList">
			<p class="introduction">주문목록</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li class="reList"><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
	
	<div class="total">
      <ul class="list">
        <li>총 상품수: ${oCnt} 가지</li>
      </ul>
    </div>
	<div id="orderList">
		
		<table class="orderTable">
			<tr>
				<th>주문 번호</th>
				<th>상품번호</th>
				<th>가격</th>
				<th>수량</th>
				<th>총금액</th>
				<th>주문일</th>
				<th>배송상태</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(oList)>0}">
					<c:forEach var="order" items="${oList}">
						<tr>
							<td class="dol1">${ordert.o_no}</td>
							<td class="dol3"><a href="/productDetail?d_no=${ordert.d_no}">${ordert.d_no}</a></td>
							<td class="dol4">${ordert.o_price}</td>
							<td class="price dol5">${ordert.quantity}</td>
							<td class="dol6">${ordert.o_amount}</td>
							<td class="dol6">${ordert.o_regdate}</td>
							<td class="dol6">${ordert.o_state}</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${fn:length(oList)==0}">
					<tr style="text-align:center;height: 30px;">
						<th colspan="5"> 등록된 주문내역이 없습니다.</th>
					</tr>
				</c:when>
			</c:choose>
		</table>
		<table class="pageBtn">
			<tr>
				<td colspan="5">
					<c:if test="${pdto.startPg>pBlock}">
						<a href="productMgt?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						<a href="productMgt?curPage=${p}&curBlock=${pdto.curBlock}">
							<span><c:out value="${p}" /></span>
						</a>&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${pdto.endPg<pdto.pgCnt}">
						<a href="productMgt?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<form action="" name="content" method="post">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="curPage" value="${pageDto.curPage}">
			<input type="hidden" name="curBlock" value="${pageDto.curBlock}">
		</form>
	</div>
</div>