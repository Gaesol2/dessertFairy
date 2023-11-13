/**
 * 
 */
$().ready(function(){
	//price 클래스 이름을 가진 숫자에 , 찍기
	let price_length = $('.price').length;
 	for(let i=0; i<price_length; i++){
	 let price=$('.price').eq(i).text();
	 let to_price = 
	     price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,",");
	 $('.price').eq(i).text(to_price);
   };
   
   //새로고침했을 때 스크롤 상단으로 이동
   window.onload = function(){
	   setTimeout(function(){
		   scrollTo(0,0);
	   }, 100);
   };
   
   $(".topSearchBtn").click(function(){
        $("#searchBox").slideDown(1000)
    });
    
   $(".upBtn").click(function(){
        $("#searchBox").slideUp(1000)
    });
    
}); //ready 끝

