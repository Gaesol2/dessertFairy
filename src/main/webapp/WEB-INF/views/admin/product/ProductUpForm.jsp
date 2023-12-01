<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/Admin.js"></script>
<script src="/script/calendart.js"></script>

<div id="product">
       <p class="productName">상품수정</p>
	 <form action="/productMgtProc?flag=update" class="proUpForm" method="post" name="productUpForm" enctype="multipart/form-data">
		<div id="productUpImage">
            <img alt="이미지" src="upload/${ddto.d_image}" class="UpImg">
            
                      <label for="file" class="fileUpBtn">파일업로드</label>
					<input id="file" type="file" title="이미지" name="inImage" value="${ddto.d_image}">
					<font class="file_name"></font>
            <input type="hidden" name="upImage" value="${ddto.d_image}">
         </div>

		<div id="detailUpMain">
			<div>
				<p class="datailName">${dessert.d_name}</p>
			</div>
			
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
				<span> <input type="text" name="d_name" class="chk1 in"  title="상품명"
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
				<p class="pol">가격</p>
				<span><input type="text" name="d_price" class="chk1 in" title="상품가격" 
                         value="${ddto.d_price}" size="10">&nbsp;원
				</span>
			</div>
			
			<div class="po">
				<p class="pol">재고</p>
				<span> <input type="text" name="d_stock" class="chk1 in"  title="재고수량"
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