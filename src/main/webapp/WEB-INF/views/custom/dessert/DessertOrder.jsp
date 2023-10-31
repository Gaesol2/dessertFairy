<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/DessertOrder.css">
<script src="/script/Dessert.js"></script>
</head>
<div id="dessert">
  <div id="top">
    <div class="Mainlist">
      <p class="introduction">제품소개</p>
    </div>
    <div class="toplist">
      <ul class="list">
        <li>
           <input type="button" id="acategory" onclick="javascript:category('a')" value="전체보기">
           <label for="acategory" class="acategory"><a>전체보기</a></label>
        </li>
        <li>
           <input type="button" id="ccategory" onclick="javascript:category('c')" value="쿠키">
           <label for="ccategory" class="ccategory"><a>쿠키</a></label>
        </li>
        <li>
           <input type="button" id="bcategory" onclick="javascript:category('b')" value="브레드">
           <label for="bcategory" class="bcategory"><a>브레드</a></label>
        </li>
        <li>
           <input type="button" id="pcategory" onclick="javascript:category('p')" value="푸딩">
           <label for="pcategory" class="pcategory"><a>푸딩</a></label>
        </li>
      </ul>
    </div>
  </div>
  <div class="productlist">
   <table>
      <tr>
         <c:forEach var="d" items="${dessert}">
            <a class="abox" href="/dessertContent?d_no=${d.d_no}">
               <div class="box">
                  <c:out value="${d.d_no}"/>
                  <img src="/upload/${d.d_image}" height="250px" width="250px">
               </div>
            </a>
         </c:forEach>
      </tr>
   </table>
  </div>
</div>