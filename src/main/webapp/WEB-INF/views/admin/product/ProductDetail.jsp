<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<script src="/script/productmgt.js"></script>
<body>
<div id="product_Detail_box">
	<h2>${dessert.d_name}</h2>
	<table>
		<tr>
			<td>
				<a href="/upload/image/${dessert.d_image}">
				<img alt="이미지" src="upload/${dessert.d_image}" height="150" width="150">
				</a>
			</td>
			
			<td>
				<form action="" name="productDetailForm" method="post">
					<table>
						<tr>
							<th>상품번호:</th>
							<td>${dessert.d_no}</td>
						</tr>
						
						<tr>
							<th>상품 카테고리</th>
							<td>${dessert.d_category}</td>
						</tr>
						
						
						<tr>
							<th>상품명</th>
							<td>${dessert.d_name}</td>
						</tr>
						
						
						<tr>
							<th>가격</th>
							<td>${dessert.d_price}</td>
						</tr>
						
						
						<tr>
							<th>재고</th>
							<td>${dessert.d_stock}</td>
						</tr>
						
						
						<tr>
							<th>유통기한</th>
							<td>${dessert.d_life}</td>
						</tr>
						
						
						<tr>
							<th>보관방법</th>
							<td>${dessert.d_storage}</td>
						</tr>
						
						
						<tr>
							<th>알레르기 성분</th>
							<td>${dessert.d_allergy}</td>
						</tr>
						
						<tr>
							<th>
								<input type="button" class="productUp" value="상품수정">
								<input type="button" class="productDel" value="상품삭제">
								<input type="button" value="상품목록" onclick = "location.href='productMgt'">
							</th>
						</tr>
						
					</table>
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
