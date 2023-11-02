<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>        
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
</head>
<script src="/script/productmgt.js"></script>
<div id="product_box">
	<div id="pCount">
	    <p>상품목록</p>
	    <p>총 상품수: ${pcnt} 가지</p>
	</div>
 
	<table class="productlist">
	  <tr>
		  <th>상품 번호</th>
		  <th>카테고리</th>
		  <th>이름</th>
		  <th>가격</th>
		  <th>재고</th>
		  <th>상품 이미지</th>
		  <th>유통기한</th>
		  <th>저장방법</th>
		  <th>알레르기</th>
	  </tr>
	  <c:choose>
	  	<c:when test="${fn:length(pList)>0}">
	       <c:forEach var="dessert" items="${pList}">
	         <tr>
		        <td>${dessert.d_no}</td>
		        <td>${dessert.d_category}</td>
		        <td>
		           	<a href="/productDetail?d_no=${dessert.d_no}">
		               ${dessert.d_name}</a>
		        </td>
		        <td class="price">${dessert.d_price}</td>
		        <td>${dessert.d_stock}</td>
		        <td>${dessert.d_image}</td>
		        <td>${dessert.d_life}</td>
		        <td>${dessert.d_storage}</td>
		        <td>${dessert.d_allergy}</td>
	         </tr>
	       </c:forEach>
	    </c:when>
	       
	    <c:when test="${fn:length(pList)==0}">
	    	<tr style="text-align:center;height: 30px;">
	        	<th colspan="5"> 등록된 상품이 없습니다.</th>
	        </tr>
	    </c:when>
	       
	  </c:choose>
	  
		<tr style="text-align:right;height: 50px;">
			  <th colspan="5"
			    style="text-align:right;border: 1px solid #ffffff;">
		   	 </th>
		</tr>
	
		<tfoot>
			<button type="button" onclick="location.href='/productInForm'">상품 등록</button>
		</tfoot>
	</table>
</div>







