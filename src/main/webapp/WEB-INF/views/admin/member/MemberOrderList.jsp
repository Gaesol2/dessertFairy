<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Member.css">
<script src="/script/Order.js"></script>

<div id="member">
	<h2 class="memName">${m_id}님의 주문목록</h2>

	<div id="memTot">
		총 상품수: ${oCnt} 가지
	</div>
	<div id="orderList">
		<div id="memlist">
			<a href= "/memberMgt" class="mmlist">회원 목록</a>
		</div>
		<table class="orderTable">
			<tr>
				<th class="mml1">주문 번호</th>
				<th class="mml2">상품번호</th>
				<th class="mml3">상품명</th>
				<th class="mml4">가격</th>
				<th class="mml5">수량</th>
				<th class="mml6">총금액</th>
				<th class="mml7">주문일</th>
				<th class="mml8">배송상태</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(orderList)>0}">
					<c:forEach var="order" items="${orderList}">
						<tr>
							<td class="mml1">${order.o_no}</td>
							<td class="mml2">${order.d_no}</td>
							<td class="mml3"><a onclick="javascript:orderDetail(this)">${order.d_name}</a>
								<input type="hidden" name="d_no" value="${order.d_no}">
								<input type="hidden" name="o_no" value="${order.o_no}">
								<input type="hidden" name="m_id" value="${order.m_id}">
							</td>
							<td class="price mml4">${order.o_price}</td>
							<td class="mml5">${order.o_quantity}</td>
							<td class="price mml6">${order.o_amount}</td>
							<td class="mml7">${order.o_regdate}</td>
							<td class="mml8">
							<c:choose>
								<c:when test="${order.o_state==1}">결제중</c:when>
								<c:when test="${order.o_state==2}">배송준비</c:when>
								<c:when test="${order.o_state==3}">배송중</c:when>
								<c:when test="${order.o_state==4}">배송완료</c:when>
								<c:when test="${order.o_state==5}">구매확정</c:when>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:when test="${fn:length(orderList)==0}">
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
						<a href="orderList?curPage=${p}&curBlock=${pdto.curBlock}">
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
			<input type="hidden" name="curPage" value="${pdto.curPage}">
			<input type="hidden" name="curBlock" value="${pdto.curBlock}">
		</form>
	</div>

	<form action="mOrderDetail" method="post" name="orDetailForm">
		<input type="hidden" name="d_no" value="${order.d_no}">
		<input type="hidden" name="o_no" value="${order.o_no}">
		<input type="hidden" name="m_id" value="${order.m_id}">
	</form>
</div>