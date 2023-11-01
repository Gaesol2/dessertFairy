<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div id="product_Insert_Box">
  <h2>상품 등록</h2>
  <form action="/productMgtProc?flag=insert" method="post" 
        name="productInsert_Form" enctype="multipart/form-data">
	  <table class="product">
	     <tr>
	       <th>상품 번호</th>
	       <td>
	        <input type="text" name="p_name" class="chk1"  title="상품명"
	        placeholder="상품번호를 입력하시오.">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품 카테고리</th>
	       <td>
	        <input type="text" name="p_name" class="chk1"  title="상품명"
	        placeholder="상품 카테고리를 입력하시오.">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품명</th>
	       <td>
	        <input type="text" name="p_name" class="chk1"  title="상품명"
	        placeholder="상품명을 입력하시오.">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품가격</th>
	       <td>
	        <input type="text" name="price" class="chk1 inprice" title="상품가격" 
	        placeholder="단가를 입력하시오">&nbsp;원
	       </td>
	     </tr>
	     
	     <tr>
	       <th>재고수량</th>
	       <td>
	        <input type="text" name="stock" class="chk1"  title="재고수량"
	        placeholder="재고수량을 입력하시오.">&nbsp;개
	       </td>
	     </tr>
	     
	     <tr>
	       <th>상품이미지</th>
	       <td>
	        <input type="file" name="image2" class="chk1" title="이미지"
	        placeholder="이미지 첨부하시오">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>유통기한</th>
	       <td>
	        <input type="text" name="stock" class="chk1"  title="재고수량"
	        placeholder="유통기한을 입력하시오.">&nbsp;개
	       </td>
	     </tr>
	     
	     
	     <tr>
	       <th>저장방법</th>
	       <td>
	        <input type="text" name="detail" title="상품설명"
	        placeholder="저장방법을 입력하시오.">
	       </td>
	     </tr>

	     <tr>
	       <th>알레르기 성분</th>
	       <td>
	        <input type="text" name="detail" title="상품설명"
	        placeholder="알레르기 성분을 입력하시오.">
	       </td>
	     </tr>
	     
	     
	     <tr>
	       <th colspan="2" class="tableBtn">
	         <input class="productInsert" type="button" value="상품등록전송">
	       </th>
	     </tr>
	     
	  </table>
  </form>
</div>
</body>
</html>