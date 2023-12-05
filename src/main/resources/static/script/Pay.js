/**
 * 
 */
$().ready(function(){
  //결제 버튼	
  
	
})//ready 끝
	function orderAjax(obj){
		var id = obj.id;
		var pay = "";
		if("payBtn"==id){
			pay = "auth";
			  $("form[name=kcp_order_info]").attr("action","/authPay?pay=auth");
		} else {
			pay = "kakao";
			  $("form[name=kcp_order_info]").attr("action","/authPay?pay=kakao");
		}
		
		var ono = $("input[name=o_no]").val();
		var amount = $("input[name=o_totalprice]").val();
		var itemname = $("input[name=d_name]").val();
		var username = $("input[name=m_id]").val();
		
		$.ajax({
			async: true,
			type: 'post',
			data: {
				"pay":pay,
				"o_no":ono,
				"o_totalprice":amount,
				"d_name":itemname,
				"m_id":username
				},
			url: "payOrder",
			dataType: "json",
			success: function(data){
				console.log(data);
				if('auth' == data.pay){
					$("input[name=kakaopay_direct]").val("N");
				} else if ('kakao' == data.pay){
					$("input[name=kakaopay_direct]").val("Y");
				}
				
				if(data.responseCode == "0000"){
					//정상 주문일 경우 
					$("input[name=ordr_idxx]").val(data.ordr_idxx);
					$("input[name=good_name]").val(data.good_name);
					$("input[name=good_mny]").val(data.good_mny);
					$("input[name=buyr_name]").val(data.buyr_name);
					$("input[name=site_cd]").val(data.site_cd);
					
					jsf__pay();
					
				} else {
					//실패일 경우
					alert("결제 실패");
				}
			}
		});
	}

	function cakeAjax(obj){
		var id = obj.id;
		var pay = "";
		if("payBtn"==id){
			pay = "auth";
			  $("form[name=kcp_order_info]").attr("action","/authPay?pay=auth");
		} else {
			pay = "kakao";
			  $("form[name=kcp_order_info]").attr("action","/authPay?pay=kakao");
		}
		
		var cno = $("input[name=c_no]").val();
		var amount = $("input[name=c_price]").val();
		var itemname = $("input[name=c_size]").val();
		var username = $("input[name=m_id]").val();
		$.ajax({
			async: true,
			type: 'post',
			data: {
				"pay":pay,
				"c_no":cno,
				"c_price":amount,
				"d_name":itemname,
				"m_id":username
				},
			url: "payOrder",
			dataType: "json",
			success: function(data){
				console.log(data);
				if('auth' == data.pay){
					$("input[name=kakaopay_direct]").val("N");
				} else if ('kakao' == data.pay){
					$("input[name=kakaopay_direct]").val("Y");
				}
				
				if(data.responseCode == "0000"){
					//정상 주문일 경우 
					$("input[name=ordr_idxx]").val(data.ordr_idxx);
					$("input[name=good_name]").val(data.good_name);
					$("input[name=good_mny]").val(data.good_mny);
					$("input[name=buyr_name]").val(data.buyr_name);
					$("input[name=site_cd]").val(data.site_cd);
					
					jsf__pay();
					
				} else {
					//실패일 경우
					alert("결제 실패");
				}
			}
		});
	}


/****************************************************************/
/* m_Completepayment 설명 */
/****************************************************************/
/* 인증완료시 재귀 함수 */
/* 해당 함수명은 절대 변경하면 안됩니다. */
/* 해당 함수의 위치는 payplus.js 보다먼저 선언되어여 합니다. */
/* Web 방식의 경우 리턴 값이 form 으로 넘어옴 */
/****************************************************************/
function m_Completepayment( FormOrJson, closeEvent ) 
{
 var frm = document.kcp_order_info; 
 /********************************************************************/
 /* FormOrJson은 가맹점 임의 활용 금지 */
 /* frm 값에 FormOrJson 값이 설정 됨 frm 값으로 활용 하셔야 됩니다. */
 /********************************************************************/
 GetField( frm, FormOrJson ); 
 console.log(frm);
 
 if( frm.res_cd.value == "0000" )
 {
 
 /*
 [가맹점 리턴값 처리 영역] 
인증이 완료되면 frm에 인증값이 들어갑니다. 해당 데이터를 가지고
승인요청을 진행 해주시면 됩니다.

 
*/

 document.getElementById("kcp_order_info").submit();
 closeEvent();
 
 }
 else
 {
 /*
 (인증실패) 인증 실패 처리 진행
*/
 alert( "[" + frm.res_cd.value + "] " + frm.res_msg.value );
 
 closeEvent();
 }
}

/* 이 함수를 실행하여 표준웹 실행 */
function jsf__pay()
{
 try
 {
 var form = document.kcp_order_info;
 KCP_Pay_Execute( form ); 
 }
 catch (e)
 {
 /* IE 에서 결제 정상종료시 throw로 스크립트 종료 */
 }
} 
 