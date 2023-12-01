<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/admin.js"></script>
<script src="/script/calendar.js"></script>

<div id="product">
	<h3 class="productName">상품 등록</h3>
	<form action="/productMgtProc?flag=insert" class="upForm" method="post" name="productInsert_Form" enctype="multipart/form-data">
		<div id="">
			<div class="upPro">
				<p class="upProName">상품 카테고리</p>
				<span class="upProSpan">
					<select class="in" name="d_category">
						<option>쿠키</option>
						<option>푸딩</option>
						<option>브레드</option>
					</select>
				</span>
			</div>
		
			<div class="upPro">
				<p class="upProName">상품명</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_name" value="${dessert.d_name}" size="40"></span>
			</div>
		
			<div class="upPro">
				<p class="upProName">상품이미지</p>
				<span class="upProSpan">
					<label for="file" class="fileBtn">파일업로드</label>
					<input id="file" type="file"class="chk1" name="inImage">
					<font class="file_name"></font>
				</span>
			</div>
			
			<div class="upPro">
				<p class="upProName">상품설명</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_detail" value="${dessert.d_detail}" size="58"></span>
			</div>
			
			<div class="upPro">
				<p class="upProName">가격</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_price" value="${dessert.d_price}" size="10"></span>
			</div>
			
			<div class="upPro">
				<p class="upProName">재고</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_stock" value="${dessert.d_stock}" size="10"></span>
			</div>
			
			<div class="upPro">
				<p class="upProName">유통기한</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_life" value="${dessert.d_life}" size="30"></span>
			</div>
			
			<div class="upPro">
				<p class="upProName">보관방법</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_storage" value="${dessert.d_storage}" size="40"></span>
			</div>
		
			<div class="upPro">
				<p class="upProName">알레르기 성분</p>
				<span class="upProSpan"><input type="text" class="chk1 in" name="d_allergy" value="${dessert.d_allergy}" size="30"></span>
			</div>
		</div>
		<div id="proUpBtn">
			<input type="submit" class="productInsert" value="상품등록전송">
		</div>
	</form>
</div>