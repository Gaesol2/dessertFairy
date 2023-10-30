<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>예약을 원하시는 날짜를 선택해 주세요</title>
<link rel="stylesheet" type="text/css" href="/css/Cakeorder.css">
<link rel="stylesheet" type="text/css" href="/css/Cakedetail.css">
<link rel="stylesheet" type="text/css" href="/css/Calendar.css">
<script src="/script/calendar.js"></script>
<div id="cake">
	<div id="cal">
 		<table class="Calendar">
            <thead>
                <tr class="day">
                    <td onClick="prevCalendar(), inputMonth();" style="cursor:pointer;">&#60;</td>
                    <td colspan="5">
                        <span id="calYear"></span>년
                        <span id="calMonth"></span>월
                    </td>
                    <td onClick="nextCalendar(), inputMonth();" style="cursor:pointer;">&#62;</td>
                </tr>
                <tr class="day">
                    <td>일</td>
                    <td>월</td>
                    <td>화</td>
                    <td>수</td>
                    <td>목</td>
                    <td>금</td>
                    <td>토</td>
                </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
	</div>
	<div id="cakedetail">
		<dl>
			<dt class="cakename">주문 제작 케이크</dt>
			<dd class="namedetail">고객이 직접 맛과 디자인을 정할 수 있어 <br> 더욱 특별한 수제 케이크</dd>
		</dl>
		<span class="option">
		 케이크 크기 :
		<select class="optionlist"> 
		  <option>선택</option>
		  <option>도시락</option>
		  <option>미니</option>
		  <option>1호</option>
		  <option>2호</option>
		  <option>3호</option>
		</select>
		</span>
		<span class="option">
		 빵시트 선택 :
		<select class="optionlist"> 
		  <option>선택</option>
		  <option>바닐라(기본)</option>
		  <option>초코</option>
		  <option>쿠앤크</option>
		</select>
		</span>
		<span class="option">
		안크림 선택 :
		<select> 
		  <option>선택</option>
		  <option>생크림(기본)</option>
		  <option>초코</option>
		  <option>쿠앤크</option>
		  <option>크림치즈</option>
		</select>
		</span>
		<span class="option">
		밖크림 선택 :
		<select> 
		  <option>선택</option>
		  <option>바닐라</option>
		  <option>초코</option>
		</select>
		</span>
		<p class="letter">레터링 입력 : 
			<input type="text" class="lettering" placeholder="최대 15글자" maxlength='15'>
		</p>
		<p class="letter">디자인 이미지 : 
			<label for="file" class="fileBtn">파일업로드</label>
			<input id="file" type="file">
		</p>
	</div>
	<div id="pickdate">
		<form action="" method="post">
		<p class="exp">픽업 날짜</p>
		월 : <input type="text" name="month" class="month"><br>
		일 : <input type="text" name="day" class="day">
		</form>
    	<a href=""><input class="orderBtn" type="button" value="주문하기"></a>
	</div>
</div>
<div id="cakecontent">
	<div class="noti">안내사항</div>
	<table class="contable">
	  	<tr class="detaillist">
	  		<th class="exp">유통(소비)기한</th>
	  	  		<td class="expdetail">냉장 3일/냉동 받으신 날부터 1주일</td>
	  	</tr>
	  	<tr class="detaillist">
	  		<th class="exp">보관방법</th>
	  	  		<td class="expdetail">영상 3~4℃ 에서 냉장보관</td>
	  	</tr>
	  	<tr class="detaillist">
	  		<th class="exp">조리방법</th>
	  	  		<td class="expdetail">냉장에 1~2시간 넣어둔 뒤 차갑게 먹으면 맛있습니다.</td>
	  	</tr>
	  	<tr class="detaillist">
	  		<th class="exp">알레르기 정보</th>
	  	  		<td class="expdetail">이 제품은 우유, 밀, 달걀을 함유하고 있습니다.</td>
	  	</tr>
	</table>
</div>





