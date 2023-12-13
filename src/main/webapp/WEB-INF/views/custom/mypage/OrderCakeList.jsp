<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id="order">
	<div>
		<div id="mainList">
			<p class="introduction" name="m_id">${ssKey.m_name}님의 주문목록</p>
		</div>
		<div class="topList">
			<ul class="list">
				<li><a href="/myPage">내 정보</a></li>
				<li><a href="/cartList">장바구니</a></li>
				<li class="reList"><a href="/orderList">주문목록</a></li>
				<li><a href="/contactList">문의하기</a></li>
			</ul>
		</div>
	</div>
    <div id="chooseBox">
    	<ul class="cakeList">
    		<li><a href="/orderList">디저트 목록</a></li>
    		<li class="reList"><a href="/cakeOrderList">케이크 목록</a></li>
    	</ul>
		<c:choose>
				<c:when test="${fn:length(CakeOrderList)>0}">
	    			<form action="cakeCancel" method="post" name="cakeCancelForm">
						<c:forEach var = "cake" items = "${CakeOrderList}" varStatus = "i">
							<div id="cakeContentBox">
								<c:choose>
									<c:when test="${cake.c_image!=null}">
										<div class="o_cakeBox1">
											<span>
												<img src="/upload/${cake.c_image}" class="orderCakeImg">
											</span>
										</div>
									</c:when>
									<c:when test="${cake.c_image==null}">
										<img src="../image/noimage.png" class="nocake">
									</c:when>
								</c:choose>
								<div class="o_cakeBox2">
									<div>
										<p class="cakeName">빵 시트</p>
										<span>
											<input type="text" name="c_sheet" class="in" value="${cake.c_sheet }" readonly="readonly" size="10">
										</span>
									</div>
									<div>
										<p class="cakeName">안 크림</p>
										<span>
											<input type="text" name="c_incream" class="in" value="${cake.c_incream }" readonly="readonly" size="10">
										</span>
									</div>
									<div>
										<p class="cakeName">밖 크림</p>
										<span>
											<input type="text" name="c_outcream" class="in" value="${cake.c_outcream }" readonly="readonly" size="10">
										</span>
									</div>
									<div>
										<p class="cakeName">사이즈</p>
										<span>
											<input type="text" name="c_size" class="in" value="${cake.c_size }" readonly="readonly" size="10">
										</span>
									</div>
								</div>
								<div class="o_cakeBox3">
									<div>
										<p class="cakeName">주문고객</p>
										<span>
											<input type="text" name="m_id" class="in" value="${cake.m_id }" readonly="readonly" size="15">
										</span>
									</div>
									<div>
										<p class="cakeName">가격</p>
										<span>
											<input type="text" name="c_price" class="in" value="${cake.c_price }" readonly="readonly" size="10">
										</span>
									</div>
									<div>
										<p class="cakeName">주문 시각</p>
										<span>
											<input type="text" name="c_regdate" class="in" value="${cake.c_regdate }" readonly="readonly" size="10">
										</span>
									</div>
									<div>
										<p class="cakeName">수령 날짜</p>
										<span>
											<input type="text" name="c_month" class="in" value="${cake.c_month }" readonly="readonly" size="3">월
											<input type="text" name="c_pickupdate" class="in" value="${cake.c_day }" readonly="readonly" size="3">일
										</span>
									</div>
									<div>
										<p class="cakeName">수령 시각</p>
										<span>
											<input type="text" name="c_pickupdate" class="in" value="${cake.c_pickupdate }" readonly="readonly" size="10">
										</span>
									</div>
								</div>
								<div class="o_cakeBox4">
									<div>
										<p class="cakeName">레터링</p>
										<span>
											<input type="text" name="c_write" class="in" value="${cake.c_write}" readonly="readonly" size="35">
										</span>
									</div>
									<div>
										<p class="cakeName">요구사항</p>
										<span>
											<textarea readonly="readonly">${cake.c_request }</textarea>
										</span>
									</div>
								</div>
							</div>
							<input type="hidden" name="c_no" value="${cake.c_no}">
						</c:forEach>
						<input type="button" value="주문취소" class="cakeCancel">
		    		</form>
				</c:when>
		
			<c:when test="${fn:length(CakeOrderList)==0}">
				<tr class="notList">
					<th>주문내역이 없습니다.</th>
				</tr>
			</c:when>
		</c:choose>
    </div>
</div>