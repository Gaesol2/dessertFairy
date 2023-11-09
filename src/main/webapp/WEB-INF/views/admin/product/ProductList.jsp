<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>        
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/Product.css">
<script src="/script/productmgt.js"></script>
<div id="product">
	<div class="mainlist">
	    <p class="productName">상품등록</p>
	</div>
	<div class="total">
      <ul class="list">
        <li>총 상품수: ${pcnt} 가지</li>
      </ul>
    </div>
	<div id="productList">
		<div id="productBtn">	
			<button type="button" class="regis" onclick="location.href='/productInForm'">상품 등록</button>
		</div>
		<table class="productTable">
			<tr>
				<th>상품 번호</th>
				<th>카테고리</th>
				<th>이름</th>
				<th>가격</th>
				<th>재고</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(pList)>0}">
					<c:forEach var="dessert" items="${pList}">
						<tr>
							<td class="dol1">${dessert.d_no}</td>
							<td class="dol3">${dessert.d_category}</td>
							<td class="dol4">
							   	<a href="/productDetail?d_no=${dessert.d_no}">${dessert.d_name}</a>
							</td>
							<td class="price dol5">${dessert.d_price}</td>
							<td class="dol6">${dessert.d_stock}</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${fn:length(pList)==0}">
					<tr style="text-align:center;height: 30px;">
						<th colspan="5"> 등록된 상품이 없습니다.</th>
					</tr>
				</c:when>
			</c:choose>
		</table>
		<table class="pageBtn">
			<tr>
				<td colspan="5">
					<c:if test="${pdto.startPg>pBlock}">
						<a href="productMgt?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						<a href="productMgt?curPage=${p}&curBlock=${pdto.curBlock}">
							<span><c:out value="${p}" /></span>
						</a>&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${pdto.endPg<pdto.pgCnt}">
						<a href="productMgt?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<form action="" name="content" method="post">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="curPage" value="${pageDto.curPage}">
			<input type="hidden" name="curBlock" value="${pageDto.curBlock}">
		</form>
	</div>
</div>







