<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div id="member">
<script src="/script/mypage.js"></script>

<form action="memUpProc" name="topForm1" method="post" >
<table>
 <thead>
 <tr>
  <th colspan="2">회원가입</th>
 </tr>
 </thead>
 <tbody>
  <tr>
   <td class="col1">아이디</td>
   <td class="col2">${mdto.m_id }
     <input type="hidden" name="m_id" value="${mdto.m_id}">
   </td>
  
  </tr>
  <tr>
   <td class="col1">패스워드</td>
   <td class="col2">
   <input type="password"  name="m_passwd" id="check1" class="chk1" title="패스워드"
       placeholder="패스워드를 입력하시오." value="${mdto.m_passwd}">
       <font id="check" size="2" color="green"></font>
   </td>
  
  </tr>
  <tr>
   <td class="col1">패스워드확인</td>
   <td class="col2">
   <input type="password" id="check2" name="m_repasswd" class="chk1" title="패스워드확인" value="${mdto.m_passwd}">
   </td>
  
  </tr>
   <tr>
   <td class="col1">이름</td>
   <td class="col2">${mdto.m_name}
  
   </td>
  
  </tr>
  <tr>
   <td class="col1">이메일</td>
   <td class="col2">
   <input type="text" name="m_email" placeholder="aaa@himidia.co.kr" value="${mdto.m_email}">
   </td>
  
  </tr>
  <tr>
   <td class="col1">연락처</td>
   <td class="col2">
   <input type="text" name="m_phone"  class="chk1" title="연락처"
          placeholder="전화번호(010-1234-4321)" value="${mdto.m_phone}">
   </td>

  </tr>
  <tr>
   <td class="col1">우편번호</td>
   <td class="col2">
   <input type="text" name="m_zipcode" id="sample6_postcode"  
             readonly="readonly"
             class="chk1" 
             placeholder="우편번호를 검색하시오" value="${mdto.m_zipcode}">
          <button type="button" onclick="zipCheck()">우편변호찾기</button>
   </td>
  
  </tr>
  <tr>
   <td class="col1">주소</td>
   <td class="col2">
   <input type="text" name="m_address" class="chk1" readonly="readonly" 
        id="sample6_address" placeholder="주소" title="주소"  value="${mdto.m_address}"><br>
   <input type="text" name="m_address2" class="chk1"
        id="sample6_detailAddress" placeholder="상세주소" title="상세주소"  value="${mdto.m_address2}"> 
   <input type="hidden" id="sample6_extraAddress" placeholder="참고항목">         
   </td>
  </tr>
</tbody>
  <tfoot>
   <tr> 
    <td colspan="2" class="tableBtn">
     <button class="submit1" type="button">회원정보수정</button>
    
   </td>
   </tr>
  </tfoot>
</table>

</form>

</body>
</html>
</div>