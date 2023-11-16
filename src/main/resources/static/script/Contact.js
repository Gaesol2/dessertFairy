/**
 * 
 */

	$().ready(function(){
	   $(".conSubmit").on("click",function(){
		   if(validate()){
	      $("form[name=conForm]").submit();
	      }
	   });
	
	  
	   
	   //custom 수정 및 삭제 
     $('.contactUp').on('click', function(){
		 if(checkPw()){
   	   $("form[name=contactForm]").attr('action', "/contactUpForm")
   	   $("form[name=contactForm]").submit();
  	 }else{
       alert("비밀번호가 맞지 않습니다.");
       return false;
    }
   });
   
     $('.contactDel').on('click', function(){
   	   $("form[name=contactForm]").attr('action', "/contactDelProc")
   	   $("form[name=contactForm]").submit();
   });
   
   $('.contactUpdate').on('click', function(){
   	   $("form[name=contactForm]").attr('action', "/contactupProc")
   	   $("form[name=contactForm]").submit();
   });
	   
	   
	   

	   });//ready 끝
	   
	   
	   function checkPw(){
	 spw = $('input[name=t_passwd]').val();
	 upw = prompt("비밀번호를 입력하시오");
	 if(upw==spw){
	    return true;
	 }else{
	    return false;
	 }
	}
   
   
   function setParentText(){
	var pw1 = $('#pwck').val() //팝업에서 받은 비밀번호
	if(pw1==null || pw1.length==0){
		alert('패스워드를 입력하시오')
		$('#pwck').focus();
		return false;
	}
	var pw2 = $("#pw", opener.document).val(); //오프너값
	if(pw1==pw2){
		$("#conForm", opener.document).submit();
		this.window.close();
	}else{
		alert('비밀번호 오류')		
		this.window.close();
	}
	   
	   
  
//chk에 대해서 점검
function validate(){
	  var flen = $("form[name=conForm] .chkc").length;
	  for(var i = 0; i < flen; i++){
		  if( $('.chkc').eq(i).val()=="" || 
		      $('.chkc').eq(i).val()==null ||
		      $('.chkc').eq(i).val().trim()==""){
		   alert($('.chkc').eq(i).attr('title') + '은/는 필수 입력');
		   $('.chkc').eq(i).focus();
		   return false;
		  }  
	  }
	  return true;
}
}