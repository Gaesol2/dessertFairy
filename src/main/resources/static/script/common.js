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
   }

})