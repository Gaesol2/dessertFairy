<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객관리 회원 주문 내역 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/DessertOrder.css">
</head>
<link rel="stylesheet" type="text/css" href="/css/Mypage.css">
<script src="/script/Order.js"></script>
<div id="mem_order">
		<div id="mem_OrderList">
			<p class="introduction" name="m_id">${m_id}님의 주문목록</p>
		</div>
	
	<div class="total">
      <ul class="list">
        <li>총 상품수: ${oCnt} 가지</li>
      </ul>
    </div>
    
	<div id="orderList">
		<table class="orderTable">
			<tr>
				<th>주문 번호</th>
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
							<td class="dol1">${order.o_no}</td>
							<td class="dol3">${order.d_no}</td>
							<td class="dol4"><a onclick="javascript:orderDetail(this)">${order.d_name}</a>
								<input type="hidden" name="d_no" value="${order.d_no}">
								<input type="hidden" name="o_no" value="${order.o_no}">
								<input type="hidden" name="m_id" value="${order.m_id}">
							</td>
							<td class="price dol4">${order.o_price}</td>
							<td class="price dol5">${order.o_quantity}</td>
							<td class="price dol6">${order.o_amount}</td>
							<td class="dol6">${order.o_regdate}</td>
							<td class="dol6">
								<c:choose>
									<c:when test="${order.o_state==1}">결제중</c:when>
									<c:when test="${order.o_state==2}">배송준비</c:when>
									<c:when test="${order.o_state==3}">배송중</c:when>
									<c:when test="${order.o_state==4}">배송완료</c:when>
									<c:when test="${order.o_state==5}">구매확정</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${fn:length(orderList)==0}">
					<tr style="text-align:center;height: 30px;">
						<th colspan="5"> 등록된 주문내역이 없습니다.</th>
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
						<a href="orderList?curPage=${p}&curBlock=${pdto.curBlock}">
							<span><c:out value="${p}" /></span>
						</a>&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${pdto.endPg<pdto.pgCnt}">
						<a href="productMgt?curPage=${pdto.startPg+pBlock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>
					<a href = "/memberMgt"><input type="button" value="회원 목록으로"></a>
				</th>
			</tr>
		</table>
		
		<form action="" name="content" method="post">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="curPage" value="${pageDto.curPage}">
			<input type="hidden" name="curBlock" value="${pageDto.curBlock}">
		</form>
	</div>
	
	<form action="mOrderDetail" method="post" name="orDetailForm">
		<input type="hidden" name="d_no" value="${order.d_no}">
	    <input type="hidden" name="o_no" value="${order.o_no}">
	    <input type="hidden" name="m_id" value="${order.m_id}">
	</form>
</div>