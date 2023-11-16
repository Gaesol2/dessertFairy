/**
 * 
 */
$().ready(function(){
    $('.noticeUp').on("click",function(){
		$("form[name=topForm]").attr('action',"/noticeUpForm");
		$("form[name=topForm]").submit();
	});
    $('.noticeDel').on("click",function(){
		$("form[name=topForm]").attr('action',"/noticeProc?flag=delete");
		$("form[name=topForm]").submit();
	});
    $('.submit').on("click",function(){
	if(validate()){
		$("form[name=topForm]").attr('action',"/noticeProc?flag=update");	
		$("form[name=topForm]").submit();
	  }	
	});
	$('.noticeBtn').on("click",function(){
	   if(validate()){
      $("form[name=topForm]").submit();
      }
   });


 });
function validate(){
	  var flen = $("form[name=topForm] .chk").length;
          for(var i = 0; i < flen; i++){
         if($('.chk').eq(i).val()=="" ||
             $('.chk').eq(i).val()==null ||
             $('.chk').eq(i).val().trim()==""){
	         alert($('.chk').eq(i).attr('title') + '를 입력하시오');
	         $('.chk').eq(i).focus();
		   return false;
		  }  
	  }
	  return true;
}