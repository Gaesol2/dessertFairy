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

   function closePop(obj){
	   $(obj).closest(".popBox").css('display', 'none');
   }
 

//function getCookie(name) { 
//	var Found = false var start, end var i = 0 
//	// cookie 문자열 전체를 검색
//	while(i <= document.cookie.length) {
//		 start = i end = start + name.length 
//		 // name과 동일한 문자가 있다면 
//		 if(document.cookie.substring(start, end) == name) {Found = true break } i++ }
//		  // name 문자열을 cookie에서 찾았다면 
//		 if(Found == true) { 
//			 start = end + 1 end = document.cookie.indexOf(";", start) 
//			 // 마지막 부분이라 는 것을 의미(마지막에는 ";"가 없다) 
//			 if(end < start) end = document.cookie.length 
//			 // name에 해당하는 value값을 추출하여 리턴한다. 
//			 return document.cookie.substring(start, end) } 
//			 // 찾지 못했다면 
//			 return "" } function openMsgBox() { 
//				 var eventCookie=getCookie("memo"); 
//				 if (eventCookie != "no") window.open('팝업창파일','_blank','width=300,height=300,top=50,left=150'); 
//				 //팝업창의 주소, 같은 도메인에 있어야 한다. 
//				 } openMsgBox();


//function setCookie( name, value, expiredays ) {
//	 var todayDate = new Date(); 
//	 todayDate.setDate( todayDate.getDate() + expiredays );
//	 document.cookie = name + "=" + escape( value ) + ";
//	 path=/; 
//	 expires=" + todayDate.toGMTString() + ";" 
//	 } function closeWin() {
//		  if ( document.myform.event.checked ) setCookie("memo", "no" , 1); 
//		  // 1일 간 쿠키적용 
//}
