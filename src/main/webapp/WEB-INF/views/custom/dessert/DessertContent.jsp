<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Dessert.css">
<script src="/script/Dessert.js"></script>

<div id="dessertContent">
	<div id="dessertImg">
		<img src="/upload/${dessert.d_image}" height="450px" width="450px">
	</div> <!-- dessertImg -->
	<div id="dessertTxt"><!-- 옵션 시작 -->
		<dl class="dessertTap">
			<dt><a href="dessert?flag=${dessert.d_category}" class="category">${dessert.d_category}</a></dt>
			<dd class="dessertname">${dessert.d_name}</dd>
			<dd class="namedetail">${dessert.d_detail}</dd>
		</dl>
		
		<div class="line"></div>
		
		<dl class="dessertMain">
			<dt>보관 방법</dt>
				<dd>${dessert.d_storage }</dd>
			<dt>유통기한</dt>
				<dd>${dessert.d_life }</dd>
			<dt>알레르기</dt>
				<dd>${dessert.d_allergy }</dd>
			<dt>재고 수</dt>
				<dd class="stock">${dessert.d_stock }</dd>
			<dt>가격</dt>
				<dd class="price">${dessert.d_price }</dd>
		</dl>
		
		<div class="line"></div>
		
		<c:choose>
			<c:when test = "${dessert.d_stock == 0}">
			품절
			</c:when>
			<c:when test = "${dessert.d_stock > 0}">         
				<form name="dessertForm" action="" method="post">
					<dl>
						<dt>주문 수량</dt>
						<dd>
						   <input type="text" value="1" class="count" readonly="readonly" name="o_quantity">
						   <input type="button" class="countUp" value="△">
						   <input type="button" class="countDown" value="▽">         
						</dd>
						   <dt>주문 가격</dt>
						<dd>
						   <input type="text" id="total_price" class="total_price" value="${dessert.d_price }" readonly="readonly">
						</dd>
					</dl>
				<table>
				   <tr>
				      <td>
				         <input class="btn_order" type="button" value="바로결제">
				      </td>
				      <td>
				         <input class="btn_cart" type="button" value="장바구니">
				      </td>
				   </tr>
				</table>
					<input type="hidden" name="d_no" value="${dessert.d_no}">
					<input type="hidden" name="d_name" value="${dessert.d_name}">
					<input type="hidden" name="d_stock" value="${dessert.d_stock}">
					<input type="hidden" name="d_image" value="${dessert.d_image}">
					<input type="hidden" name="o_price" value="${dessert.d_price}">
				</form>
			</c:when>
		</c:choose>
	</div>
</div> <!-- dessertContent end -->