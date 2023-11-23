<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=iyykc44paa"></script>
<title>예약을 원하시는 날짜를 선택해 주세요</title>
<link rel="stylesheet" type="text/css" href="/css/Cakeorder.css">
<script src="/script/calendar.js"></script>
<div id="cake"><!-- 케이크 예약 시작 -->
	<div id="cal"><!-- 캘린더 시작 -->
 		<table class="Calendar">
            <thead>
                <tr class="day">
                    <td class="pointer" onClick="prevCalendar(), inputMonth();">&#60;</td>
                    <td colspan="5">
                        <span id="calYear"></span>년
                        <span id="calMonth"></span>월
                    </td>
                    <td class="pointer" onClick="nextCalendar(), inputMonth();">&#62;</td>
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
	</div><!-- 캘린더 끝 -->
<form action="cakeOrderProc" method="post" name="cakeOrder" enctype="multipart/form-data">
	<div id="cakedetail"><!-- 옵션 시작 -->
		<dl>
			<dt class="cakename">주문 제작 케이크</dt>
			<dd class="namedetail">고객이 직접 맛과 디자인을 정할 수 있어 <br> 더욱 특별한 수제 케이크</dd>
		</dl>
		<span class="option">
		 케이크 크기 :
			<select name="c_size" onFocus="size_focus()"> 
			  <option value="도시락" >도시락 (16,000원)</option>
			  <option value="미니">미니 (18,000원)</option>
			  <option value="1호" selected>1호 (21,000원)</option>
			  <option value="2호">2호 (27,000원)</option>
			  <option value="3호">3호 (32,000원)</option>
			</select>
		</span>
		<span class="option">
		 빵시트 선택 :
			<select name="c_sheet" title="빵시트" class="chk" onFocus="sheet_focus()"> 
			  <option value="none">선택</option>
			  <option value="바닐라">바닐라</option>
			  <option value="초코">초코 (+1000원)</option>
			  <option value="쿠앤크">쿠앤크 (+1500원)</option>
			</select>
		</span>
		<span class="option">
		안크림 선택 :
			<select name="c_incream" title="안크림" class="chk" onFocus="incream_focus()"> 
			  <option value="none">선택</option>
			  <option value="바닐라">생크림</option>
			  <option value="초코">초코 (+1000원)</option>
			  <option value="크림치즈">크림치즈 (+1000원)</option>
			  <option value="쿠앤크">쿠앤크 (+1500원)</option>
			</select>
		</span>
		<span class="option">
		밖크림 선택 :
			<select name="c_outcream" title="밖크림" class="chk" onFocus="outcream_focus()"> 
			  <option value="none">선택</option>
			  <option value="바닐라">바닐라</option>
			  <option value="초코">초코 (+1000원)</option>
			</select>
		</span>
		<p class="letter">레터링 입력 : 
			<input type="text" class="lettering" name="c_write" placeholder="최대 15글자" maxlength='15'>
		</p>
		<p class="option">픽업 날짜 : 
			<input type="text" name="c_month" class="month" readonly="readonly"> 월 
			<input type="text" name="c_day" class="day" readonly="readonly"> 일
		</p>
	    <span class="option">
		픽업할 시간 : 
	    	<select name="c_pickupdate" title="픽업 시간" class="chk">
	    		<option value="none">시간 선택</option>
	    		<option>10:00-11:00</option>
	    		<option>11:00-12:00</option>
	    		<option>12:00-13:00</option>
	    		<option>13:00-14:00</option>
	    		<option>14:00-15:00</option>
	    		<option>15:00-16:00</option>
	    		<option>16:00-17:00</option>
	    		<option>17:00-18:00</option>
	    	</select>
	    </span>
		<p class="letter">디자인 이미지 : 
			<label for="file" class="fileBtn">파일업로드</label>
			<input id="file" type="file" name="image">
			<font class="file_name"></font>
		</p>
		<p class="letter">상세 요구사항 : 
			<label for="detail" class="detalBtn">요구사항 작성</label>
			<input id="detail" type="button">
			<span class="detail_name"></span>
			<input type="hidden" class="c_request" name="c_request">
		</p>
	<div id="cakePrice">
		<p class="letter"><strong> 금액 : </strong>
			<span class="price">21000</span>
			<input type="hidden" name="c_price" readonly="readonly">
		</p>
	</div>
	</div><!-- 옵션 끝 -->
	    <input class="orderBtn" type="button" value="주문하기">
</form>
	<div id="cakeImg">
		<img src="../image/ordercake1.jpg" class="orderCake">
		<p class="cakeDetail">생크림 케이크</p>
		<br>
		<img src="../image/ordercake2.jpg" class="orderCake">
		<p class="cakeDetail">초코 생크림 케이크</p>
		<br>
		<img src="../image/ordercake3.jpg" class="orderCake">
		<p class="cakeDetail">계절 과일 생크림 조각케이크</p>
		<br>
		<img src="../image/ordercake4.jpg" class="orderCake">
		<p class="cakeDetail">계절 과일 생크림 케이크</p>
		<br>
		<img src="../image/ordercake5.jpg" class="orderCake">
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	<div id="cakecontent"><!-- 안내사항 시작 -->
		<div class="noti">안내사항</div>
		<div class="notilist">
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
		    <dl class="detaillist">
		         <dt class="exp">배송 안내</dt>
		         <dd class="expdetail">제품 특성상 흔들림에 의해 망가질 수 있어 배송을 하지 않고 있습니다.</dd>
		    </dl>
		    <dl class="detaillist">
		         <dt class="exp">픽업 안내</dt>
		         <dd class="expdetail">픽업 시간에서 10분 이상 늦으실 경우 제품의 품질이 떨어져 폐기됩니다.</dd>
		         <dd class="expdetail">만약 늦으실 경우 하단에 전화번호로 미리 알려주시길 바랍니다.</dd>
		    </dl>
		</div>	
	</div><!-- 안내사항 끝 -->
	
	<div id="map_area">
		<div id="map"></div>
		<div id="pickup">
			<div class="way">
				<dl>
			         <dt class="pickDt">찾아오시는 길</dt>
			         <dd class="pickDd">모란역 5번출구 21m 도보 약 1분</dd>
			    </dl>
			    <dl>
			    	<dt class="pickDt">주소</dt>
			    	<dd class="pickDd">경기도 성남시 성남대로 1133 우: 07788</dd>
			    </dl>
			    <dl>
			    	<dt class="pickDt">매장 전화</dt>
			    	<dd class="pickDd">010-1234-1234</dd>
			    </dl>
			    <dl>
			    	<dt class="pickDt">영업 시간</dt>
			    	<dd class="pickDd">10:00 ~ 18:00</dd>
			    </dl>
			    <dl>
			    	<dt class="pickDt">휴무</dt>
			    	<dd class="pickDd">매주 수요일 휴무</dd>
			    </dl>
			    <dl>
			    	<dt class="pickDt">주차장 안내</dt>
			    	<dd class="pickDd">주차를 하셨을 경우 말씀해주시면<br>1시간 무료 이용 가능합니다.</dd>
			    </dl>
			</div>
		</div>
	</div>
	
</div><!-- 케이크 예약 끝 -->