<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Member.css">
<script src="/script/Order.js"></script>

<div id="member">
	<h3 class="memName">${odto.m_id}(${odto.o_no}) 상세 주문 내역</h3>
	
	<form action="mUpdateOrder" name="orderDetailForm" method="post">
		<div id="mdDetail">
			
			<div class="md">
				<p class="md1">주문번호</p>
				<span class="md2">
					<input type="text" class="in" name="o_no" readonly="readonly" value="${odto.o_no}"size="10">
					<input type="hidden" name="o_no" value="${odto.o_no}">     
	                <input type="hidden" name="d_no" value="${odto.d_no}">     
	                <input type="hidden" name="m_id" value="${odto.m_id}">
				</span>
			</div>
			<div class="md">
				<p class="md1">상품명</p>
				<span class="md2">
					<input type="text" class="in" name="d_name" readonly="readonly" value="${odto.d_name}"size="30">
				</span>
			</div>
			<div class="md">
				<p class="md1">단가</p>
				<span class="md2">
					<input type="text" class="in" name="o_price" readonly="readonly" value="${odto.o_price}"size="10">
				</span>
			</div>
			<div class="md">
				<p class="md1">구매수량</p>
				<span class="md2">
					<input type="text" class="in" name="o_quantity" readonly="readonly" value="${odto.o_quantity}"size="10">
				</span>
			</div>
			<div class="md">
				<p class="md1">결제금액</p>
				<span class="md2">
					<input type="text" class="in" name="o_amount" readonly="readonly" value="${odto.o_amount}"size="10">
				</span>
			</div>
			<div class="md">
				<p class="md1">고객정보</p>
				<span class="md2">
					<input type="text" class="in" name="m_name" readonly="readonly" value="${odto.m_name}(${odto.m_id})"size="30">
				</span>
			</div>
			<div class="md">
				<p class="md1">배송상태</p>
				<span class="option"> 
					<select name="o_state" id="state">
		                <option value="1">결제중</option>
		                <option value="2">배송준비</option>
		                <option value="3">배송중</option>
		                <option value="4">배송완료</option>
		                <option value="5">구매확정</option>
	               </select>
	               <script type="text/javascript">
	                     $(function(){
	                        //배송관련 상태
	                        $("#state").val('${odto.o_state}')
	                     })
	               </script>
				</span>
			</div>
		</div>
		<div id="mdBtn">
			<a href= "/memberMgt" class="regis">회원 목록</a>
			<input type="submit" class="regis" value="상태수정">
		</div>
	</form>
</div>