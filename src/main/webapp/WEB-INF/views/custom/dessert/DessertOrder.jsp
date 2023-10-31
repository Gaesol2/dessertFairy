<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/DessertOrder.css">
<script src="/script/Dessert.js"></script>
</head>
<div id="dessert">
  <div id="top">
    <div class="Mainlist">
		<p class="introduction">제품소개</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><input type="button" onclick="javascript:category('a')" value="전체보기"></li>
        <li><input type="button" onclick="javascript:category('c')" value="쿠키"></li>
        <li><input type="button" onclick="javascript:category('b')" value="브레드"></li>
        <li><input type="button" onclick="javascript:category('p')" value="푸딩"></li>
      </ul>
    </div>
  </div>
  <div class="productlist">
	<table>
		<tr>
			<c:forEach var="dessert" items="${dessert}">
				<a class="abox" href="">
					<div class="box">
						<c:out value="${dessert.d_no}"/>
						<img src="/upload/${dessert.d_image}" height="250px" width="250px">
					</div>
				</a>
			</c:forEach>
		</tr>
	</table>
  </div>
</div>