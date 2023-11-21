<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/admin.js"></script>

<div id="product">
	<div class="mainlist">
	    <p class="productName">상품수정</p>
	</div>
	<div id="productUpForm">
		<form action="/productMgtProc?flag=update" method="post" name="productUpForm" enctype="multipart/form-data">
			<div id="productUpImage">
				<img alt="이미지" src="upload/${ddto.d_image}" class="UpImg">
				<c:choose>
	            	<c:when test="${ddto.d_image==null or ddto.d_image==ready.jpg}">
	                	<input type="file" name="inImage" class="chk1" 
	                 		title="이미지" value="${ddto.d_image}">
	                </c:when>
	                <c:when test="${ddto.d_image!=null and ddto.d_image!=ready.jpg}">
	                	<input type="file" name="inImage"
	                   		 title="이미지" value="${ddto.d_image}">
	                </c:when>
	            </c:choose>
				<input type="hidden" name="upImage" value="${ddto.d_image}">
			</div>
			
			<div id="productUp">
				<div class="po">
					<p class="pol">상품번호</p>
					<span>
						<input type="text" name="d_no" class="chk1 in"  title="상품번호"
	           				readonly="readonly" value="${ddto.d_no}" size="5">
					</span>
				</div>
				
				<div class="po">
					<p class="pol">상품 카테고리</p>
					<span>
						<select name="d_category" title="상품카테고리" value="${ddto.d_category}"  class="chk1 in">
		                   <option>쿠키</option>
		                   <option>브레드</option>
		                   <option>푸딩</option>
		                </select>
					</span>
				</div>
				
				<div class="po">
					<p class="pol">상품명</p>
					<span>
						<input type="text" name="d_name" class="chk1 in"  title="상품명"
	          				 value="${ddto.d_name}" size="50">
	           		</span>
				</div>
				
				<div class="po">
					<p class="pol">상품설명</p>
					<span>
						<input type="text" name="d_detail" class="chk1 in"  title="상품설명"
	          				 value="${ddto.d_detail}" size="50">
					</span>
				</div>
				
				<div class="po">
					<p class="pol">상품가격</p>
					<span>
						<input type="text" name="d_price" class="chk1 in" title="상품가격" 
	          				value="${ddto.d_price}" size="10">&nbsp;원
					</span>
				</div>
				
				<div class="po">
					<p class="pol">재고수량</p>
					<span>
						<input type="text" name="d_stock" class="chk1 in"  title="재고수량"
	           				value="${ddto.d_stock}" size="10">&nbsp;개
						
					</span>
				</div>
				
				<div class="po">
					<p class="pol">유통기한</p>
					<span>
						<input type="text" name="d_life" class="chk1 in"  title="유통기한"
	           				value="${ddto.d_life}" size="40">&nbsp;개
					</span>
				</div>
				
				<div class="po">
					<p class="pol">보관방법</p>
					<span>
						<input type="text" name="d_storage" class="chk1 in" title="저장방법"
	           				value="${ddto.d_storage}" size="50">
					</span>
				</div>
				
				<div class="po">
					<p class="pol">알레르기 성분</p>
					<span>
						<input type="text" name="d_allergy" class="chk1 in" title="알레르기 성분"
	          				 value="${ddto.d_allergy}" size="50">
					</span>
				</div>
				
				<div id="proUpBtn">
					<input type="submit" class="productUpBtn" value="상품수정전송">
				</div>
				
			</div>
		</form>
	</div>
</div>