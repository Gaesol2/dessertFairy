<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/script/Pay.js"></script>
<script type="text/javascript" src="https://testpay.kcp.co.kr/plugin/payplus_web.jsp"></script>
</head>
<body>
주문 상세 내역 나오게
<div id="detail_order">
	<c:choose>
		<c:when test="${odto!=null}">
			주문번호 <input type="text" name="o_no" value="${odto.o_no }"><br>
			총 가격 <input type="text" name="o_totalprice" value="${odto.o_totalprice }"><br>
			상품 이름 <input type="text" name="d_name" value="${odto.d_name }"><br>
			주문자 아이디 <input type="text" name="m_id" value="${odto.m_id }"><br>
			주문 시각 <input type="text" name="o_regdate" value="${odto.o_regdate }">
			
			<input type="button" value="결제하기" id="payBtn" onclick="javascript:orderAjax(this)">
			<input type="button" value="카카오페이" id="kakoPayBtn" onclick="javascript:orderAjax(this)">
		</c:when>
		<c:when test="${cdto!=null}">
			주문번호 <input type="text" name="c_no" value="${cdto.c_no }"><br>
			빵 시트 <input type="text" name="c_sheet" value="${cdto.c_sheet }"><br>
			안 크림 <input type="text" name="c_incream" value="${cdto.c_incream }"><br>
			밖 크림 <input type="text" name="c_outcream" value="${cdto.c_outcream }"><br>
			케이크 사이즈 <input type="text" name="c_size" value="${cdto.c_size }"><br>
			가격 <input type="text" name="c_price" value="${cdto.c_price }"><br>
			주문자 아이디 <input type="text" name="m_id" value="${cdto.m_id }"><br>
			주문 시각 <input type="text" name="c_regdate" value="${cdto.c_regdate }"><br>
			수령 날짜 월: <input type="text" name="c_month" value="${cdto.c_month }"><br>
			 일: <input type="text" name="c_day" value="${cdto.c_day }">
			
			<input type="button" value="결제하기" id="payBtn" onclick="javascript:cakeAjax(this)">
			<input type="button" value="카카오페이" id="kakoPayBtn" onclick="javascript:cakeAjax(this)">
		</c:when>
	</c:choose>
</div>

<div class="container">
	<form name="kcp_order_info" id="kcp_order_info" action="/authPay" method="post" accept-charset="euc-kr">
		<input type="hidden" name="ordr_idxx" value=""> 
		<input type="hidden" name="good_name" value=""> 
	    <input type="hidden" name="good_mny" value=""> 
	    <input type="hidden" name="buyr_name" value=""> 
	    <input type="hidden" name="site_cd" value="">
		
		<!-- 고정값 -->
		<input type="hidden" name="req_tx" value="pay">
		<input type="hidden" name="pay_method" value="100000000000">
		
		<!-- 인증 -->
		<input type="hidden" name="site_name" value="payup">

		<!-- 카카오 -->
		<input type="hidden" name="currency" value="410">
		<input type="hidden" name="kakaopay_direct" value="Y">
		<input type="hidden" name="module_type" value="01"/>
		
		<!-- 주문정보 검증 관련 정보 : 표준웹 에서 설정하는 정보입니다  -->
		<input type="hidden" name="ordr_chk" value=""/>
		
		<!--
			 ※ 필 수
			 필수 항목 : 표준웹에서 값을 설정하는 부분으로 반드시 포함되어야 합니다
			 값을 설정하지 마십시오
		-->
		<input type="hidden" name="res_cd" value="" />
		<input type="hidden" name="res_msg" value="" />
		<input type="hidden" name="enc_info" value="" />
		<input type="hidden" name="enc_data" value="" />
		<input type="hidden" name="ret_pay_method" value="" />
		<input type="hidden" name="tran_cd" value="" />
		<input type="hidden" name="use_pay_method" value="" />

		<!-- 인증 -->		
		<input type="hidden" name="buyr_mail" value="">
		<input type="hidden" name="ordr_chk" value="" />
		<!-- 2012년 8월 18일 전자상거래법 개정 관련 설정 부분 -->
		<!-- 제공 기간 설정 0:일회성 1:기간설정(ex 1:2012010120120131) -->
		<input type="hidden" name="good_expr" value="0">
		<!-- 표준웹 설정 정보입니다(변경 불가) -->
		<input type="hidden" name="module_type" value="01" />
		<!-- 필수 항목 : 결제 금액/화폐단위 -->
		<input type="hidden" name="currency" value="WON" />

		<!-- 카카오 -->
		<input type="hidden" name="card_pay_method" value=""/>
	</form>
</div>
</body>
</html>