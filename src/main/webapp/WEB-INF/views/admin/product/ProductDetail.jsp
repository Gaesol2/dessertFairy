<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/admin.js"></script>

<div id="product">
	<form action="" name="productDetailForm" method="post">
		<div id="detailImage">
			<img alt="이미지" src="upload/${dessert.d_image}" class="deImg">
		</div>
		<div id="detailMain">
			<div>
				<p class="datailName">${dessert.d_name}</p>
			</div>
			
			<div class="po">
				<p class="pol">상품번호</p>
				<span>
					<input type="text" class="in" name="d_no" value="${dessert.d_no}"
					      readonly="readonly" size="1">
				</span>
			</div>
			
			<div class="po">
				<p class="pol">상품 카테고리</p>
				<span><input type="text" class="in" name="d_category" value="${dessert.d_category}"
				          size="5" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">상품명</p>
				<span><input type="text" class="in" name="d_name" value="${dessert.d_name}"
				       size="40" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">상품설명</p>
				<span><input type="text" class="in" name="d_detail" value="${dessert.d_detail}" 
				       size="56" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">가격</p>
				<span><input type="text" class="in" name="d_price" value="${dessert.d_price}"
				       size="10"  readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">재고</p>
				<span><input type="text" class="in" name="d_stock" value="${dessert.d_stock}"
				       size="10" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">유통기한</p>
				<span><input type="text" class="in" name="d_life" value="${dessert.d_life}"
				        size="30" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">보관방법</p>
				<span><input type="text" class="in" name="d_storage" value="${dessert.d_storage}"
				        size="40" readonly="readonly"></span>
			</div>
			
			<div class="po">
				<p class="pol">알레르기 성분</p>
				<span><input type="text" class="in" name="d_allergy" value="${dessert.d_allergy}"
				       size="30" readonly="readonly"></span>
			</div>
			
			<div id="proBtn">
				<input type="button" class="productUp regis" value="상품수정">
				<input type="button" class="productDel regis" value="상품삭제">
				<input type="button" class="regis" value="상품목록" onclick = "location.href='productMgt'">
			</div>
			
		</div>
	</form>
</div>