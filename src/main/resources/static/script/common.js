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

	//close라는 쿠키가 있으면 팝업창 none
   if(checkPopupCookie("close")){
  		$(".popBox").css("display","none"); 
	}
	
}); //ready 끝

//팝업창 X 버튼 누르면 1회성 none
function X(){
	$(".popBox").css('display', 'none');
}

//다시 보지 않음 누르면 close 쿠키 설정하고 팝업창 none
function closePop(){
  // 하루 동안 close 라는 쿠키 유지
    setCookie("close","close",1);
	$(".popBox").css("display","none"); 
}

//close 쿠키 설정
 function setCookie(name, value, expiredays){
  let d = new Date();
  d.setDate(d.getDate() + expiredays);
  document.cookie = name + "=" + escape( value ) + ";path=/; expires=" + d.toGMTString() + ";";
}

//close 쿠키 있는지 확인하는 함수
function checkPopupCookie(cookieName){
  let cookie = document.cookie;

	// 현재 쿠키가 존재할 경우
	if(cookie.length > 0){ 

    // set해준 쿠키명이 존재하는지 검색
    startIndex = cookie.indexOf(cookieName);
	
	// 존재 한다면
    if(startIndex != -1){ 
    	return true;
    }else{
    
	  // 쿠키 내에 해당 쿠키가 존재하지 않을 경우
      return false;
    }
  
	}else{
    // 쿠키 자체가 없을 경우
    return false;
  }
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
