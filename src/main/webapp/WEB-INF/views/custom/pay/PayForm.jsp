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
	<p>${odto}</p>
</div>

<input type="button" value="결제하기" id="payBtn" onclick="javascript:orderAjax(this)">
<input type="button" value="카카오페이" id="kakoPayBtn" onclick="javascript:orderAjax(this)">
<p>${orderResult}</p>

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
		<input type="hidden" name="site_name" value="payup">
		
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
		<input type="hidden" name="buyr_mail" value="">
		<input type="hidden" name="ordr_chk" value="" />
		<!-- 2012년 8월 18일 전자상거래법 개정 관련 설정 부분 -->
		<!-- 제공 기간 설정 0:일회성 1:기간설정(ex 1:2012010120120131) -->
		<input type="hidden" name="good_expr" value="0">
		<!-- 표준웹 설정 정보입니다(변경 불가) -->
		<input type="hidden" name="module_type" value="01" />
		<!-- 필수 항목 : 결제 금액/화폐단위 -->
		<input type="hidden" name="currency" value="WON" />
	</form>
</div>
</body>
</html>