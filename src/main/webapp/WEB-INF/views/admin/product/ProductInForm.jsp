<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/admin.js"></script>

<div id="product">
	<h3 class="productUp">상품 등록</h3>
	<form action="/productMgtProc?flag=insert" class="upForm" method="post" name="productInsert_Form" enctype="multipart/form-data">
		<div id="upMain">
			<div class="box">
				<p class="boxName">상품 카테고리</p>
				<select class="opt" name="d_category">
					<option>쿠키</option>
					<option>푸딩</option>
					<option>브레드</option>
				</select>
			</div>
		
			<div class="box">
				<p class="boxName">상품명</p>
				<span><input type="text" class="chk1 in" name="d_name" value="${dessert.d_name}" size="40"></span>
			</div>
		
			<div class="box">
				<p class="boxName">상품이미지</p>
				<span><input type="file" class="chk1" name="inImage"></span>
			</div>
			
			<div class="box">
				<p class="boxName">상품설명</p>
				<span><input type="text" class="chk1 in" name="d_detail" value="${dessert.d_detail}" size="58"></span>
			</div>
			
			<div class="box">
				<p class="boxName">가격</p>
				<span><input type="text" class="chk1 in" name="d_price" value="${dessert.d_price}" size="10"></span>
			</div>
			
			<div class="box">
				<p class="boxName">재고</p>
				<span><input type="text" class="chk1 in" name="d_stock" value="${dessert.d_stock}" size="10"></span>
			</div>
			
			<div class="box">
				<p class="boxName">유통기한</p>
				<span><input type="text" class="chk1 in" name="d_life" value="${dessert.d_life}" size="30"></span>
			</div>
			
			<div class="box">
				<p class="boxName">보관방법</p>
				<span><input type="text" class="chk1 in" name="d_storage" value="${dessert.d_storage}" size="40"></span>
			</div>
		
			<div class="box">
				<p class="boxName">알레르기 성분</p>
				<span><input type="text" class="chk1 in" name="d_allergy" value="${dessert.d_allergy}" size="30"></span>
			</div>
		</div>
		<div id="UpBtn">
			<input type="submit" class="productInsert regis" value="상품등록전송">
		</div>
	</form>
</div>