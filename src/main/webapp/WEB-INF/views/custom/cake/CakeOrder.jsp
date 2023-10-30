<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>예약을 원하시는 날짜를 선택해 주세요</title>
<link rel="stylesheet" type="text/css" href="/css/ordercake.css">
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
		<dl class="detaillist">
			<dt class="exp">유통(소비)기한</dt>
			<dd class="expdetail">냉장 3일/냉동 받으신 날부터 1주일</dd>
		</dl>
		<dl class="detaillist">
			<dt class="exp">보관방법</dt>
			<dd class="expdetail">영상 3~4℃ 에서 냉장보관</dd>
		</dl>
		<dl class="detaillist">
			<dt class="exp">조리방법</dt>
			<dd class="expdetail">냉장에 1~2시간 넣어둔 뒤 차갑게 먹으면 맛있습니다.</dd>
		</dl>
		<dl class="detaillist">
			<dt class="exp">알레르기 정보</dt>
			<dd class="expdetail">이 제품은 우유, 밀, 달걀을 함유하고 있습니다.</dd>
		</dl>
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
