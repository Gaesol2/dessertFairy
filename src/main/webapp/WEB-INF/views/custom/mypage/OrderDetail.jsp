<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id = "order">
	<div id = "OrderDetail">
		<p>${DetailList[0].m_name}님 상세 주문 내역</p>
	</div>
	
	<div class="ordList"><a href = "/orderList">주문목록으로</a></div>
	
	<form action="updateOrder" name="orderDetailForm" method="post">
 			
		<div id="orderDetailBox">
			<div id="orderDetailMain">
				
				<c:forEach var="odto" items="${DetailList}">
				<div class="oll">
					<span class="ol2">
						<img src="/upload/${odto.d_image}" class="orderImg">
					</span>
				</div>
				<div class="oll">
					<p class="ol1">주문번호</p>
					<span class="ol2">
						<input type="text" class="in" name="o_no" readonly="readonly" value="${DetailList[0].o_no}"size="5">
					</span>
				</div>
				<div class="oll">
					<p class="ol1">상품명</p>
					<span class="ol2">
						<input type="text" class="in" name="d_name" readonly="readonly" value="${odto.d_name}"size="35">
					</span>
				</div>
				<div class="oll">
					<p class="ol1">단가</p>
					<span class="ol2">
						<input type="text" class="in" name="o_price" readonly="readonly" value="${odto.o_price}"size="10">원
					</span>
				</div>
				<div class="oll">
					<p class="ol1">구매수량</p>
					<span class="ol2">
						<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_quantity}"size="5">
					</span>
				</div>	
				<div class="oll">
					<p class="ol1">합 계</p>
					<span class="ol2">
						<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_amount}"size="5">
					</span>
				</div>	
				<div class="line"></div>
				<input type="hidden" name="state" value="${odto.o_state}">
				<c:set var="total" value="${total + odto.o_amount}" />
				</c:forEach>
				
				<div class="oll">
					<p class="ol1">결제금액</p>
					<span class="ol2">
						<input type="text" class="in" name="o_amount" readonly="readonly" value="${DetailList[0].o_totalprice}"size="10">원
					</span>
				</div>
				<div class="oll">
					<p class="ol1">고객정보</p>
					<span class="ol2">
						<input type="text" class="in" name="m_name" readonly="readonly" value="${DetailList[0].m_name}(${DetailList[0].m_id})"size="35">
					</span>
				</div>
				<div class="oll">
					<p class="ol1">배송상태</p>
					 <c:choose>
	                     <c:when test="${DetailList[0].o_state==1}">결제중</c:when>
	                     <c:when test="${DetailList[0].o_state==2}">배송준비</c:when>
	                     <c:when test="${DetailList[0].o_state==3}">배송중</c:when>
	                     <c:when test="${DetailList[0].o_state==4}">배송완료</c:when>
	                     <c:when test="${DetailList[0].o_state==5}">구매확정</c:when>
	                   </c:choose>
				</div>
			</div>
		</div>
	</form>
	<div id="order_button">
		<c:if test="${DetailList[0].o_state==1}">
			<form action="orderListPay" method="post" name="onoForm1" class="orderListPay">
				<input type="hidden" name="o_no" value="${DetailList[0].o_no}">
				<input class="button" type="submit" value="결제하기">
			</form>
			<form action="orderCancel" method="post" name="onoForm1">
				<input type="hidden" name="o_no" value="${DetailList[0].o_no}">
				<input class="button" type="submit" value="주문 취소하기">
			</form>
		</c:if>
	</div>
</div>
