<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Dessert.css">
<script src="/script/Dessert.js"></script>
</head>
<body>
<div id="dessertContent">
	<div id="dessertImg">
		<img src="/upload/${dessert.d_image}" height="450px" width="450px">
	</div> <!-- dessertImg -->
	<div id="dessertTxt">
		<ul>
			<li><a href="dessert?flag=${dessert.d_category}" class="category">${dessert.d_category}</a></li>
			<li class="title">${dessert.d_name}</li>
			<li class="detail">${dessert.d_detail}</li>
		</ul>
		
		<div class="line"></div>
		
		<dl>
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
						<input id="btn_order" type="button" value="바로결제">
						<label for="btn_order" class="btn_order">바로결제</label>					
					</td>
					<td>
						<input id="btn_cart" type="button" value="장바구니">
						<label for="btn_cart" class="btn_cart">장바구니</label>
					</td>
				</tr>
			</table>
			<input type="hidden" name="d_no" value="${dessert.d_no}">
			<input type="hidden" name="d_name" value="${dessert.d_name}">
			<input type="hidden" name="d_stock" value="${dessert.d_stock}">
			<input type="hidden" name="d_image" value="${dessert.d_image}">
			<input type="hidden" name="o_price" value="${dessert.d_price}">
		</form>
	</div> <!-- dessertTxt -->
</div> <!-- dessertContent end -->
</body>
</html>