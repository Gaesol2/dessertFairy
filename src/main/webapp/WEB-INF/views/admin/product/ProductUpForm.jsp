<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script src="/script/admin.js"></script>
<body>
<div id="product_Update_Box">
  <h2>상품 수정</h2>
  <form action="/productMgtProc?flag=update" method="post" 
        name="productUpForm" enctype="multipart/form-data">
	  <table class="product">
	    	     <tr>
	       <th>상품 번호</th>
	       <td>
	        <input type="text" name="d_no" class="chk1"  title="상품번호"
	        readonly="readonly" value="${ddto.d_no}">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품 카테고리</th>
	       <td>
		       	<select name="d_category" title="상품카테고리" value="${ddto.d_category}">
		       		<option>쿠키</option>
		       		<option>브레드</option>
		       		<option>푸딩</option>
		       	</select>
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품명</th>
	       <td>
	        <input type="text" name="d_name" class="chk1"  title="상품명"
	        value="${ddto.d_name}">
	       </td>
	     </tr>

	     <tr>
	       <th>상품설명</th>
	       <td>
	        <input type="text" name="d_detail" class="chk1"  title="상품설명"
	        value="${ddto.d_detail}">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품가격</th>
	       <td>
	        <input type="text" name="d_price" class="chk1 inprice" title="상품가격" 
	       value="${ddto.d_price}">&nbsp;원
	       </td>
	     </tr>
	     
	     <tr>
	       <th>재고수량</th>
	       <td>
	        <input type="text" name="d_stock" class="chk1"  title="재고수량"
	        value="${ddto.d_stock}">&nbsp;개
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품이미지</th>
	       <td>
		       <img alt="이미지" src="upload/${ddto.d_image}">
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
	       </td>
	     </tr>
	     
	     <tr>
	       <th>유통기한</th>
	       <td>
	        <input type="text" name="d_life" class="chk1"  title="유통기한"
	        value="${ddto.d_life}">&nbsp;개
	       </td>
	     </tr>
	     
	     
	     <tr>
	       <th>저장방법</th>
	       <td>
	        <input type="text" name="d_storage" title="저장방법"
	        value="${ddto.d_storage}">
	       </td>
	     </tr>

	     <tr>
	       <th>알레르기 성분</th>
	       <td>
	        <input type="text" name="d_allergy" title="알레르기 성분"
	        value="${ddto.d_allergy}">
	       </td>
	     </tr>
	     
	     
	     <tr>
	       <th colspan="2" class="tableBtn">
	         <input type="submit" class="productUpBtn" value="상품수정전송">
	       </th>
	     </tr>
	     
	  </table>
  </form>
</div>
</body>
</html>