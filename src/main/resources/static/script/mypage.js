/**
 * 
 */

 $().ready(function(){
	/* $('.update').on('click', function(){
		
		 
	 })*/
	  $('.submit1').on("click",function(){
		 var flen = $("form[name=topForm1] .chk1").length;
         for(var i=0; i<flen; i++){
         if($('.chk1').eq(i).val()=="" ||
             $('.chk1').eq(i).val()==null ||
             $('.chk1').eq(i).val().trim()==""){
           alert($('.chk1').eq(i).attr('title')+'를 입력하시오');
           $('.chk1').eq(i).focus();
           return false;
         }
      }
		  $("form[name=topForm1]").submit();
	  });
	})
	
	function update(flag){
		//패스워드 확인하기
		
		if(flag=='u'){
			$("#upForm").attr("action", "/memUpForm");
		}else{
			$("#upForm").attr("action", "/memDelete");	
			var yn = confirm("정말 탈퇴하시겠습니까?\n 구매이력과 포인트가 소멸됩니다.")
			if(yn==false){
				return false;
			}
		}
	}
		
		
	 function checkPw(){
	 spw = $('input[name=update]').val();
	 upw = prompt("비밀번호를 입력하시오");
	 if(upw==spw){
	    return true;
	 }else{
	    return false;
	 }
	}

	 
	 