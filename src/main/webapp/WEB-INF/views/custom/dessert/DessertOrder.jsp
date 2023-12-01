<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Dessert.css">
<script src="/script/Dessert.js"></script>

<div id="dessert">
	<div id="">
		<div class="Mainlist">
			<p class="introduction">제품소개</p>
		</div>
		<div class="toplist">
			<ul class="list">
				<li>
					<input type="button" id="acategory" onclick="javascript:category('a')" value="전체보기">
					<label for="acategory" class="acategory">
					<c:choose>
						<c:when test='${flag==null || flag=="all" }'>
							<a class="a_bold">전체보기</a>
						</c:when>
						<c:when test='${flag!="all" }'>
							<a>전체보기</a>
						</c:when>
					</c:choose>
					</label>
				</li>
				<li>
					<input type="button" id="ccategory" onclick="javascript:category('c')" value="쿠키">
					<label for="ccategory" class="ccategory">
						<a <c:if test='${flag=="쿠키"}'>class="a_bold"</c:if> >쿠키</a>
					</label>
				</li>
				<li>
					<input type="button" id="bcategory" onclick="javascript:category('b')" value="브레드">
					<label for="bcategory" class="bcategory">
						<a <c:if test='${flag=="브레드"}'>class="a_bold"</c:if> >브레드</a>
					</label>
				</li>
				<li>
					<input type="button" id="pcategory" onclick="javascript:category('p')" value="푸딩">
					<label for="pcategory" class="pcategory">
						<a <c:if test='${flag=="푸딩"}'>class="a_bold"</c:if> >푸딩</a>
					</label>
				</li>
			</ul>
		</div>
	</div>
	<div class="productlist">
		<table>
			<tr>
				<c:forEach var="dessert" items="${dessert}" varStatus="status">
					<c:if test="${dessert.d_stock>0}">
					<a class="abox" href="/dessertContent?d_no=${dessert.d_no}">
						<div class="box">
							<c:if test="${dessert.d_stock==0}">
								<div class="black"><strong>SOLD OUT</strong></div>
							</c:if>
							<c:forEach var="sale" items="${maxSale}">
								<c:if test="${dessert.d_no == sale }">
									<img src="image/Hot.png" class="hot">
								</c:if>
							</c:forEach>
							<img src="/upload/${dessert.d_image}" class="abox_img">
							<p class="p_name">${dessert.d_name}</p>
							<p class="p_price price">${dessert.d_price }</p>
						</div>
					</a>
					</c:if>
				</c:forEach>
				<c:forEach var="dessert" items="${dessert}" varStatus="status">
					<c:if test="${dessert.d_stock==0}">
					<a class="abox" href="/dessertContent?d_no=${dessert.d_no}">
						<div class="box">
							<c:if test="${dessert.d_stock==0}">
								<div class="black"><strong>SOLD OUT</strong></div>
							</c:if>
							
							<img src="/upload/${dessert.d_image}" class="abox_img">
							<p class="p_name">${dessert.d_name}</p>
							<p class="p_price price">${dessert.d_price }</p>
						</div>
					</a>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>