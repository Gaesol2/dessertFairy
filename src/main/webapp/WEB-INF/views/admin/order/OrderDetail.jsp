<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>상세 주문 내역</title>
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id = "order">
	<div id = "adminOrderDetail">
		<p>${odto.m_id}님 상세 주문 내역</p>
	</div>
	<div class="ordList"><a href = "/orderMgt">주문목록으로</a></div>
	<form action="updateOrder" name="orderDetailForm" method="post">
		<div id="adminOrderMain">
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
					<select name="o_state" id="state">
						<option value="1">결재중</option>
						<option value="2">배송준비</option>
						<option value="3">배송중</option>
						<option value="4">배송완료</option>
						<option value="5">구매확정</option>
					</select>
					<script type="text/javascript">
		               $(function(){
		            	   //배송관련 상태
		            	   $("#state").val('${odto.o_state}')
		               })
		            </script>
			</div>
			<div>
				<input type="submit" value="상태수정" class="stateUpBtn orderBtn">
			</div>
		</div>
	</form>
</div>
