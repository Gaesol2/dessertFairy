/**
 * 
 */
$().ready(function(){
   
   //주문 수량 up 버튼
   $(".countUp").on("click",function(){
	   //상품의 재고 수, 가격 불러오기
	   let stock = $(".stock").text();
	   let price = $(".price").text().replace(",","");

	   //주문 수량 개수 불러오기
	   let count = $(".count").val().replace(",","");
	   
	   //주문 수가 재고보다 많으면 false, 적으면 주문 수 1 올리기
	   if(Number(count) >= Number(stock)){
		   alert("재고가 부족합니다.");
		   return false;
	   } else {
		   $(".count").val(Number(count)+1);
		   count = $(".count").val();
		   $(".total_price").val(Number(price)*Number(count));
	   }
   })

   //주문 수량 down 버튼
   $(".countDown").on("click",function(){
		//상품 가격 불러오기
		let price = $(".price").text().replace(",","");
		
		//주문 수량 개수 불러오기
		let count = $(".count").val().replace(",","");
		
		//주문 수가 1보다 작아지면 false, 아니면 주문 수 1감소하기
	   if(count<='1'){
		   alert("1개 이상 주문하세요.");
		   return false;
	   } else {
		   $(".count").val(Number(count)-1);
		   count = $(".count").val();
		   $(".total_price").val(Number(price)*Number(count));	   
	   }
   })
  
   //dessertOrder에서 장바구니 담기
   $(".btn_cart").on("click",function(){
	   $("form[name=dessertForm]").attr("action","cartProc?flag=insert");
	   $("form[name=dessertForm]").submit();	   
   })

   //dessertOrder에서 바로 결제하기
   $(".btn_order").on("click",function(){
	   $("form[name=dessertForm]").attr("action","orderProc");
	   $("form[name=dessertForm]").submit();	   
   })
   
}) //ready end

//버튼 클릭 시 flag 파라미터를 지닌 채로 dessert 매핑으로 이동
function category(f){
	if(f=='a'){
		location.href="dessert?flag=all"
		
	} else if(f=='c'){
		location.href="dessert?flag=쿠키"
		
	} else if(f=='b'){
		location.href="dessert?flag=브레드"
		
	} else if(f=='p'){
		location.href="dessert?flag=푸딩"
		
	}
	
	
}