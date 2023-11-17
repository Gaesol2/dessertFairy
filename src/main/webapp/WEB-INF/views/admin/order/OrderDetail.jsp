<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>상세 주문 내역</title>
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id = "order_detail_box">
	<div id = "order_detail_head">
		<p>${odto.m_id}(${odto.o_no}) 상세 주문 내역</p>
	</div>
	
	<form action="updateOrder" name="orderDetailForm" method="post">
		<table>
			<tr>
				<th>주문번호</th>
				<td>
					${odto.o_no}
					<input type="hidden" name="o_no" value="${odto.o_no}">     
       				<input type="hidden" name="d_no" value="${odto.d_no}">     
    			    <input type="hidden" name="m_id" value="${odto.m_id}">
				</td>
			</tr>
			
			<tr>
				<th>상품명</th>
				<td>${odto.d_name}</td>
			</tr>
			<tr>
				<th>단가</th>
				<td>${odto.o_price}</td>
			</tr>
			<tr>
				<th>구매수량</th>
				<td>${odto.o_quantity}</td>
			</tr>
			<tr>
				<th>결제금액</th>
				<td>${odto.o_amount}</td>
			</tr>
			<tr>
				<th>고객정보</th>
				<td>${odto.m_name}(${odto.m_id})</td>
			</tr>
			<tr>
				<th>배송상태</th>
				<td>
					<select name="o_state" id="state">
						<option value="1">결재중</option>
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
				</td>
			</tr>
			
			<tr>
				<th>
					<input type="submit" value="상태수정">
				</th>
				<th>
					<a href = "/orderList"><input type="button" value="주문목록으로"></a>
				</th>
			</tr>
		</table>
	</form>
</div>
