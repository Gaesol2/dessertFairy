/**
 * 
 */
$().ready(function(){
	var pwCheck = false;
	
   $(".writeSubmit").on("click",function(){
	   if(validate()){
		    if(pwCheck){
					alert('4~6자리 숫자만 가능합니다');
					$('#r_passwd').focus();
					
					return false;
			}
      $("form[name=writeForm]").submit();
      }
   });
   
   $('#r_passwd').keyup(function(){		// 비밀번호 숫자4~6자리 조합
		 var pattern = /^[0-9]{4,6}$/;
		 
		 if(!pattern.test($('#r_passwd').val())) pwCheck = true;
		 else pwCheck = false;
			
	});
  
    //custom 수정 및 삭제 
     $('.reviewUp').on('click', function(){
		 if(checkPw()){
   	   $("form[name=reviewForm]").attr('action', "/myUpForm")
   	   $("form[name=reviewForm]").submit();
  	 }else{
       alert("비밀번호가 맞지 않습니다.");
       return false;
    }
   });
   
     $('.reviewDel').on('click', function(){
   	   $("form[name=reviewForm]").attr('action', "/delProc")
   	   $("form[name=reviewForm]").submit();
   });
   
   $('.reviewUpdate').on('click', function(){
	  if(validate()){
		    if(pwCheck){
					alert('4~6자리 숫자만 가능합니다');
					$('#r_passwd').focus();
					
					return false;
			}
	   	   $("form[name=reviewForm]").attr('action', "/upProc")
	   	   $("form[name=reviewForm]").submit();
   	   }
   });
   
   //admin 답글 수정 및 삭제
	   $(".adminWriteSubmit").on("click",function(){
	      $("form[name=replyForm]").submit();
	   });
   
     $('.replyDel').on('click', function(){
   	   $("form[name=replyForm]").attr('action', "/replydelProc")
   	   $("form[name=replyForm]").submit();
   	   var yn = confirm("정말 삭제하시겠습니까?")
		if(yn==true){
		}else{
			return false;
		}
   });
   
   $('.replyUpdate').on('click', function(){
   	   $("form[name=replyForm]").attr('action', "/replyupProc")
   	   $("form[name=replyForm]").submit();
   });
	 
		 let ratingLength = Number($("input[name='ratingLength']").val());
		 if(ratingLength==5) $("#rate1").attr("checked","checked");
		 else if(ratingLength==4) $("#rate2").attr("checked","checked");
		 else if(ratingLength==3) $("#rate3").attr("checked","checked");
		 else if(ratingLength==2) $("#rate4").attr("checked","checked");
		 else $("#rate5").attr("checked","checked");		 
	 
   });//ready 끝
   
   
   function checkPw(){
	 spw = $('input[name=r_passwd]').val();
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
		$("#upForm", opener.document).submit();
		this.window.close();
	}else{
		alert('비밀번호 오류')		
		this.window.close();
	}
}
  
//chk에 대해서 점검
function validate(){
	  var flen = $("form[name=reviewForm] .chkb").length;
	  for(var i = 0; i < flen; i++){
		  if( $('.chkb').eq(i).val()=="" || 
		      $('.chkb').eq(i).val()==null ||
		      $('.chkb').eq(i).val().trim()==""){
		   alert($('.chkb').eq(i).attr('title') + '은/는 필수 입력');
		   $('.chkb').eq(i).focus();
		   return false;
		  }  
	  }
	  
	  return true;
}

//카테고리
function category(){
	let category = $(".category").val();
	if(category=="최신순"){
		location.href="/reviewList?orderby=new";
	}else if(category=="오래된 순"){
		location.href="/reviewList?orderby=old";
	}else if(category=="별점 높은순"){
		location.href="/reviewList?orderby=star";
	}else if(category=="조회수 순"){
		location.href="/reviewList?orderby=read";
	}
	
	
}
