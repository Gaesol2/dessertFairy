<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>상세 주문 내역</title>
<div id = "order_detail_box">
	<div id = "order_detail_head">
		<p>${odto.m_name}님의 상세 주문 내역</p>
	</div>
	
	<table>
		<tr>
			<th>주문번호</th>
			<td>${odto.o_no}</td>
		</tr>
		
		<tr>
			<th>상품명</th>
			<td>${odto.d_name}</td>
		</tr>
		<tr>
			<th>단가</th>
			<td class = "price">${odto.o_price}</td>
		</tr>
		<tr>
			<th>구매수량</th>
			<td class = "price">${odto.o_quantity}</td>
		</tr>
		<tr>
			<th>결제금액</th>
			<td class = "price">${odto.o_amount}</td>
		</tr>
		<tr>
			<th>고객정보</th>
			<td>${odto.m_name}(${odto.m_id})</td>
		</tr>
		<tr>
			<th>배송상태</th>
			<td>
				<c:choose>
					<c:when test="${odto.o_state==1}">결제중</c:when>
					<c:when test="${odto.o_state==2}">배송준비</c:when>
					<c:when test="${odto.o_state==3}">배송중</c:when>
					<c:when test="${odto.o_state==4}">배송완료</c:when>
					<c:when test="${odto.o_state==5}">구매확정</c:when>
				</c:choose>
			</td>
		</tr>
		
		<tr>
			<th>
				<a href = "/orderList"><input type="button" value="주문목록으로"></a>
			</th>
		</tr>
	</table>
</div>
