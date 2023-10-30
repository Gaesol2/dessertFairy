/**
 * 
 */
$().ready(function(){
	
 $('.loginBtn').on('click',function(){		// 로그인
			var flen = $("form[name=loginForm] .chkt").length;
		 	for(var i=0; i<flen; i++){
			if($('.chkt').eq(i).val()=="" ||
		       $('.chkt').eq(i).val()==null ||
		       $('.chkt').eq(i).val().trim()==""){
			  alert($('.chkt').eq(i).attr('title')+'를 입력하시오.');
			  $('.chkt').eq(i).focus();
			  return false;
			}
		   }
		    $("form[name=loginForm]").submit();
		});
});