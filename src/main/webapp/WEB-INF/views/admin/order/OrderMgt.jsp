<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<meta charset="UTF-8">
<title>전체 주문 내역 리스트</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/Order.css">
<script src="/script/Order.js"></script>

<div id = "order">
    <div id="orderSubject">
		<h2 class="orderName">주문관리</h2>
	</div>
	<div class="topList">
      <ul class="list">
        <li class="reList"><a href="orderMgt">디저트 목록</a></li>
        <li><a href="">케이크 목록</a></li>
      </ul>
    </div>
   
   <div id="adminOrderList">
      <table class="listTable" id="orderTable">
         <tr>
            <th>선택</th>
            <th>주문번호</th>
            <th>상품명</th>
            <th>회원명(회원 아이디)</th>
            <th>결제금액</th>
            <th>결제일</th>
            <th>주문상태</th>
         </tr>
         
         <c:choose>
            <c:when test="${fn:length(adminOrderList)>0}">
               <c:forEach var = "order" items = "${adminOrderList}" varStatus = "i">
                  <tr>
                     <td class="orl1"><input type="checkbox" name="check" value = "${i.index}" readonly="readonly"></td>
                     <td class="orl2"><a onclick="javascript:orderDetail(this)">${order.o_no}</a>
                        <input type="hidden" name="d_no" value="${order.d_no}">
                        <input type="hidden" name="o_no" value="${order.o_no}">
                        <input type="hidden" name="m_id" value="${order.m_id}">
                     </td>
                     <td class="orl3"><a onclick="javascript:orderDetail(this)">${order.d_name}</a>
                        <input type="hidden" name="d_no" value="${order.d_no}">
                        <input type="hidden" name="o_no" value="${order.o_no}">
                        <input type="hidden" name="m_id" value="${order.m_id}">
                     </td>
                     <td class="orl4">${order.m_name}(${order.m_id})</td>
                     <%-- <td class="price orl6">${order.o_quantity}</td> --%>
                     <%-- <td class="price orl7">${order.o_price}</td> --%>
                     <td class="price orl5">${order.o_totalprice}</td>
                     <td class="orl6">${order.o_regdate}</td>
                     <td class="state orl7">
                        <select name="o_state" id="state${i.count}"  class="stateUpBtn">
                           <option value="1">결제중</option>
                           <option value="2">배송준비</option>
                           <option value="3">배송중</option>
                           <option value="4">배송완료</option>
                           <option value="5">구매확정</option>
                        </select>
                        <script type="text/javascript">
                        $(function(){
                            //배송관련 상태
                            $("#state"+'${i.count}').val('${order.o_state}')
                        })
                        </script>
                     </td>
                  </tr>
               </c:forEach>
            </c:when>
         
            <c:when test="${fn:length(adminOrderList)==0}">
               <tr class="notList">
                  <th>주문내역이 없습니다.</th>
               </tr>
            </c:when>
         </c:choose>
      </table>
      <div id="odmBtn">
         <input type="button" class="orderUpBtn" value="상태수정">
      </div>
   </div>
   <form action="" name="content" method="post">
      <input type="hidden" name="bno" value="">
      <input type="hidden" name="curPage" value="${pageDto.curPage}">
      <input type="hidden" name="curBlock" value="${pageDto.curBlock}">
   </form>
   <form action="orderDetail" method="post" name="orDetailForm">
      <input type="hidden" name="d_no" value="${order.d_no}">
      <input type="hidden" name="o_no" value="${order.o_no}">
      <input type="hidden" name="m_id" value="${order.m_id}">
   </form>
   
</div>
<form action="/orderMgt"></form>