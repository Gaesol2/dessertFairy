/**
 * 
 */

	$().ready(function(){
		var pwCheck = false;
		
	   $(".conSubmit").on("click",function(){
		   if(validate()){
			   
			   if(pwCheck){
					alert('4~6자리 숫자만 가능합니다');
					$('#t_passwd').focus();
					
					return false;
				}
			      $("form[name=contactForm]").submit();
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
	   if(validate()){
		   
			if(pwCheck){
					alert('4~6자리 숫자만 가능합니다');
					$('#t_passwd').focus();
					
					return false;
				}
				
	   	   $("form[name=contactForm]").attr('action', "/contactupProc")
	   	   $("form[name=contactForm]").submit();
	     }
   });
   
   $('.conSubmit').on('click', function(){
   	   alert(a)
   });
   
   
   
   
	   //admin 수정 및 삭제 
    $('.adminReContact').on('click', function(){
   	   $("form[name=replyForm]").attr('action', "/adminContactUpForm")
   	   $("form[name=replyForm]").submit();
  	 
   });
   
     $('.adminDelContact').on('click', function(){
   	   $("form[name=replyForm]").attr('action', "/adminContactDelProc")
   	   $("form[name=replyForm]").submit();
   });
   
   $('#t_passwd').keyup(function(){		// 비밀번호 숫자4~6자리 조합
		 var pattern = /^[0-9]{4,6}$/;
		 
		 if(!pattern.test($('#t_passwd').val())) pwCheck = true;
		 else pwCheck = false;
			
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
	}
	
	   
  
//chk에 대해서 점검
function validate(){
	var flen = $("form[name=contactForm] .chkc").length;
	var value = $("input[type=radio][name=t_secret]:checked").val();
	  if(value==null){
				alert("공개 여부를 체크해주세요")
				$('#cs_open').focus();
				return false;
		
		}	
				
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

function pwPattern(obj){
		
		if(!pattern.test(obj)){
			alert('4~6자리 숫자만 가능합니다');
			$('#t_passwd').focus();
			pwpt=false;
			
			return false;
		}
}
