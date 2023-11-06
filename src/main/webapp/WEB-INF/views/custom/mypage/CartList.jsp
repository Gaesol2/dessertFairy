<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Cart.css">
</head>
<div id="mypage">
  <div id="top">
    <div class="mypagelist">
		<p class="introduction">장바구니</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li><a href="/myPage">내 정보</a></li>
        <li><a href="/cartList">장바구니</a></li>
        <li><a href="/orderList">주문목록</a></li>
        <li><a href="/contactList">문의하기</a></li>
      </ul>
	</div> <!--  toplist end -->
  </div> <!-- top end -->
  <div id="cartContent">
  	<c:choose>
  		<c:when test="${hCartList==null}">
  			장바구니 목록이 없습니다.
  		</c:when>
  		<c:when test="${hCartList!=null}">
			<c:forEach var="cart" items="${hCartList}">
				<div class="cart_img">
					<img src="/upload/${cart.d_image}" width="100px" height="100px">
				</div> <!-- cart_img end -->
				<div class="cart_txt">
					<ul>
						<li>${cart.d_name}</li>
						<li>2번줄</li>
						<li>3번줄</li>
					</ul>
				</div> <!-- cart_txt end -->
			</c:forEach>  	  		
  		</c:when>
  	</c:choose>
		
  </div> <!-- cartContent end -->
</div> <!-- mypage end -->