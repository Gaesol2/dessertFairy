<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Cart.css">
<script src="/script/Cart.js"></script>

<div id="cart">
	<div>
		<div id="cartList">
			<p class="introduction">장바구니</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li class="reList"><a href="/cartList">장바구니</a></li>
				<li><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
	<div id="cartContent">
		<form action="orderProc" method="post">
			<c:choose>
				<c:when test="${fn:length(hCartList)==0}">
					<p>장바구니 목록이 없습니다.</p>
				</c:when>
				<c:when test="${hCartList!=null}">
					<p>총 <strong>${fn:length(hCartList)}</strong> 개의 <strong>상품</strong>이 있습니다.</p>
					<table class="cart_table">
						<thead>
							<tr>
								<th>상품</th>
								<th>이름</th>
								<th>가격</th>
								<th>수량</th>
								<th>총 가격</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
								<c:forEach var="cart" items="${hCartList}">
									<tr>
										<td class="col1"><a href="dessertContent?d_no=${cart.value.d_no }"><img src="/upload/${cart.value.d_image}" width="200px" height="200px"></a></td>
										<td class="col2"><a class="name" href="dessertContent?d_no=${cart.value.d_no }">${cart.value.d_name }</a></td>
										<td class="col3 price o_price">${cart.value.o_price }</td>
										<td class="col4">
											<input type="button" value="▲" onclick="javascript:count(this,'up')" class="cartUp">
											<input type="text" class="count" name="o_quantity" value="${cart.value.o_quantity }" size="1px;" readonly="readonly">
											<input type="button" value="▼" onclick="javascript:count(this,'down')" class="cartDown">
											<br><font class="hidden_text" color="red">재고 수 : ${cart.value.d_stock }</font>
											<!-- hidden 요소들 -->
											<input type="hidden" name="d_stock" value="${cart.value.d_stock}">
											<input type="hidden" name="d_no" value="${cart.value.d_no}">
											<input type="hidden" class="overStock" name="overStock" value="${cart.value.overStock}">
											<input type="hidden" name="o_price" value="${cart.value.o_price}">
											<input type="hidden" name="m_id" value="${cart.value.m_id}">
										</td>
										<td class="col5 price total_price">
											${cart.value.o_price * cart.value.o_quantity}
											<input type="hidden" name="total_price" value="${cart.value.o_price * cart.value.o_quantity}">
										</td>
										<td class="col6"><input type="button" value=" x " onclick="javascript:x(this)" class="cartdelBtn"></td>
									</tr>
								</c:forEach>
						</tbody>
					</table>
					<table class="price_table">
						<tr>
							<th>총 상품 금액</th>
							<th> </th>
							<th>총 배송비</th>
							<th> </th>
							<th>총 결제 금액</th>
						</tr>
						<tr>
							<td class="amount price"></td>
							<td class="plus">+</td>
							<td class="delivery price"></td>
							<td class="same">=</td>
							<td class="total_amount price"></td>
						</tr>
					</table>
					<div>
						<input type="submit" value="주문하기" class="CartorderBtn" id="cartBtn">
					</div>
				</c:when>
			</c:choose>
		</form>
	</div><!--   cartContent end -->
</div> <!-- mypage end -->