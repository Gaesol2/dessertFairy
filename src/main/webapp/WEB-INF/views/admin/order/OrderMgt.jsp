<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<meta charset="UTF-8">
<title>전체 주문 내역 리스트</title>
</head>
<script src="/script/Order.js"></script>
<div id = "orders">
	<div id = "orders_head">
		<p>${ssKey.m_name}님 주문 내역</p>
		<p>총 주문 내역 : ${orderTot} 건</p>
	</div>
	
	<table>
		<tr>
			<th>선택</th>
			<th>주문번호</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>회원 아이디</th>
			<th>주문수량</th>
			<th>단가</th>
			<th>결제금액</th>
			<th>결제일</th>
			<th>주문상태</th>
		</tr>
		
		<c:choose>
			<c:when test="${fn:length(orderList)>0}">
				<c:forEach var = "order" items = "${orderList}" varStatus = "i">
					<tr>
						<td><input type="checkbox" name="check" value = "${i.index}" readonly="readonly"></td>
						<td>${order.o_no}</td>
						<td>${order.d_no}</td>
						<td><a onclick="javascript:orderDetail(this)">${order.d_name}</a></td>
						<td>${order.m_id}</td>
						<td>${order.o_quantity}</td>
						<td>${order.o_price}</td>
						<td>${order.o_amount}</td>
						<td>${order.o_regdate}</td>
						<td>
							<select name="state" id="state${i.count}">
								<option value="1">결제중</option>
								<option value="1">배송준비</option>
								<option value="1">배송중</option>
								<option value="1">배송완료</option>
								<option value="1">구매확정</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			
			<c:when test="${fn:length(orderList)==0}">
				<tr><th>주문내역이 없습니다.</th></tr>
			</c:when>
		</c:choose>
		<tr><th><input type="button" name="orderUpBtn" value="상태수정"></th></tr>
	</table>
</div>

<form action="orderDetail" method="post" name="orDetailForm">
	<input type="hidden" name="d_no" value="${order.d_no}">
    <input type="hidden" name="o_no" value="${order.o_no}">
	<input type="hidden" name="m_id" value="${order.m_id}">
</form>