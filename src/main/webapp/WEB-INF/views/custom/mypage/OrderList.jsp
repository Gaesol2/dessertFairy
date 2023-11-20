<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/mypage.js"></script>
<script src="/script/Order.js"></script>


<div id="order">
	<div>
		<div id="mainList">
			<p class="introduction" name="m_id">${mdto.m_id}님의 주문목록</p>
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
	
    
    <div id="orderList">
    	<ul class="list">
       		 <li>총 상품수: ${oCnt} 가지</li>
      	</ul>
		<table class="orderTable">
			<tr>
				<th>주문번호</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>총금액</th>
				<th>주문일</th>
				<th>배송상태</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(orderList)>0}">
					<c:forEach var="order" items="${orderList}">
						<tr>
							<td class="ool1">${order.o_no}</td>
							<td class="ool2">${order.d_no}</td>
							<td class="ool3"><a onclick="javascript:orderDetail(this)">${order.d_name}</a>
								<input type="hidden" name="d_no" value="${order.d_no}">
								<input type="hidden" name="o_no" value="${order.o_no}">
								<input type="hidden" name="m_id" value="${order.m_id}">
							</td>
							<td class="price ool4">${order.o_price}</td>
							<td class="price ool5">${order.o_quantity}</td>
							<td class="price ool6">${order.o_amount}</td>
							<td class="ool7">${order.o_regdate}</td>
							<td class="ool8">
								<c:choose>
									<c:when test="${order.o_state==1}">결제중</c:when>
									<c:when test="${order.o_state==2}">배송준비</c:when>
									<c:when test="${order.o_state==3}">배송중</c:when>
									<c:when test="${order.o_state==4}">배송완료</c:when>
									<c:when test="${order.o_state==5}">구매확정</c:when>
								</c:choose>
							</td>
							<td  class="ool9">
								<c:if test="${order.o_state==5}">
									<a href="/reviewWrite">리뷰쓰기</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${fn:length(orderList)==0}">
					<tr class="notList"">
						<th colspan="5"> 등록된 주문내역이 없습니다.</th>
					</tr>
				</c:when>
			</c:choose>
		</table>
    </div>
		
		<table class="pageBtn">
			<tr>
				<td colspan="5">
					<c:if test="${pdto.startPg>pBlock}">
						<a href="productMgt?curPage=${pdto.startPg-pBlock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${pdto.startPg}" end="${pdto.endPg}" var="p" step="1">
						<a href="orderList?curPage=${p}&curBlock=${pdto.curBlock}">
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
	
	<form action="memOrderDetail" method="post" name="orDetailForm">
		<input type="hidden" name="d_no" value="${order.d_no}">
	    <input type="hidden" name="o_no" value="${order.o_no}">
	    <input type="hidden" name="m_id" value="${order.m_id}">
	</form>
</div>