<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>상세 주문 내역</title>
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>
<div id ="order">
	<div id="orderName">
		<p class="memOrderDetail" name="m_id">${odto.m_name}님의 상세 주문 내역</p>
	</div>
	<div id="order_detail_head">
		<div id="orderDetail_img">
			<img src="/upload/${odto.d_image}" height="350px" width="350px">
		</div>
		<div id="orderMain">
			<div class="ol">
				<p class="ol1">주문번호</p>
				<span class="ol2">
	                  <input type="text" class="in" name="o_no" readonly="readonly" value="${odto.o_no}"size="5">
	            </span>
			</div>
			<div class="ol">
				<p class="ol1">상품명</p>
				<span class="ol2">
					<input type="text" class="in" name="d_name" readonly="readonly" value="${odto.d_name}"size="30">
				</span>
			</div>
			<div class="ol">
				<p class="ol1">단가</p>
				<span class="ol2">
					<input type="text" class="price in" name="o_price" readonly="readonly" value="${odto.o_price}"size="10">원
				</span>
			</div>
			<div class="ol">
				<p class="ol1">구매수량</p>
				<span class="ol2">
					<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_quantity}"size="5">
				</span>
			</div>
			<div class="ol">
				<p class="ol1">결제금액</p>
				<span class="ol2">
					<input type="text" class="price in" name="o_amount" readonly="readonly" value="${odto.o_amount}"size="10">원
				</span>
			</div>
			<div class="ol">
				<p class="ol1">고객정보</p>
				<span class="ol2">
					<input type="text" class="in" name="m_name" readonly="readonly" value="${odto.m_name}(${odto.m_id})"size="30">
				</span>
			</div>
			<div class="ol">
				<p class="ol1">배송상태</p>
				<span class="odl">
					<c:choose>
	                  <c:when test="${odto.o_state==1}">결제중</c:when>
	                  <c:when test="${odto.o_state==2}">배송준비</c:when>
	                  <c:when test="${odto.o_state==3}">배송중</c:when>
	                  <c:when test="${odto.o_state==4}">배송완료</c:when>
	                  <c:when test="${odto.o_state==5}">구매확정</c:when>
	                </c:choose>
				</span>
			</div>
			<div class="ol">
				<a href = "/orderList"><input type="button" value="주문목록으로" class="orderBtn"></a>
			</div>
		</div>
	</div>
</div>
