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
</head>
<div id="dessert">
  <div id="top">
    <div class="Mainlist">
		<p class="introduction">제품소개</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="/dessertOrder">전체보기</a></li>
        <li><a href="/cookieOrder">쿠키</a></li>
        <li><a href="/breadOrder">브레드</a></li>
        <li><a href="/puddingOrder">푸딩</a></li>
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