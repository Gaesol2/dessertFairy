<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/Dessert.css">
<script src="/script/Dessert.js"></script>
</head>
<div id="dessert">
  <div id="top">
    <div class="Mainlist">
      <p class="introduction">검색결과</p>
    </div>
  </div>
  <div class="productlist">
   <table>
      <tr>
         <c:forEach var="search" items="${sList}">
            <a class="abox" href="/dessertContent?d_no=${search.d_no}">
               <div class="box">
                  <img src="/upload/${search.d_image}">
                  <p class="p_name">${search.d_name}</p>
                  <p class="p_price price">${search.d_price}</p>
               </div>
            </a>
         </c:forEach>
      </tr>
   </table>
  </div>
</div>