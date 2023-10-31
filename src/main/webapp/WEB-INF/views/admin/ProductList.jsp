<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>        
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
</head>
<script src="/script/productmgt.js"></script>
<div id="product">
	<div id="productHead">
	    <p>상품목록</p>
	    <p>총 상품수: ${pcnt} 가지</p>
	</div>
 
	<table class="productlist">
	  <tr>
		  <th>상품번호</th>
		  <th>상품명</th>
		  <th>상품가격</th>
		  <th>등록일</th>
		  <th>재고</th>
	  </tr>
	  <c:choose>
	    <c:when test="${fn:length(pList)>0}">
	       <c:forEach var="product" items="${pList}">
	         <tr>
	           <td class="co1">${product.rr}
	           <input type="hidden" value="${product.p_no}">
	           </td>
	           <td class="co2"><a href="/productDetail?p_no=${product.p_no}">
	               ${product.p_name}</a></td>
	           <td class="price">${product.price}</td>
	           <td class="co4">${product.pr_date}</td>
	           <td class="co5">${product.stock}</td>
	         </tr>
	       </c:forEach>
	    </c:when>   
	    <c:when test="${fn:length(pList)==0}">
	      <tr style="text-align:center;height: 30px;">
	        <th colspan="5"> 등록된 상품이 없습니다.</th></tr>
	    </c:when>   
	  </c:choose>
	  <tr style="text-align:right;height: 50px;">
	  <th colspan="5"
	    style="text-align:right;border: 1px solid #ffffff;">
	    </th>
	    </tr>
	</table>
</div>







