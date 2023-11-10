/**
 * 
 */
$().ready(function(){
	//처음에 총 상품 금액을 표기하는 함수
	amount();
	
	//배송비 금액을 표기하는 함수
	delivery();
	
	//총 결제 금액을 표기하는 함수
	total();
	
})

   //주문 수량 버튼
function count(obj, flag){
	   //상품의 재고 수, 가격 불러오기
	   let stock = $(obj).closest("tr").find("input[name='d_stock']").val();
	   let price = $(obj).closest("tr").find(".o_price").text().replace(",","");

	   //주문 수량 개수 불러오기
	   let count = $(obj).closest("tr").find(".count").val().replace(",","");
	   
	   // flag가 up일 때 수량 증가하고, flag가 down일 때 수량 감소시키기
	   if(flag=='up'){
		   
		   //주문 수가 재고보다 많으면 false, 적으면 주문 수 1 올리기
		   if(Number(count) >= Number(stock)){
			   alert("재고가 부족합니다.");
			   //재고량 개수 보이도록 수정하기
			   $(obj).closest("tr").find(".hidden_text").show();
			   return false;
		   } else {
			   //주문 수량 개수를 1 올리고, 올라간 숫자를 count에 다시 받아와서 저장하기
			   $(obj).closest("tr").find(".count").val(Number(count)+1);
			   count = $(obj).closest("tr").find(".count").val();
		   }
		   
	   } else if(flag=='down'){
			//주문 수가 1보다 작아지면 false, 아니면 주문 수 1감소하기
		   if(count<='1'){
			   alert("1개 이상 주문하세요.");
			   return false;
		   } else {
			   
			   //재고량 개수 감추기
			   $(obj).closest("tr").find(".hidden_text").hide();
			   
			   //주문 수량을 1 내리고, 내려간 숫자를 count에 다시 받아와서 저장하기
			   $(obj).closest("tr").find(".count").val(Number(count)-1);
			   count = $(obj).closest("tr").find(".count").val();
		   }
   		}
			
			//총 금액 계산
		   let total_price = Number(price)*Number(count);
		   $(obj).closest("tr").find("input[name='total_price']").val(total_price);
		   
		   // 총 금액에 , 찍기
		   total_price = total_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,",");
		   
		   //총 금액을 jsp에 반영하기
		   $(obj).closest("tr").find(".total_price").text(total_price);
		   
		   //금액 표기 함수들 실행
		   amount();
		   delivery();
		   total();
		   
		   //ajax Data로 사용할 변수 선언
		   let o_quantity = $(obj).closest("tr").find("input[name='o_quantity']").val();
		   let d_no = $(obj).closest("tr").find("input[name='d_no']").val();
		   
		   //ajax 수행
		   $.ajax({
				async: true,
				type: 'post',
				data: {
					"d_no": d_no,
					"o_quantity":o_quantity,
				},
				url: "cartProc?flag=update",
				dataType: "json",
				success: function(){
					alert('장바구니 수정');
				}
			});
 	}
 	
function x (obj){
	   	   let d_no = $(obj).closest("tr").find("input[name='d_no']").val();
	   	   if(confirm("상품을 삭제하시겠습니까?")){
				  
		   $.ajax({
				async: true,
				type: 'post',
				data: {
					"d_no": d_no
				},
				url: "cartProc?flag=delete",
				dataType: "json",
				success: function(){
				}
			});
			
			location.reload()
			
			} else{
				return false;
			}
	 }

	//총 상품 금액 표기 함수
function amount(){
	//초기 상품 금액 0원
	let amount=0;
	
	//상품의 개수만큼 반복문
	for(let i=0;i<$(".total_price").length;i++){
		//상품 개수만큼 ,를 제외한 총 가격 다 더해서 amount에 저장
		amount += Number($(".total_price").eq(i).text().replace(",",""));
	}
	
	//view화면을 위한 text에 숫자 입력 (, 추가)
	$(".amount").text(amount.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
}

	//총 배송비 금액 표기 함수
function delivery(){
	//배달비 3000원 고정
	const delivery = 3000;
	//총 주문 금액이 50000원 이상이면 배달비 대신 0 대입
	if(Number($(".amount").text().replace(",",""))>=50000) {
		// view화면을 위한 text에 숫자 입력
		$(".delivery").text(0);
	} else {
		//view화면을 위한 text에 숫자 입력 (, 추가)
		$(".delivery").text(delivery.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
	}
}

	//총 결제 금액 표기 함수
function total(){
	let amount = Number($(".amount").text().replace(",",""));
	let delivery = Number($(".delivery").text().replace(",",""));
	//view화면을 위한 text에 숫자 입력 (, 추가)
	$(".total_amount").text((amount+delivery).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
}