<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id = "order">
	<div id = "OrderDetail">
		<p>${DetailList[0].m_name}님 상세 주문 내역</p>
	</div>
	
	<div class="ordList"><a href = "/orderMgt">주문목록으로</a></div>
	
	<form action="updateOrder" name="orderDetailForm" method="post">
				
		<div id="orderDetailBox">
			<div id="orderDetailMain">
				<c:forEach var="odto" items="${DetailList}">
					<div class="oll">
						<span class="ol2">
							<img src="/upload/${odto.d_image}" class="orderImg">
						</span>
					</div>
					<div class="oll">
						<p class="ol1">주문번호</p>
						<span class="ol2">
							<input type="text" class="in" name="o_no" readonly="readonly" value="${DetailList[0].o_no}"size="5">
						</span>
					</div>
					<div class="oll">
						<p class="ol1">상품명</p>
						<span class="ol2">
							<input type="text" class="in" name="d_name" readonly="readonly" value="${odto.d_name}"size="35">
						</span>
					</div>
					<div class="oll">
						<p class="ol1">단가</p>
						<span class="ol2">
							<input type="text" class="in" name="o_price" readonly="readonly" value="${odto.o_price}"size="10">원
						</span>
					</div>
					<div class="oll">
						<p class="ol1">구매수량</p>
						<span class="ol2">
							<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_quantity}"size="5">
						</span>
					</div>	
					<div class="oll">
						<p class="ol1">합 계</p>
						<span class="ol2">
							<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_amount}"size="5">
						</span>
					</div>	
					<div class="line"></div>
					<input type="hidden" name="state" value="${odto.o_state}">
					<c:set var="total" value="${total + odto.o_amount}" />
				</c:forEach>
			
				<div class="oll">
					<p class="ol1">결제금액</p>
					<span class="ol2">
						<input type="text" class="in" name="o_amount" readonly="readonly" value="${total}"size="10">원
					</span>
				</div>
				<div class="oll">
					<p class="ol1">고객정보</p>
					<span class="ol2">
						<input type="text" class="in" name="m_name" readonly="readonly" value="${DetailList[0].m_name}(${DetailList[0].m_id})"size="35">
					</span>
				</div>
				<div class="oll">
					<p class="ol1">배송상태</p>
					<input type="hidden" value="${DetailList[0].o_state}" name="stateInput" id="stateInput">
					<select name="o_state" id="o_state">
						<option value="1">결제중</option>
						<option value="2">배송준비</option>
						<option value="3">배송중</option>
						<option value="4">배송완료</option>
						<option value="5">구매확정</option>
						<%-- <option selected>${DetailList[0].o_state}</option> --%>
					</select>
			
					<script type="text/javascript">
						$(function(){
							 //배송관련 상태
							 for(int i=0; i<${DetailList}.size; i++)
							 $("#state").val('${DetailList[i].o_state}')
						})
					</script>
					<input type="submit" value="상태수정" class="stateUpBtn">
				</div>
			</div>
		</div>
	</form>
</div>
