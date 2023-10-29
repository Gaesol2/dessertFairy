<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>예약을 원하시는 날짜를 선택해 주세요</title>
<link rel="stylesheet" type="text/css" href="/css/ordercake.css">
<link rel="stylesheet" type="text/css" href="/css/calendar.css">
<script src="/script/calendar.js"></script>
<script type="text/javascript">	
	//JSTL을 사용해 jsva script의 array에 입력
    var thisMonthFullDateList = new Array();
	<c:forEach items="${thisMonthFullDateList}" var = "date">
		thisMonthFullDateList.push(${date});
	</c:forEach>
	var nextMonthFullDateList = new Array();
	<c:forEach items="${nextMonthFullDateList}" var = "date">
		nextMonthFullDateList.push(${date});
	</c:forEach>
</script>
<div id="cake">
	<div id="cal">
		 <table id="calendar">
			<tr class="caltd">
				<td><label onclick="prevCalendar()"> ◀ </label></td>
				<td colspan="5" id="calendarTitle">yyyy년 m월</td>
				<td><label onclick="nextCalendar()"> ▶ </label></td>
			</tr>
			<tr>
				<td class="sun">일</td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td class="sat">토</td>
			</tr>
			<script type="text/javascript">buildCalendar();</script>
		 </table>
		 <!--  선택한 예약일시를 출력할 위치 -->
				<input id="selectedDate" name="selectedDate" value="" readonly="readonly">
				
			<!--  총 예약금액을 출력할 위치 -->
				<input id="totalPrice" name="totalPrice" value="" readonly="readonly">
	</div>
	<div id="cakedetail">
		<dl>
			<dt class="dt">주문 제작 케이크</dt>
			<dd class="dd">고객이 직접 맛과 디자인을 정할 수 있어 <br> 더욱 특별한 수제 케이크</dd>
		</dl>
		<p>맛난케이크</p>
	</div>
</div>
