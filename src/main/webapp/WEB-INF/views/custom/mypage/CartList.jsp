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
      <table class="cartlist">
      <tr>    
		  <th>상품명</th>
		  <th>상품가격</th>
		  <th>수량</th>
		  <th>결제금액</th>
		  <th>수정/삭제</th>
		  <th>조회</th>
     </tr> 
  <c:choose>
  <c:when test="${fn:length(hCartList)>0}">
   <tbody>
    <c:forEach var="cvo" items="${hCartList}">
     <tr>
      <td class="co2 border">${cvo.value.p_name}</td>
      <td class="price border">${cvo.value.price}</td>
      <td class="co5 border"><!-- 수량 -->
       <input type="hidden" name="stock" value="${cvo.value.stock}">
       <input type="hidden" name="p_no" value="${cvo.value.d_no}">
       <input type="hidden" name="p_name" value="${cvo.value.d_name}">
       <input type="hidden" name="price" value="${cvo.value.price}">
      </td>
      <td class="co4 price border">
      ${cvo.value.price*cvo.value.p_name}
      </td>
      <td class="co4 border"><input type="button" value="수정" 
            onclick="javascript:cartUpdate('U', this)">&nbsp;/&nbsp;
          <input type="button" value="삭제" 
            onclick="javascript:cartUpdate('D', this)">
      </td>
      <td class="border"><!-- 상품 상세 조회 -->
      <a href="productDetail?p_no=${cvo.value.d_no}">상세보기</a>    
      </td>
     </tr>
    </c:forEach>
      <tr class="buttonArea">
       <th colspan="6"><a href="orderProc">주문하기</a></th>
      </tr>
      </tbody>
   </c:when>
   <c:when test="${fn:length(pList)==0}">
   <tbody>
    <th colspan="5"> 등록된 상품이 없습니다 </th></tr>
   </tbody>
   </c:when>
  </c:choose>
 </table>
    </div>
  </div>
</div>