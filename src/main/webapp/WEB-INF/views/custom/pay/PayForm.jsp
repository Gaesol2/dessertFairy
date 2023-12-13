<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/Pay.css">
<script src="/script/Pay.js"></script>
<script type="text/javascript" src="https://testpay.kcp.co.kr/plugin/payplus_web.jsp"></script>

<div id="detail_order">
	<c:choose>
		<c:when test="${odto!=null}">
			<div id="dessertOrderBox">
				<div>
					<p class="c_orderP">주문자 아이디</p>
					<span>
						<input type="text" name="m_id" class="in" value="${odto.m_id }" readonly="readonly">
					</span>
				</div>
				<div>
					<p class="c_orderP">상품 이름</p>
					<span>
						<input type="text" name="d_name" class="in" value="${odto.d_name }" readonly="readonly">
						<input type="hidden" name="o_no" value="${odto.o_no}" readonly="readonly">
					</span>
				</div>
				<div>
					<p class="c_orderP">총 가격</p>
		            <span>
		               <input type="text" name="o_totalprice" class="in" value="${odto.o_totalprice }" readonly="readonly">
		            </span>
				</div>
				<div>
					<p class="c_orderP">주문 날짜</p>
					<span>
						<input type="text" name="o_regdate" class="in" value="${odto.o_regdate }" readonly="readonly" size="10">
					</span>
				</div>
			</div>
			<div id="payBox1">
				<div id="dessert_payBtn">
					<img src="../image/pay.png" class="payImg" id="payBtn" onclick="javascript:orderAjax(this)">
					<input type="button" class="payName1" value="결제하기" id="payBtn" onclick="javascript:orderAjax(this)">
				</div>
				<div id="dessert_kakaoBtn">
					<img src="../image/kakao.png" class="payImg" id="kakoPayBtn" onclick="javascript:orderAjax(this)">
					<input type="button" class="payName2" value="카카오페이" id="kakoPayBtn" onclick="javascript:orderAjax(this)">
				</div>
			</div>
		</c:when>
		<c:when test="${cdto!=null}">
			<div id="c_orderBox1">
				<div>
					<p class="c_orderP">주문자 아이디</p>
					<span>
						<input type="text" name="m_id" class="in" value="${cdto.m_id }" readonly="readonly" size="20">
						<input type="hidden" name="c_no" value="${cdto.c_no}" readonly="readonly">
					</span>
				</div>
				<div>
					<p class="c_orderP">빵 시트</p>
					<span>
						<input type="text" name="c_sheet" class="in" value="${cdto.c_sheet }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">안 크림</p>
					<span>
						<input type="text" name="c_incream" class="in" value="${cdto.c_incream }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">밖 크림</p>
					<span>
						<input type="text" name="c_outcream" class="in" value="${cdto.c_outcream }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">케이크 사이즈</p>
					<span>
						<input type="text" name="c_size" class="in" value="${cdto.c_size }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">가격</p>
					<span>
						<input type="text" name="c_price" class="in" value="${cdto.c_price }" readonly="readonly" size="10">
					</span>
				</div>
			</div>
			<div id="c_orderBox2">
				<div>
					<p class="c_orderP">주문 시각</p>
					<span>
						<input type="text" name="c_regdate" class="in" value="${cdto.c_regdate }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">수령 날짜</p>
					<span>
						<input type="text" name="c_month" class="in" value="${cdto.c_month }" readonly="readonly" size="3">월
						<input type="text" name="c_pickupdate" class="in" value="${cdto.c_day }" readonly="readonly" size="3">일
					</span>
				</div>
				<div>
					<p class="c_orderP">수령 시각</p>
					<span>
						<input type="text" name="c_pickupdate" class="in" value="${cdto.c_pickupdate }" readonly="readonly" size="10">
					</span>
				</div>
				<div>
					<p class="c_orderP">레터링</p>
					<span>
						<input type="text" name="c_write" class="in" value="${cdto.c_write}" readonly="readonly" size="40">
					</span>
				</div>
				<div>
					<p class="c_orderP">요구사항</p>
					<span>
						<textarea readonly="readonly">${cdto.c_request }</textarea>
					</span>
				</div>
			</div>
			<div id="payBox2">
				<div id="order_payBtn">
					<img src="../image/pay.png" class="payImg" id="payBtn" onclick="javascript:cakeAjax(this)">
					<input type="button" class="payName3" value="결제하기" id="payBtn" onclick="javascript:cakeAjax(this)">
				</div>
				<div id="order_kakaoBtn">
					<img src="../image/kakao.png" class="payImg" id="kakoPayBtn" onclick="javascript:cakeAjax(this)">
					<input type="button" class="payName4" value="카카오페이" id="kakoPayBtn" onclick="javascript:cakeAjax(this)">
				</div>
			</div>
		</c:when>
	</c:choose>
</div>

<div class="container">
	<form name="kcp_order_info" id="kcp_order_info" action="/authPay" method="post" accept-charset="euc-kr">
		<input type="hidden" name="o_no" value="${o_no}">
		<input type="text" name="p_type" value="${pay}">
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